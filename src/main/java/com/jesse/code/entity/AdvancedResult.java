package com.jesse.code.entity;

import java.util.List;

public class AdvancedResult {
    private String result;
    private List<ReplaceResult> replaceResultList;

    public AdvancedResult() {
    }

    public AdvancedResult(String result, List<ReplaceResult> replaceResultList) {
        this.result = result;
        this.replaceResultList = replaceResultList;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ReplaceResult> getReplaceResultList() {
        return replaceResultList;
    }

    public void setReplaceResultList(List<ReplaceResult> replaceResultList) {
        this.replaceResultList = replaceResultList;
    }
}
