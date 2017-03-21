package com.aquario;

import static java.util.Arrays.asList;
import static ratpack.jackson.Jackson.json;

import com.aquario.data.dao.AquarioDao;
import com.aquario.data.model.AquarioData;
import com.aquario.data.model.DaySchedule;
import ratpack.server.RatpackServer;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String... args) throws Exception {

//        List<DaySchedule> currentLightsSchedule = asList(new DaySchedule("Monday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Tuesday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Wednesday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Thursday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Friday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Saturday", "08:00", "12:00", "17:00", "23:00"),
//                new DaySchedule("Sunday", "08:00", "12:00", "17:00", "23:00"));
//        List<DaySchedule> currentCo2Schedule = asList(new DaySchedule("Monday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Tuesday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Wednesday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Thursday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Friday", "06:00", "10:00", "16:00", "22:00"),
//                new DaySchedule("Saturday", "08:00", "12:00", "17:00", "23:00"),
//                new DaySchedule("Sunday", "08:00", "12:00", "17:00", "23:00"));
//
//        AquarioData aquarioData = new AquarioData("15:39", new Date(1489680218598L), "Thursday", "25", currentLightsSchedule, currentCo2Schedule);

        AquarioDao aquarioDao = new AquarioDao();

        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .get("api/aquarioData", ctx -> ctx.render(json(aquarioDao.getAquarioData())))
                )
        );
    }
}
