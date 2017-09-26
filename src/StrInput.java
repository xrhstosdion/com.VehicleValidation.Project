import java.util.Scanner;

class StrInput {

    private static String userInput;

    StrInput(){
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
    }

    String setStrInput(String x){
        return userInput = x;
    }

    static String getStrInput(){
        return userInput;
    }
}
