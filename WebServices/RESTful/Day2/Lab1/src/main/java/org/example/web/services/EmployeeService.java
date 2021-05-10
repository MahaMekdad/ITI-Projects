package org.example.web.services;

import org.example.models.dtos.*;
import java.util.*;

public interface EmployeeService {

    EmployeeDto addEmp(EmployeeDto emp);

    EmployeeDto updateEmp(EmployeeDto emp, int id);

    void deleteEmp(int id);

    EmployeeDto getEmp(int id);

    List<EmployeeDto> getAllEmps();

    void deleteAllEmps();
}
