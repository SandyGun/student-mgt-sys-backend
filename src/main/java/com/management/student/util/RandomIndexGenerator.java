package com.management.student.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIndexGenerator {
    public static int generateRandomFourDigitNumber() {
        return ThreadLocalRandom.current().nextInt(1000, 10000); // Generates a number between 1000 and 9999 } }
    }
}