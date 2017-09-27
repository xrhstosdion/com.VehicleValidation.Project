package Validators;

import tools.Tools;

import java.text.ParseException;
import java.util.Date;

public class Validators {

    public String validFormat;
    private String data;
    private int type;
    private static String wrongFormat;


    public void formatValidator(int type, String data) {

        this.data = data;
        this.type = type;

        switch (type) {
            case 1: {
                validFormat = "[a-zA-Z]{3}-\\d{4}";
                setWrongFormat("The format is Wrong, provide a correct one (ABC-1234) or type 'exit' to EXIT");
                break;
            }
            case 2: {
                validFormat = "\\d{9}";
                wrongFormat = "The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT";

                setWrongFormat("The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT");
                break;
            }
        }
    }

    public boolean validateConfirmation() {

        return data.matches(validFormat);
    }

    public String getWrongFormat() {
        return wrongFormat;
    }

    public void setWrongFormat(String wrongFormat) {
        Validators.wrongFormat = wrongFormat;
    }

    public static boolean dateValidator(String VehicleDate) {
        Date date = null;
        try {
            date = Tools.dateFormat().parse(VehicleDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String expiredStatus = "EXPIRED"; // <- epanafora ths "expir" sthn arxikh ths timh
        // An h hmerominia einai megalhterh apo thn shmerinh, tote einai VALID
        if (date.compareTo(Tools.dateNowFormat()) >= 0) {
            expiredStatus = "VALID";
            return true;
        }
        return false;
    }
}