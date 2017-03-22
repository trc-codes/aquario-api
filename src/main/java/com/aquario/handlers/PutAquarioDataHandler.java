package com.aquario.handlers;

import com.aquario.data.dao.AquarioDao;
import com.aquario.data.model.AquarioData;
import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PutAquarioDataHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {

        AquarioDao aquarioDao = new AquarioDao();

        ObjectMapper mapper = new ObjectMapper();

        ctx.getRequest().getBody()
                .map(is -> mapper.readValue(is.getBytes(), AquarioData.class))
                .flatMap(aquarioData -> aquarioDao.updateAquarioData(aquarioData.getCurrentTime(),
                        aquarioData.getCurrentDate(),
                        aquarioData.getCurrentDay(),
                        aquarioData.getCurrentTankTemp()))
                .then(ignored -> ctx.getResponse().status(204).send());
    }
}
