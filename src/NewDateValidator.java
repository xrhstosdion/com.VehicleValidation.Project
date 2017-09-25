import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class NewDateValidator {

    public NewDateValidator() {

        //Diavasma arxeiou CSV
        String filePath = new File("VehiclesData.csv").getAbsolutePath();
        System.out.println("EDW" + filePath);

        String line = ""; // <- Diaxorizei thn kathe grammh sto CSV arxeio
        String cvsSplitBy = ";"; // <- Orizei me poio simvolo sto CSV arxeio pername sthn epomenh eggrafh

        ////////////////////////////////////
        // Metatroph shmerinhs hmerominias se symvath morfh
        LocalDate localDate = LocalDate.now ();//For reference <- apothikefsh shmerinhs hmeorminias se metablith
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd/MM/yyyy" );// <- metatroph se ayto to fortmat

        DateFormat df = new SimpleDateFormat ( "dd/MM/yyyy", Locale.ENGLISH );

        ////////////////////////// LOCAL DATE
        Date dateNow = null;
        try {
            dateNow = df.parse ( localDate.format ( formatter ) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /////////////////////////

        //Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
        try (BufferedReader br = new BufferedReader ( new FileReader ( filePath ) )) {

            //Date conversion
            //Eisagei thn hmerominia me sygkekrimeno format


            while ((line = br.readLine ()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                String[] info = line.split ( cvsSplitBy ); // <- use ; as separator

                //diavazei thn hmerominia apo thn thesh 2 tou pinaka
                Date date = df.parse ( info[2] );

                String expir="EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh

                // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
                if (date.compareTo ( dateNow ) >= 0) {
                    expir = "VALID";
                }


                // ektyposh olwn twn stoixeiwn gia dokimh
                System.out.println ( "The owner is: " + info[1] + " the licence number is: " + info[0] +
                        " and the date registered is: " + date + ". This licence is: " + expir );

            }
        }

        // Aparaithto se periptosh pou dothei lathos hmeromhnia
        catch (IOException | ParseException e) {
            // Invalid date was entered
            e.printStackTrace ();
        }
    }
}
