package Validators;

import Input.StrInput;

public class Validators {

    private String validFormat;
    private String wrongFormat;

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
            case "Fine": {
                validFormat = "\\d+";
                setWrongFormat("The format is Wrong, provide a correct one (a number) or type 'exit' to EXIT");
                break;
            }
        }
    }

    public boolean validateConfirmation(String userData, String type) {
        while(!userData.matches(validFormat) && !userData.equals("exit")){
            System.out.println(getWrongFormat());
            userData = StrInput.askStrInput();
            if (type.equals("afm")){
                StrInput.setUserAfm(userData);
            }
            if (type.equals("LicensePlates")){
                StrInput.setUserLicensePlates(userData);
            }
            if (type.equals("Fine")){
                StrInput.setFine(userData);
            }
        }
        return userData.matches(validFormat);
    }

    public String getWrongFormat() {
        return wrongFormat;
    }

    private void setWrongFormat(String wrongFormat) {
        this.wrongFormat = wrongFormat;
    }

}