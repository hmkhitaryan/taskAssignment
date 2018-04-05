package com.egs.repo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.UUID;


public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    AbstractDao() {
        String token = UUID.randomUUID().toString();


        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    void persist(T entity) {
        getSession().persist(entity);
    }

    void delete(T entity) {
        getSession().delete(entity);
    }

    Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }
}
