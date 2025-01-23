package test;

import locations.Velo;

import java.time.LocalDate;

public class testVelo {

    public static void main(String[] args) {

        Velo velo1 = new Velo("A brand", "Some model", LocalDate.of(2020, 10, 15), 10);
        Velo velo2 = new Velo("Another Brand", "A second model", LocalDate.of(2024, 11, 1), 8);

        velo1.setRentingPrice();
        System.out.println(velo1);
        System.out.println(velo2);

    }

}
