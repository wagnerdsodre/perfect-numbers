package com.wdgs.poc.testingperfectnumber.utils;

public class PerfectNumber {

    public static Integer searchPerfectNumber(int number) {

        int counter = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                counter += i;
            }
        }
        if (counter == number) {
            return number;
        }

        return 0;
    }


}
