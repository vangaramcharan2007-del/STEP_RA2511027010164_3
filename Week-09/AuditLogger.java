// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
import java.util.ArrayList;
import java.util.List;

public class AuditLogger {
    private String systemEnvironment;
    private List<AuditEntry> entries;

    public AuditLogger(String systemEnvironment) {
        this.systemEnvironment = systemEnvironment;
        this.entries = new ArrayList<>();
    }

    // 1. MEMBER INNER CLASS (Can access outer class private fields directly)
    public class AuditEntry {
        private String action;
        private long timestamp;

        public AuditEntry(String action) {
            this.action = action;
            this.timestamp = System.currentTimeMillis();
        }

        public String formatLog() {
            // Accesses outer class 'systemEnvironment'
            return String.format("[%s] Action: %s @ %d", systemEnvironment, action, timestamp);
        }

        public String getAction() { return action; }
    }

    // 2. STATIC NESTED CLASS (Independent of outer class instance)
    public static class FilterCriteria {
        private double minThreshold;

        public FilterCriteria(double minThreshold) {
            this.minThreshold = minThreshold;
        }

        public boolean matches(double value) {
            return value >= minThreshold;
        }

        public double getMinThreshold() { return minThreshold; }
    }

    // Callback interface for anonymous inner class
    @FunctionalInterface
    public interface LogFormatter {
        String format(String rawMessage);
    }

    // 3. LOCAL INNER CLASS & 4. ANONYMOUS INNER CLASS
    public String processAndSanitize(String rawMessage, boolean applyCustomFormatter) {
        // 3. LOCAL INNER CLASS (Defined inside a method block)
        class SecuritySanitizer {
            public String sanitize(String input) {
                if (input == null) return "";
                return input.replaceAll("[<>&\"'/]", "_");
            }
        }

        SecuritySanitizer sanitizer = new SecuritySanitizer();
        String cleanMessage = sanitizer.sanitize(rawMessage);

        // 4. ANONYMOUS INNER CLASS (Inline implementation of interface)
        LogFormatter formatter;
        if (applyCustomFormatter) {
            formatter = new LogFormatter() {
                @Override
                public String format(String msg) {
                    return ">>> [SECURE_AUDIT] " + msg.toUpperCase() + " <<<";
                }
            };
        } else {
            formatter = msg -> msg;
        }

        AuditEntry entry = new AuditEntry(cleanMessage);
        entries.add(entry);

        return formatter.format(cleanMessage);
    }

    public List<AuditEntry> getEntries() { return entries; }
}
