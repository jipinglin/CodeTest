package com.jesse.code;

import com.jesse.code.constant.TypeEnum;
import com.jesse.code.factory.SimpleAnalyzerFactory;
import com.jesse.code.processor.Processor;
import org.junit.Test;

public class AdvacedAnalyzerTest {
    private SimpleAnalyzerFactory factory = new SimpleAnalyzerFactory();

    /**
     * standard input: abcccbad
     */
    @Test
    public void case1() {
        process("abcccbad");
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


    private void process(String input) {
        Processor processor = factory.createProcessor(input, TypeEnum.ADVANCED);
        processor.process();
    }
}
