package org.example.main;

import org.example.services.employeeService.Employee;
import org.example.services.employeeService.EmployeeService;
import org.example.services.employeeService.EmployeeServiceImplService;

public class Main {
    public static void main(String [] args){
        EmployeeServiceImplService employeeServiceImplService = new EmployeeServiceImplService();
        EmployeeService employeeService = employeeServiceImplService.getEmployeeServiceImplPort();

        Employee empToAdd = new Employee();
        empToAdd.setFirstName("zeina");
        empToAdd.setLastName("zeina");
        empToAdd.setEmail("zeina@gmail.com");
        empToAdd.setPhone("01146777777");
        empToAdd.setId(1);
        
        Employee returnedEmpAfterAdd = employeeService.addEmp(empToAdd);

        System.out.print(returnedEmpAfterAdd.getFirstName() + " Added to db successfully");
    }
}