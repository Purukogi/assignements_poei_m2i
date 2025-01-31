package test;

import locations.Gyroroue;

import java.time.LocalDate;

public class TestGyroroue {

    public static void main(String[] args) {

        Gyroroue gyroroue1 = new Gyroroue("A brand", "Some model", LocalDate.of(2020, 10, 15), 200);
        Gyroroue gyroroue2 = new Gyroroue("Another Brand", "A second model", LocalDate.of(2024, 11, 1), 350);

        System.out.println(gyroroue1.getRentingPrice());
        System.out.println(gyroroue2);

    }

}
