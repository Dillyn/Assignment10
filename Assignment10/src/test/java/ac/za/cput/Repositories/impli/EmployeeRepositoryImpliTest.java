package ac.za.cput.Repositories.impli;

import ac.za.cput.Facotories.EmployeeFactory;
import ac.za.cput.Facotories.GenderFactory;
import ac.za.cput.Facotories.RaceFactory;
import ac.za.cput.Repositories.EmployeeRepository;
import ac.za.cput.domain.Employee;
import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImpliTest {

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployee() {
        Set<Employee> savedEmployee = this.repository.getAll();
        return savedEmployee.iterator().next();
    }

    @Before
    public void setUp(){

        String firstName = "Siraaj";
        String lastName = "Wilkinson";
        /*Gender gender = "sdfdsag", "sadgfsdag";*/

        String genderId = "1";
        String genderDescription = "Male";

        String raceId = "1";
        String raceDescription = "South African";


      Gender gender = GenderFactory.getGender(genderId, genderDescription);
        Race race = RaceFactory.getRace(raceId, raceDescription);

        this.repository = EmployeeRepositoryImpli.getRepository();

        this.employee = EmployeeFactory.getEmployee(firstName,lastName,gender, race);

    }

    @Test
    public void a_createEmployee() {
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        assertSame(created, this.employee);
    }

    @Test
    public void c_readEmployee() {
        Employee employee = getSavedEmployee();
        System.out.println("In read, courseId = "+ employee.getEmployeeNumber());
        Employee read = this.repository.read(employee.getEmployeeNumber());
        System.out.println("In read, read = " + read);
        b_getAll();
        Assert.assertEquals(employee, read);
    }



    @Test
    public void d_updateEmployee() {
        String name = "Dillyn";
        String lastName = "Lakey";
        Employee updated = new Employee.Builder().copy(getSavedEmployee()).firstName(name)
                .lastName(lastName)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getFirstName());
    }

    @Test
    public void b_getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
      Assert.assertSame(1, all.size());
    }

    @Test
    public void e_deleteEmployee() {
        Employee employee = getSavedEmployee();
        this.repository.delete(employee.getEmployeeNumber());
    }
}