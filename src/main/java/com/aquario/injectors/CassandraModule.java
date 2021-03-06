package com.aquario.injectors;

import com.aquario.data.dao.AquarioDao;
import com.aquario.services.CassandraService;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class CassandraModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CassandraService.class).in(Scopes.SINGLETON);
        bind(AquarioDao.class).in(Scopes.SINGLETON);
    }
}
