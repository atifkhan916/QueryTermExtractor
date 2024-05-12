package com.queryterm;

import com.queryterm.service.ExtractQueryTermsService;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws Exception {
        ExtractQueryTermsService extractQueryTermsService = new ExtractQueryTermsService();
        String response = extractQueryTermsService.extractQueryTerms();
    }

}
