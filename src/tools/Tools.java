package tools;
import Input.StrInput;
import Vehicle.Vehicle;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tools {

       public ArrayList<Vehicle> vehicleSearch(ArrayList<Vehicle> vehicleList, String userInput) {

           ArrayList<Vehicle> foundVehiclesList = new ArrayList<Vehicle>();

           for (int i = 0; i < vehicleList.size(); i++) {
               //String expired = "VALID";
               if (vehicleList.get(i).afm.equals(userInput)) {
                   foundVehiclesList.add(vehicleList.get(i));
               }
               if (vehicleList.get(i).licensePlate.equals((userInput))) {
                   foundVehiclesList.add(vehicleList.get(i));
               }
           }
           return foundVehiclesList;
       }

    public ArrayList<Vehicle> vehicleNonExpiredSearch(ArrayList<Vehicle> vehicleList) {

        ArrayList<Vehicle> foundVehiclesList = new ArrayList<Vehicle>();

        for (int i = 0; i < vehicleList.size(); i++) {
            //String expired = "VALID";
            int j = 0;
            if ((!DateCompare.dateCompare(vehicleList.get(i).licenseDate))) {
                foundVehiclesList.add(vehicleList.get(j));
                System.out.println("AFM : " + foundVehiclesList.get(j).afm +
                        " Plates number:" + " " + foundVehiclesList.get(j).licensePlate +
                        " Date Until Expired: " + foundVehiclesList.get(j).licenseDate +
                        " License: ");
                j++;

            }

        }
        return foundVehiclesList;
    }

       public static void actionVehicleSearch(ArrayList<Vehicle> foundVehiclesList, String action) {
           String licenseStatus = "EXPIRED";
           int sum = 0;
           int fine;
           //for/in object property
           switch (action) {
               case "LicensePlates": {
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("the vehicle with the above License Plates does not exist!");
                       break;
                   }
                   if (!DateCompare.dateCompare(foundVehiclesList.get(0).licenseDate)) {
                       System.out.println("The License is " + licenseStatus);
                   } else {
                       licenseStatus = "VALID";
                       System.out.println("The License is " + licenseStatus);
                   }
                   System.out.println("AFM : " + foundVehiclesList.get(0).afm +
                           " Plates number:" + " " + foundVehiclesList.get(0).licensePlate +
                           " Date Until Expired: " + foundVehiclesList.get(0).licenseDate +
                           " License: " + licenseStatus);
               }
               break;
               case "AFM": {
                   DateCompare.setLocalDate(0);
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("the owner with the above AFM does not exist!");
                       break;
                   }
                   System.out.println("Please provide the amount of fine");
                   fine = Integer.parseInt(StrInput.askStrInput());
                   for (int i = 0; i < foundVehiclesList.size(); i++) {
                       licenseStatus = "VALID";
                       if (!DateCompare.dateCompare(foundVehiclesList.get(i).licenseDate)) {
                           licenseStatus = "EXPIRED";
                           sum = sum + fine;
                       }
                       System.out.println("AFM : " + foundVehiclesList.get(i).afm +
                               " Plates number:" + " " + foundVehiclesList.get(i).licensePlate +
                               " Date Until Expired: " + foundVehiclesList.get(i).licenseDate +
                               " License: "+licenseStatus);
                   }
                   System.out.println("The total amount of fine is "+sum);
                   break;
               }
               case "Date": {
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("the owner with the above AFM does not exist!");
                       break;
                   }
                   for (int i = 0; i < foundVehiclesList.size(); i++) {
                       //licenseStatus = "VALID";
                       if (!DateCompare.dateCompare(foundVehiclesList.get(i).licenseDate)) {
                           //licenseStatus = "EXPIRED";
                           System.out.println("AFM : " + foundVehiclesList.get(i).afm +
                                   " Plates number:" + " " + foundVehiclesList.get(i).licensePlate +
                                   " Date Until Expired: " + foundVehiclesList.get(i).licenseDate +
                                   " License: EXPIRED");
                       }

                   }
                   break;
               }
           }
       }
    }
