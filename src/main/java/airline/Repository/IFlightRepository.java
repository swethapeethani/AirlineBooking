package airline.Repository;

import airline.Model.Flight;

import java.util.ArrayList;

public interface IFlightRepository {
    ArrayList<Flight> getFlights();
}
