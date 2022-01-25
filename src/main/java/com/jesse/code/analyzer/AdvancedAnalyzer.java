package com.jesse.code.analyzer;

import com.jesse.code.entity.ReplaceResult;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedAnalyzer implements Analyzer {
    private String input;

    private StringBuffer sb;

    private boolean isComplete;

    private List<ReplaceResult> replaceResultList;

    public AdvancedAnalyzer(String input) {
        this.input = input;
        sb = new StringBuffer();
        replaceResultList = new ArrayList<>();
        isComplete = true;
    }

    @Override
    public void process() {
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        String alphabet = input;
        Matcher matcher = pattern.matcher(alphabet);

        String alhpa;
        while (matcher.find()) {
            isComplete = false;
            alhpa = getReplaceAlpha(matcher.start());
            matcher.appendReplacement(sb, alhpa);
            replaceResultList.add(new ReplaceResult(matcher.group(), alhpa));
        }
        matcher.appendTail(sb);
    }

    /**
     * get the single character
     * @param start
     * @return
     */
    private String getReplaceAlpha(int start) {
        if (start <= 0) {
            return STR_BLANK;
        }
        return input.substring(start - 1, start);
    }

    @Override
    public String getResult() {
        return sb.toString();
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public List<ReplaceResult> getReplaceResult() {
        return replaceResultList;
    }
}
