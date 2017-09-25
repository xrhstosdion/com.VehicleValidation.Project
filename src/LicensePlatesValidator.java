import java.util.Scanner;

/**
 * Performs a License Plates format validation, (correct format: ABC-1234)
 * it will forever await input from the user until either the format is correct or == "exit"
 */
public class LicensePlatesValidator {

    public String strInput;

    public static boolean getValidFormat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a license type (format: ABC-1234)");
        String userInput = scanner.nextLine();
        String validFormat = "[a-zA-Z]{3}-\\d{4}";

        while (!userInput.matches(validFormat) && !userInput.equals("exit")) {
            System.out.println("The format is Wrong, provide a correct one (ABC-1234) or type 'exit' to EXIT");
            userInput = scanner.nextLine();
        }
        if (userInput.matches(validFormat)) {
            System.out.println("The license plates format is accepted");
            return true;
        } else {
            System.out.println("The program is exiting");
        }
        return false;
    }

    public String setStrInput(String x){
        return this.strInput = x;
    }

    public String getStrInput(){
        return strInput;
    }
    public boolean getValidFormat2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide AFM");
        String userInput = scanner.nextLine();
        String validFormat = "\\d{9}";


        while (!userInput.matches(validFormat) && !userInput.equals("exit")) {
            System.out.println("The format is Wrong, provide a correct one ('123456789') or type 'exit' to EXIT");
            userInput = scanner.nextLine();
        }
        if (userInput.matches(validFormat)) {
            System.out.println("The AFM format is accepted!");
            setStrInput(userInput);
            return true;
        } else {
            System.out.println("The program is exiting");
        }
        return false;
    }
}
