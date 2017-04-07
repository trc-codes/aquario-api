package com.aquario.data.dao;

import com.aquario.data.model.AquarioData;
import com.aquario.data.model.DaySchedule;
import com.aquario.services.CassandraService;
import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.exec.Promise;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;

@Singleton
public class AquarioDao {

    private CassandraService cassandraService;

    @Inject
    public AquarioDao(CassandraService cassandraService) {
        this.cassandraService = cassandraService;
    }

    public Promise<AquarioData> getAquarioData() throws ExecutionException, InterruptedException {

        return execute(QueryBuilder.select().all().from("aquariodata").where(QueryBuilder.eq("id", "1"))).map(rs -> {
            Row row = rs.one();
            return new AquarioData(row.getString("currenttime"), row.getString("currentdate"), row.getString("currentday"), row.getString("currenttanktemp"));
        });
    }

    public Promise<List<DaySchedule>> getDaySchedulesData() throws ExecutionException, InterruptedException {

        return execute(QueryBuilder.select().all().from("dayschedules")).map(rs ->
                rs.all()
                        .stream()
                        .map(row -> new DaySchedule(row.getString("type"), row.getString("day"), row.getString("firststarttime"), row.getString("firststoptime"), row.getString("secondstarttime"), row.getString("secondstoptime")))
                        .collect(Collectors.toList())
        );
    }

    public Promise<Void> updateAquarioData(String currentTime,
                                           String currentDate,
                                           String currentDay,
                                           String currentTankTemp) {

        List<String> names = asList("id", "currentTime", "currentDate", "currentDay", "currentTankTemp");
        List<Object> values = asList("1", currentTime, currentDate, currentDay, currentTankTemp);

        return execute(QueryBuilder.insertInto("aquariodata").values(names, values)).map(ignored -> null);
    }

    public Promise<Void> updateDaySchedules(String type,
                                            String day,
                                            String firststarttime,
                                            String firststoptime,
                                            String secondstarttime,
                                            String secondstoptime) {

        List<String> names = asList("type", "day", "firststarttime", "firststoptime", "secondstarttime", "secondstoptime");
        List<Object> values = asList(type, day, firststarttime, firststoptime, secondstarttime, secondstoptime);

        return execute(QueryBuilder.insertInto("dayschedules").values(names, values)).map(ignored -> null);
    }

    public Promise<ResultSet> execute(Statement statement) {
        return Promise.async(upstream -> {
            ResultSetFuture resultSetFuture = cassandraService.getSession().executeAsync(statement);
            upstream.accept(resultSetFuture);
        });
    }

}