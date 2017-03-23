package com.aquario;

import com.aquario.data.dao.AquarioDao;
import com.aquario.handlers.GetAquarioDataHandler;
import com.aquario.handlers.PutAquarioDataHandler;
import com.aquario.handlers.PutDaySchedulesHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import ratpack.server.RatpackServer;

public class Main {

    public static void main(String... args) throws Exception {

        AquarioDao aquarioDao = new AquarioDao();

        ObjectMapper mapper = new ObjectMapper();

        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .path("api/aquarioData", ctx -> ctx
                                .byMethod(m -> m
                                        .get(() -> new GetAquarioDataHandler(aquarioDao).handle(ctx))
                                        .put(() -> new PutAquarioDataHandler(aquarioDao, mapper).handle(ctx))
                                )
                        )
                        .path("api/daySchedules", ctx -> ctx
                                .byMethod(m -> m
                                        .put(() -> new PutDaySchedulesHandler(aquarioDao, mapper).handle(ctx)))
                        )
                )
        );
    }
}
