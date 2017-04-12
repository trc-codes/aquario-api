package com.aquario;

import com.aquario.handlers.GetAquarioDataHandler;
import com.aquario.handlers.PutAquarioDataHandler;
import com.aquario.handlers.PutDaySchedulesHandler;
import com.aquario.injectors.CassandraModule;
import com.aquario.injectors.HandlersModule;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

public class Main {

    public static void main(String... args) throws Exception {

        RatpackServer.start(server -> server
                .registry(Guice.registry(bindingsSpec -> bindingsSpec.module(CassandraModule.class)
                        .module(HandlersModule.class)))
                .handlers(chain -> chain
                        .path("api/aquarioData", ctx -> ctx
                                .byMethod(m -> m
                                        .get(() -> ctx.get(GetAquarioDataHandler.class).handle(ctx))
                                        .put(() -> ctx.get(PutAquarioDataHandler.class).handle(ctx))
                                )
                        )
                        .path("api/daySchedules", ctx -> ctx
                                .byMethod(m -> m
                                        .put(() ->ctx.get(PutDaySchedulesHandler.class).handle(ctx)))
                        )
                )
        );
    }
}
