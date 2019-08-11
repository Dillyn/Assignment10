package ac.za.cput.Services.impl;

import ac.za.cput.Facotories.RaceFactory;
import ac.za.cput.Repositories.impli.RaceRepositoryImpl;
import ac.za.cput.utils.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {
    private RaceRepositoryImpl repository;
    private Race race;

    private Race getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        String genderID = "1";
        String genderDesc = "South African";


        this.repository = (RaceRepositoryImpl) RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.getRace(genderID,genderDesc);
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void d_update() {


        String genderID = "2";
        String genderDesc = "Italian";

        Race g = RaceFactory.getRace(genderID, genderDesc);



        Race updated = new Race.Builder().copy(getSaved()).raceNumber(genderID)
                .description(genderDesc)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(genderID, updated.getRaceNumber());
    }

    @Test
    public void e_delete() {
        Race saved = getSaved();
        this.repository.delete(saved.getRaceNumber());
        //d_getAll();
    }

    @Test
    public void b_read() {
        Race saved = getSaved();
        Race read = this.repository.read(saved.getRaceNumber());
        System.out.println("In read, read = " + read);

    }

    @Test
    public void c_getAll() {
        Set<Race> races = this.repository.getAll();
        System.out.println("In get all, all = " + races);
        assertSame(1 ,races.size());
    }

}