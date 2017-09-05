package airline.Model;


public class City {

    private String id;

    private String name;

    public City(String id, String cityName){
        this.id = id;
        this.name = cityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }

    public void setName(String name){

        this.name = name;
    }
}
