package airline.Services;

import airline.Model.Flight;
import airline.Model.FlightView;
import airline.Model.SearchCriteria;
import airline.Model.TravelClass;
import airline.Repository.FlightRepository;
import airline.Repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService implements IFlightSearchService {

    public FlightSearchService() {

    }

    @Autowired
    private IFlightRepository flightRepository;

    private Predicate<Flight> isFlightAvailableForSourceDestination(String source, String destination){

        return x -> x.isFlightAvailableForSourceDestination(source, destination);

    }

    private Predicate<Flight> isFlightAvailableForDepartureDate( LocalDate departureDate) {

        return x -> x.isFlightAvailableForDepartureDate(departureDate);

    }

    private Predicate<Flight> isFlightAvailableForTravelClass(String travelClassName, int numberOfPassengers){

        return x -> x.isFlightAvailableForTravelClass(travelClassName, numberOfPassengers);

    }

    //private void calculateTotalTicketPriceForEconomy()

    @Override
    public List<Flight> search(SearchCriteria searchCriteria) {

        List<Flight> flights = flightRepository.getFlights();

         return flights.stream()
                .filter(isFlightAvailableForSourceDestination(searchCriteria.getSource(),searchCriteria.getDestination()))
                .filter(isFlightAvailableForDepartureDate(searchCriteria.getDepartureDate()))
                .filter(isFlightAvailableForTravelClass(searchCriteria.getSeatingClass(),searchCriteria.getNumberOfPassengers()))
                .collect(Collectors.toList());

    }

    @Override
    public List<FlightView> getFlightsView(SearchCriteria searchCriteria){
        List<FlightView> flightViewList = new ArrayList<>();

        List<Flight> availableFlights = search(searchCriteria);
        for(Flight flight : availableFlights){
            FlightView flightView = new FlightView();
            flightView.setFlightName(flight.getFlightName());
            flightView.setSource(flight.getSource());
            flightView.setDestination(flight.getDestination());
            flightView.setDepartureDate(flight.getDepartureDate().toString());
            TravelClass travelClass = flight.getAirplane().getTravelClassMap().get(searchCriteria.getSeatingClass());
            flightView.setTotalPrice(travelClass.calculateTotalPrice(searchCriteria));
            flightViewList.add(flightView);
        }
        return flightViewList;
    }

}
