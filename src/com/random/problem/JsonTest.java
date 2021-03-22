/*
package com.random.problem;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashSet;
import java.util.Set;

public class JsonTest {

    public static void main(String[] args) {

        String jsonString = "{\"per_page\": 3,\"total\": 12,\"data\": [{\"color\": \"#98B2D1\",\"year\": 2000,\"name\": \"cerulean\",\"id\": 1,\"pantone_value\": \"15-4020\" }, {\"color\": \"#C74375\",\"year\": 2001,\"name\": \"fuchsia rose\",\"id\": 2,\"pantone_value\": \"17-2031\" }], \"page\": 1,\"total_pages\": 4 }\r\n";
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(jsonString);
        Set<String> keys = new HashSet<>();
        parseAllKeys(keys, object);
        keys.forEach(System.out::println);
    }
    private static void parseAllKeys(Set<String> keys, JsonObject object) {
        keys.addAll(object.keySet());
        object.entrySet().stream().filter(entry -> entry.getValue().isJsonObject()).forEach(entry -> parseAllKeys(keys, (JsonObject) entry.getValue()));
        object.entrySet().stream().filter(entry -> entry.getValue().isJsonArray()).forEach(entry -> entry.getValue().getAsJsonArray().forEach(subEntry -> parseAllKeys(keys, (JsonObject) subEntry)));
    }
}

*/
