// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// Java OOP Implementation
import java.util.ArrayList;
import java.util.List;

public class BankManager {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount acc) { accounts.add(acc); }

    public double getTotalLiquidity() {
        return accounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}