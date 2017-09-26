public class Validator {
    public String validFormat;
    private String data;
    private int type;
    private String wrongFormat;

    public Validator ( int type, String data){

        this.data=data;
        this.type=type;

        switch(type){
            case 1: {
                 validFormat = "[a-zA-Z]{3}-\\d{4}";
                 setWrongFormat("The format is Wrong, provide a correct one (ABC-1234) or type 'exit' to EXIT");
                 break;
            }
            case 2:{
                 validFormat = "\\d{9}";
                setWrongFormat("The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT");
                break;
            }

        }

    }
    public boolean validateConfirmation(){

        return data.matches(validFormat);
    }

    public String getWrongFormat() {
        return wrongFormat;
    }

    public void setWrongFormat(String wrongFormat) {
        this.wrongFormat = wrongFormat;
    }
}
