package test;

import locations.Gyropode;

import java.time.LocalDate;

public class TestGyropode {

    public static void main(String[] args) {

        Gyropode gyropode1 = new Gyropode("A nice brand", "Expensive model", LocalDate.of(2025, 10, 18), 500, 170);

        System.out.println(gyropode1.getRentingPrice());
        System.out.println(gyropode1);

    }

}
