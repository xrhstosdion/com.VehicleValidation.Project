package tools;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateCompare {

    public static LocalDate localDate = LocalDate.now();

    public static void setLocalDate(int days){
        localDate = LocalDate.now().plusDays(days);
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
            date = dateFormat().parse(VehicleDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String expiredStatus = "EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh
        // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
        if (date.compareTo(dateNowFormat()) >= 0) {
            expiredStatus = "VALID";
            return true;
        }
        return false;
    }
}
