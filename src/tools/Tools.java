package tools;
import Input.StrInput;
import Vehicle.Vehicle;
import org.jetbrains.annotations.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Tools {

    public static LocalDate localDate = LocalDate.now();

    public static void setLocalDate(int days){
        localDate = LocalDate.now().plusDays(days);
    }

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
                   if (!dateCompare(foundVehiclesList.get(0).licenseDate)) {
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
                   localDate = LocalDate.now();
                   if (foundVehiclesList.isEmpty()){
                       System.out.println("the owner with the above AFM does not exist!");
                       break;
                   }
                   System.out.println("Please provide the amount of fine");
                   fine = Integer.parseInt(StrInput.askStrInput());
                   for (int i = 0; i < foundVehiclesList.size(); i++) {
                       licenseStatus = "VALID";
                       if (!dateCompare(foundVehiclesList.get(i).licenseDate)) {
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
                       if (!dateCompare(foundVehiclesList.get(i).licenseDate)) {
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

    @NotNull
    public static DateFormat dateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    }

    public static Date dateNowFormat() {
        //LocalDate.now().plusDays(1000);
        // Metatroph shmerinhs hmerominias se symvath morfh
        //For reference <- apothikefsh shmerinhs hmeorminias se metablith
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");// <- metatroph se ayto to fortmat
        ////////////////////////// LOCAL DATE
        Date dateNow = null;
        try {
            dateNow = dateFormat().parse(localDate.format(formatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateNow;
    }

    public static boolean dateCompare(String VehicleDate) {
        Date date = null;
        try {
            date = Tools.dateFormat().parse(VehicleDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String expiredStatus = "EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh
        // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
        if (date.compareTo(Tools.dateNowFormat()) >= 0) {
            expiredStatus = "VALID";
            return true;
        }
        return false;
    }
}
