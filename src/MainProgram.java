import java.util.Scanner;

public class MainProgram {

    public static void main ( String[] args ) {

        int input = 0 ;
        do {
            // epanalipsh gia na doulepsei panw apo mia askhsh
            // edw ksekinaei to programma. zhtaei ton arithmo ths askishs
//trial and error
            System.out.println ( "=== OUR AWESOME PROJECT ===" );
            System.out.println ( "1. LicensePlatesValidator" );
            System.out.println ( "2. DateValidator" );
            System.out.println ( "3. ----" );
            // edw diavazei ton arithmo pou tou dwsame

            Scanner scan = new Scanner ( System.in );
            // h metablith input tha pernei to apotelesma kai tha fortonei to katalilo operation
            input = scan.nextInt ();

            switch (input) {
                case 1: //LicensePlatesValidator
                    new LicensePlatesValidator();
                    break;

                case 2: // DateValidator
                    new DateValidator ();
                    break;


            }

        }
        while (input != 0);
        System.out.println ( "Good Bye!!" );
    }
}



