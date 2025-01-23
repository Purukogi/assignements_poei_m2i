package locations;

import exceptions.NoClientFoundException;
import exceptions.NoItemFoundException;

import java.util.ArrayList;
import java.util.List;

public class Magasin {

    List<Cycle> inventory = new ArrayList<>();
    List<Location> currentRents = new ArrayList<>();
    List<Client> clientsList = new ArrayList<>();

    public void addCycle(Cycle cycle){
        inventory.add(cycle);
    }

    public void addLocation(Location location) { currentRents.add(location); }

    public void addClient(Client client) { clientsList.add(client); }

    public Cycle searchCycle(String model) throws NoItemFoundException{
        for(Cycle cycle : this.inventory){
            if(cycle.getModel().equals(model)){
                return cycle;
            }
        }
        throw new NoItemFoundException("No such item in inventory!");
    }

    public void removeCycle(Cycle cycle) throws NoItemFoundException{
        try {
            inventory.remove(cycle);
        } catch (Exception e) {
            throw new NoItemFoundException("No such item in inventory!");
        }
    }

    public List<Location> getCurrentLocations(){
        List<Location> currentLocations = new ArrayList<>();
        for(Location location : this.currentRents){
            if(location.getRentEnd() == null){
                currentLocations.add(location);
            }
        }
        return currentLocations;
    }

    public Client findClient(String name){
        for(Client client : clientsList){
            if(client.getLastName().equals(name)){
                return client;
            }
        }
        throw new NoClientFoundException("No such client found");
    }

    public float moneyDue(Client client){
        float amount = 0;
        for(Location location : client.getRentedItems()){
            amount += location.amountDue();
        }
        return amount;
    }

    public void printInventory(){
        System.out.println("############### SHOP'S INVENTORY #################");
        inventory.forEach(System.out::println);
    }

    public List<Cycle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Cycle> inventory) {
        this.inventory = inventory;
    }

    public List<Location> getCurrentRents() {
        return currentRents;
    }

    public void setCurrentRents(List<Location> currentRents) {
        this.currentRents = currentRents;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }
}
