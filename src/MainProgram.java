import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainProgram {

    public static void main(String[] args) {

        /* diavasma arxeiou CSV
          Diabazei to arxeio CSV, me xorismenh thn kathe timh me ;
         */
        String csvFile = "C:/Users/ekped/Desktop/Projects/com.VehicleValidation.Project/csvv.csv";
        String line = "";
        String cvsSplitBy = ";";
        String expir = "VALID";

        LocalDate localDate = LocalDate.now();

        Date datenow = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println(localDate);
        System.out.println(datenow);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


            /*
              Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
             */

            while ((line = br.readLine()) != null) {

                /*
                  Epanalipsi oso yparxoun grammes sto CSV
                 */

                // use comma as separator
                String[] info = line.split(cvsSplitBy);

                //Date conversion
                /* Eisagei thn hmerominia me sygkekrimeno format
                 */
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = df.parse(info[3]);

                // Elegxos an h hmerominia einai prin thn shmerinh hmerominia
                 if (date.before(datenow)){
                    expir ="EXPIRED";
                }

                /* ektyposh olwn twn stoixeiwn gia dokimh
                 */
                System.out.println("The owner is: " + info[0] + " the brand is: " + info[1] +
                        " the model is: " + info[2] + " it was registered at: "+
                        (new SimpleDateFormat("MM-dd-yyyy").format(date))
                        + " for " + info[4] + " months. " + expir );

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }


}



