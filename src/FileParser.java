import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    private String filePath;

    public FileParser(String filePath){
        this.filePath=filePath;
    }

    public String[][] csvToTable (){

        String[] info;
        String[][] info1 = new String[99][3];
        int i = 0;
        //Diavasma arxeiou CSV

        String absoluteFilePath = new File(filePath).getAbsolutePath();
        String line = ""; // <- Diaxorizei thn kathe grammh sto CSV arxeio

        //Epanalipsh gia na apothikevei se pinaka tis times apo to CSV
        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            while ((line = br.readLine()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                info = line.split(";"); // <- use ; as separator
                int columnNumber = info.length;
                System.arraycopy(info, 0, info1[i], 0,3);
                i++;
            }
        }
        // Aparaithto se periptosh pou dothei lathos hmeromhnia
        catch (IOException e) {
            // Invalid date was entered
            e.printStackTrace();
        }
        return info1;
    }
}
