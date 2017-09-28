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

            // epanalipsh gia na doulepsei panw apo mia askhsh
            // edw ksekinaei to programma. zhtaei ton arithmo ths askishs
            System.out.println("===========================");
            System.out.println("=== OUR AWESOME PROJECT ===");
            System.out.println("PLEASE SELECT AN OPERATION");
            System.out.println("1. LicensePlatesValidator");
            System.out.println("2. DateValidator");
            System.out.println("4. FineCalculator");
            System.out.println("0. TO EXIT");
            System.out.println("===========================");

            // edw diavazei ton arithmo pou tou dwsame
            // h metablith input tha pernei to apotelesma kai tha fortonei to katalilo operation
            input = StrInput.askStrInput();
            try {
                i = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("wrong is not valid number. try again");
            }
            if (i==0 || i>3){
                System.out.println("not in 1-4");
            }

            // Se kathe epilogh fortonetai h antistoixh klash
            switch (input) {

                case "1": //LicensePlatesValidator

                    System.out.println("give the License Plates");
                    String userInputLP = StrInput.askStrInput();

                    Validators valid = new Validators();
                    valid.formatValidator(1,userInputLP);

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

                case "4": // Fine Calculator

                    System.out.println("give the AFM");
                    String userInputAFM = StrInput.askStrInput();

                    FileParser fp2 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList2 = fp2.csvToTable();
                    Tools myArray2 = new Tools();

                    ArrayList<Vehicle> vehiclesFound2 = myArray2.vehicleSearch(vehicleList2,userInputAFM);
                    Tools.actionVehicleSearch(vehiclesFound2,"afm");

                    break;

                case "3":
                    String userInput = StrInput.askStrInput();
                    Validators valid100 = new Validators();
                    valid100.formatValidator(1,userInput);

                    while (!valid100.validateConfirmation(userInput) && !userInput.equals("exit")) {
                        System.out.println(valid100.getWrongFormat());
                        userInput = StrInput.askStrInput();
                    }
                    break;

                case "5":



                    /*for (int k = 0; k <info10.length; k++ ){
                        for (int l = 1; l<info10.length -k; l++){
                            String licensePlate1 = info10[l-1][0];
                            String licensePlate2 = info10[l][0];

                            if (info10[l-1][0] > info10[l][0]){

                            }
                        }
                    }*/
                    break;
            }
        } while (i != 0);
        System.out.println ( "Good Bye!!" );
    }
}
