package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParser{

    private String filePath;

    public FileParser(String filePath) {
        this.filePath = filePath;
    }

    public String[][] csvToTable() {

        String[] array;
        String[][] table = new String[99][3];
        int i = 0;
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        String line = ""; // <- Diaxorizei thn kathe grammh sto CSV arxeio

        //Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            while ((line = br.readLine()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                array = line.split(";"); // <- use ; as separator
                int columnNumber = array.length;
                System.arraycopy(array, 0, table[i], 0, columnNumber);
                i++;
            }
        }
        // Aparaithto se periptosh pou dothei lathos hmeromhnia
        catch (IOException e) {
            // Invalid date was entered
            e.printStackTrace();
        }
        return table;
    }
}