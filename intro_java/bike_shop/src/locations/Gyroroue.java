package locations;

import java.time.LocalDate;

public class Gyroroue extends Cycle{

    protected int autonomy;

    public Gyroroue(String marque, String modele, LocalDate dateAchat, int autonomy) {
        super(marque, modele, dateAchat);
        this.autonomy = autonomy;
        this.setRentingPrice();
    }

    @Override
    public void setRentingPrice(){
        this.rentingPrice = 18.90F;
    }

    @Override
    public float getRentingPrice(){
        return this.rentingPrice;
    }

    @Override
    public String toString(){
        return "Gyroroue ----------------------" + this.priceToString() + "/hour\n\t > Brand: " + this.brand +
                "\n\t > Model: " + this.model +
                "\n\t > Bought on:" + this.boughtOn +
                "\n\t > Autonomy : " + this.autonomy + "km";
    }

    public int getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(int autonomy) {
        this.autonomy = autonomy;
    }
}
