package Input;

import java.util.Scanner;

public class StrInput {

    private static String userAfm;
    private static int fine;
    private static String userLicensePlates;

    public static String getUserLicensePlates() {
        return userLicensePlates;
    }

    public static void setUserLicensePlates(String userLicensePlates) {
        StrInput.userLicensePlates = userLicensePlates;
    }

    public static String getUserAfm() {
        return userAfm;
    }

    public static void setUserAfm(String userData) {
        userAfm = userData;
    }

    public static String askStrInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void setFine(String stringFine){
        try {
            fine = Integer.parseInt(stringFine);
        } catch (NumberFormatException e){
            System.out.println("wrong is not valid number. try again");
        }
    }

    public static int getFine() {
        return fine;
    }

}
