package com.jesse.code.processor;

import com.jesse.code.analyzer.Analyzer;
import com.jesse.code.constant.TypeEnum;
import com.jesse.code.factory.SimpleAnalyzerFactory;

import java.util.ArrayList;
import java.util.List;

public class BaseProcessor implements Processor {
    private SimpleAnalyzerFactory factory;

    private String input;

    private List<String> result;

    public BaseProcessor(String input) {
        factory = SimpleAnalyzerFactory.getInstance();
        this.input = input;
        result = new ArrayList<>();
    }

    @Override
    public void process() {
        Analyzer analyzer = factory.createAnalyzer(input, TypeEnum.BASE);
        analyzer.process();
        String alphabet = analyzer.getResult();
        result.add(alphabet);

        while (!analyzer.isComplete()) {
            analyzer = factory.createAnalyzer(alphabet, TypeEnum.BASE);
            analyzer.process();
            alphabet = analyzer.getResult();

            if (!analyzer.isComplete()) {
                result.add(alphabet);
            }
        }

        print();
    }

    public void print() {
        System.out.println(String.format("Input: %s", input));
        System.out.println("Output:");
        result.forEach(item -> {
            System.out.println(String.format("-> %s", item));
        });
    }
}
