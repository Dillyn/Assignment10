package ac.za.cput.Repositories.impli;

import ac.za.cput.Facotories.GenderFactory;
import ac.za.cput.Repositories.GenderRepository;
import ac.za.cput.utils.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {
    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender() {
        Set<Gender> savedGender = this.repository.getAll();
        return savedGender.iterator().next();
    }

    @Before
    public void setUp(){


        /*Gender gender = "sdfdsag", "sadgfsdag";*/

        String genderId = "1";
        String genderDescription = "Male";




        this.repository = GenderRepositoryImpl.getRepository();

        this.gender = GenderFactory.getGender(genderId, genderDescription);

    }

    @Test
    public void a_createGender() {
        Gender created = this.repository.create(this.gender);
        System.out.println("In create, created = " + created);
        assertSame(created, this.gender);
    }

    @Test
    public void c_readGender() {
        Gender gender = getSavedGender();
        System.out.println("In read, genderId = "+ gender.getGenderNumber());
        Gender read = this.repository.read(gender.getGenderNumber());
        System.out.println("In read, read = " + read);
        b_getAll();
        Assert.assertEquals(gender, read);
    }



    @Test
    public void d_updateGender() {
        String genderNumber = "56";
        String description = "non-binary";
        Gender updated = new Gender.Builder().copy(getSavedGender()).genderNumber(genderNumber)
                .description(description)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(genderNumber, updated.getGenderNumber());
    }

    @Test
    public void b_getAll() {
        Set<Gender> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(1, all.size());
    }

    @Test
    public void e_deleteGender() {
        Gender gender = getSavedGender();
        this.repository.delete(gender.getGenderNumber());
    }
}