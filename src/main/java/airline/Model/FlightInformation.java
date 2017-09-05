package airline.Model;

import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.util.Optional;

public class FlightInformation {

    private String source;
    private String destination;
    private int availableSeats;
    //private LocalDate date;
    private Optional<LocalDate> date;
    public FlightInformation(){

    }

    //public FlightInformation( String sourceName, String destinationName, int availableSeats, LocalDate date){
    public FlightInformation( String sourceName, String destinationName, int availableSeats, Optional<LocalDate> date){
        this.source = sourceName;
        this.destination = destinationName;
        this.availableSeats = availableSeats;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    //public LocalDate getDate() { return date; }

    public Optional<LocalDate> getDate() { return date; }

    public void setDate(Optional<LocalDate> date) {
   // public void setDate(LocalDate date) {
        this.date = date;
    }

    }



