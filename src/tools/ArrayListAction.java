package tools;

import Input.StrInput;
import Texts.Texts;
import Vehicle.Vehicle;
import java.util.ArrayList;

public class ArrayListAction {

    /**
     * Takes As arguments an ArrayList<Vehicle> and the user input (afm or licensePlates expected)
     * Uses the user input to search in the ArrayList that was given as Argument
     * Returns an ArrayList<Vehicle> with the found vehicles
     * If the user input is an afm it will search for all the vehicles with the same afm
     * If the user input is a License Plates it will search for the correct vehicle
     */
    public ArrayList<Vehicle> vehicleSearch(ArrayList<Vehicle> vehicleList, String userInput) {

        ArrayList<Vehicle> foundVehiclesArrayList = new ArrayList<Vehicle>();

        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getAfm().equals(userInput)) {
                foundVehiclesArrayList.add(vehicleList.get(i));
            }
            if (vehicleList.get(i).getLicensePlate().equals((userInput))) {
                foundVehiclesArrayList.add(vehicleList.get(i));
            }
        }
        return foundVehiclesArrayList;
    }
    /**
     * The main method of the Project.
     * Takes as input an ArrayList<Vehicle> (the one returned from VehicleSearch in order to have correct results)
     * Action : LicensePlates, will print the found vehicle
     * Action : AFM, will check how many expired vehicles it has and add a fine for each one expired
     * Action : Date, will check only the License "VALID" vehicles
     */
    public void vehicleSearchOption(ArrayList<Vehicle> foundVehiclesArrayList, String action) {
        int totalFine = 0;
        switch (action) {
            case "LicensePlates":
                if (foundVehiclesArrayList.isEmpty()) {
                    System.out.println("the vehicle with the above License Plates does not exist!");
                    break;
                }
                Texts.vehicleText(foundVehiclesArrayList, 0);
                break;

            case "AFM":
                DateCompare.setLocalDate(0);
                if (foundVehiclesArrayList.isEmpty()) {
                    System.out.println("the owner with the above AFM does not exist!");
                    break;
                }
                for (int i = 0; i < foundVehiclesArrayList.size(); i++) {
                    if (foundVehiclesArrayList.get(i).getStatus().equals("EXPIRED")) {
                        totalFine = totalFine + StrInput.getFine();
                    }
                    Texts.vehicleText(foundVehiclesArrayList, i);
                }
                System.out.println("The total amount of fine is " + totalFine);
                break;

            case "Date":
                if (foundVehiclesArrayList.isEmpty()) {
                    System.out.println("No vehicles found that will be expired!");
                    break;
                }
                for (int i = 0; i < foundVehiclesArrayList.size(); i++) {
                    if (foundVehiclesArrayList.get(i).getStatus().equals("VALID")) {
                        if (!DateCompare.dateCompare(foundVehiclesArrayList.get(i).getLicenseDate())) {
                            Texts.vehicleText2(foundVehiclesArrayList, i);
                        }
                    }
                }
                break;
        }
    }
}
