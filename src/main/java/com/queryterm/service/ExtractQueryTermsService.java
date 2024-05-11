package com.queryterm.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.queryterm.vo.Alert;
import com.queryterm.vo.AlertContent;
import com.queryterm.vo.QueryTerm;
import com.queryterm.vo.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExtractQueryTermsService {

    private AlertService alertService;
    private QueryTermService queryTermService;

    public ExtractQueryTermsService() {
        this.alertService = new AlertService();
        this.queryTermService = new QueryTermService();
    }

    public ExtractQueryTermsService(AlertService alertService, QueryTermService queryTermService) {
        this.alertService = alertService;
        this.queryTermService = queryTermService;
    }

    public String extractQueryTerms() throws Exception {
        try {
            List<Alert> alerts = this.alertService.readAlerts();
            List<QueryTerm>  queryTerms = this.queryTermService.readQueryTerms();
            List<Response> responses = search(queryTerms, alerts);
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            String response = gson.toJson(responses);
            System.out.println("Response JSON :\n" + response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to retrieve data from prewave APIs");
            throw new Exception("Failed to retrieve data from prewave APIs", e);
        }
    }

    private List<Response> search(List<QueryTerm> queryTerms, List<Alert> alerts) {
        List<Response> response = new ArrayList<>();
        for (QueryTerm queryTerm : queryTerms) {
            if (queryTerm != null
                && queryTerm.getText() != null
                && !queryTerm.getText().trim().isEmpty()) {

                String query = queryTerm.getText();
                boolean keepOrder = queryTerm.isKeepOrder();
                String language = queryTerm.getLanguage();
                Locale locale = new Locale(language);
                String[] tokens = keepOrder
                                    ? new String[] {query.toLowerCase(locale) } : query.toLowerCase(locale).split(" ");
                for (String queryToken : tokens) {
                    for (Alert alert : alerts) {
                        for (AlertContent content: alert.getContents()) {
                            String contentLanguage = content.getLanguage();
                            Locale contentLocale = new Locale(contentLanguage);
                            if (contentLanguage.equalsIgnoreCase(language)
                                && content.getText() != null
                                && content.getText().trim().toLowerCase(contentLocale).contains(queryToken)) {
                                Response responseData = new Response(queryTerm.getId(),
                                                                                queryToken,
                                                                                alert.getId(),
                                                                                content.getText(),
                                                                                language);
                                response.add(responseData);
                            }
                        }
                    }

                }

            }
        }

        return deDuplicate(response);
    }

    private List<Response> deDuplicate(List<Response> data) {
        List<Response> uniqueData = new ArrayList<>();
        for (Response responseData : data) {
            if (!uniqueData.contains(responseData)) {
                uniqueData.add(responseData);
            }
        }
        return uniqueData;
    }
}
