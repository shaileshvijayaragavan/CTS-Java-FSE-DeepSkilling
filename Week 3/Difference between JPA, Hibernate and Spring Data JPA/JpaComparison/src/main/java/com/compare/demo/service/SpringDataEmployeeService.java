package com.compare.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compare.demo.entity.Employee;
import com.compare.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class SpringDataEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(Employee employee) {

        employeeRepository.save(employee);

    }
}