package airline.Services;

import airline.Model.Flight;
import airline.Model.SearchCriteria;
import airline.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Service
public class FlightSearchService {

    private FlightRepository flightRepository = new FlightRepository();

    private boolean searchFlightsBySourceDestination(Flight flight, String source, String destination){

        return (flight.getSource().equalsIgnoreCase(source) && flight.getDestination().equalsIgnoreCase(destination));

    }

    private boolean  searchFlightByDepartureDate(Flight flight,LocalDate date) {

        if(date == null){
            date = LocalDate.now();
        }

        return (flight.getDepartureDate().equals(date));

    }


    public List<Flight> search(SearchCriteria searchCriteria) {

        BookingService bookingService = new BookingService();

        List<Flight> flights = flightRepository.getFlights();

        List<Flight> flightList = new ArrayList<>();

       for (Flight flight : flights) {
            if ((searchFlightsBySourceDestination(flight, searchCriteria.getSource(), searchCriteria.getDestination())) &&
                    (searchFlightByDepartureDate(flight, searchCriteria.getParsedDate())) &&
                    (bookingService.seatAvailabilityByClass(flight,searchCriteria.getSeatingClass(),searchCriteria.getNumberOfPassengers()))) {

                flightList.add(flight);
            }

       }

       /* for(Flight flight : flightList){
            if (!bookingService.seatAvailabilityByClass(flight,searchCriteria.getSeatingClass(),searchCriteria.getNumberOfPassengers())) {
                flightList.remove(flight);
            }

        }*/

        return flightList;
    }

}
