package com.queryterm.vo;

import java.util.Objects;

public class Response {

    private String queryTermId;
    private String queryTermText;
    private String alertId;
    private String alertText;
    private String language;

    public Response() {}

    public Response(String queryTermId, String queryTermText, String alertId, String alertText, String language) {
        this.queryTermId = queryTermId;
        this.queryTermText = queryTermText;
        this.alertId = alertId;
        this.alertText = alertText;
        this.language = language;
    }

    public String getQueryTermId() {
        return queryTermId;
    }

    public void setQueryTermId(String queryTermId) {
        this.queryTermId = queryTermId;
    }

    public String getQueryTermText() {
        return queryTermText;
    }

    public void setQueryTermText(String queryTermText) {
        this.queryTermText = queryTermText;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Response responseData = (Response) obj;
        if (responseData.getAlertId() != null
            && responseData.getAlertId().equalsIgnoreCase(this.alertId)
            && responseData.getQueryTermId() != null
            && responseData.getQueryTermId().equalsIgnoreCase(this.getQueryTermId())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.alertId, this.queryTermId);
    }

    @Override
    public String toString() {
        return "ResponseData [queryTermId=" + queryTermId + ", queryTermText=" + queryTermText + ", alertId=" + alertId
                + ", alertText=" + alertText
                + ", language=" + language + "]";
    }

}
