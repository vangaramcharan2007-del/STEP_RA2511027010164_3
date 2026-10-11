// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class CombustionVehicle extends Vehicle {
    private double fuelEfficiencyKmPerLiter;
    private double fuelPricePerLiter;

    public CombustionVehicle(String id, String model, double baseRatePerKm, 
                             double fuelEfficiencyKmPerLiter, double fuelPricePerLiter) {
        super(id, model, baseRatePerKm);
        this.fuelEfficiencyKmPerLiter = fuelEfficiencyKmPerLiter;
        this.fuelPricePerLiter = fuelPricePerLiter;
    }

    public double getFuelEfficiencyKmPerLiter() { return fuelEfficiencyKmPerLiter; }
    public double getFuelPricePerLiter() { return fuelPricePerLiter; }

    @Override
    public double calculateTripCost(double distanceKm) {
        // Base rate + fuel consumption + 5% carbon surcharge
        double fuelRequired = distanceKm / fuelEfficiencyKmPerLiter;
        double fuelCost = fuelRequired * fuelPricePerLiter;
        double carbonTax = fuelCost * 0.05;
        return super.calculateTripCost(distanceKm) + fuelCost + carbonTax;
    }

    @Override
    public String getVehicleType() {
        return "Internal Combustion Vehicle";
    }
}
