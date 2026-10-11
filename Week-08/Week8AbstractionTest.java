// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java & OOP
public class Week8AbstractionTest {
    public static void main(String[] args) {
        System.out.println("Running Week 8 Test Suite for RAM CHARAN VANGA (RA2511027010164)...");

        // 1. Instantiating concrete cloud implementations
        AWSStorageService aws = new AWSStorageService("us-east-1");
        AzureStorageService azure = new AzureStorageService("westeurope");

        // 2. Testing polymorphic StorageClient (Loose Coupling)
        StorageClient client = new StorageClient(aws);
        client.storeString("report.txt", "Confidential Data 2026");

        String retrievedAws = client.fetchString("report.txt");
        assert "Confidential Data 2026".equals(retrievedAws) : "AWS retrieved data mismatch";
        assert aws.getStoredFileCount() == 1 : "AWS bucket count mismatch";
        assert client.testSyncCapability() : "AWS sync capability failed";
        assert aws.isBucketSynced() : "AWS bucket should be marked synced";

        // 3. Hot-swapping provider to Azure
        client.setStorageProvider(azure);
        client.storeString("metrics.csv", "id,revenue,profit\n1,5000,1200");

        String retrievedAzure = client.fetchString("metrics.csv");
        assert retrievedAzure != null && retrievedAzure.contains("profit") : "Azure retrieved data mismatch";
        assert azure.getStoredFileCount() == 1 : "Azure bucket count mismatch";
        assert client.testSyncCapability() : "Azure sync capability failed";
        assert azure.isReplicationActive() : "Azure replication state failed";

        // 4. Testing static and default interface methods
        assert Syncable.validatePath("valid/path/file.json") : "Valid path check failed";
        assert !Syncable.validatePath("../dangerous/file.txt") : "Directory traversal check failed";
        assert aws.isEncryptionCompliant() : "Default interface method compliance failed";
        assert "HTTPS/TLS_1.3".equals(azure.getSyncProtocol()) : "Default sync protocol failed";

        System.out.println("-> AWS Upload/Download & Sync: PASSED");
        System.out.println("-> Azure Hot-swap & Verification: PASSED");
        System.out.println("-> Static & Default Interface Contracts: PASSED");

        System.out.println("WEEK 8 TESTS PASSED (100%)");
    }
}
