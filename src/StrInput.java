import java.util.Scanner;

class StrInput {

    private static String userInput;

    String setStrInput(String x){
        return userInput = x;
    }

    static String getStrInput(){
        return userInput;
    }

    static String askStrInput(){
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        return userInput;

    }
}
