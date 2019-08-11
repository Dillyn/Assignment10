package ac.za.cput.domain;

import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Race;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class  Employee {
    private String employeeNumber;
    private String firstName, lastName;
    private Gender gender;
    private Race race;

    private Employee() {
    }

    private Employee(Employee.Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.race = builder.race;

    }

    public String getEmployeeNumber() { return employeeNumber; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() { return gender; }

    public Race getRace(){ return  race; }

    public static class Builder {

        private String employeeNumber, firstName, lastName;
        private Gender gender;
        private Race race;

        public Employee.Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Employee.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Employee.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Employee.Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Employee.Builder race(Race race) {
            this.race = race;
            return this;
        }

        public Builder copy(Employee employee){
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.employeeNumber = employee.employeeNumber;
            this.race = employee.race;
            this.gender = employee.gender;
            return this;
        }



        public Employee build() {
            return new Employee(this);
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee.equals(employee.employeeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }

}
