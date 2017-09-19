

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainProgram {

    public static void main (String [] args ){

        // diavasma arxeiou CSV
        String csvFile = "/Users/chris/Desktop/#Projects/com.VehicleValidation.Project/csv.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader ( new FileReader ( csvFile ) )) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] info = line.split(cvsSplitBy);

                //String daten = info[3];
                String daten = "02/03/2011";


                //Date conversion === NOT WORKING ===
                SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date date = df.parse(daten);
                Date dateOfInsurance = df.parse ( daten ); // Here you have date stored

                // ektyposh olwn twn stoixeiwn gia dokimh
                System.out.println("The owner is: " + info[0] + " the brand is: " + info[1] +
                        " the model is: " + info[2] + " it was registered at: " + dateOfInsurance + " for " + info[4] + " months.");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        }




    }

