package com.jesse.code.factory;

import com.jesse.code.analyzer.AdvancedAnalyzer;
import com.jesse.code.analyzer.Analyzer;
import com.jesse.code.analyzer.BaseAnalyzer;
import com.jesse.code.constant.TypeEnum;
import com.jesse.code.processor.AdvancedProcessor;
import com.jesse.code.processor.BaseProcessor;
import com.jesse.code.processor.Processor;

public class SimpleAnalyzerFactory {
    private static SimpleAnalyzerFactory factory = new SimpleAnalyzerFactory();

    public static SimpleAnalyzerFactory getInstance() {
        return factory;
    }

    public Analyzer createAnalyzer(String input, TypeEnum type) {
        switch (type) {
            case BASE:
                return new BaseAnalyzer(input);
            case ADVANCED:
                return new AdvancedAnalyzer(input);
        }
        return null;
    }

    public Processor createProcessor(String input, TypeEnum type) {
        switch (type) {
            case BASE:
                return new BaseProcessor(input);
            case ADVANCED:
                return new AdvancedProcessor(input);
        }
        return null;
    }
}
