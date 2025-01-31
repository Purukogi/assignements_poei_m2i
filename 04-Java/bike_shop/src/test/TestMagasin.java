package test;

import locations.*;
import org.xml.sax.helpers.XMLReaderAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TestMagasin {

    public static void main(String[] args) {

        Velo velo1 = new Velo("LaPierre", "Speed Run 400", LocalDate.of(2021, 3, 25), 27);
        Velo velo2 = new Velo("Btwin", "Riverside 900", LocalDate.of(2022, 4, 10), 10);
        Gyropode gyropode1 = new Gyropode("Segway", "Ninebot Elite", LocalDate.of(2022, 3, 12), 40, 150);
        Gyropode gyropode2 = new Gyropode("Weebot", "echo", LocalDate.of(2022, 3, 12), 35, 160);
        Gyroroue gyroroue1 = new Gyroroue("Immotion", "v8", LocalDate.of(2022, 3, 12), 40);
        Gyroroue gyroroue2 = new Gyroroue("Segway", "Ninebot One E+", LocalDate.of(2020, 12, 4), 30);

        Magasin magasin = new Magasin();

        magasin.addCycle(velo1);
        magasin.addCycle(velo2);
        magasin.addCycle(gyropode1);
        magasin.addCycle(gyropode2);
        magasin.addCycle(gyroroue1);
        magasin.addCycle(gyroroue2);

        magasin.printInventory();


        Client client1 = new Client("John", "Doe", "123 A Street, 12345 SomeTown");
        Location location1 = new Location(client1, velo1);
        location1.setRentStart(LocalDateTime.of(2025, 1, 10, 10, 0));

        magasin.addClient(client1);
        magasin.addLocation(location1);
        System.out.println(magasin.getCurrentLocations().toString());

        location1.setRentEnd(LocalDateTime.now());


        System.out.println(client1.getFirstName() + " " + client1.getLastName() + " owes " + magasin.moneyDue(client1) + '€');

    }


}
