import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Scanner;

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
            Scanner scan = new Scanner(System.in);

            // h metablith input tha pernei to apotelesma kai tha fortonei to katalilo operation
            input = scan.next();
            try {
                i = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("wrong is not valid number. try again");
            }
            if (i==0 || i>3){
                System.out.println("not in 1-3");
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
                    new DataSorter ();
                    break;

                case "3":
                    new NewDateValidator();
                    break;

                case "4":
                    System.out.println("please provide the holy input");
                    new StrInput();
                    String hello = StrInput.getStrInput();
                    new StrInput();
                    String hello1 = StrInput.getStrInput();
                    System.out.println("the hello is "+hello);
                    System.out.println("the hello1 is "+hello);

                    break;
            }
        }

        // Ta parapanw tha simvenoun mexri o xrhsths na eisagei 0
        while (i < 1 || i > 5);
        //while (i != 0);
        System.out.println ( "Good Bye!!" );
    }
}



