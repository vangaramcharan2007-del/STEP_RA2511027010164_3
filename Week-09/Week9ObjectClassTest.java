// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
import java.util.HashSet;
import java.util.Set;

public class Week9ObjectClassTest {
    public static void main(String[] args) {
        System.out.println("Running Week 9 Test Suite for RAM CHARAN VANGA (RA2511027010164)...");

        // 1. Testing equals() and hashCode() Contract
        String[] tags = {"PAYROLL", "Q3"};
        TransactionRecord t1 = new TransactionRecord("TX-1001", 4500.0, "USD", tags);
        TransactionRecord t2 = new TransactionRecord("TX-1001", 4500.0, "USD", tags);
        TransactionRecord t3 = new TransactionRecord("TX-1002", 7200.0, "EUR", new String[]{"SERVER"});

        assert t1.equals(t2) : "Symmetric equals() check failed";
        assert !t1.equals(t3) : "Inequality check failed";
        assert t1.hashCode() == t2.hashCode() : "hashCode() equality contract failed";

        Set<TransactionRecord> set = new HashSet<>();
        set.add(t1);
        set.add(t2); // Should not duplicate in HashSet due to hashCode & equals
        assert set.size() == 1 : "HashSet deduplication failed";

        // 2. Testing toString()
        String strRep = t1.toString();
        assert strRep.contains("TX-1001") && strRep.contains("4500.00") : "toString() output malformed";

        // 3. Testing Deep Copy clone()
        TransactionRecord cloned = t1.clone();
        assert cloned != t1 : "Clone reference should be distinct";
        assert cloned.equals(t1) : "Cloned object state should match original";

        // Modify cloned tags to test mutation independence
        cloned.setAuditTags(new String[]{"MODIFIED_TAG"});
        assert !cloned.equals(t1) : "Clone deep copy mutation affected original!";
        assert t1.getAuditTags()[0].equals("PAYROLL") : "Original tags were altered!";

        // 4. Testing All 4 Inner Class Variants
        AuditLogger logger = new AuditLogger("PRODUCTION");

        // Member Inner Class
        AuditLogger.AuditEntry entry = logger.new AuditEntry("DATABASE_BACKUP_INITIATED");
        assert entry.formatLog().contains("PRODUCTION") : "Member inner class failed to access outer state";

        // Static Nested Class
        AuditLogger.FilterCriteria filter = new AuditLogger.FilterCriteria(1000.0);
        assert filter.matches(1500.0) : "Static nested class logic failed";
        assert !filter.matches(500.0) : "Static nested class logic failed";

        // Local & Anonymous Inner Classes
        String formatted = logger.processAndSanitize("<script>ALERT</script>", true);
        assert formatted.contains("_SCRIPT_ALERT__SCRIPT_") : "Local inner class sanitization failed";
        assert formatted.startsWith(">>> [SECURE_AUDIT]") : "Anonymous inner class formatting failed";

        assert logger.getEntries().size() == 1 : "Audit log list size mismatch";

        System.out.println("-> equals() & hashCode() Contract: PASSED");
        System.out.println("-> Deep Copy Clone Mutation Independence: PASSED");
        System.out.println("-> Member, Static, Local & Anonymous Inner Classes: PASSED");

        System.out.println("WEEK 9 TESTS PASSED (100%)");
    }
}
