package Input;

import java.util.Scanner;

public class StrInput {

    public static String userInput;

    String setStrInput(String x){
        return userInput = x;
    }

    public static String getStrInput(){
        return userInput;
    }

    public static String askStrInput(){
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        return userInput;
    }
}
