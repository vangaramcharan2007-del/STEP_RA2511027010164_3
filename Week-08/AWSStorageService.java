// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class AWSStorageService extends CloudStorageService implements Encryptable, Syncable {
    private boolean bucketSynced = false;

    public AWSStorageService(String region) {
        super("Amazon Web Services (S3)", region);
    }

    @Override
    public byte[] encrypt(byte[] rawData) {
        if (rawData == null) return new byte[0];
        byte[] encrypted = new byte[rawData.length];
        for (int i = 0; i < rawData.length; i++) {
            encrypted[i] = (byte) (rawData[i] ^ CIPHER_KEY);
        }
        return encrypted;
    }

    @Override
    public byte[] decrypt(byte[] encryptedData) {
        // XOR symmetric cipher reversal
        return encrypt(encryptedData);
    }

    @Override
    public void uploadFile(String fileName, byte[] data) {
        if (Syncable.validatePath(fileName) && data != null) {
            byte[] encryptedData = encrypt(data);
            storageBucket.put(fileName, encryptedData);
        }
    }

    @Override
    public byte[] downloadFile(String fileName) {
        byte[] encryptedData = storageBucket.get(fileName);
        if (encryptedData == null) return null;
        return decrypt(encryptedData);
    }

    @Override
    public void deleteFile(String fileName) {
        storageBucket.remove(fileName);
    }

    @Override
    public void syncBucketWithRemote() {
        this.bucketSynced = true;
    }

    public boolean isBucketSynced() {
        return bucketSynced;
    }
}
