package locations;

import java.time.LocalDate;

public class Velo extends Cycle{

    private int numberOfGears;

    public Velo(String marque, String modele, LocalDate dateAchat, int numberOfGears) {
        super(marque, modele, dateAchat);
        this.numberOfGears = numberOfGears;
        this.setRentingPrice();
    }

    @Override
    public void setRentingPrice(){
        this.rentingPrice = 4.90F;
    }

    @Override
    public float getRentingPrice(){
        return this.rentingPrice;
    }

    @Override
    public String toString(){
        return "Velo --------------------------" + this.priceToString() + "/hour\n\t > Brand: " + this.brand +
                "\n\t > Model: " + this.model +
                "\n\t > Bought on:" + this.boughtOn +
                "\n\t > Number of gears: " + this.numberOfGears;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }
}
