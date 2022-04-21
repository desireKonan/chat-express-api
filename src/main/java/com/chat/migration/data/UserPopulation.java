package com.chat.migration.data;

import com.chat.domain.model.User;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.*;

public class UserPopulation {

    private static final List<User> users = Arrays.asList(
            new User(
                    UUID.randomUUID(), "KONAN", "Harvey", "Homme",
                    Date.from(Instant.parse("1999-01-13T00:00:00.00Z").atOffset(ZoneOffset.UTC).toInstant()),"", Date.from(Instant.now()),
                    null, "harveykonan@gmail.com", "12345678", null
            ),
            new User(
                    UUID.randomUUID(), "KONAN", "Désiré", "Homme",
                    Date.from(Instant.parse("1969-03-30T00:00:00.00Z").atOffset(ZoneOffset.UTC).toInstant()), "", Date.from(Instant.now()),
                    null, "desirekonan@gmail.com", "23456789", null
            ),
            new User(
                    UUID.randomUUID(), "KONAN", "Erick", "Homme",
                    Date.from(Instant.parse("1971-03-07T00:00:00.00Z").atOffset(ZoneOffset.UTC).toInstant()), "", Date.from(Instant.now()),
                    null, "erick.konan@gmail.com", "88888888", null
            )
    );


    public static List<User> getUsers() {
        return users;
    }

}
