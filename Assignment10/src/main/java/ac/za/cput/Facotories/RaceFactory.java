package ac.za.cput.Facotories;

import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Race;

public class RaceFactory {
    public static Race getRace(String raceId, String description ){
        return new Race.Builder()
                .raceNumber(raceId)
                .description(description)
                .build();
    }
}
