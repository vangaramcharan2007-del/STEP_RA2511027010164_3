# Week 08 — Abstraction, Interfaces & Loose Coupling

## Concepts Covered
- **Abstract Classes (`CloudStorageService`)**: Definition of incomplete abstractions providing common state (`storageBucket`) and abstract method contracts (`uploadFile`, `downloadFile`).
- **Multiple Interface Implementation**: Both `AWSStorageService` and `AzureStorageService` implement `Encryptable` and `Syncable`.
- **Default and Static Interface Methods**: Implementation of static path verification (`Syncable.validatePath`) and default protocol definitions (`getSyncProtocol`).
- **Loose Coupling (`StorageClient`)**: Client-side decoupling permitting hot-swapping between storage providers at runtime without modifying consumer code.

## Verification
```bash
cd Week-08
javac *.java
java -ea Week8AbstractionTest
```
