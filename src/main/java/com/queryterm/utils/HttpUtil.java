package com.queryterm.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.util.Timeout;

public final class HttpUtil {

    private static final int CONNECTTION_TIMEOUT = 3;

    private HttpUtil() {}

    public static String getData(String url) throws IOException {
        return Request.get(url)
        .connectTimeout(Timeout.ofSeconds(CONNECTTION_TIMEOUT))
        .execute().returnContent().asString(Charset.forName("UTF8"));
    }
}
