package com.queryterm.service;

import com.google.gson.reflect.TypeToken;
import com.queryterm.utils.HttpUtil;
import com.queryterm.utils.ResourceUtils;
import com.queryterm.utils.Utils;
import com.queryterm.vo.Alert;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class AlertService {

    public List<Alert> readAlerts() throws IOException {
        String alertApiUrl = ResourceUtils.getPropertyValue("alert.api");
        String key = ResourceUtils.getPropertyValue("api.key");
        String urlWithParam = alertApiUrl + key;
        String alertsStr = HttpUtil.getData(urlWithParam);
        System.out.println("\n Alerts JSON :\n" + alertsStr);
        Type listType = new TypeToken<List<Alert>>(){}.getType();
        List<Alert> alerts = Utils.fromJson(alertsStr, listType);
        return alerts;
    }

}
