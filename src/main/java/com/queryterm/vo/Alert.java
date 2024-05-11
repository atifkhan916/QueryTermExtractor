package com.queryterm.vo;

import java.util.Arrays;

public class Alert {

    private String id;
    private AlertContent[] contents;
    private String date;
    private String inputType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AlertContent[] getContents() {
        return contents;
    }

    public void setContents(AlertContent[] contents) {
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    @Override
    public String toString() {
        return "Alert [id=" + id + ", contents=" + Arrays.toString(contents) + ", date=" + date + ", inputType="
                + inputType + "]";
    }

}
