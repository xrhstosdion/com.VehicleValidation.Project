package Validators;

public class Validators {

    public String validFormat;
    private String data;
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
                wrongFormat = "The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT";

                setWrongFormat("The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT");
                break;
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