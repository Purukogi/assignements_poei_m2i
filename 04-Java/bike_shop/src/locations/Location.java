package locations;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Location {

    private LocalDateTime rentStart, rentEnd;
    private Client client;
    private Cycle article;
    private Boolean hasBeenPaid;

    public void stopRenting(){
        this.rentEnd = LocalDateTime.now();
    }

    public float amountDue(){
        long hoursRented = ChronoUnit.HOURS.between(this.getRentStart(), this.getRentEnd());
        return hoursRented*this.article.getRentingPrice();
    }

    public Location(Client client, Cycle article) {
        this.client = client;
        this.client.addRentedItem(this);
        this.article = article;
        this.setRentStart(LocalDateTime.now());
    }

    public Location(Location location) {
        this.client = location.client;
        this.article = location.article;
        this.setRentStart(LocalDateTime.now());
    }

    public LocalDateTime getRentStart() {
        return rentStart;
    }

    public void setRentStart(LocalDateTime rentStart) {
        this.rentStart = rentStart;
    }

    public LocalDateTime getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDateTime rentEnd) {
        this.rentEnd = rentEnd;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cycle getArticle() {
        return article;
    }

    public void setArticle(Cycle article) {
        this.article = article;
    }

    public Boolean getHasBeenPaid() {
        return hasBeenPaid;
    }

    public void setHasBeenPaid(Boolean hasBeenPaid) {
        this.hasBeenPaid = hasBeenPaid;
    }

    @Override
    public String toString(){
        return "Client: " + this.client.getFirstName() + " " + this.client.getLastName().toUpperCase() +
                "\n Article: " + this.article +
                "\n Start date: " + this.rentStart;
    }
}
