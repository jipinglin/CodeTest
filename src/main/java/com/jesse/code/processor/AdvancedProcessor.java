package com.jesse.code.processor;

import com.jesse.code.analyzer.Analyzer;
import com.jesse.code.constant.TypeEnum;
import com.jesse.code.entity.AdvancedResult;
import com.jesse.code.entity.ReplaceResult;
import com.jesse.code.factory.SimpleAnalyzerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedProcessor implements Processor {
    private SimpleAnalyzerFactory factory;

    private String input;

    private List<AdvancedResult> result;

    public AdvancedProcessor(String input) {
        factory = SimpleAnalyzerFactory.getInstance();
        this.input = input;
        result = new ArrayList<>();
    }

    @Override
    public void process() {
        Analyzer analyzer = factory.createAnalyzer(input, TypeEnum.ADVANCED);
        analyzer.process();
        String alphabet = analyzer.getResult();
        result.add(new AdvancedResult(alphabet, analyzer.getReplaceResult()));

        while (!analyzer.isComplete()) {
            analyzer = factory.createAnalyzer(alphabet, TypeEnum.ADVANCED);
            analyzer.process();
            alphabet = analyzer.getResult();


            result.add(new AdvancedResult(alphabet, analyzer.getReplaceResult()));

        }

        print();
    }

    public void print() {
        System.out.println(String.format("Input: %s", input));
        System.out.println("Output:");
        result.forEach(item -> {
            List<ReplaceResult> list = item.getReplaceResultList().stream().filter(r -> !Analyzer.STR_BLANK.equals(r.getReplace())).collect(Collectors.toList());
            if (needPrint(item, list)) {
                System.out.print(String.format("-> %s", item.getResult()));
                list.forEach(r -> {
                    System.out.print(String.format(", %s is replaced by %s", r.getSource(), r.getReplace()));
                });
                System.out.println();
            }
        });
    }

    /**
     * if replaced character is blank, no need to print
     *
     * @param result
     * @return
     */
    private boolean needPrint(AdvancedResult result, List<ReplaceResult> list) {
        // no replacement, print
        if (result.getReplaceResultList().size() <= 0) {
            return true;
        }

        if (list.size() > 0) {
            return true;
        }

        return false;
    }
}
