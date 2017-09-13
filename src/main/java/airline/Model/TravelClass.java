package airline.Model;

public class TravelClass {

    private int totalSeats;
    private int availableSeats;
    private double baseFare;


    public TravelClass(int totalSeats, int availableSeats,double baseFare){
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.baseFare = baseFare;

    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    /*public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }*/

    public double getBaseFare() {
        return baseFare;
    }



    /*public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }*/

}

