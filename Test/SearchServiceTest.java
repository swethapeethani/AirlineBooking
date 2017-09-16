import airline.Model.SearchCriteria;
import airline.Services.FlightSearchService;
import java.time.LocalDate;

import airline.Services.IFlightSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration()
public class SearchServiceTest{

    @Autowired
    private IFlightSearchService searchService;

    @Test
    public void showFlightsFromHYDtoBLR(){

        SearchCriteria searchCriteria = new SearchCriteria("HYD","BLR",5, LocalDate.of(2017,9,14),"Economy");
        assertEquals(searchService.search(searchCriteria).size(),3);
    }

    @Test
    public void showFlightsWhenDestinationIsNull() {
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", null, 5, LocalDate.of(2017,9,14),"Economy");
        assertEquals(searchService.search(searchCriteria).size(),3);
    }

    @Test
    public void showFlightsWhenSourceIsNull() {
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria(null, "BLR", 5, LocalDate.of(2017, 9, 14), "Economy");
        assertEquals(searchService.search(searchCriteria).size(), 3);
    }

    @Test
    public void showFlightFromHYDtoBLRfor80Passengers(){
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 80, LocalDate.of(2017,9,14),"Economy");
        assertEquals(searchService.search(searchCriteria).size(),1);

    }
    //number of passengers is more than available seats
    @Test
    public void showFlightFromHYDtoBLRfor150Passengers() {
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 150, LocalDate.of(2017, 9, 14), "Economy");
        assertEquals(searchService.search(searchCriteria).size(), 0);
    }
    //When the departure date is prior to the current date,
    // list all the flights between the selected source and destination starting from todays date
    @Test
    public void showFlightHYDtoBLRon12Sep(){
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 10, LocalDate.of(2017,9,12),"Economy");
        assertEquals(searchService.search(searchCriteria).size(),3);
    }
    @Test
    public void showFlightHYDtoBLRon14SepWithSeatingClassAsNull(){
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 10, LocalDate.of(2017,9,12), null);
        assertEquals(searchService.search(searchCriteria).size(),3);
    }
    //If number of passengers is 0, take default value as 1
    @Test
    public void showFlightFromHYDtoBLRfor0Passengers() {
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 0, LocalDate.of(2017, 9, 14), "Economy");
        assertEquals(searchService.search(searchCriteria).size(), 3);
    }
}