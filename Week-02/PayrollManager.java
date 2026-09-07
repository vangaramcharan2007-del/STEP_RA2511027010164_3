// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// Java OOP Implementation
import java.util.ArrayList;
import java.util.List;

public class PayrollManager {
    private List<Employee> workforce = new ArrayList<>();

    public void addEmployee(Employee emp) {
        workforce.add(emp);
    }

    public double calculateTotalPayroll() {
        double total = 0.0;
        for (Employee e : workforce) {
            total += e.calculateNetSalary();
        }
        return total;
    }

    public int getEmployeeCount() {
        return workforce.size();
    }
}