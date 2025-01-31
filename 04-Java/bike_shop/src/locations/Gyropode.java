package locations;

import java.time.LocalDate;

public class Gyropode extends Gyroroue{

    private int minHeight;

    public Gyropode(String marque, String modele, LocalDate dateAchat, int autonomie, int minHeight) {
        super(marque, modele, dateAchat, autonomie);
        this.minHeight = minHeight;
        this.setRentingPrice();
    }

    @Override
    public void setRentingPrice(){
        this.rentingPrice = 29.90F;
    }

    @Override
    public float getRentingPrice(){
        return this.rentingPrice;
    }

    @Override
    public String toString(){
        return "Gyropode ----------------------" + this.priceToString() + "/hour\n\t > Brand: " + this.brand +
                "\n\t > Model: " + this.model +
                "\n\t > Bought on:" + this.boughtOn +
                "\n\t > Autonomy: " + this.autonomy + "km" +
                "\n\t > Minimal height to ride: " + this.minHeight +"cm";
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }
}
