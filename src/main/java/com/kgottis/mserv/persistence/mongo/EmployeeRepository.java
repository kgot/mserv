/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.persistence.mongo;

import com.kgottis.mserv.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author kostas
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
    /**
     * Get employee by id.
     * 
     * @param employeeId
     * @return
     */
    public Employee findByEmployeeId(String employeeId);
    
    /**
     * Get employee by email.
     * 
     * @param email
     * @return
     */
    public Employee findByEmail(String email);
    
    /**
     * Get employee by full name.
     * 
     * @param fullName
     * @return
     */
    public Employee findByFullName(String fullName);
}
