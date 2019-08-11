package ac.za.cput.Services.impl;

import ac.za.cput.Facotories.GenderFactory;
import ac.za.cput.Repositories.impli.GenderRepositoryImpl;
import ac.za.cput.utils.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {

    private GenderRepositoryImpl repository;
    private Gender gender;

    private Gender getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        String genderID = "1";
        String genderDesc = "Male";


        this.repository = (GenderRepositoryImpl) GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.getGender(genderID,genderDesc);
    }

    @Test
    public void a_create() {
        Gender created = this.repository.create(this.gender);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.gender);
    }

    @Test
    public void d_update() {


        String genderID = "2";
        String genderDesc = "Male";

        Gender g = GenderFactory.getGender(genderID, genderDesc);



        Gender updated = new Gender.Builder().copy(getSaved()).genderNumber(genderID)
                .description(genderDesc)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(genderID, updated.getGenderNumber());
    }

    @Test
    public void e_delete() {
        Gender saved = getSaved();
        this.repository.delete(saved.getGenderNumber());
        //d_getAll();
    }

    @Test
    public void b_read() {
        Gender saved = getSaved();
        Gender read = this.repository.read(saved.getGenderNumber());
        System.out.println("In read, read = " + read);

    }

    @Test
    public void c_getAll() {
        Set<Gender> genders = this.repository.getAll();
        System.out.println("In get all, all = " + genders);
        assertSame(1 ,genders.size());
    }

}