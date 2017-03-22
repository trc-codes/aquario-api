package com.aquario.handlers;

import com.aquario.data.dao.AquarioDao;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static ratpack.jackson.Jackson.json;

public class GetAquarioDataHandler implements Handler {

    @Override
    public void handle(Context ctx) throws ExecutionException, InterruptedException {

        AquarioDao aquarioDao = new AquarioDao();

        aquarioDao.getAquarioData()
                .flatRight(ignored -> aquarioDao.getDaySchedulesData())
                .then(pairOfDataAndSchedules -> {
                    ctx.render(json(pairOfDataAndSchedules
                            .getLeft()
                            .setCurrentLightsSchedule(pairOfDataAndSchedules.getRight()
                                    .stream()
                                    .filter(schedule -> "lights".equals(schedule.getType()))
                                    .collect(Collectors.toList()))
                            .setCurrentCo2Schedule(pairOfDataAndSchedules.getRight()
                                    .stream()
                                    .filter(schedule -> "co2".equals(schedule.getType()))
                                    .collect(Collectors.toList()))
                    ));
                });
    }
}
