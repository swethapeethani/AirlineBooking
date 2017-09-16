package airline.Model;

public class TravelClass {

    private int totalSeats;
    private int availableSeats;
    private double baseFare;
    private double totalPrice;


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

    public double getBaseFare() {
        return baseFare;
    }

    public double getTotalPrice(int numberOfPassenger){

        int seatsOccupied = totalSeats - availableSeats;
        totalPrice = baseFare * numberOfPassenger;
        totalPrice  = (seatsOccupied > totalSeats * 0.4 && seatsOccupied < totalSeats * 0.9) ? totalPrice + totalPrice * 0.3 :
                ((seatsOccupied > totalSeats * 0.9) ? totalPrice + totalPrice * 0.6 : totalPrice);
        return totalPrice;
    }


}

