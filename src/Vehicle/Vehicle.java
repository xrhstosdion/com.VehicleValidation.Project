package Vehicle;

import tools.DateCompare;

public class Vehicle {

    public String licensePlate;
    public String afm;
    public String licenseDate;
    public String status = "EXPIRED";

    public Vehicle(String licensePlate, String afm, String licenseDate) {
        this.licensePlate = licensePlate;
        this.afm = afm;
        this.licenseDate = licenseDate;

        if (DateCompare.dateCompare(this.licenseDate)){
            this.status = "VALID";
        }

    }
}
