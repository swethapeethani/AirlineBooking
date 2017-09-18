package airline.Model;

import java.time.LocalDate;

public class Economy extends TravelClass {

    public  Economy(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        super(totalSeats,availableSeats,baseFare, totalPrice);
    }

public double calculateTotalPrice(int numberOfPassengers, LocalDate departureDate) {

    int seatsOccupied = getTotalSeats() - getAvailableSeats();
    double totalPrice = getBaseFare() * numberOfPassengers;
    totalPrice = (seatsOccupied > getTotalSeats() * 0.4 && seatsOccupied < getTotalSeats() * 0.9) ?
            totalPrice + totalPrice * 0.3 :
            ((seatsOccupied > getTotalSeats() * 0.9) ? totalPrice + totalPrice * 0.6 : totalPrice);
    setTotalPrice(totalPrice);
    return totalPrice;
    }

}
