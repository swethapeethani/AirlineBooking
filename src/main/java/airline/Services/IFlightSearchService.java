package airline.Services;

import airline.Model.Flight;
import airline.Model.FlightView;
import airline.Model.SearchCriteria;

import java.util.List;

public interface IFlightSearchService {
    List<Flight> search(SearchCriteria searchCriteria);

    List<FlightView> getFlightsView(SearchCriteria searchCriteria);
}
