package tools;

import Vehicle.Vehicle;
import java.util.ArrayList;

public class LicensePlateSorter {

    /**
     * Given an ArrayList<Vehicle> the method will sort it
     * then return it
     */
    public ArrayList<Vehicle> arraySorter (ArrayList<Vehicle> vehicleList) {

        for (int i = 0; i < vehicleList.size(); i++) {
            for (int j = 1; j < (vehicleList.size() - i); j++) {
                if (vehicleList.get(j - 1).getLicensePlate().compareTo(vehicleList.get(j).getLicensePlate()) > 0) {
                    Vehicle temp = vehicleList.get(j - 1);
                    vehicleList.set(j - 1, vehicleList.get(j));
                    vehicleList.set(j, temp);
                }
            }
        }
        return vehicleList;
    }
}
