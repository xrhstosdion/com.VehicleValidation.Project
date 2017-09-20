import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.time.LocalDate;

public class MainProgram {

    public static void main(String[] args) {

        /* diavasma arxeiou CSV
          Diabazei to arxeio CSV, me xorismenh thn kathe timh me ;
         */
        String csvsource1 ="C:/Users/ekped/Desktop/Projects/com.VehicleValidation.Project/csvv.csv"; //apo PC
        String csvsource2 ="/Users/chris/Desktop/#Projects/com.VehicleValidation.Project/csvv.csv"; // apo MAC
        String csvFile = csvsource2;
        String line = "";
        String cvsSplitBy = ";";
        String expir = "EXPIRED";

        //dokimh tou local date

        // Metatroph shmerinhs hmerominias se symvath morfh
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateNow = localDate.format(formatter);
        System.out.println ( formattedDateNow );


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


            /*
              Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
             */

            while ((line = br.readLine()) != null) {

                //Epanalipsi oso yparxoun grammes sto CSV

                // use ; as separator
                String[] info = line.split(cvsSplitBy);

                //Date conversion
                //Eisagei thn hmerominia me sygkekrimeno format
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                //eisagei thn hmerominia apo pinaka sthn thesh 3
                Date date = df.parse(info[3]);
                Date datenow = df.parse ( formattedDateNow );
                if (date.compareTo ( datenow ) >= 0 ){
                    expir = "VALID";
                }


                /* ektyposh olwn twn stoixeiwn gia dokimh
                 */
                System.out.println("The owner is: " + info[0] + " the brand is: " + info[1] +
                        " the model is: " + info[2] + " it was registered at: "+
                        (new SimpleDateFormat("MM-dd-yyyy").format(date))
                        + " for " + info[4] + " months. " + expir );

            }
        } catch (IOException | ParseException e) {
            // Invalid date was entered
            e.printStackTrace();
        }

    }


}



