package com.auction.rest.config;

import org.junit.Assert;
import org.junit.Test;

public class EnvironmentTest {
    @Test
    public void testEnv() {
        Environment env = Environment.getInstance();
        Assert.assertNotNull(env.getUrl());
    }
}
