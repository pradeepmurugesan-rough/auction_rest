package com.auction.rest.config;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.util.Constants;
import com.auction.rest.util.JsonConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class Environment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);

    private String dialect;
    private String driverClass;
    private String url;
    private String username;
    private String password;
    private String webSocketUrl;
    private String restApisUrl;
    private static Environment environment;

    private Environment() {}

    @JsonProperty("hibernate.dialect")
    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    @JsonProperty("hibernate.connection.driver_class")
    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @JsonProperty("hibernate.connection.url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("hibernate.connection.username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("hibernate.connection.password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("websocket.url")
    public String getWebSocketUrl() {
        return webSocketUrl;
    }

    public void setWebSocketUrl(String webSocketUrl) {
        this.webSocketUrl = webSocketUrl;
    }

    @JsonProperty("restapis.url")
    public String getRestApisUrl() {
        return restApisUrl;
    }

    public void setRestApisUrl(String restApisUrl) {
        this.restApisUrl = restApisUrl;
    }

    public static Environment getInstance() {
        String environmentName = System.getProperty(Constants.ENVIRONMENT_NAME);
        LOGGER.info("Loading the values for the environment" +  environmentName);
        if (environment == null) {
            try {
                InputStream stream = Environment.class.getClassLoader().getResourceAsStream(Constants.ENV_FILE);
                String envJson = IOUtils.toString(stream);
                JSONObject environmentObj = new JSONObject(envJson);
                environment = JsonConverter.jsonToObject(
                                environmentObj.getJSONObject(environmentName).toString(),
                                Environment.class);
            } catch (IOException | JSONException | AuctionException e) {
                LOGGER.error("Error occured while retrieving the environment values", e);
            }
        }
        return environment;
    }
}
