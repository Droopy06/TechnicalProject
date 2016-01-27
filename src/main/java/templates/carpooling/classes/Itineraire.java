package templates.carpooling.classes;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
public class Itineraire {

    private long id;
    private String departure;
    private String arrival;
    private long price;
    private int seat;

    public Itineraire() {
        this.id = 1L;
        this.departure = "";
        this.arrival = "";
        this.price = 0;
        this.seat = 4;
    }

    public Itineraire(long id, String departure, String arrival, long price, int seat) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
