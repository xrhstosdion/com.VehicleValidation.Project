package Texts;

import Vehicle.Vehicle;
import java.util.ArrayList;
import static tools.DateCompare.dateNowFormat;

public class Texts {

    public static void mainText(){
            System.out.println("===========================");
            System.out.println("PLEASE SELECT AN OPERATION");
            System.out.println("1. LicensePlatesValidator");
            System.out.println("2. DateValidator");
            System.out.println("3. LicensePlateShorter");
            System.out.println("4. FineCalculator");
            System.out.println("0. TO EXIT");
            System.out.println("===========================");
            System.out.println("");
    }

    public static void vehicleText(ArrayList<Vehicle> vehicleList, int i){
        System.out.println("AFM : " + vehicleList.get(i).getAfm() +
                " Plates number: " + vehicleList.get(i).getLicensePlate() +
                " Date Until Expired: " + vehicleList.get(i).getLicenseDate() +
                " License: " + vehicleList.get(i).getStatus());
    }
    public static void vehicleText2(ArrayList<Vehicle> vehicleList, int i){
        System.out.println("AFM : " + vehicleList.get(i).getAfm() +
                " Plates number:" + " " + vehicleList.get(i).getLicensePlate() +
                " Date Until Expired: " + vehicleList.get(i).getLicenseDate() +
                " License: it will be EXPIRED before " + dateNowFormat());
    }
}
