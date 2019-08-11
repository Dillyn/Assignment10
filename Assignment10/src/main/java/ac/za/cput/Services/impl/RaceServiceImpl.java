package ac.za.cput.Services.impl;

import ac.za.cput.Repositories.RaceRepository;
import ac.za.cput.Services.RaceService;
import ac.za.cput.utils.Race;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private RaceRepository repository;

    @Autowired
    public RaceServiceImpl(RaceRepository repository) {
        this.repository = repository;
    }



    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Race> getAllRace() {
        Set<Race> race = getAll();

        return null;
    }

    @Override
    public Set<Race> getAll() {
        return this.repository.getAll();
    }

}
