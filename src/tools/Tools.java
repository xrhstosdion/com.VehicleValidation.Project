package tools;
import Validators.Validators;
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

       public int tableSearch(ArrayList<Vehicle> vehicleList, int fine, String userInput) {
           int sum = 0;
           for (int i = 0; i < vehicleList.size(); i++){
               if (vehicleList.get(i).afm.equals(userInput)){
                   if (!Validators.dateValidator(vehicleList.get(i).licenseDate)){
                       sum = sum + fine;
                   }
                   System.out.println("AFM : " + vehicleList.get(i).afm + " Plates number: " + vehicleList.get(i).licensePlate +
                           " Date Until Expired: " + vehicleList.get(i).licenseDate);
               }
           }
           System.out.println("the total fine is "+sum);
           return sum;
    }

    @NotNull
    public static DateFormat dateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    }

    public static Date dateNowFormat() {

        // Metatroph shmerinhs hmerominias se symvath morfh
        LocalDate localDate = LocalDate.now();//For reference <- apothikefsh shmerinhs hmeorminias se metablith
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
}
