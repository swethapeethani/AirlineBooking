package airline.Model;

public class TravelClass {
    int totalSeats;
    int availableSeats;


    public TravelClass(int totalSeats, int availableSeats){
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

