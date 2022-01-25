package com.jesse.code.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseAnalyzer implements Analyzer {
    private String input;


    private StringBuffer sb;

    private boolean isComplete;

    public BaseAnalyzer(String input) {
        this.input = input;
        sb = new StringBuffer();
        isComplete = true;
    }

    public void process() {
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        String alphabet = input;
        Matcher matcher = pattern.matcher(alphabet);

        while (matcher.find()) {
            isComplete = false;
            matcher.appendReplacement(sb, STR_BLANK);
        }
        matcher.appendTail(sb);
    }

    public String getResult() {
        return sb.toString();
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }
}
