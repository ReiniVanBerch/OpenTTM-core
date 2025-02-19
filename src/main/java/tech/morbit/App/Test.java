package tech.morbit.App;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Test {

    static String json = "{\n" +
            "  \"name\": \"John Doe\",\n" +
            "  \"qualities\": [\n" +
            "    {\n" +
            "      \"name\": \"Strength\",\n" +
            "      \"type\": \"Integer\",\n" +
            "      \"quality\": \"fixedValue\",\n" +
            "      \"values\": [10]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Speed\",\n" +
            "      \"type\": \"Double\",\n" +
            "      \"quality\": \"range\",\n" +
            "      \"values\": [3.5, 7.2]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Agility\",\n" +
            "      \"type\": \"Integer\",\n" +
            "      \"quality\": \"changingValue\",\n" +
            "      \"values\": [12]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Skills\",\n" +
            "      \"type\": \"Quality\",\n" +
            "      \"quality\": \"listValue\",\n" +
            "      \"values\": [\n" +
            "        {\n" +
            "          \"name\": \"Stealth\",\n" +
            "          \"type\": \"Boolean\",\n" +
            "          \"quality\": \"fixedValue\",\n" +
            "          \"values\": [true]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Archery\",\n" +
            "          \"type\": \"Integer\",\n" +
            "          \"quality\": \"range\",\n" +
            "          \"values\": [5, 15]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Swordsmanship\",\n" +
            "          \"type\": \"Integer\",\n" +
            "          \"quality\": \"rangedValue\",\n" +
            "          \"values\": [5, 15, 10]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Intelligence\",\n" +
            "      \"type\": \"Quality\",\n" +
            "      \"quality\": \"listValue\",\n" +
            "      \"values\": [\n" +
            "        {\n" +
            "          \"name\": \"Problem Solving\",\n" +
            "          \"type\": \"Double\",\n" +
            "          \"quality\": \"changingValue\",\n" +
            "          \"values\": [8.5]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Memory\",\n" +
            "          \"type\": \"Integer\",\n" +
            "          \"quality\": \"range\",\n" +
            "          \"values\": [7, 9]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";





public static String Testing(){
        return json;
    }
}