package airline.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Optional;

public class SearchCriteria {

    private String source;
    private String destination;
    private int numberOfPassengers;
    private String dateString;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate departureDate;
    private String SeatingClass;

    public SearchCriteria(){

    }


    public SearchCriteria(String source, String destination, int numberOfPassengers, LocalDate departureDate, String SeatingClass){
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.departureDate = departureDate;
        this.SeatingClass = SeatingClass;
    }

    public String getSeatingClass() {

        SeatingClass = (SeatingClass == null) ? "Economy" : SeatingClass;
        return SeatingClass;
    }

    public void setSeatingClass(String seatingClass) {
        this.SeatingClass = seatingClass;
    }

    public String getSource() {
        this.source = (this.source == null ) ? "HYD" : this.source;

        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {

        this.destination = (this.destination == null) ? "BLR" : this.destination ;
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        numberOfPassengers = (numberOfPassengers == 0) ? 1 : numberOfPassengers;
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {

        this.numberOfPassengers = numberOfPassengers;
    }


    public String getDateString() {

        if(dateString == null || dateString.isEmpty()) {
            //this.departureDate = LocalDate.now();
            dateString = LocalDate.now().toString();
        }
        return dateString;
    }

    public void setDateString(String dateString){
        this.dateString =dateString;
    }

    public void setDepartureDate(LocalDate departureDate){
        this.departureDate = departureDate;
    }

    public LocalDate getDepartureDate()
    {
        return this.departureDate;
    }


  }
