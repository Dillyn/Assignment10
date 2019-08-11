package ac.za.cput.Services;

import ac.za.cput.domain.Employee;

import java.util.Set;

public interface EmployeeService extends IService <Employee, String>{

    Set<Employee> getAllEmployee();
    Set<Employee> getAll();

}