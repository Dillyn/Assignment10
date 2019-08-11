package ac.za.cput.Repositories.impli;

import ac.za.cput.Facotories.RaceFactory;
import ac.za.cput.Repositories.RaceRepository;
import ac.za.cput.utils.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RaceRepositoryImplTest {
    private RaceRepository repository;
    private Race race;

    private Race getSavedRace() {
        Set<Race> savedGender = this.repository.getAll();
        return savedGender.iterator().next();
    }

    @Before
    public void setUp(){


        /*Gender gender = "sdfdsag", "sadgfsdag";*/

        String genderId = "1";
        String genderDescription = "South African";




        this.repository = RaceRepositoryImpl.getRepository();

        this.race = RaceFactory.getRace(genderId, genderDescription);

    }

    @Test
    public void a_createRace() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        assertSame(created, this.race);
    }

    @Test
    public void c_readRace() {
        Race race = getSavedRace();
        System.out.println("In read, RaceId = "+ race.getRaceNumber());
        Race read = this.repository.read(race.getRaceNumber());
        System.out.println("In read, read = " + read);
        b_getAll();
        Assert.assertEquals(race, read);
    }



    @Test
    public void d_updateRace() {
        String genderNumber = "1";
        String description = "American";
        Race updated = new Race.Builder().copy(getSavedRace()).raceNumber(genderNumber)
                .description(description)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(genderNumber, updated.getRaceNumber());
    }

    @Test
    public void b_getAll() {
        Set<Race> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(1, all.size());
    }

    @Test
    public void e_deleteRace() {
        Race race = getSavedRace();
        this.repository.delete(race.getRaceNumber());
    }
}