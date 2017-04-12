package com.aquario.handlers;

import com.aquario.data.dao.AquarioDao;
import com.aquario.data.model.AquarioData;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PutAquarioDataHandler implements Handler {

    private AquarioDao aquarioDao;

    public PutAquarioDataHandler(AquarioDao aquarioDao) {
        this.aquarioDao = aquarioDao;
    }

    @Override
    public void handle(Context ctx) throws Exception {

        ctx.parse(AquarioData.class)
                .flatMap(aquarioData -> aquarioDao.updateAquarioData(aquarioData.getCurrentTime(),
                        aquarioData.getCurrentDate(),
                        aquarioData.getCurrentDay(),
                        aquarioData.getCurrentTankTemp())
                )
                .then(ignored -> ctx.getResponse().status(204).send());
    }
}
