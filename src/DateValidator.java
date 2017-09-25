import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateValidator {

    public DateValidator () {

          //Diavasma arxeiou CSV
          //Diabazei to arxeio CSV, me xorismenh thn kathe timh me ";"
        String csvsource1 = "C:/Users/ekped/Desktop/Projects/com.VehicleValidation.Project/csvv.csv"; //apo PC
        String csvsource2 = "/Users/chris/Desktop/#Projects/com.VehicleValidation.Project/VehiclesData.csv"; // apo MAC
        String csvFile = csvsource2; // <- Default path gia to CSV arxeio
        String line = ""; // <- Diaxorizei thn kathe grammh sto CSV arxeio
        String cvsSplitBy = ";"; // <- Orizei me poio simvolo sto CSV arxeio pername sthn epomenh eggrafh

        // Metatroph shmerinhs hmerominias se symvath morfh
        LocalDate localDate = LocalDate.now ();//For reference <- apothikefsh shmerinhs hmeorminias se metablith
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd/MM/yyyy" );// <- metatroph se ayto to fortmat
        String formattedDateNow = localDate.format ( formatter ); // <-
        // System.out.println ( formattedDateNow ); // <- dokimastiko

        // Edw dinetai h dynatothta na eisagoume neo path gia to arxeio CSV
        System.out.println ( "Give us the path of the CSV File (leave blank for default)" );
        System.out.println ( "Default path: " + csvFile); // <- Emfanizei to default path
        System.out.println ("The current date is: " +  formattedDateNow );
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ();

                // Edw orizoume an den mas graspei tipota o xrhsths, krataei to default path
                if(input != null && !input.isEmpty()) {
                csvFile = input;
                // System.out.println ( " KENO " ); // <- dokimastiko gia an doulevei h IF
            }

        //Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
        try (BufferedReader br = new BufferedReader ( new FileReader ( csvFile ) )) {

            //Date conversion
            //Eisagei thn hmerominia me sygkekrimeno format
            DateFormat df = new SimpleDateFormat ( "dd/MM/yyyy", Locale.ENGLISH );

            while ((line = br.readLine ()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                String[] info = line.split ( cvsSplitBy ); // <- use ; as separator

                //diavazei thn hmerominia apo thn thesh 2 tou pinaka
                Date date = df.parse ( info[2] );
                Date datenow = df.parse ( formattedDateNow );

                String expir="EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh

                // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
                if (date.compareTo ( datenow ) >= 0) {
                    expir = "VALID";
                }


                // ektyposh olwn twn stoixeiwn gia dokimh
                System.out.println ( "The owner is: " + info[1] + " the licence number is: " + info[0] +
                        " and the date registered is: " +
                        (new SimpleDateFormat ( "dd/MM/yyyy" ).format ( date )) + ". This licence is: " + expir );

            }
        }

        // Aparaithto se periptosh pou dothei lathos hmeromhnia
        catch (IOException | ParseException e) {
            // Invalid date was entered
            e.printStackTrace ();
        }
    }
}
