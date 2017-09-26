public class Validator {
    private String validFormat;
    private String data;
    private int type;
    private String wrongFormat;

    public Validator ( int type, String data){

        this.data=data;
        this.type=type;

        switch(type){
            case 1: {
                 validFormat = "[a-zA-Z]{3}-\\d{4}";
                 wrongFormat = "The format is Wrong, provide a correct one (ABC-1234) or type 'exit' to EXIT";
            }
            case 2:{
                 validFormat = "\\d{9}";
                wrongFormat = "The format is Wrong, provide a correct one (123456789) or type 'exit' to EXIT";

            }
            
        }

    }
    public boolean validateConfirmation(){

        while (!data.matches(validFormat) && !data.equals("exit")) {
            System.out.println(wrongFormat);
            data = StrInput.askStrInput();
        }
        if (data.matches(validFormat)) {
            System.out.println("The format is accepted");
            return true;
        } else {
            System.out.println("The program is exiting");
        }
        return false;
    }
}
