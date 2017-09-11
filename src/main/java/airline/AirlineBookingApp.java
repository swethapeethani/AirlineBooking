package airline;

import airline.Controller.FlightController;
import org.springframework.boot.SpringApplication;

public class AirlineBookingApp {

    public static void main(String []args) {

        SpringApplication.run(FlightController.class,args);
    }
}
