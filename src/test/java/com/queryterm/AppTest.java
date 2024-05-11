package com.queryterm;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.queryterm.service.ExtractQueryTermsService;
import com.queryterm.utils.HttpUtil;
import com.queryterm.vo.Response;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

class AppTest {

    private MockedStatic<HttpUtil> mockedHttpUtil;

    @BeforeEach
    public void setUp() {
        mockedHttpUtil = Mockito.mockStatic(HttpUtil.class);
    }

    @Test
    void testApp() throws Exception {

        mockedHttpUtil.when(() -> HttpUtil.getData(anyString())).thenReturn(mockAlertsData(), mockQueryTermData());
        ExtractQueryTermsService extractQueryTermsService = new ExtractQueryTermsService();
        String responseStr = extractQueryTermsService.extractQueryTerms();
        Type listType = new TypeToken<List<Response>>(){}.getType();
        List<Response> response = new Gson().fromJson(responseStr, listType);
        assertEquals(3, response.size());
        assertEquals("1", response.get(0).getAlertId());
        assertEquals("101", response.get(0).getQueryTermId());
        assertEquals("de", response.get(0).getLanguage());
        assertEquals("1", response.get(1).getAlertId());
        assertEquals("102", response.get(1).getQueryTermId());
        assertEquals("تكم", response.get(1).getQueryTermText());
        assertEquals("2", response.get(2).getAlertId());
        assertEquals("104", response.get(2).getQueryTermId());
    }

    private String mockAlertsData() {
        return "["
            + "{\"id\":\"1\",\"contents\":["
            + "{\"text\":\"تكم من جبل علي الينا هل هذا هو الأدب\",\"type\":\"text \","
            + "\"language\":\"ar\"}, "
            + "{\"text\":\"Arbeitsplätze Industriegewerkschaft für Metall setzt Wolfgang Lemb , ig metall\""
            + ",\"type\":\"text \","
            + "\"language\":\"de\"}],\"date\":\"2020-07-24T06:18:45.777Z\",\"inputType\":\"tweet\"},"
            + "{\"id\":\"2\",\"contents\":["
            + "{\"text\":\"Más que un autonomía Tesla\",\"type\":\"text \","
            + "\"language\":\"es\"}],"
            + "\"date\":\"2020-07-24T06:18:45.777Z\",\"inputType\":\"tweet\"}"
            + "]";
    }

    private String mockQueryTermData() {
        return
             "[{\"id\": 101, \"text\":\"Arbeitsplätze Industriegewerkschaft\", \"language\":\"de\",\"keepOrder\":true},"
             + " {\"id\": 102, \"text\":\"تكم\", \"language\":\"ar\",\"keepOrder\":false}, "
             + " {\"id\": 103, \"text\":\"Más autonomía\", \"language\":\"es\",\"keepOrder\":true}, "
             + " {\"id\": 104, \"text\":\"que autonomía Tesla\", \"language\":\"es\",\"keepOrder\":false}, "
             + "]";
    }

}
