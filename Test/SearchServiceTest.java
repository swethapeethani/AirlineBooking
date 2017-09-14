import airline.Model.Flight;
import airline.Model.SearchCriteria;
import airline.Services.FlightSearchService;
import java.time.LocalDate;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SearchServiceTest{

    @Test
    public void showFlightsFromHYDtoBLR(){
        FlightSearchService flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD","BLR",5, LocalDate.of(2017,9,14),"Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(),3);
    }

    @Test
    public void showFlightsWhenDestinationIsNull() {
        FlightSearchService  flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", null, 5, LocalDate.of(2017,9,14),"Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(),3);
    }

    @Test
    public void showFlightsWhenSourceIsNull() {
        FlightSearchService flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria(null, "BLR", 5, LocalDate.of(2017, 9, 14), "Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(), 3);
    }

    @Test
    public void showFlightFromHYDtoBLRfor80Passengers(){
        FlightSearchService  flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 80, LocalDate.of(2017,9,14),"Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(),1);

    }
    //number of passengers is more than available seats
    @Test
    public void showFlightFromHYDtoBLRfor150Passengers() {
        FlightSearchService flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 150, LocalDate.of(2017, 9, 14), "Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(), 0);
    }
    //When the departure date is prior to the current date,
    // list all the flights between the selected source and destination starting from todays date
    @Test
    public void showFlightHYDtoBLRon12Sep(){
        FlightSearchService  flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 10, LocalDate.of(2017,9,12),"Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(),3);
    }
    @Test
    public void showFlightHYDtoBLRon14SepWithSeatingClassAsNull(){
        FlightSearchService  flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 10, LocalDate.of(2017,9,12), null);
        assertEquals(flightSearchService.search(searchCriteria).size(),3);
    }
    //If number of passengers is 0, take default value as 1
    @Test
    public void showFlightFromHYDtoBLRfor0Passengers() {
        FlightSearchService flightSearchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 0, LocalDate.of(2017, 9, 14), "Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(), 3);
    }
}