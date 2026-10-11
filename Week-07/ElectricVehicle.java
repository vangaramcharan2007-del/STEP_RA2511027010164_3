// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class ElectricVehicle extends Vehicle {
    private double batteryCapacityKWh;
    private double batteryLevelPercent;
    private double electricityRatePerKWh;

    public ElectricVehicle(String id, String model, double baseRatePerKm, 
                           double batteryCapacityKWh, double electricityRatePerKWh) {
        super(id, model, baseRatePerKm);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.electricityRatePerKWh = electricityRatePerKWh;
        this.batteryLevelPercent = 100.0;
    }

    public double getBatteryCapacityKWh() { return batteryCapacityKWh; }
    public double getBatteryLevelPercent() { return batteryLevelPercent; }

    public void chargeBattery(double percent) {
        this.batteryLevelPercent = Math.min(100.0, this.batteryLevelPercent + percent);
    }

    @Override
    public double calculateTripCost(double distanceKm) {
        // Base vehicle rate + energy consumption surcharge minus green eco discount
        double energyCost = (distanceKm * 0.15) * electricityRatePerKWh; // 0.15 kWh per km
        double ecoDiscount = 0.10; // 10% green discount
        double total = (super.calculateTripCost(distanceKm) + energyCost) * (1.0 - ecoDiscount);
        
        // Deduct battery
        double batteryUsed = (distanceKm * 0.2);
        this.batteryLevelPercent = Math.max(0.0, this.batteryLevelPercent - batteryUsed);
        
        return total;
    }

    @Override
    public String getVehicleType() {
        return "Electric Vehicle (Eco)";
    }
}
