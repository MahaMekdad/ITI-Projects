package org.example.web.services;

import org.example.entities.*;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface EmployeeService {

    @WebMethod
    Employee addEmp(Employee emp);

    @WebMethod
    Employee updateEmp(Employee emp, int id);

    @WebMethod
    Employee deleteEmp(int id);
    
    @WebMethod
    Employee getEmp(int id);
}
