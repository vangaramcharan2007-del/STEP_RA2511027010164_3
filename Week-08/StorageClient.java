// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
import java.nio.charset.StandardCharsets;

public class StorageClient {
    private CloudStorageService storage;

    public StorageClient(CloudStorageService storage) {
        this.storage = storage;
    }

    public void setStorageProvider(CloudStorageService storage) {
        this.storage = storage;
    }

    public void storeString(String fileName, String content) {
        storage.uploadFile(fileName, content.getBytes(StandardCharsets.UTF_8));
    }

    public String fetchString(String fileName) {
        byte[] bytes = storage.downloadFile(fileName);
        if (bytes == null) return null;
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public boolean testSyncCapability() {
        if (storage instanceof Syncable) {
            Syncable syncable = (Syncable) storage;
            syncable.syncBucketWithRemote();
            return true;
        }
        return false;
    }
}
