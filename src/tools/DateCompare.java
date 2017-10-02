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

    /**
     * Sets the LocalDate to now() plus the days it was given as parameter
     */
    public static void setLocalDate(int days){
        localDate = LocalDate.now().plusDays(days);
    }

    /**
     * Used in formatting the Vehicle Date
     */
    @NotNull
    public static DateFormat dateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    }

    /**
     * Formatting localDate so it can be compared with vehicle date
     */
    public static Date dateNowFormat() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Date dateNow = null;
        try {
            dateNow = dateFormat().parse(localDate.format(formatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateNow;
    }

    /**
     * Compares the formatted LocalDate with the formatted vehicle date
     * Returns true if VehicleDate (which is given as argument) is bigger/older than LocalDate
     */
    public static boolean dateCompare(String VehicleDate) {
        Date date = null;
        try {
            date = dateFormat().parse(VehicleDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        if (date.compareTo(dateNowFormat()) >= 0) {
            return true;
        }
        return false;
    }
}
