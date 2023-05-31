/**
 * This program will read details of a prospective insurer, calculate the cost of their health insurance, and output a quotation.
 *
 * Programmer: Oleksandr Mitichkin
 * Date: 21.03.2023
 */
import java.util.Scanner; // Import scanner
public class Main {
    static Scanner sc = new Scanner (System.in); // Create a scanner
    static public boolean Again = false;
    public static void main(String[] args) {
        HealthPolicy policy = new HealthPolicy(); // Create a object

        do {
            policy.askAge(); // Call method to ask age
            policy.askName(); // Call method to ask name
            policy.askPersonToAddDependant(); // Call method to add dependant
            policy.askInpatientInsurance(); // Call method to add inpatient insurance
            policy.additionalExtras(); // Call method to add additional extra's
            policy.outputQuotation(); // Call method to output all quotation
            policy.askUserDoAgain(); // Call method to ask user if he wants to add another quotation
        } while (!Again);

    }
}