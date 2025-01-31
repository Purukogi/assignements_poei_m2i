package test;

import locations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestLocation {

    public static void main(String[] args) {

        Client client1 = new Client("John", "Doe", "123 A Street, 12345 SomeTown");

        Velo velo1 = new Velo("LaPierre", "Speed Run 400", LocalDate.of(2021, 3, 25), 27);

        Location location1 = new Location(client1, velo1);

        System.out.println(client1);

        location1.setRentStart(LocalDateTime.of(2025, 1, 10, 10, 0));
        location1.setRentEnd(LocalDateTime.now());
        System.out.println(location1.amountDue());

    }

}
