// Chris Karidis

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
            System.out.println("3. ----");
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
                    if ( LicensePlatesValidator.getValidFormat()){
                    System.out.println("Hello People of Las Vegas!");
                }
                    break;

                case "2": // DateValidator
                    new DateValidator ();
                    break;

                case "32": // Data Sorter
                    //new DataSorter ();
                    FileParser fp = new FileParser("VehiclesData.csv");
                    String[][] info3 = fp.csvToTable();
                    for (i=0; i<info3.length; i++){
                        for (int j=0; j<info3[1].length; j++){

                            System.out.println(info3[i][j]);
                        }


                    }
                    break;

                case "3":
                    String userInput = StrInput.askStrInput();
                    Validator valid = new Validator(1,userInput);

                    while (!valid.validateConfirmation() && !userInput.equals("exit")) {
                        System.out.println(valid.getWrongFormat());
                        userInput = StrInput.askStrInput();
                    }

                    if (valid.validateConfirmation()){
                        NewDateValidator info = new NewDateValidator();
                        String info1[][] = info.fileParser();
                    }



                    break;

                case "4":
                    System.out.println("please provide the holy input");
                    String input123;
                    StrInput.askStrInput();
                    input123 = StrInput.askStrInput();
                    input123 = input123.getClass().getName();
                    System.out.println("the hello is "+input123);
                    //System.out.println("the hello1 is "+hello1);
                    break;
            }
        } while (i != 0);
        System.out.println ( "Good Bye!!" );
    }
}
