package model;



/**
 *
 * @author kibsoft
 */
public class Order {
    private String name;

    private String pickLocation;

    private String dropLocation;
    
    private String pickLatitude;
    
    private String pickLongitude;
    
    private String dropLatitude;
    
    private String dropLongitude;

    public Order() {
    }
    
    

    public Order(String the_name, String pick_at, String drop_at) {
        this.name = the_name;
        this.pickLocation = pick_at;
        this.dropLocation = drop_at;
    }

    public Order(String name, String pickLatitude, String pickLongitude, String dropLatitude, String dropLongitude) {
        this.name = name;
        this.pickLatitude = pickLatitude;
        this.pickLongitude = pickLongitude;
        this.dropLatitude = dropLatitude;
        this.dropLongitude = dropLongitude;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(String pickLocation) {
        this.pickLocation = pickLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }
    
    public String getPickLatitude() {
        return pickLatitude;
    }

    public void setPickLatitude(String pickLatitude) {
        this.pickLatitude = pickLatitude;
    }

    public String getPickLongitude() {
        return pickLongitude;
    }

    public void setPickLongitude(String pickLongitude) {
        this.pickLongitude = pickLongitude;
    }

    public String getDropLatitude() {
        return dropLatitude;
    }

    public void setDropLatitude(String dropLatitude) {
        this.dropLatitude = dropLatitude;
    }

    public String getDropLongitude() {
        return dropLongitude;
    }

    public void setDropLongitude(String dropLongitude) {
        this.dropLongitude = dropLongitude;
    }
    
     @Override
    public String  toString() {
        return "\nOrder " + name + "\n From : Pick Lat:" + pickLatitude + " Pick Lng:" + pickLongitude + "\n To : Delivery Lat:" + dropLatitude + " Delivery Lng:" + dropLongitude;
    }

}

    

