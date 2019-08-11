package ac.za.cput.Repositories.impli;

import ac.za.cput.Repositories.EmployeeRepository;
import ac.za.cput.domain.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpli implements EmployeeRepository {

    private static EmployeeRepositoryImpli repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpli() {
        this.employees = new HashSet<>();
    }

    private Employee findEmployee(String employeeNumber) {
        return this.employees.stream()
                .filter(employees -> employees.getEmployeeNumber().trim().equals(employeeNumber))
                .findAny()
                .orElse(null);
    }

    public static EmployeeRepository getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpli();
        return repository;
    }

    public Employee create(Employee employees){
        this.employees.add(employees);
        return employees;
    }

    public Employee read(String employeeNumber){
        Employee employees = findEmployee(employeeNumber);
        return employees;
    }

    public Employee update(Employee employees) {
        Employee toDelete = findEmployee(employees.getEmployeeNumber());
        if(toDelete != null) {
            this.employees.remove(toDelete);
            return create(employees);
        }
        return null;
    }

    public void delete(String employeeNumber) {
        Employee employees = findEmployee(employeeNumber);
        if (employees != null) this.employees.remove(employees);

    }

    public Set<Employee> getAll(){
        return this.employees;
    }


}
