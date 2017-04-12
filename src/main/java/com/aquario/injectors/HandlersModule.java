package com.aquario.injectors;

import com.aquario.handlers.GetAquarioDataHandler;
import com.aquario.handlers.PutAquarioDataHandler;
import com.aquario.handlers.PutDaySchedulesHandler;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class HandlersModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GetAquarioDataHandler.class).in(Scopes.SINGLETON);
        bind(PutAquarioDataHandler.class).in(Scopes.SINGLETON);
        bind(PutDaySchedulesHandler.class).in(Scopes.SINGLETON);
    }
}
