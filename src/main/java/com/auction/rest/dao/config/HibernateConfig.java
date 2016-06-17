package com.auction.rest.dao.config;

import com.auction.rest.config.Environment;
import com.auction.rest.util.Constants;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {

        final Configuration configuration = new Configuration().configure();
        Environment env = Environment.getInstance();
        Properties properties = new Properties();
        properties.setProperty(Constants.Hibernate.HIBERNATE_DIALECT, env.getDialect());
        properties.setProperty(Constants.Hibernate.HIBERNATE_DRIVER_CLASS, env.getDriverClass());
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_URL, env.getUrl());
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_USER, env.getUsername());
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_PWD, env.getPassword());
        if (configuration != null) {
            configuration.addProperties(properties);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
