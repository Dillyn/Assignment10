package ac.za.cput.Facotories;

import ac.za.cput.domain.Employee;
import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Race;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeFactoryTest {

    @Test
    public void getEmployeeTest(){

        String firstName = "Siraaj";
        String lastName = "Wilkinson";
        /*Gender gender = "sdfdsag", "sadgfsdag";*/

        String genderId = "1";
        String genderDescription = "Male";

        String raceId = "1";
        String raceDescription = "South African";


        Gender gender = GenderFactory.getGender(genderId, genderDescription);
        Race race = RaceFactory.getRace(raceId, raceDescription);

        Employee c = EmployeeFactory.getEmployee( firstName, lastName, gender, race);
        System.out.println(c);
        Assert.assertNotNull(c.getEmployeeNumber() + "\n" + c.getFirstName() + "\n" + c.getLastName() + "\n" + c.getGender() + "\n" + c.getRace());
    }


}
