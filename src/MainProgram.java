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


                    break;

                case "4": // Fine Calculator

                    System.out.println("give the AFM");
                    String userInputAFM = StrInput.askStrInput();
                    System.out.println("give the amount of fine per expired license");
                    int userInputFine = Integer.parseInt(StrInput.askStrInput());

                    FileParser fp10 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList = fp10.csvToTable();
                    Tools myArray = new Tools();
                    int fine = myArray.tableSearch(vehicleList,userInputFine,userInputAFM);
                    System.out.println("the fine is really "+fine);
                    break;

                case "3":
                    String userInput = StrInput.askStrInput();
                    Validators valid = new Validators();
                    valid.formatValidator(1,userInput);

                    while (!valid.validateConfirmation() && !userInput.equals("exit")) {
                        System.out.println(valid.getWrongFormat());
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
