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

    //////////////////////////////////////////////
    public DateFormat dateFormat() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return df;
    }
    //////////////////////////////////////////////////////

    public Date formatedDateNow() {

        ////////////////////////////////////
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
        /////////////////////////
        return dateNow;
    }

    public String[] fileParser() {

        //Diavasma arxeiou CSV
        String filePath = new File("VehiclesData.csv").getAbsolutePath();

        String line = ""; // <- Diaxorizei thn kathe grammh sto CSV arxeio

        //Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                String[] info = line.split(";"); // <- use ; as separator



            }
        }

        // Aparaithto se periptosh pou dothei lathos hmeromhnia
        catch (IOException  e) {
            // Invalid date was entered
            e.printStackTrace();
        }
        return fileParser();
    }


    public NewDateValidator() {


        //diavazei thn hmerominia apo thn thesh 2 tou pinaka
        Date date = dateFormat().parse(info[2]);

        String expiredStatus = "EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh

        // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
        if (date.compareTo(formatedDateNow()) >= 0) {
            expiredStatus = "VALID";
        }
        String formatedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);

        // ektyposh olwn twn stoixeiwn gia dokimh
        System.out.println("The owner is: " + info[1] + " the licence number is: " + info[0] +
                " and the date registered is: " + formatedDate + ". This licence is: " + expiredStatus);
    }

}

