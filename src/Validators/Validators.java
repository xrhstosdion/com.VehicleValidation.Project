package Validators;

import Input.StrInput;

public class Validators {

    public String validFormat;
    private static String wrongFormat;

    public void formatValidator(String type) {

        switch (type) {
            case "LicensePlates": {
                validFormat = "[a-zA-Z]{3}-\\d{4}";
                setWrongFormat("The format is Wrong, provide a correct one (ABC-1234) or type 'exit' to EXIT");
                break;
            }
            case "AFM": {
                validFormat = "\\d{9}";
                setWrongFormat("The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT");
                break;
            }
            case "Fine":{
                validFormat = "\\d+";
                setWrongFormat("The format is Wrong, provide a correct one (a number) or type 'exit' to EXIT");

            }
        }
    }

    public boolean validateConfirmation(String data) {

        return data.matches(validFormat);
    }

    public String getWrongFormat() {
        return wrongFormat;
    }

    public void setWrongFormat(String wrongFormat) {
        Validators.wrongFormat = wrongFormat;
    }

}