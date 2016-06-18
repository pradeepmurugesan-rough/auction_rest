package com.auction.rest.impl;

import com.auction.rest.config.Environment;
import com.auction.rest.config.UiConfig;

public class UiConfigImpl {

    public UiConfig getUiConfig() {

        Environment environment = Environment.getInstance();
        UiConfig config = new UiConfig();
        config.setWebSocketUrl(environment.getWebSocketUrl());
        return config;
    }
}
