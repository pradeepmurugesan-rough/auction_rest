package com.auction.rest.config;


public class UiConfig {

    private String webSocketUrl;
    private String restApisUrl;

    public String getWebSocketUrl() {
        return webSocketUrl;
    }

    public void setWebSocketUrl(String webSocketUrl) {
        this.webSocketUrl = webSocketUrl;
    }

    public String getRestApisUrl() {
        return restApisUrl;
    }

    public void setRestApisUrl(String restApisUrl) {
        this.restApisUrl = restApisUrl;
    }
}
