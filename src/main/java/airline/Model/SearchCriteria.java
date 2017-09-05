package airline.Model;

import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.util.Optional;

public class SearchCriteria {

    private String source;
    private String destination;
    private int numberOfPassengers;
    private String dateString;
    private Optional<LocalDate> date;

    public SearchCriteria(){

    }

    public SearchCriteria(String source,String destination,int numberOfPassengers,Optional<LocalDate> date){
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.date = date;
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

    public void setDate(String dateString) {
        if(dateString == null || dateString.isEmpty()) {
            this.date = null;
        }
        else {
            this.date = Optional.of(LocalDate.parse(dateString));
        }

        this.dateString = dateString;
    }

    public LocalDate getDate()
    {
        return LocalDate.parse(this.dateString);
    }

    public Optional<LocalDate> getParsedDate()
    {
        return this.date;
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
