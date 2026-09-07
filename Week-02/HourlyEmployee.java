// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// Java OOP Implementation
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String empId, String name, String department, double hourlyRate, int hoursWorked) {
        super(empId, name, department, 0.0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateMonthlyGross() {
        if (hoursWorked <= 160) {
            return hoursWorked * hourlyRate;
        } else {
            int overtime = hoursWorked - 160;
            return (160 * hourlyRate) + (overtime * hourlyRate * 1.5);
        }
    }
}