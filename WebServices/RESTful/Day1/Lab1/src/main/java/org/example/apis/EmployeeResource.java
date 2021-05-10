package org.example.apis;

import org.example.web.services.EmployeeService;
import org.example.web.services.impls.EmployeeServiceImpl;
import java.util.List;
import org.example.models.dtos.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Consumes({"application/json", "application/xml"})
@Produces({"application/json", "application/xml"})
@Path("employees")
public class EmployeeResource{
    private static EmployeeService employeeService = EmployeeServiceImpl.getInstance();

    //get all emps
    @GET
    public List<EmployeeDto> getAllEmps(){
        return employeeService.getAllEmps();
    } 

    //post new emp
    @POST
    public EmployeeDto addEmp(EmployeeDto emp){
        return employeeService.addEmp(emp);
    }

    //delete all emps
    @DELETE
    public void deleteAllEmps(){
        employeeService.deleteAllEmps();
    }

    //get emp by id
    @GET
    @Path("{eid}")
    public EmployeeDto getEmpById(@PathParam("eid") int id){
        return employeeService.getEmp(id);
    }

    //put emp by id
    @PUT
    @Path("{eid}")
    public EmployeeDto updateEmpById(@PathParam("eid") int id, EmployeeDto emp){
        return employeeService.updateEmp(emp, id);
    }

    //delete emp by id
    @DELETE
    @Path("{eid}")
    public void deleteEmpById(@PathParam("eid") int id){
        employeeService.deleteEmp(id);
    }
}