package tools;

import Vehicle.Vehicle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser{

    private String filePath;

    public FileParser(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the CSV file that is set to filePath
     * For each line it reads, a Vehicle is created and saved in an ArrayList<Vehicle>
     * Finally the ArrayList is returned
     */
    public ArrayList<Vehicle> csvToArrayList() {

        String[] array;
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            while ((line = br.readLine()) != null) {
                array = line.split(";");
                Vehicle vehicle = new Vehicle(array[0],array[1],array[2]);
                vehicle.setStatus();
                vehicleArrayList.add(vehicle);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleArrayList;
    }
}