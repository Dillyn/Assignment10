package ac.za.cput.Facotories;

import ac.za.cput.domain.Employee;
import ac.za.cput.utils.Gender;
import ac.za.cput.utils.Misc;
import ac.za.cput.utils.Race;

public class GenderFactory {
    public static Gender getGender(String genderId, String description ){
        return new Gender.Builder()
                .genderNumber(genderId)
                .description(description)
                .build();
    }
}
