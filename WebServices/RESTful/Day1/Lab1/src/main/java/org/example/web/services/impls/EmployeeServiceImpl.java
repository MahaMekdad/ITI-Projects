package org.example.web.services.impls;

import org.example.entities.Employee;
import org.example.models.dtos.EmployeeDto;
import org.example.web.services.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl employeeServiceImpl = null;

    public static EmployeeService getInstance() {
        if (employeeServiceImpl == null) {
            synchronized (EmployeeServiceImpl.class) {
                if (employeeServiceImpl == null) {
                    employeeServiceImpl = new EmployeeServiceImpl();
                }
            }
        }
        return employeeServiceImpl;
    }

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");

    @Override
    public EmployeeDto addEmp(EmployeeDto emp) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee empToAdd = new Employee();
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
    public EmployeeDto updateEmp(EmployeeDto emp, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee empToUpdate = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();
        empToUpdate.setFirstName(emp.getFirstName());
        empToUpdate.setLastName(emp.getLastName());
        empToUpdate.setEmail(emp.getEmail());
        empToUpdate.setPhone(emp.getPhone());
        entityManager.getTransaction().commit();
        entityManager.close();
        return emp;
    }

    @Override
    public void deleteEmp(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee empToDelete = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(empToDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public EmployeeDto getEmp(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee getEmp = entityManager.find(Employee.class, id);
        entityManager.close();
        EmployeeDto empToReturn = new EmployeeDto(getEmp.getId(), getEmp.getFirstName(), getEmp.getLastName(), getEmp.getPhone(), getEmp.getEmail());
        return empToReturn;
    }

    @Override
    public List<EmployeeDto> getAllEmps() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> emps = query.getResultList();
        List<EmployeeDto> empsList = new ArrayList<>();
        for (Employee em : emps) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(em.getId());
            employeeDto.setFirstName(em.getFirstName());
            employeeDto.setLastName(em.getLastName());
            employeeDto.setEmail(em.getEmail());
            employeeDto.setPhone(em.getPhone());
            empsList.add(employeeDto);
        }
        entityManager.close();
        return empsList;
    }

    @Override
    public void deleteAllEmps() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Employee");
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
