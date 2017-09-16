package airline.Model;

import java.time.LocalDate;

public class Business extends TravelClass {

    public  Business(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        super(totalSeats,availableSeats,baseFare, totalPrice);
    }

    public double calculateTotalPrice(SearchCriteria searchCriteria) {

        double totalPrice = getBaseFare() * searchCriteria.getNumberOfPassengers();

        //1,5,7 represent Monday,Friday, Sunday respectively
        totalPrice = ((searchCriteria.getDepartureDate().getDayOfWeek().getValue() == 1) ||
                    (searchCriteria.getDepartureDate().getDayOfWeek().getValue() == 5) ||
                    (searchCriteria.getDepartureDate().getDayOfWeek().getValue() == 7))?
                    (totalPrice + (getBaseFare() * searchCriteria.getNumberOfPassengers() * 0.4)) : totalPrice;

        return totalPrice;
    }

}
