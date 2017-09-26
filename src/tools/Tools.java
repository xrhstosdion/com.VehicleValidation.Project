package tools;
import Validators.Validators;
import Input.StrInput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Tools {
       public int tableSearch(String[][] table, int j, int fine) {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][j].equals(StrInput.getStrInput())) {
                if (!Validators.dateValidator(table[i][2])) {
                    sum = sum + fine;
                }
                System.out.println("AFM : " + table[i][1] + " Plates number: " + table[i][0] +
                        " Date Until Expired: " + table[i][2]);
            }
        }
        System.out.println("the total fine is!"+sum);
        return sum;
    }

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
