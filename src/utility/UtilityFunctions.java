package utility;


/**
 *
 * @author kibsoft
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UtilityFunctions {
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    
    public List<String> arrayToList(String[] array) {
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        return stringList;
    }
    
    public List<String> addToList(String element, List<String> list) {
        list.add(element);
        return list;
    }
    
    public String[] listToArray(List<String> list) {
        String[] ins = (String[]) list.toArray(new String[list.size()]);
        return ins;
    }
    
    public String[] addtemToArray(String element, String[] array) {
        List<String> list = arrayToList(array);
        list = addToList(element, list);
        return listToArray(list);
    }
    
    public int calculateDistanceInKilometer(double userLat, double userLng,
            double venueLat, double venueLng) {
        
        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }
    
    // Creation of HashMap
//        HashMap<String, String> Geeks = new HashMap<>();
//        Geeks.put("", "");
        
//        Geeks.put("Language", "Java");
//        Geeks.put("Platform", "Geeks For geeks");
//        Geeks.put("Code", "HashMap");
//        Geeks.put("Learn", "More");
        
        
    
    public static Point nearestPoint(Point[] points, Point point) {
    Point p = points[0];
    for (int i = 0; i < points.length; i++) {
        if (points[i].distance(point) < p.distance(point)) {
            p = points[i];
        }
    }
    return p;
}
    
    // Returns element closest to target in arr[]
public int findClosest(int arr[], int n, int target)
{
    // Corner cases
    if (target <= arr[0])
        return arr[0];
    if (target >= arr[n - 1])
        return arr[n - 1];
 
    // Doing binary search
    int i = 0, j = n, mid = 0;
    while (i < j) {
        mid = (i + j) / 2;
 
        if (arr[mid] == target)
            return arr[mid];
 
        /* If target is less than array element,
            then search in left */
        if (target < arr[mid]) {
 
            // If target is greater than previous
            // to mid, return closest of two
            if (mid > 0 && target > arr[mid - 1])
                return getClosest(arr[mid - 1],
                                  arr[mid], target);
 
            /* Repeat for left half */
            j = mid;
        }
 
        // If target is greater than mid
        else {
            if (mid < n - 1 && target < arr[mid + 1])
                return getClosest(arr[mid],
                                  arr[mid + 1], target);
            // update i
            i = mid + 1; 
        }
    }
 
    // Only single element left after search
    return arr[mid];
}
 
// Method to compare which one is the more close.
// We find the closest by taking the difference
// between the target and both values. It assumes
// that val2 is greater than val1 and target lies
// between these two.
int getClosest(int val1, int val2,
               int target)
{
    if (target - val1 >= val2 - target)
        return val2;
    else
        return val1;
}
    
    
}
