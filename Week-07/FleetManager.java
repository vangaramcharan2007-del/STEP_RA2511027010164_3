// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
import java.util.ArrayList;
import java.util.List;

public class FleetManager {
    private List<Vehicle> fleet;

    public FleetManager() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        if (v != null) {
            fleet.add(v);
        }
    }

    public int getFleetSize() {
        return fleet.size();
    }

    // Demonstrates Runtime Polymorphism / Dynamic Method Dispatch
    public double dispatchTrip(int index, double distanceKm) {
        if (index >= 0 && index < fleet.size()) {
            Vehicle v = fleet.get(index);
            return v.calculateTripCost(distanceKm);
        }
        throw new IndexOutOfBoundsException("Invalid vehicle index");
    }

    public double calculateTotalFleetCost(double distancePerVehicle) {
        double total = 0.0;
        for (Vehicle v : fleet) {
            total += v.calculateTripCost(distancePerVehicle);
        }
        return total;
    }

    public int countElectricVehicles() {
        int count = 0;
        for (Vehicle v : fleet) {
            if (v instanceof ElectricVehicle) {
                count++;
            }
        }
        return count;
    }
}
