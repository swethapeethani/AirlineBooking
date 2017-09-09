package airline.Services;

import airline.Model.Flight;
import airline.Model.SearchCriteria;
import airline.Repository.FlightRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Service
public class FlightSearchService {

    private boolean searchFlightsBySourceDestination(Flight flight, String source, String destination){

        return (flight.getSource().equalsIgnoreCase(source) && flight.getDestination().equalsIgnoreCase(destination));

    }

    private boolean  searchFlightByDepartureDate(Flight flight,LocalDate date) {

        if(date == null){
            date = LocalDate.now();
        }

        return (flight.getDepartureDate().equals(date));

    }

    private FlightRepository flightRepository = new FlightRepository();


    public List<Flight> search(SearchCriteria searchCriteria) {

        SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService();

        List<Flight> flights = flightRepository.getFlights();

        List<Flight> flightList = new ArrayList<>();

        for (Flight flight : flights) {
            if ((searchFlightsBySourceDestination(flight, searchCriteria.getSource(), searchCriteria.getDestination())) &&
                    (searchFlightByDepartureDate(flight, searchCriteria.getParsedDate()))) {

                flightList.add(flight);
            }

        }

        for(Flight flight : flightList){
            if (!seatAvailabilityService.seatAvailabiltyByClass(flight,searchCriteria.getSeatingClass(),searchCriteria.getNumberOfPassengers())) {
                flightList.remove(flight);
            }

        }

        return flightList;
    }

}
