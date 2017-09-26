import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Performs a License Plates format validation, (correct format: ABC-1234)
 * it will forever await input from the user until either the format is correct or == "exit"
 */
public class LicensePlatesValidator {

    public static boolean getValidFormat() {

        System.out.println("Please provide a license type (format: ABC-1234)");
        String userInput = StrInput.askStrInput();
        String validFormat = "[a-zA-Z]{3}-\\d{4}";

        while (!userInput.matches(validFormat) && !userInput.equals("exit")) {
            System.out.println("The format is Wrong, provide a correct one (ABC-1234) or type 'exit' to EXIT");
            userInput = StrInput.askStrInput();
        }
        if (userInput.matches(validFormat)) {
            System.out.println("The license plates format is accepted");
            return true;
        } else {
            System.out.println("The program is exiting");
        }
        return false;
    }

    public static boolean getValidFormat2() {

        System.out.println("Please provide AFM");
        String userInput = StrInput.askStrInput();
        String validFormat = "\\d{9}";

        while (!userInput.matches(validFormat) && !userInput.equals("exit")) {
            System.out.println("The format is Wrong, provide a correct one ('123456789') or type 'exit' to EXIT");
            userInput = StrInput.askStrInput();
        }
        if (userInput.matches(validFormat)) {
            System.out.println("The AFM format is accepted!");
            return true;
        } else {
            System.out.println("The program is exiting");
        }
        return false;
    }
static int sum =0;

    public static int dateValidator(String date1){
            Date date = null;
            try {
                date = NewDateValidator.dateFormat().parse(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String expiredStatus = "EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh
            // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
            if (date.compareTo(NewDateValidator.dateNowFormat()) >= 0) {
                expiredStatus = "VALID";
            }
            else {
                sum = sum + 50;
            }
            System.out.println("the sum is = "+sum);
            return sum;
    }
}
