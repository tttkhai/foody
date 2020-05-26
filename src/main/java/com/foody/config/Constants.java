package com.foody.config;

public final class Constants {
    public static final String SPRING_URLS_IGNORING = "\"**/login\", \"**/addUser\", \"/roles\", \"/city/**\", \"/country\",\"/getFoodTypes\", \"/results\", \"/restaurantList\",\"/restaurants\",\"/restaurant/**\",\"/states/**\",\"/restaurantTypes\",\"/restaurantType/**\", \"/reviews\"";
    public static final String SECRET="foodyApplication";
    public static final long SERIALVERSIONUID=-7858869558953243875L;
//    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
}
