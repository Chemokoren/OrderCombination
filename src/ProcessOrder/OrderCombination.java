package ProcessOrder;


/**
 *
 * @author kibsoft
 */
import model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utility.UtilityFunctions;
public class OrderCombination {
    private final Input input;
    ConvertLocationtoCoordinates locationProcessor;
    private ArrayList<Order> list;
    

    public OrderCombination() {
        input = new Input();
        locationProcessor = new ConvertLocationtoCoordinates();
    }
    

    public void processOrderCombination() {
            list = getOrders();
            System.out.println("Your Order is as below:\n");
           
//             System.out.println(getListOrders(list));
            
//            list.stream().forEach((order) -> {
//                locationProcessor.setLocations(order);
//            });
//            getDeliveryDetails();


UtilityFunctions utilityfuncs =new UtilityFunctions();

 ArrayList<Order> my_list=list;

    int pickup_closeness=(utilityfuncs.calculateDistanceInKilometer(Double.parseDouble(list.get(0).getPickLatitude()),Double.parseDouble(list.get(0).getPickLongitude()), 
            Double.parseDouble(list.get(1).getPickLatitude()),Double.parseDouble(list.get(1).getPickLongitude())));
     int delivery_closeness=(utilityfuncs.calculateDistanceInKilometer(Double.parseDouble(list.get(0).getDropLatitude()),Double.parseDouble(list.get(0).getDropLongitude()), 
            Double.parseDouble(list.get(1).getDropLatitude()),Double.parseDouble(list.get(1).getDropLongitude())));
//}
checkOrderCombination(pickup_closeness,delivery_closeness);
for(int i=0; i<getItemCount();i++){
System.out.println("Order Name: "+list.get(i).getName()+" pick lat: "+list.get(i).getPickLatitude()+" pick lng: "+list.get(i).getPickLongitude()+" Delivery lat: "+list.get(i).getDropLatitude()+" Delivery lng: "+list.get(i).getDropLongitude());
}
    }
    public ArrayList<Order> getListOrders(ArrayList<Order> list){
        ArrayList<Order> my_list=list;
       return  my_list;
    }
    public void checkOrderCombination(int pickup_variation, int drop_variation){
        
//        combine orders if the variation in pickup location is less than 1km and variation in delivery location is 
        if(pickup_variation <=1 && drop_variation<=1){
          System.out.println(" Pickup Variation is: "+pickup_variation+ ".Delivery Variation is "+pickup_variation+ " \n\n\ncombine the orders");
        }else{
          System.out.println(" Pickup Variation is: "+pickup_variation+ ".Delivery Variation is "+pickup_variation+ " \n\n\nOrders cannot be combined"); 
        }
        
    }
    
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }
    public void getDeliveryDetails() {
        String[] centers = locationProcessor.getLocations();
        System.out.println("Similar Orders");
        
        for (String place : centers) {
            System.out.println("\n" + place + "\n");
            List<Order> from_here = getOrdersFromPlace(place);
            List<Order> to_here = getOrdersToPlace(place);
            if (!from_here.isEmpty()) {
                System.out.println("Pick the orders below");
                System.out.println(from_here);
            }
            if (!to_here.isEmpty()) {
                System.out.println("Drop the orders below");
                System.out.println(to_here);
            }
        }


    }
    
 
    private List<Order> getOrdersFromPlace(String location) {
        return list.stream().filter(p -> p.getPickLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }
    

    private List<Order> getOrdersToPlace(String location) {
        return list.stream().filter(p -> p.getDropLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }
    
   
    public ArrayList<Order> getOrders() {
        return input.getInputs();
    }
    
    
}
