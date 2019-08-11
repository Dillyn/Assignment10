package ac.za.cput.Facotories;

import ac.za.cput.domain.Employee;
import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Misc;
import ac.za.cput.utils.Race;

public class EmployeeFactory {
    public static Employee getEmployee( String firstName, String lastName, Gender gender, Race race) {
        return new Employee.Builder()
                .employeeNumber(Misc.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .race(race)
                .build();
    }

}
