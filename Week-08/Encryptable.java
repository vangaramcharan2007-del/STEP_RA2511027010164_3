// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public interface Encryptable {
    // Interface constant
    byte CIPHER_KEY = 0x5A;

    // Abstract methods
    byte[] encrypt(byte[] rawData);
    byte[] decrypt(byte[] encryptedData);

    // Default interface method (Java 8+)
    default boolean isEncryptionCompliant() {
        return true;
    }
}
