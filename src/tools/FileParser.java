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

    public ArrayList<Vehicle> csvToTable() {

        String[] array;
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            while ((line = br.readLine()) != null) { // <- Epanalipsi oso yparxoun grammes sto CSV
                array = line.split(";"); // <- use ; as separator
                Vehicle vehicle = new Vehicle(array[0],array[1],array[2]);
                vehicleList.add(vehicle);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }
}