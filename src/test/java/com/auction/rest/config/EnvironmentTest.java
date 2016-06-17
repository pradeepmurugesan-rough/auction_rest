package com.auction.rest.config;

import org.junit.Assert;
import org.junit.Test;

public class EnvironmentTest {
    @Test
    public void testEnv() {
        Environment env = Environment.getInstance();
        Assert.assertEquals(env.getUrl(), "jdbc:postgresql://localhost/auction");
    }
}
