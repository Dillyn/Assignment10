package ac.za.cput.Services.impl;

import ac.za.cput.Repositories.EmployeeRepository;
import ac.za.cput.Services.EmployeeService;
import ac.za.cput.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }



    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Employee read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Employee> getAllEmployee() {
        Set<Employee> employeee = getAll();

        return null;
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }

}