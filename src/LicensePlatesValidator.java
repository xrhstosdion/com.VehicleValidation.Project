import java.util.Scanner;

/**
 * Performs a License Plates format validation, (correct format: ABC-1234)
 * it will forever await input from the user until either the format is correct or == "exit"
 */
public class LicensePlatesValidator {

    public LicensePlatesValidator(){

        Scanner scanner = new Scanner( System.in );
        System.out.println("Please provide a license type (format: ABC-1234)");
        String userInput = scanner.nextLine();
        String validFormat = "[a-zA-Z]{3}-\\d{4}";

        while (!userInput.matches(validFormat) &&  !userInput.equals("exit")){
            System.out.println("The format is Wrong, provide a correct one (ABC-1234) or type exit to exit");
            userInput = scanner.nextLine();
        }
        if (userInput.matches(validFormat)){
            System.out.println("The license plates format is accepted");
        }
        else {
            System.out.println("The program is exiting");
        }
    }
}
