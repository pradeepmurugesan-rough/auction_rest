package com.auction.rest.testutils;

import com.auction.rest.util.Constants;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateTestConfig {
    public SessionFactory getUnitTestSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = getHibernateProperties();
        configuration.addProperties(properties);
        addAnnotatedClasses(configuration);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(Constants.Hibernate.HIBERNATE_DIALECT, "org.hibernate.dialect.HSQLDialect");
        properties.setProperty(Constants.Hibernate.HIBERNATE_DRIVER_CLASS, "org.hsqldb.jdbcDriver");
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_URL, "jdbc:hsqldb:mem:auction");
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_USER, "sa");
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_PWD, "");
        properties.setProperty("hibernate.archive.autodetection", "class,hbm");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }

    private Properties getMySqlHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(Constants.Hibernate.HIBERNATE_DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Constants.Hibernate.HIBERNATE_DRIVER_CLASS, "org.postgresql.Driver");
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_URL, "jdbc:postgresql://localhost/auction");
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_USER, "postgres");
        properties.setProperty(Constants.Hibernate.HIBERNATE_CONN_PWD, "postgres");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.archive.autodetection", "class,hbm");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        //properties.setProperty("hibernate.current_session_context_class", "thread");
        return properties;
    }

    public SessionFactory getIntegrationTestSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = getMySqlHibernateProperties();
        configuration.addProperties(properties);
        addAnnotatedClasses(configuration);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    private void addAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(com.auction.rest.model.Auction.class);
        configuration.addAnnotatedClass(com.auction.rest.model.Bid.class);
        configuration.addAnnotatedClass(com.auction.rest.model.Item.class);
        configuration.addAnnotatedClass(com.auction.rest.model.User.class);
    }
 }
