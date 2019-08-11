package ac.za.cput.Services;

import ac.za.cput.utils.Race;

import java.util.Set;

public interface RaceService extends IService <Race, String>{

    Set<Race> getAllRace();
    Set<Race> getAll();

}