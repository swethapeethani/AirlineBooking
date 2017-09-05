package airline.Model;

import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;

public class SearchCriteria {

    private String source;
    private String destination;
    private int numberOfPassengers;
    private LocalDate date;

    public SearchCriteria(){

    }

    public SearchCriteria(String source,String destination,int numberOfPassengers,LocalDate date){
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.date = LocalDate.of(date);
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
    public LocalDate getDate() {

        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
