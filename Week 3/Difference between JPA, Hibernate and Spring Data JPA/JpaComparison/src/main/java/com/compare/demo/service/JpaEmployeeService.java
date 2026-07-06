package com.compare.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compare.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class JpaEmployeeService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {

        entityManager.persist(employee);

    }
}