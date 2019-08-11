package ac.za.cput.Facotories;

import ac.za.cput.utils.Gender;
import org.junit.Assert;
import org.junit.Test;
/*import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;*/

public class GenderFactoryTest {

    @Test
   public void getEGender() {


        String genderId = "1";
        String genderDescription = "Male";




        Gender gender = GenderFactory.getGender(genderId, genderDescription);


        System.out.println(gender);
        Assert.assertNotNull( gender );
    }
}