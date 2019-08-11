package ac.za.cput.Repositories;

import ac.za.cput.domain.Employee;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {

    Set<Employee> getAll();

}