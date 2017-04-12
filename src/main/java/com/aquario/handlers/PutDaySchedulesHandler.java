package com.aquario.handlers;

import com.aquario.data.dao.AquarioDao;
import com.aquario.data.model.DaySchedule;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PutDaySchedulesHandler implements Handler {

    private AquarioDao aquarioDao;

    @Inject
    public PutDaySchedulesHandler(AquarioDao aquarioDao) {
        this.aquarioDao = aquarioDao;
    }

    @Override
    public void handle(Context ctx) throws Exception {

        ctx.parse(DaySchedule.class)
                .flatMap(daySchedule -> aquarioDao.updateDaySchedules(daySchedule.getType(),
                        daySchedule.getDay(),
                        daySchedule.getFirstStartTime(),
                        daySchedule.getFirstStopTime(),
                        daySchedule.getSecondStartTime(),
                        daySchedule.getSecondStopTime())
                )
                .then(ignored -> ctx.getResponse().status(204).send());
    }
}
