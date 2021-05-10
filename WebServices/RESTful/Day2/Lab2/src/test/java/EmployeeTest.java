import org.junit.jupiter.api.*;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import org.example.ClientSalma;
import org.example.models.dtos.EmployeeDto;

public class EmployeeTest {

    private static Client clientSalma;
    
    @BeforeAll
    public static void beforeAll(){
        clientSalma =  ClientSalma.getInstance();
    }

    @Test
    public void testAddEmp(){
        EmployeeDto empToAdd = new EmployeeDto();
        empToAdd.setFirstName("salma");
        empToAdd.setLastName("salma");
        empToAdd.setEmail("salma@gmail.com");
        empToAdd.setPhone("01146777777");
        empToAdd.setId(9);
        EmployeeDto emp = clientSalma.target("http://localhost:9191/RESTDay2Lab1/api/employees")
                            .request()
                            .post(Entity.entity(empToAdd, MediaType.APPLICATION_JSON), EmployeeDto.class);

        Assertions.assertTrue(emp.getFirstName().equals("salma"));
    }

    // @Test
    // public void testUpdateEmp(){
    //     Employee empToUpdate = new Employee();
    //     empToUpdate.setFirstName("maha");
    //     empToUpdate.setLastName("hadeerUPDATE");
    //     empToUpdate.setEmail("hadeer@gmail.comUPDATE");
    //     empToUpdate.setPhone("01146777777");
    //     empToUpdate.setId(7);
    //     Employee returnedEmpAfterUpdate = employeeService.updateEmp(empToUpdate, 7);
    //     Assertions.assertTrue(returnedEmpAfterUpdate.getFirstName().equals("maha"));
    // }

    // @Test
    // public void testDeleteEmp() {
    //     Employee empToDelete = employeeService.deleteEmp(5);
    //     Employee getDeletedEmp = employeeService.getEmp(5);
    //     Assertions.assertNull(getDeletedEmp);
    // }

    @AfterAll
    public static void afterAll() {
        clientSalma = null;
    }
}