package com.jesse.code;

import com.jesse.code.constant.TypeEnum;
import com.jesse.code.factory.SimpleAnalyzerFactory;
import com.jesse.code.processor.Processor;
import org.junit.Test;

public class BaseAnalyzerTest {
    private SimpleAnalyzerFactory factory = new SimpleAnalyzerFactory();

    /**
     * standard input: aabcccbbad
     */
    @Test
    public void case1() {
        process("aabcccbbad");
    }

    /**
     * Not Match
     */
    @Test
    public void case2() {
        process("aab");
    }

    /**
     * all match
     */
    @Test
    public void case3() {
        process("aaabcccbdddb");
    }

    /**
     * Consecutive matches
     */
    @Test
    public void case4() {
        process("aaacccdddb");
    }

    private void process(String input) {
        Processor processor = factory.createProcessor(input, TypeEnum.BASE);
        processor.process();
    }
}
