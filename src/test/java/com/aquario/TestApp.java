package com.aquario;

import org.junit.Test;
import ratpack.test.MainClassApplicationUnderTest;
import static org.junit.Assert.assertEquals;

public class TestApp {

    @Test
    public void TestGetAquarioDataReturns200() throws Exception {
        new MainClassApplicationUnderTest(Main.class).test(testHttpClient ->
                assertEquals(200, testHttpClient.get("/api/aquarioData").getStatusCode())
        );
    }

    @Test
    public void TestGetAquarioDataReturnsApplicationJsonHeader() throws Exception {
        new MainClassApplicationUnderTest(Main.class).test(testHttpClient ->
                assertEquals("application/json", testHttpClient.get("/api/aquarioData").getHeaders().get("Content-Type"))
        );
    }

    @Test
    public void TestGetAquarioDataReturnsCorrectBodyText() throws Exception {
        new MainClassApplicationUnderTest(Main.class).test(testHttpClient ->
                assertEquals("{\"currentTime\":\"15:39\",\"currentDate\":\"22.03.2017\",\"currentDay\":\"Thursday\",\"currentTankTemp\":\"25\",\"currentLightsSchedule\":[{\"day\":\"Monday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Tuesday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Wednesday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Thursday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Friday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Saturday\",\"firstStartTime\":\"08:00\",\"firstStopTime\":\"12:00\",\"secondStartTime\":\"17:00\",\"secondStopTime\":\"23:00\"},{\"day\":\"Sunday\",\"firstStartTime\":\"08:00\",\"firstStopTime\":\"12:00\",\"secondStartTime\":\"17:00\",\"secondStopTime\":\"23:00\"}],\"currentCo2Schedule\":[{\"day\":\"Monday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Tuesday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Wednesday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Thursday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Friday\",\"firstStartTime\":\"06:00\",\"firstStopTime\":\"10:00\",\"secondStartTime\":\"16:00\",\"secondStopTime\":\"22:00\"},{\"day\":\"Saturday\",\"firstStartTime\":\"08:00\",\"firstStopTime\":\"12:00\",\"secondStartTime\":\"17:00\",\"secondStopTime\":\"23:00\"},{\"day\":\"Sunday\",\"firstStartTime\":\"08:00\",\"firstStopTime\":\"12:00\",\"secondStartTime\":\"17:00\",\"secondStopTime\":\"23:00\"}]}", testHttpClient.get("/api/aquarioData").getBody().getText())
        );
    }
}
