/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.controller;

import com.kgottis.mserv.domain.Employee;
import com.kgottis.mserv.persistence.mongo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @RequestMapping(value = "/id/{employeeId}", method = RequestMethod.GET)
    public Employee getById(@PathVariable String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);            
    }
    
    @RequestMapping(value = "/fullname/{fullName}", method = RequestMethod.GET)
    public Employee getByFullName(@PathVariable String fullName) {
        return employeeRepository.findByFullName(fullName);            
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public Employee getByEmail(@PathVariable String email) {
        return employeeRepository.findByEmail(email);            
    }
}
