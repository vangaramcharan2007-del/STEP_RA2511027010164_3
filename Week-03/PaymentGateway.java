// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// Java OOP Implementation
public interface PaymentGateway {
    boolean processPayment(String transactionId, double _amt);
    String getProviderName();
}