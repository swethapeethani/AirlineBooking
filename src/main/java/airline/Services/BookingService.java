package airline.Services;

import airline.Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class BookingService {

    FlightSearchService flightSearchService;

    public  boolean seatAvailabilityByClass(Flight flight, String className, int numberOfPassengers){

        if (flight.getAirplane().getTravelClassMap().containsKey(className) ){


            if(flight.getAirplane().getTravelClassMap().get(className).getAvailableSeats() >= numberOfPassengers){
                flight.setTotalPrice(flight.getAirplane().getTravelClassMap().get(className).getBaseFare() *
                        numberOfPassengers);
                flight.setAvailableSeats(flight.getAirplane().getTravelClassMap().get(className).getAvailableSeats());

                return true;
            }

            else { return false; }


        }
        else { return false; }

    }

}
