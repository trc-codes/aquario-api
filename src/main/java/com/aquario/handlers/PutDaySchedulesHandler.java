package com.aquario.handlers;

import com.aquario.data.dao.AquarioDao;
import com.aquario.data.model.DaySchedule;
import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PutDaySchedulesHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {

        AquarioDao aquarioDao = new AquarioDao();

        ObjectMapper mapper = new ObjectMapper();

        ctx.getRequest().getBody()
                .map(is -> mapper.readValue(is.getBytes(), DaySchedule.class))
                .flatMap(daySchedule -> aquarioDao.updateDaySchedules(daySchedule.getType(),
                        daySchedule.getDay(),
                        daySchedule.getFirstStartTime(),
                        daySchedule.getFirstStopTime(),
                        daySchedule.getSecondStartTime(),
                        daySchedule.getSecondStopTime()))
                .then(ignored -> ctx.getResponse().status(204).send());
    }
}
