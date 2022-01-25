package com.jesse.code.entity;

public class ReplaceResult {
    /**
     * source string
     */
    private String source;

    /**
     * replacement character
     */
    private String replace;

    public ReplaceResult() {
    }

    public ReplaceResult(String source, String replace) {
        this.source = source;
        this.replace = replace;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }
}
