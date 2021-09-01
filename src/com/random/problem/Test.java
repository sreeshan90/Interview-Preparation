package com.random.problem;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(Instant.now().toEpochMilli()/ Duration.ofSeconds(60).toMillis());
        Map mpa = new HashMap<>();
        mpa.computeIfAbsent(5, (k) -> {
            return 0;
        });
    }

}
