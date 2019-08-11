package ac.za.cput.Services;

import ac.za.cput.domain.Employee;
import ac.za.cput.utils.Gender;

import java.util.Set;

public interface GenderService extends IService <Gender, String>{

    Set<Gender> getAllGender();
    Set<Gender> getAll();

}