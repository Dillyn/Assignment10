package ac.za.cput.Repositories;

import ac.za.cput.utils.Gender;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {

        Set<Gender> getAll();

        }
