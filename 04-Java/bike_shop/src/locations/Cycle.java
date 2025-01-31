package locations;

import java.time.LocalDate;

public abstract class Cycle {

    protected String brand, model;
    protected LocalDate boughtOn;
    protected float rentingPrice;

    public Cycle(String brand, String model, LocalDate boughtOn) {
        this.brand = brand;
        this.model = model;
        this.boughtOn = boughtOn;
    }

    public String priceToString(){
        String price = Float.toString(100*this.getRentingPrice());
        StringBuilder builder = new StringBuilder(price.substring(0, price.length() - 2));
        builder.insert(builder.length() - 2, '€');
        price = builder.toString();
        return price;
    }

    public abstract void setRentingPrice();

    public abstract float getRentingPrice();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getBoughtOn() {
        return boughtOn;
    }

    public void setBoughtOn(LocalDate boughtOn) {
        this.boughtOn = boughtOn;
    }
}
