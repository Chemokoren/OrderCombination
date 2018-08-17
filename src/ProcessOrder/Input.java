package ProcessOrder;

/**
 *
 * @author kibsoft
 */
import model.Order;
import java.util.ArrayList;
import java.util.Scanner;
public class Input {
    private final Scanner scanner;
ArrayList<Order> orders = new ArrayList<>();
 
    public Input() {
        scanner = new Scanner(System.in);
    }

    public ArrayList<Order> getInputs() {
        
        System.out.println("Kindly Provide the Name of the order, Pickup Coordinates and Delivery Coordinates\n");
        while (true) {
            orders.add(new Order(getName(), getPickLatitude(),getPickLongitude(),getDeliveryLatitude(), getDeliveryLongitude()));
            if (promptMore().equalsIgnoreCase("N")) {
                break;
            }
        }
        return orders;
        
    }


    private String getPickLocation() {
        return this.getScannerValue("Please enter the pick up location");
    }

    private String getDeliverLocation() {
        return this.getScannerValue("Please enter the delivery location");
    }
    private String getPickLatitude() {
        return this.getScannerValue("Enter the pick up latitude");
    }
    private String getPickLongitude() {
        return this.getScannerValue("Enter the pick up longitude");
    }
      private String getDeliveryLatitude() {
        return this.getScannerValue("Enter the delivery latitude");
    }
    private String getDeliveryLongitude() {
        return this.getScannerValue("Enter the delivery longitude");
    }

    private String getName() {
        return this.getScannerValue("Enter the name of order ");
    }

    private String promptMore() {
        return this.getScannerValue("Want to add another order? Y:N");
    }

    protected String getScannerValue(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim().toUpperCase();
    }

    ArrayList<Order> getInput() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
        
}
