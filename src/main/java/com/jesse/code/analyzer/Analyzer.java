package com.jesse.code.analyzer;

import com.jesse.code.entity.ReplaceResult;

import java.util.ArrayList;
import java.util.List;

public interface Analyzer {
    public static final String REGEX = "([a-z])\\1{2,}";

    public static final String STR_BLANK = "";

    /**
     * process alphabet characters
     */
    void process();

    /**
     * get the result
     *
     * @return
     */
    String getResult();

    default List<ReplaceResult> getReplaceResult(){
        return new ArrayList<>();
    };

    boolean isComplete();
}
