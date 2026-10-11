// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
import java.util.HashMap;
import java.util.Map;

public abstract class CloudStorageService {
    private String providerName;
    private String region;
    protected Map<String, byte[]> storageBucket;

    public CloudStorageService(String providerName, String region) {
        this.providerName = providerName;
        this.region = region;
        this.storageBucket = new HashMap<>();
    }

    public String getProviderName() { return providerName; }
    public String getRegion() { return region; }

    // Concrete method common to all storage providers
    public int getStoredFileCount() {
        return storageBucket.size();
    }

    public boolean fileExists(String fileName) {
        return storageBucket.containsKey(fileName);
    }

    // Abstract methods defining contract for concrete subclasses
    public abstract void uploadFile(String fileName, byte[] data);
    public abstract byte[] downloadFile(String fileName);
    public abstract void deleteFile(String fileName);
}
