package com.auction.rest.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Properties;

public abstract class AbstractDao {

    private Session currentSession;
    private Transaction currentTransaction;
    private static Properties connectionProperties = null;
    protected SessionFactory sessionFactory;

    public Session openCurrentSession() throws HibernateException {
        if (this.sessionFactory != null) {
            currentSession = this.sessionFactory.openSession();
        }
        return currentSession;

    }

    public Session openCurrentSessionwithTransaction() throws HibernateException {
        currentSession = this.sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        if (currentSession != null && currentSession.isOpen()) {
            currentSession.close();
        }
    }

    public void closeCurrentSessionwithTransaction() {
        if (currentTransaction != null ) {
            currentTransaction.commit();
        }
        if (currentSession != null && currentSession.isOpen()) {
            currentSession.close();
        }
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
