package airline.Model;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit.*;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class First extends TravelClass {

    public  First(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        super(totalSeats,availableSeats,baseFare, totalPrice);
    }

    public double calculateTotalPrice(int numberOfPassengers, LocalDate departureDate) {
        long numberOfDaysLeftForBooking = DAYS.between(LocalDate.now(),departureDate);

        if( numberOfDaysLeftForBooking <= 10) {
          return (getBaseFare() + getBaseFare()*(10 - numberOfDaysLeftForBooking ) * 0.1 )* numberOfPassengers;
        }
        return 0;
    }

}