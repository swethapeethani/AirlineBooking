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
        return dateString;
    }

    public void setDateString(String dateString){
        this.dateString =dateString;
    }

    public void setDepartureDate(String dateString) {
        if(dateString == null || dateString.isEmpty()) {
            this.departureDate = null;
        }
        else {
            this.departureDate = LocalDate.parse(dateString);
        }

        this.dateString = dateString;
    }

    public LocalDate getDepartureDate()
    {
        return LocalDate.parse(this.dateString);
    }

    public LocalDate getParsedDate()
    {
        return this.departureDate = LocalDate.parse(this.dateString);
    }



    /*
    public boolean isNull(Field field) {
            try {
                Object value = field.get(this);
                if (value != null) {
                    return false;
                }
            }
            catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return true;

    }
    */
}
