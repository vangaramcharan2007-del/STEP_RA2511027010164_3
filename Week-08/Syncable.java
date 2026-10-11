// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public interface Syncable {
    void syncBucketWithRemote();

    // Static interface method (Utility function)
    static boolean validatePath(String path) {
        return path != null && !path.trim().isEmpty() && !path.contains("..");
    }

    // Default interface method
    default String getSyncProtocol() {
        return "HTTPS/TLS_1.3";
    }
}
