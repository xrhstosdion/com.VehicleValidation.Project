import Validators.Validators;
import tools.FileParser;
import tools.Tools;
import Input.StrInput;
public class MainProgram {

    public static void main ( String[] args ) {
        String input;
        int i =0;
        do {

            // epanalipsh gia na doulepsei panw apo mia askhsh
            // edw ksekinaei to programma. zhtaei ton arithmo ths askishs
            System.out.println("===========================");
            System.out.println("=== OUR AWESOME PROJECT ===");
            System.out.println("PLEASE SELECT AN OPERATION");
            System.out.println("1. LicensePlatesValidator");
            System.out.println("2. DateValidator");
            System.out.println("4. FineCalculator");
            System.out.println("0. TO EXIT");
            System.out.println("===========================");

            // edw diavazei ton arithmo pou tou dwsame
            // h metablith input tha pernei to apotelesma kai tha fortonei to katalilo operation
            input = StrInput.askStrInput();
            try {
                i = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("wrong is not valid number. try again");
            }
            if (i==0 || i>3){
                System.out.println("not in 1-4");
            }

            // Se kathe epilogh fortonetai h antistoixh klash
            switch (input) {

                case "1": //LicensePlatesValidator


                    break;

                case "4": // Fine Calculator
                    //new DataSorter ();
                    FileParser fp = new FileParser("VehiclesData.csv");
                    StrInput.askStrInput();
                    String[][] info3 = fp.csvToTable();

                    Tools myTable = new Tools();
                    myTable.tableSearch(info3,1, 100);
                    break;

                case "3":
                    String userInput = StrInput.askStrInput();
                    Validators valid = new Validators();
                    valid.formatValidator(1,userInput);

                    while (!valid.validateConfirmation() && !userInput.equals("exit")) {
                        System.out.println(valid.getWrongFormat());
                        userInput = StrInput.askStrInput();
                    }

                    break;

                case "5":
                    //Validator.validateConfirmation();
                    break;
            }
        } while (i != 0);
        System.out.println ( "Good Bye!!" );
    }
}
