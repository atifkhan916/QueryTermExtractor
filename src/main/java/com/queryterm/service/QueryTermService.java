package com.queryterm.service;

import com.google.gson.reflect.TypeToken;
import com.queryterm.utils.HttpUtil;
import com.queryterm.utils.ResourceUtils;
import com.queryterm.utils.Utils;
import com.queryterm.vo.QueryTerm;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class QueryTermService {

    public List<QueryTerm> readQueryTerms() throws IOException {
        String apiUrl = ResourceUtils.getPropertyValue("query.term.api");
        String key = ResourceUtils.getPropertyValue("api.key");
        String urlWithParam = apiUrl + key;
        String queryTermsStr = HttpUtil.getData(urlWithParam);
        System.out.println("\n QueryTerms JSON :\n" + queryTermsStr);
        Type listType = new TypeToken<List<QueryTerm>>(){}.getType();
        List<QueryTerm> queryTerms = Utils.fromJson(queryTermsStr, listType);
        return queryTerms;
    }
}
