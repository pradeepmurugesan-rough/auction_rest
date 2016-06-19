package com.auction.rest.util;

public class Constants {
    public class Hibernate {
        public static final String HIBERNATE_DIALECT = "hibernate.dialect";
        public static final String INVALID_SEARCH_TYPE = "Invalid Search type provided : ";
        public static final String HIBERNATE_DRIVER_CLASS = "hibernate.connection.driver_class";
        public static final String HIBERNATE_CONN_URL = "hibernate.connection.url";
        public static final String HIBERNATE_CONN_USER = "hibernate.connection.username";
        public static final String HIBERNATE_CONN_PWD = "hibernate.connection.password";
    }

    public class ExceptionMessage {
        public static final String  JSON_CONVERSION_ERROR = "Error occurred while converting the Json Object";
    }

    public static final String ENV_FILE = "environments.json";
    public static final String ENVIRONMENT_NAME = "environmentName";
    public static final String VALIDATION_ERROR_MESSAGE = "Improper input";
    public static final String WS_BID_UPDATED = "bidUpdated";
}
