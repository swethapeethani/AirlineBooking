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
        return SeatingClass;
    }

    public void setSeatingClass(String seatingClass) {
        this.SeatingClass = seatingClass;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }


    public String getDateString() {

        if(dateString == null || dateString.isEmpty()) {
            this.departureDate = null;
            dateString = LocalDate.now().toString();
        }
        return dateString;
    }

    public void setDateString(String dateString){
        this.dateString =dateString;
    }

    public void setDepartureDate(String dateString) {
        if(dateString == null || dateString.isEmpty()) {
            this.departureDate = LocalDate.now();
        }
        else {
            this.departureDate = LocalDate.parse(dateString);
        }

        this.dateString = dateString;
    }

    public LocalDate getDepartureDate()
    {
        if(dateString == null || dateString.isEmpty()) {
            this.departureDate = null;
        }
        else {
            this.departureDate = LocalDate.parse(dateString);
        }
        return this.departureDate;
    }


  }
