package tools;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    String afm;
    String licensePlate;
    String licenseDate;
    String status;
    int repeats;

    public CSVExporter(String afm, String licensePlate, String licenseDate, String status, int repeats) {

        this.afm= afm;
        this.licenseDate=licenseDate;
        this.licensePlate=licensePlate;
        this.status=status;
        this.repeats=repeats;

    }

    public void  csvExporter (){


            FileWriter writer = null;
            try {
                writer = new FileWriter("C:\\Users\\ekped\\Desktop\\file.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < repeats; i++){

            try {
                writer.write(afm + ";" + licensePlate +
                        ";" + licenseDate + ";" + status);
                writer.write(System.lineSeparator());

            }

            catch (IOException e) {
                e.printStackTrace();
            }

            }


    }
}
