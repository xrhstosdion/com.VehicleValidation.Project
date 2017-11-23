package Vehicle;

import tools.DateCompare;

public class Vehicle {

    private String licensePlate;
    private String afm;
    private String licenseDate;
    private String status = "EXPIRED";


    public Vehicle(String licensePlate, String afm, String licenseDate) {
        this.licensePlate = licensePlate;
        this.afm = afm;
        this.licenseDate = licenseDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(String licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = "EXPIRED";
        if (DateCompare.dateCompare(this.licenseDate)){
            this.status = "VALID";
        }
    }
}
