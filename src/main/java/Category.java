package main.java;

import java.util.Map;

public enum Category {

    NULL(""),
    HEALTH_AND_BEAUTY("Health and Beauty"),
    TOILETRIES("Toiletries"),
    SPORTS_AND_OUTDOOR("Sports and Outdoor"),
    FASHION_ACCESSORIES("Fashion Accessories");

    private static Map<String, String> stringToEnum = Map.ofEntries(
            Map.entry("Health and Beauty","HEALTH_AND_BEAUTY"),
            Map.entry("Toiletries","TOILETRIES"),
            Map.entry("Sports and Outdoor","SPORTS_AND_OUTDOOR"),
            Map.entry("Fashion Accessories","FASHION_ACCESSORIES")
    );

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }
    public static String getEnum(String displayName){
        return stringToEnum.get(displayName);
    }
    @Override
    public String toString() {
        return displayName;
    }
}
