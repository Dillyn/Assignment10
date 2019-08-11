package ac.za.cput.Repositories;

import ac.za.cput.utils.Race;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {

        Set<Race> getAll();

        }
