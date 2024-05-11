package com.queryterm.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;

public final class Utils {

    private Utils() {}

    public static <T> T fromJson(String json, Type t) {
        return new Gson().fromJson(json, t);
    }
}
