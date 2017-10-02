import Texts.Texts;
import Validators.Validators;
import Vehicle.Vehicle;
import tools.*;
import Input.StrInput;
import java.util.ArrayList;

public class MainProgram {

    private static String filePath = "./resources/CSV/VehiclesData.csv";

    public static void main (String[] args) {
        String input;
        int intInput = 100;

        do {
            Texts.mainText();
            input = StrInput.askStrInput();
            try {
                intInput = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("wrong is not valid number. try again");
            }
            if (intInput==0 || intInput>4){
                System.out.println("not in 1-4");
            }
            switch (input) {

                case "1": //LicensePlatesValidator

                    System.out.println("give the License Plates");
                    String userInputLP = StrInput.askStrInput();
                    StrInput.setUserLicensePlates(userInputLP);
                    Validators ValidPlates = new Validators();
                    ValidPlates.formatValidator("LicensePlates");

                    if (ValidPlates.validateConfirmation(userInputLP,"LicensePlates")){
                        FileParser fp1 = new FileParser(filePath);
                        ArrayList<Vehicle> vehicleList1 = fp1.csvToArrayList();
                        ArrayListAction myArray1 = new ArrayListAction();

                        ArrayList<Vehicle> vehiclesFound1;
                        vehiclesFound1 = myArray1.vehicleSearch(vehicleList1,StrInput.getUserLicensePlates());
                        myArray1.vehicleSearchOption(vehiclesFound1, "LicensePlates");
                    }
                    break;

                case "2": //DateValidator (it prints ONLY the vehicles that are about to expire in the given Days)

                    FileParser fp2 = new FileParser(filePath);
                    ArrayList<Vehicle> vehicleList2 = fp2.csvToArrayList();
                    ArrayListAction myArray2 = new ArrayListAction();

                    System.out.println("give the DAYS");
                    int days =  Integer.parseInt(StrInput.askStrInput());
                    DateCompare.setLocalDate(days);

                    myArray2.vehicleSearchOption(vehicleList2,"Date");
                    break;

                case "3": // LicensePlateShorter (Sorts the CSV file by Plates and prints it on console)

                    FileParser fp3 = new FileParser(filePath);
                    ArrayList<Vehicle> vehicleList3 = fp3.csvToArrayList();

                    LicensePlateSorter lps = new LicensePlateSorter();
                    vehicleList3 = lps.arraySorter(vehicleList3);

                    for (int i = 0; i < vehicleList3.size(); i++) {
                        Texts.vehicleText(vehicleList3,i);
                    }

                    break;

                case "4": // Fine Calculator

                    Validators validAfm = new Validators();
                    Validators validFine = new Validators();

                    validAfm.formatValidator("AFM");
                    validFine.formatValidator("Fine");

                    System.out.println("give the AFM");
                    String userInputAFM = StrInput.askStrInput();
                    StrInput.setUserAfm(userInputAFM);

                    if (validAfm.validateConfirmation(userInputAFM,"afm")) {

                        System.out.println("Please provide the amount of fine");
                        String fine = StrInput.askStrInput();
                        StrInput.setFine(fine);

                        if (validFine.validateConfirmation(fine, "Fine")) {

                            FileParser fp4 = new FileParser(filePath);
                            ArrayList<Vehicle> vehicleList4 = fp4.csvToArrayList();

                            ArrayListAction myArray4 = new ArrayListAction();

                            ArrayList<Vehicle> vehiclesFound4;
                            vehiclesFound4 = myArray4.vehicleSearch(vehicleList4, StrInput.getUserAfm());
                            myArray4.vehicleSearchOption(vehiclesFound4, "AFM");
                        }
                    }
                    break;
            }
        } while (intInput != 0);
        System.out.println ( "Good Bye!!" );
    }
}
