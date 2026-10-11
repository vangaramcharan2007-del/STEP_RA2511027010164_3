// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class Vehicle {
    private String id;
    private String model;
    private double baseRatePerKm;

    public Vehicle(String id, String model, double baseRatePerKm) {
        this.id = id;
        this.model = model;
        this.baseRatePerKm = baseRatePerKm;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public double getBaseRatePerKm() { return baseRatePerKm; }

    public double calculateTripCost(double distanceKm) {
        return distanceKm * baseRatePerKm;
    }

    public String getVehicleType() {
        return "Generic Vehicle";
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %s | Model: %s | Base Rate: $%.2f/km", 
                getVehicleType(), id, model, baseRatePerKm);
    }
}
