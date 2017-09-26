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

    public DateFormat dateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    }

    public Date dateNowFormat() {

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

    public String[][] fileParser() {
        String[] info = new String[3];
        String[][] info1 = new String[99][3];
        int i = 0;
        //Diavasma arxeiou CSV

        String filePath = new File("VehiclesData.csv").getAbsolutePath();
        String line = ""; // <- Diaxorizei thn kathe grammh sto CSV arxeio

        //Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                info = line.split(";"); // <- use ; as separator
                for (int j= 0; j<3; j++){
                info1[i][j] = info[j];
                }
                i++;
            }
        }
        // Aparaithto se periptosh pou dothei lathos hmeromhnia
        catch (IOException  e) {
            // Invalid date was entered
            e.printStackTrace();
        }
        return info1;
    }

    public NewDateValidator() {
        String[][] info1 = fileParser();

        LicensePlatesValidator lpv = new LicensePlatesValidator();
        if (lpv.getValidFormat2()) {
            for (int i = 0; i < info1.length; i++ ){
                if (info1[i][1].equals(StrInput.getStrInput())){
                    Date date = null;
                    try {
                        date = dateFormat().parse(info1[i][2]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String expiredStatus = "EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh

                    // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
                    if (date.compareTo(dateNowFormat()) >= 0) {
                        expiredStatus = "VALID";
                    }
                    System.out.println("AFM : " + info1[i][1] + " Plates number: " + info1[i][0] +
                            " Date registered: " + info1[i][2] +" License status: "+ expiredStatus);
                }
            }
        }
    }
}