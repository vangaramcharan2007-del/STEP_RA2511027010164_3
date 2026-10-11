// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
import java.util.Arrays;
import java.util.Objects;

public class TransactionRecord implements Cloneable {
    private String transactionId;
    private double amount;
    private String currency;
    private String[] auditTags;

    public TransactionRecord(String transactionId, double amount, String currency, String[] auditTags) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.auditTags = (auditTags != null) ? auditTags.clone() : new String[0];
    }

    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String[] getAuditTags() { return auditTags; }

    public void setAuditTags(String[] tags) {
        this.auditTags = (tags != null) ? tags.clone() : new String[0];
    }

    // Contract: Overriding equals() must be reflexive, symmetric, transitive, and consistent
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TransactionRecord other = (TransactionRecord) obj;
        return Double.compare(other.amount, this.amount) == 0 &&
                Objects.equals(this.transactionId, other.transactionId) &&
                Objects.equals(this.currency, other.currency) &&
                Arrays.equals(this.auditTags, other.auditTags);
    }

    // Contract: If two objects are equal according to equals(), their hashCode() MUST be identical
    @Override
    public int hashCode() {
        int result = Objects.hash(transactionId, amount, currency);
        result = 31 * result + Arrays.hashCode(auditTags);
        return result;
    }

    // Overriding toString() for comprehensive diagnostic logging
    @Override
    public String toString() {
        return String.format("TransactionRecord[id='%s', amount=%.2f %s, tags=%s]",
                transactionId, amount, currency, Arrays.toString(auditTags));
    }

    // Deep copy implementation of clone()
    @Override
    public TransactionRecord clone() {
        try {
            TransactionRecord copy = (TransactionRecord) super.clone();
            // Deep copy mutable reference array to ensure independent state
            copy.auditTags = this.auditTags.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone operation unexpectedly failed", e);
        }
    }
}
