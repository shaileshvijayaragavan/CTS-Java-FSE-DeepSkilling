package com.compare.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compare.demo.entity.Employee;
import com.compare.demo.service.HibernateEmployeeService;
import com.compare.demo.service.JpaEmployeeService;
import com.compare.demo.service.SpringDataEmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private JpaEmployeeService jpaService;

    @Autowired
    private HibernateEmployeeService hibernateService;

    @Autowired
    private SpringDataEmployeeService springDataService;

    @GetMapping("/jpa")
    public String saveUsingJpa() {

        jpaService.save(new Employee("John", 50000));

        return "Employee saved using JPA";
    }

    @GetMapping("/hibernate")
    public String saveUsingHibernate() {

        hibernateService.save(new Employee("David", 60000));

        return "Employee saved using Hibernate";
    }

    @GetMapping("/springdata")
    public String saveUsingSpringDataJpa() {

        springDataService.save(new Employee("Alice", 70000));

        return "Employee saved using Spring Data JPA";
    }
}