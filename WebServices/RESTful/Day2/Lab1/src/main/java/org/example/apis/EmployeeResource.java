package org.example.apis;

import org.example.web.services.EmployeeService;
import org.example.web.services.impls.EmployeeServiceImpl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.example.apis.exceptions.ResourceNotFoundException;
import org.example.models.dtos.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Consumes({"application/json", "application/xml"})
@Produces({"application/json", "application/xml"})
@Path("employees")
public class EmployeeResource{
    private static EmployeeService employeeService = EmployeeServiceImpl.getInstance();

    //get all emps
    @GET
    public Response getAllEmps(){
        List<EmployeeDto> emps = employeeService.getAllEmps();
        return Response.ok().entity(emps).build();
    } 

    //post new emp
    @POST
    public Response addEmp(EmployeeDto emp){
        EmployeeDto employee = employeeService.addEmp(emp);
        return Response.ok().entity(employee).build();
    }

    //delete all emps
    @DELETE
    public void deleteAllEmps(){
        employeeService.deleteAllEmps();
    }

    //get emp by id
    @GET
    @Path("{eid}")
    public Response getEmpById(@PathParam("eid") int id, @Context UriInfo uriInfo){
        EmployeeDto employee = employeeService.getEmp(id);
        if(employee == null){
            throw new ResourceNotFoundException("There are no employees found with this " + id);
        }

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        URI path = uriInfo.getBaseUriBuilder().path("employees").build();
        Link getAllEmpsLink = Link.fromUri(path).rel("retrieveAll").build();
        List<Link> links = new ArrayList<>();
        links.add(self); 
        links.add(getAllEmpsLink);
        employee.setLinks(links);
        return Response.ok().entity(employee).build();

        //doesn't return in the response but in the headers in the "Link" only
        //return Response.ok().entity(employee).links(self).build();
    }

    //put emp by id
    @PUT
    @Path("{eid}")
    public Response updateEmpById(@PathParam("eid") int id, EmployeeDto emp){
        EmployeeDto employee = employeeService.updateEmp(emp, id);
        if(employee == null){
            throw new ResourceNotFoundException("There are no employees found with this " + id);
        }
        return Response.ok().entity(employee).build();
    }

    //delete emp by id
    @DELETE
    @Path("{eid}")
    public void deleteEmpById(@PathParam("eid") int id){
        employeeService.deleteEmp(id);
    }
}