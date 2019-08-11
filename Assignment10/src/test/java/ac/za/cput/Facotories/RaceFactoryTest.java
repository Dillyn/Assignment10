package ac.za.cput.Facotories;

import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Race;
import org.junit.Assert;
import org.junit.Test;
/*import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;*/

public class RaceFactoryTest {

    @Test
    public void getRace() {


        String raceId = "1";
        String raceDescription = "South African";


        Race race = RaceFactory.getRace(raceId, raceDescription);


        System.out.println(race);
        Assert.assertNotNull(race);
    }
}

