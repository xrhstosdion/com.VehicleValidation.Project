package tools;
import Input.StrInput;
import Validators.Validators;
import Vehicle.Vehicle;
import java.util.ArrayList;

import static tools.DateCompare.dateNowFormat;

public class Tools {

       public ArrayList<Vehicle> vehicleSearch(ArrayList<Vehicle> vehicleList, String userInput) {

           ArrayList<Vehicle> foundVehiclesList = new ArrayList<Vehicle>();

           for (int i = 0; i < vehicleList.size(); i++) {
               if (vehicleList.get(i).getAfm().equals(userInput)) {
                   foundVehiclesList.add(vehicleList.get(i));
               }
               if (vehicleList.get(i).getLicensePlate().equals((userInput))) {
                   foundVehiclesList.add(vehicleList.get(i));
               }
           }
           return foundVehiclesList;
       }

       public void actionVehicleSearch(ArrayList<Vehicle> foundVehiclesList, String action) {
           int sum = 0;
           switch (action) {
               case "LicensePlates":
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("the vehicle with the above License Plates does not exist!");
                       break;
                   }
                   System.out.println("AFM : " + foundVehiclesList.get(0).getAfm() +
                           " Plates number:" + " " + foundVehiclesList.get(0).getLicensePlate() +
                           " Date Until Expired: " + foundVehiclesList.get(0).getLicenseDate() +
                           " License: " + foundVehiclesList.get(0).getStatus());
               break;

               case "AFM":
                   DateCompare.setLocalDate(0);
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("the owner with the above AFM does not exist!");
                       break;
                   }
                   /*System.out.println("Please provide the amount of fine");
                   String fine = Integer.parseInt(StrInput.askStrInput());*/
                   Validators val = new Validators();
                   val.formatValidator("Fine");
                   System.out.println("Please provide the amount of fine");
                   String fine = StrInput.askStrInput();
                   int fine1;
                   while (!val.validateConfirmation(fine) && !fine.equals("exit")) {
                       System.out.println(val.getWrongFormat());
                       fine = StrInput.askStrInput();
                   }
                   if (!val.validateConfirmation(fine)) {
                       break;
                   }
                   else{
                       fine1 = Integer.parseInt(fine);
                   }
                   for (int i = 0; i < foundVehiclesList.size(); i++) {
                       if (foundVehiclesList.get(i).getStatus() == "EXPIRED") {
                           sum = sum + fine1;
                       }
                       System.out.println("AFM : " + foundVehiclesList.get(i).getAfm() +
                               " Plates number:" + " " + foundVehiclesList.get(i).getLicensePlate() +
                               " Date Until Expired: " + foundVehiclesList.get(i).getLicenseDate() +
                               " License: "+foundVehiclesList.get(i).getStatus());
                   }
                   System.out.println("The total amount of fine is "+sum);

               break;
               case "Date":
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("No vehicles found that will be expired!");
                       break;
                   }
                   for (int i = 0; i < foundVehiclesList.size(); i++) {
                       if (foundVehiclesList.get(i).getStatus() == "VALID") {
                           if (!DateCompare.dateCompare(foundVehiclesList.get(i).getLicenseDate())) {
                               System.out.println("AFM : " + foundVehiclesList.get(i).getAfm() +
                                       " Plates number:" + " " + foundVehiclesList.get(i).getLicensePlate() +
                                       " Date Until Expired: " + foundVehiclesList.get(i).getLicenseDate() +
                                       " License: it will be EXPIRED before " + dateNowFormat());
                           }
                       }
                   }
                   break;
           }
       }
    }
