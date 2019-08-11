package ac.za.cput.Services.impl;

import ac.za.cput.Repositories.GenderRepository;
import ac.za.cput.Services.GenderService;
import ac.za.cput.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GenderServiceImpl implements GenderService {

    private GenderRepository repository;

    @Autowired
    public GenderServiceImpl(GenderRepository repository) {
        this.repository = repository;
    }



    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Gender> getAllGender() {
        Set<Gender> gender = getAll();

        return null;
    }

    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }

}
