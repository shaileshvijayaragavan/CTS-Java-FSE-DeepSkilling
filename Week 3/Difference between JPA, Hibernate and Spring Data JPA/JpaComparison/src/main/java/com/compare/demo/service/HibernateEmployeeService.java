package com.compare.demo.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.compare.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class HibernateEmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.persist(employee);

    }
}