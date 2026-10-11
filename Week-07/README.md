# Week 07 — OOP Inheritance & Dynamic Polymorphism

## Concepts Covered
- **Inheritance Hierarchy**: Extensibility of a base `Vehicle` superclass through `ElectricVehicle` and `CombustionVehicle` subclasses.
- **Constructor Chaining**: Proper invocation of superclass constructors via `super()` to initialize base fields cleanly.
- **Method Overriding**: Specialization of `calculateTripCost(double distance)` in subclasses for electric energy consumption and internal combustion carbon surcharges.
- **Dynamic Method Dispatch**: Heterogeneous collection storage and polymorphic method execution managed by `FleetManager`.

## Verification
```bash
cd Week-07
javac *.java
java -ea Week7InheritanceTest
```
