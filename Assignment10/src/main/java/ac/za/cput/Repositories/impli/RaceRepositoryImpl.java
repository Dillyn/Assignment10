package ac.za.cput.Repositories.impli;

import ac.za.cput.Repositories.RaceRepository;
import ac.za.cput.utils.Race;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl repository = null;
    private Set<Race> races;

    private RaceRepositoryImpl() {
        this.races = new HashSet<>();
    }

    private Race findRace(String raceNumber) {
        return this.races.stream()
                .filter(races -> races.getRaceNumber().trim().equals(raceNumber))
                .findAny()
                .orElse(null);
    }

    public static RaceRepository getRepository(){
        if(repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    public Race create(Race races){
        this.races.add(races);
        return races;
    }

    public Race read(String raceNumber){
        Race races = findRace(raceNumber);
        return races;
    }

    public Race update(Race races) {
        Race toDelete = findRace(races.getRaceNumber());
        if(toDelete != null) {
            this.races.remove(toDelete);
            return create(races);
        }
        return null;
    }

    public void delete(String raceNumber) {
        Race races = findRace(raceNumber);
        if (races != null) this.races.remove(races);

    }

    public Set<Race> getAll(){
        return this.races;
    }


}
