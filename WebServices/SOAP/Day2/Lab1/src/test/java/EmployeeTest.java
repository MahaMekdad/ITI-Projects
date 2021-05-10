import org.junit.jupiter.api.*;
import org.example.services.employeeService.*;

public class EmployeeTest {

    private static EmployeeServiceImplService employeeServiceImplService;
    private static EmployeeService employeeService;
    
    @BeforeAll
    public static void beforeAll(){
        employeeServiceImplService = new EmployeeServiceImplService();
        employeeService = employeeServiceImplService.getEmployeeServiceImplPort();
    }

    @Test
    public void testAddEmp(){
        Employee empToAdd = new Employee();
        empToAdd.setFirstName("salma");
        empToAdd.setLastName("salma");
        empToAdd.setEmail("salma@gmail.com");
        empToAdd.setPhone("01146777777");
        empToAdd.setId(9);
        Employee returnedEmpAfterAdd = employeeService.addEmp(empToAdd);
        Assertions.assertTrue(returnedEmpAfterAdd.getFirstName().equals("hadeer"));
    }

    @Test
    public void testUpdateEmp(){
        Employee empToUpdate = new Employee();
        empToUpdate.setFirstName("maha");
        empToUpdate.setLastName("hadeerUPDATE");
        empToUpdate.setEmail("hadeer@gmail.comUPDATE");
        empToUpdate.setPhone("01146777777");
        empToUpdate.setId(7);
        Employee returnedEmpAfterUpdate = employeeService.updateEmp(empToUpdate, 7);
        Assertions.assertTrue(returnedEmpAfterUpdate.getFirstName().equals("maha"));
    }

    @Test
    public void testDeleteEmp() {
        Employee empToDelete = employeeService.deleteEmp(5);
        Employee getDeletedEmp = employeeService.getEmp(5);
        Assertions.assertNull(getDeletedEmp);
    }

    @AfterAll
    public static void afterAll() {
        employeeServiceImplService = null;
        employeeService = null;
    }
}