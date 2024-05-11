package com.queryterm.vo;

public class QueryTerm {

    private String id;
    private String text;
    private String language;
    private boolean keepOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isKeepOrder() {
        return keepOrder;
    }

    public void setKeepOrder(boolean keepOrder) {
        this.keepOrder = keepOrder;
    }

    @Override
    public String toString() {
        return "QueryTerm [id=" + id + ", text=" + text + ", language=" + language + ", keepOrder=" + keepOrder + "]";
    }

}
