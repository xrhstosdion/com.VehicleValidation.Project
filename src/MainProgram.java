import Validators.Validators;
import Vehicle.Vehicle;
import tools.DateCompare;
import tools.FileParser;
import tools.LicensePlateSorter;
import tools.Tools;
import Input.StrInput;
import java.util.ArrayList;

public class MainProgram {

    public static void main (String[] args) {
        String input123;
        int caseInt = 100;
        do {

            System.out.println("===========================");
            System.out.println("=== OUR AWESOME PROJECT ===");
            System.out.println("PLEASE SELECT AN OPERATION");
            System.out.println("1. LicensePlatesValidator");
            System.out.println("2. DateValidator");
            System.out.println("3. LicensePlateShorter");
            System.out.println("4. FineCalculator");
            System.out.println("0. TO EXIT");
            System.out.println("===========================");

            input123 = StrInput.askStrInput();
            try {
                caseInt = Integer.parseInt(input123);
            } catch (NumberFormatException e){
                System.out.println("wrong is not valid number. try again");
            }
            if (caseInt==0 || caseInt>4){
                System.out.println("not in 1-4");
            }

            switch (input123) {

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
                        myArray1.actionVehicleSearch(vehiclesFound1, "LicensePlates");
                    }
                    break;

                case "2":

                    FileParser fp2 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList2 = fp2.csvToTable();
                    Tools myArray2 = new Tools();

                    System.out.println("give the DAYS");
                    int days =  Integer.parseInt(StrInput.askStrInput());
                    DateCompare.setLocalDate(days);

                    myArray2.actionVehicleSearch(vehicleList2,"Date");
                    break;

                case "3": // LicensePlateShorter

                    FileParser fp3 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList3 = fp3.csvToTable();

                    LicensePlateSorter lps = new LicensePlateSorter();
                    vehicleList3 = lps.arraySorter(vehicleList3);

                    for (int i = 0; i < vehicleList3.size(); i++){

                        System.out.println("AFM : " + vehicleList3.get(i).getAfm() +
                                " Plates number: " + vehicleList3.get(i).getLicensePlate() +
                                " Date Until Expired: " + vehicleList3.get(i).getLicenseDate() +
                                " License: " + vehicleList3.get(i).getStatus());
                    }

                    break;

                case "4": // Fine Calculator

                    System.out.println("give the AFM");
                    String userInputAFM = StrInput.askStrInput();

                    Validators valid4 = new Validators();
                    valid4.formatValidator("AFM");

                    while (!valid4.validateConfirmation(userInputAFM) && !userInputAFM.equals("exit")) {
                        System.out.println(valid4.getWrongFormat());
                        userInputAFM = StrInput.askStrInput();
                    }
                    if (!valid4.validateConfirmation(userInputAFM)) {
                        break;
                    }


                    FileParser fp4 = new FileParser("VehiclesData.csv");
                    ArrayList<Vehicle> vehicleList4 = fp4.csvToTable();
                    Tools myArray4 = new Tools();

                    ArrayList<Vehicle> vehiclesFound4 = myArray4.vehicleSearch(vehicleList4, userInputAFM);
                    myArray4.actionVehicleSearch(vehiclesFound4, "AFM");
                    }
                    break;
        } while (input123 != "0");
        System.out.println ( "Good Bye!!" );
    }
}
