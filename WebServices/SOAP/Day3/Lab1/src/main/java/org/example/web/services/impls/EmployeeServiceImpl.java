package org.example.web.services.impls;

import org.example.entities.Employee;
import org.example.web.services.EmployeeService;
import jakarta.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.util.*;

@WebService(endpointInterface = "org.example.web.services.EmployeeService", 
            portName = "LOLPortInServiceElement", 
            serviceName = "MahaInTheServiceNameInServiceTag")
public class EmployeeServiceImpl implements EmployeeService {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");
    //List<org.example.models.Employee> empList = new ArrayList<>();

    @Override
    public Employee addEmp(Employee emp) {
        // empList.add(emp);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee empToAdd = new Employee();
        System.out.print(emp.getFirstName() + " <--------------");
        System.out.print(emp.getEmail() + " <--------------");
        empToAdd.setFirstName(emp.getFirstName());
        empToAdd.setLastName(emp.getLastName());
        empToAdd.setEmail(emp.getEmail());
        empToAdd.setPhone(emp.getPhone());
        entityManager.persist(empToAdd);
        entityManager.getTransaction().commit();
        entityManager.close();
        return emp;
    }

    @Override
    public Employee updateEmp(Employee emp, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee empToUpdate = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();
        empToUpdate.setFirstName(emp.getFirstName());
        empToUpdate.setLastName(emp.getLastName());
        empToUpdate.setEmail(emp.getEmail());
        empToUpdate.setPhone(emp.getPhone());
        entityManager.getTransaction().commit();
        entityManager.close();
        return empToUpdate;
    }

    @Override
    public Employee deleteEmp(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee empToDelete = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(empToDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
        return empToDelete;
    }

    @Override
    public Employee getEmp(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee getEmp = entityManager.find(Employee.class, id);
        entityManager.close();
        return getEmp;
    }

}
