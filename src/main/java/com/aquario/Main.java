package com.aquario;

import com.aquario.handlers.GetAquarioDataHandler;
import com.aquario.handlers.PutAquarioDataHandler;
import com.aquario.handlers.PutDaySchedulesHandler;
import ratpack.server.RatpackServer;

public class Main {

    public static void main(String... args) throws Exception {

        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .path("api/aquarioData", ctx -> ctx
                                .byMethod(m -> m
                                        .get(() -> new GetAquarioDataHandler().handle(ctx))
                                        .put(() -> new PutAquarioDataHandler().handle(ctx))
                                )
                        )
                        .path("api/daySchedules", ctx -> ctx
                                .byMethod(m -> m
                                        .put(() -> new PutDaySchedulesHandler().handle(ctx)))
                        )
                )
        );
    }
}
