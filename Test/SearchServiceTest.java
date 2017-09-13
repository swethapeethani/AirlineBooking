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
        SearchCriteria searchCriteria = new SearchCriteria("HYD","BLR",50,LocalDate.of(2017,9,11),"Economy");
        assertEquals(flightSearchService.search(searchCriteria).size(),2);
    }

}