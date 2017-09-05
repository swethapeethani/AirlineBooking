package airline.Repository;

import airline.Model.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class CityRepository {

    public List<City> getCities() {

        List<City> cities = new ArrayList<City>();
        cities.add(new City("HYD","Hyderabad"));
        cities.add(new City("BLR", "Bangalore"));
        cities.add(new City("CHN", "Chennai"));
        cities.add(new City("PUN", "Pune"));

        return cities;
    }
}


