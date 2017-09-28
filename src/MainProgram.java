import Validators.Validators;
import Vehicle.Vehicle;
import tools.FileParser;
import tools.Tools;
import Input.StrInput;

import java.util.ArrayList;

public class MainProgram {

    public static void main (String[] args) {
        String input;
        int i = 100;
        do {

            System.out.println("===========================");
            System.out.println("=== OUR AWESOME PROJECT ===");
            System.out.println("PLEASE SELECT AN OPERATION");
            System.out.println("1. LicensePlatesValidator");
            System.out.println("2. DateValidator");
            System.out.println("4. FineCalculator");
            System.out.println("0. TO EXIT");
            System.out.println("===========================");

            input = StrInput.askStrInput();
            try {
                i = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("wrong is not valid number. try again");
            }
            if (i==0 || i>4){
                System.out.println("not in 1-4");
            }

            switch (input) {

                case "1": //LicensePlatesValidator

                    System.out.println("give the License Plates");
                    String userInputLP = StrInput.askStrInput();

                    Validators valid = new Validators();
                    valid.formatValidator("LicensePlates");

                    while (!valid.validateConfirmation(userInputLP) && !userInputLP.equals("exit")) {
                        System.out.println(valid.getWrongFormat());
                        userInputLP = StrInput.askStrInput();
                    }
                    if (valid.validateConfirmation(userInputLP)) {
                        FileParser fp1 = new FileParser("VehiclesData.csv");
                        ArrayList<Vehicle> vehicleList1 = fp1.csvToTable();
                        Tools myArray1 = new Tools();

                        ArrayList<Vehicle> vehiclesFound1 = myArray1.vehicleSearch(vehicleList1, userInputLP);
                        Tools.actionVehicleSearch(vehiclesFound1, "LicensePlates");
                    }
                    break;

                case "2":

                    System.out.println("give the DAYS");
                    int days =  Integer.parseInt(StrInput.askStrInput());
                    Tools.setLocalDate(days);

                    FileParser fp2 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList2 = fp2.csvToTable();

                    Tools.actionVehicleSearch(vehicleList2,"Date");
                    break;

                case "4": // Fine Calculator

                    System.out.println("give the AFM");
                    String userInputAFM = StrInput.askStrInput();

                    FileParser fp4 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList4 = fp4.csvToTable();
                    Tools myArray4 = new Tools();

                    ArrayList<Vehicle> vehiclesFound4 = myArray4.vehicleSearch(vehicleList4,userInputAFM);
                    Tools.actionVehicleSearch(vehiclesFound4,"AFM");

                    break;

                case "3":
                   /* String userInput = StrInput.askStrInput();
                    Validators valid100 = new Validators();
                    valid100.formatValidator("AFM");

                    while (!valid100.validateConfirmation(userInput) && !userInput.equals("exit")) {
                        System.out.println(valid100.getWrongFormat());
                        userInput = StrInput.askStrInput();
                    }*/
                    break;
            }
        } while (i != 0);
        System.out.println ( "Good Bye!!" );
    }
}
