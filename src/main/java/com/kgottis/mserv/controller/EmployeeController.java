/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.controller;

import com.kgottis.mserv.domain.Employee;
import com.kgottis.mserv.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kostas
 */
@RestController
@RequestMapping("/employee")
@Configuration
@ComponentScan
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Employee create(@RequestBody Employee employee) {
        System.err.println("save!!!");
        Employee result = employeeRepository.save(employee);
        return result;
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Employee get(@PathVariable String employeeId) {
        System.err.println("get employee!!!");
        return employeeRepository.findOne(employeeId);
    }
}
