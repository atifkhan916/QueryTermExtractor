package com.queryterm.vo;

public class AlertContent {

    private String text;
    private String type;
    private String language;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "AlertContent [text=" + text + ", type=" + type + ", language=" + language + "]";
    }

}
