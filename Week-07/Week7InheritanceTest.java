// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class Week7InheritanceTest {
    public static void main(String[] args) {
        System.out.println("Running Week 7 Test Suite for RAM CHARAN VANGA (RA2511027010164)...");

        // 1. Instantiating heterogeneous vehicle hierarchy
        Vehicle baseCar = new Vehicle("VH-001", "Standard Sedan", 2.0);
        ElectricVehicle ev = new ElectricVehicle("EV-101", "Tesla Model 3", 2.0, 75.0, 0.15);
        CombustionVehicle ice = new CombustionVehicle("ICE-201", "Ford F-150", 2.0, 10.0, 1.20);

        // 2. Base calculations
        double distance = 50.0;
        double baseCost = baseCar.calculateTripCost(distance); // 50 * 2.0 = 100.0
        assert Math.abs(baseCost - 100.0) < 0.001 : "Base vehicle cost calculation failed";

        // 3. Dynamic Method Dispatch via FleetManager
        FleetManager manager = new FleetManager();
        manager.addVehicle(baseCar);
        manager.addVehicle(ev);
        manager.addVehicle(ice);

        assert manager.getFleetSize() == 3 : "Fleet size mismatch";
        assert manager.countElectricVehicles() == 1 : "Electric vehicle count mismatch";

        // Dispatch trips polymorphically
        double costEv = manager.dispatchTrip(1, distance);
        double costIce = manager.dispatchTrip(2, distance);

        assert costEv > 0 : "EV trip cost must be positive";
        assert costIce > 0 : "ICE trip cost must be positive";
        assert costEv < costIce : "Electric trip should be cheaper than ICE trip with eco-discount";

        double totalFleetCost = manager.calculateTotalFleetCost(distance);
        assert totalFleetCost == (baseCost + costEv + costIce) : "Total fleet cost aggregation failed";

        System.out.println("-> Base Vehicle Cost: $" + String.format("%.2f", baseCost));
        System.out.println("-> EV Cost (Dispatched): $" + String.format("%.2f", costEv));
        System.out.println("-> ICE Cost (Dispatched): $" + String.format("%.2f", costIce));
        System.out.println("-> Total Fleet Cost: $" + String.format("%.2f", totalFleetCost));

        System.out.println("WEEK 7 TESTS PASSED (100%)");
    }
}
