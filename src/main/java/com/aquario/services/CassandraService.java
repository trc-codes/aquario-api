package com.aquario.services;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraService {

    public Session getSession() {
        return Cluster.builder().addContactPoint("127.0.0.1").build().connect("aquario");
    }
}
