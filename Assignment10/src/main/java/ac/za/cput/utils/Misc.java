package ac.za.cput.utils;

import java.util.UUID;

public class Misc {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
