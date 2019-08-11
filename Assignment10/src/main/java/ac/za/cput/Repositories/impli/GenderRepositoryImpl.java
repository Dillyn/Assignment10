package ac.za.cput.Repositories.impli;

import ac.za.cput.Repositories.GenderRepository;
import ac.za.cput.utils.Gender;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl repository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl() {
        this.genders = new HashSet<>();
    }

    private Gender findGender(String genderNumber) {
        return this.genders.stream()
                .filter(genders -> genders.getGenderNumber().trim().equals(genderNumber))
                .findAny()
                .orElse(null);
    }

    public static GenderRepository getRepository(){
        if(repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }

    public Gender create(Gender genders){
        this.genders.add(genders);
        return genders;
    }

    public Gender read(String genderNumber){
        Gender genders = findGender(genderNumber);
        return genders;
    }

    public Gender update(Gender genders) {
        Gender toDelete = findGender(genders.getGenderNumber());
        if(toDelete != null) {
            this.genders.remove(toDelete);
            return create(genders);
        }
        return null;
    }

    public void delete(String genderNumber) {
        Gender genders = findGender(genderNumber);
        if (genders != null) this.genders.remove(genders);

    }

    public Set<Gender> getAll(){
        return this.genders;
    }


}
