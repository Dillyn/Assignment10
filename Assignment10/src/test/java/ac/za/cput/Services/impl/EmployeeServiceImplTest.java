package ac.za.cput.Services.impl;

import ac.za.cput.Facotories.EmployeeFactory;
import ac.za.cput.Facotories.GenderFactory;
import ac.za.cput.Facotories.RaceFactory;
import ac.za.cput.Repositories.EmployeeRepository;
import ac.za.cput.Repositories.impli.EmployeeRepositoryImpli;
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
public class EmployeeServiceImplTest {


    private EmployeeRepositoryImpli repository;
    private Employee employee;

    private Employee getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        String genderID = "1";
        String genderDesc = "Male";
        String raceNum = "1";
        String raceDesc = "Arab";

        Gender g = GenderFactory.getGender(genderID, genderDesc);
        Race r = RaceFactory.getRace(raceNum, raceDesc);

        this.repository = (EmployeeRepositoryImpli) EmployeeRepositoryImpli.getRepository();
        this.employee = EmployeeFactory.getEmployee("Carly", "Josias", g, r);
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void d_update() {

        String fname = "Peter";
        String lname = "Parker";
        String genderID = "1";
        String genderDesc = "Male";
        String raceNum = "1";
        String raceDesc = "Arab";

        Gender g = GenderFactory.getGender(genderID, genderDesc);
        Race r = RaceFactory.getRace(raceNum, raceDesc);


        Employee updated = new Employee.Builder().copy(getSaved()).firstName(fname)
                .lastName(lname)
                .gender(g)
                .race(r)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(fname, updated.getFirstName());
    }

    @Test
    public void e_delete() {
        Employee saved = getSaved();
        this.repository.delete(saved.getEmployeeNumber());
        //d_getAll();
    }

    @Test
    public void b_read() {
        Employee saved = getSaved();
        Employee read = this.repository.read(saved.getEmployeeNumber());
        System.out.println("In read, read = " + read);

    }

    @Test
    public void c_getAll() {
        Set<Employee> employees = this.repository.getAll();
        System.out.println("In get all, all = " + employees);
        assertSame(1 ,employees.size());
    }

}