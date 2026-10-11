// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class AzureStorageService extends CloudStorageService implements Encryptable, Syncable {
    private boolean replicationActive = false;

    public AzureStorageService(String region) {
        super("Microsoft Azure Blob Storage", region);
    }

    @Override
    public byte[] encrypt(byte[] rawData) {
        if (rawData == null) return new byte[0];
        byte[] encrypted = new byte[rawData.length];
        for (int i = 0; i < rawData.length; i++) {
            encrypted[i] = (byte) (rawData[i] ^ (CIPHER_KEY + 1));
        }
        return encrypted;
    }

    @Override
    public byte[] decrypt(byte[] encryptedData) {
        if (encryptedData == null) return new byte[0];
        byte[] decrypted = new byte[encryptedData.length];
        for (int i = 0; i < encryptedData.length; i++) {
            decrypted[i] = (byte) (encryptedData[i] ^ (CIPHER_KEY + 1));
        }
        return decrypted;
    }

    @Override
    public void uploadFile(String fileName, byte[] data) {
        if (Syncable.validatePath(fileName) && data != null) {
            byte[] encrypted = encrypt(data);
            storageBucket.put(fileName, encrypted);
        }
    }

    @Override
    public byte[] downloadFile(String fileName) {
        byte[] encrypted = storageBucket.get(fileName);
        if (encrypted == null) return null;
        return decrypt(encrypted);
    }

    @Override
    public void deleteFile(String fileName) {
        storageBucket.remove(fileName);
    }

    @Override
    public void syncBucketWithRemote() {
        this.replicationActive = true;
    }

    public boolean isReplicationActive() {
        return replicationActive;
    }
}
