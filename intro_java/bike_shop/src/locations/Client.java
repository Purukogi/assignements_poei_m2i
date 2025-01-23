package locations;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String firstName, lastName, address;
    private List<Location> rentedItems = new ArrayList<>();

    public Client(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public void addRentedItem(Location location){
        this.rentedItems.add(location);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Location> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(List<Location> rentedItems) {
        this.rentedItems = rentedItems;
    }

    @Override
    public String toString(){
        String toPrint = "Client: " + this.firstName + " " + this.lastName.toUpperCase() +
                "\n Address: " + this.address;
        if(!this.rentedItems.isEmpty()){
            for(Location location : rentedItems){
                toPrint += "\n Rented items: " + location.toString();
            }
        }
        return toPrint;
    }
}
