package airline.Model;

import java.time.LocalDate;

public class Business extends TravelClass {

    public  Business(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        super(totalSeats,availableSeats,baseFare, totalPrice);
    }

    public double calculateTotalPrice(int numberOfPassengers, LocalDate departureDate) {

        double totalPrice = getBaseFare() * numberOfPassengers;

        //1,5,7 represent Monday,Friday, Sunday respectively
        totalPrice = ((departureDate.getDayOfWeek().getValue() == 1) ||
                    (departureDate.getDayOfWeek().getValue() == 5) ||
                    (departureDate.getDayOfWeek().getValue() == 7))?
                    (totalPrice + (getBaseFare() * numberOfPassengers * 0.4)) : totalPrice;

        return totalPrice;
    }

}
