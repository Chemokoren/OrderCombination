package ProcessOrder;

/**
 *
 * @author kibsoft
 */
import java.util.ArrayList;
import utility.UtilityFunctions;
import model.Order;
import java.util.Arrays;
public class ConvertLocationtoCoordinates {
    protected String[] places = {};


    protected void setLocations(Order order) {
        pushPlace(order.getPickLocation());
        pushPlace(order.getDropLocation());
    }


    protected String[] getLocations() {
        return this.places;
    }

 
    private void pushPlace(String place) {
        boolean inArray = Arrays.stream(places).anyMatch(place::equalsIgnoreCase);
        if (!inArray) {
            UtilityFunctions utilityFunctions = new UtilityFunctions();
            places = utilityFunctions.addtemToArray(place, places);
        }
    }


    public boolean checkForDuplicates(String[][] inArray) {
        for (String[] inArray1 : inArray) {
            for (int col = 0; col < inArray1.length; col++) {
                String num = inArray1[col];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++) {
                    if (num.equals(inArray1[otherCol])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
//    give equivalent gprs coordinates of the given place
    public ArrayList<String> coordinateTranslation(String place_name){
        ArrayList<String> lat_long = new ArrayList<>();
        
        return lat_long;
    }

    
    
    
}
