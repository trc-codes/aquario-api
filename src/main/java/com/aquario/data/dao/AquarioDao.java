package com.aquario.data.dao;


import com.aquario.data.model.AquarioData;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class AquarioDao {

    // Connect to the cluster and keyspace "aquario"
    Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
    ListenableFuture<Session> session = cluster.connectAsync("aquario");

    public AquarioData getAquarioData() throws ExecutionException, InterruptedException {
        ListenableFuture<ResultSet> resultSet = Futures.transformAsync(session,
                session -> session.executeAsync("select * from aquariodata"));

        Row row = resultSet.get().one();

        return new AquarioData(row.getString("currenttime"), row.getString("currentdate"), row.getString("currentday"), row.getString("currenttanktemp"));
    }
}
