# Week 09 — Object Class Contracts & Inner Class Architectures

## Concepts Covered
- **Object Class Methods (`TransactionRecord`)**:
  - `equals(Object o)`: Enforcing reflexivity, symmetry, transitivity, and null-safety.
  - `hashCode()`: Guaranteeing hash consistency across identical object states for hashed collections (`HashSet`, `HashMap`).
  - `clone()`: Deep cloning via `Cloneable` interface to eliminate shared mutable state vulnerabilities.
  - `toString()`: Clean formatted representation of domain records.
- **Java Inner Class Types (`AuditLogger`)**:
  - **Member Inner Class** (`AuditEntry`): Direct access to outer instance fields (`systemEnvironment`).
  - **Static Nested Class** (`FilterCriteria`): Standalone helper unlinked to outer instances.
  - **Local Inner Class** (`SecuritySanitizer`): Scoped strictly within a method execution frame.
  - **Anonymous Inner Class** (`LogFormatter`): Dynamic inline implementation of functional contracts.

## UML Class Diagram
```
+---------------------------------------------------------+
|                  TransactionRecord                      |
+---------------------------------------------------------+
| - transactionId : String                                |
| - amount        : double                                |
| - currency      : String                                |
| - auditTags     : String[]                              |
+---------------------------------------------------------+
| + equals(obj: Object) : boolean                         |
| + hashCode() : int                                      |
| + toString() : String                                   |
| + clone() : TransactionRecord                           |
+---------------------------------------------------------+

+---------------------------------------------------------+
|                      AuditLogger                        |
+---------------------------------------------------------+
| - systemEnvironment : String                            |
| - entries : List<AuditEntry>                            |
+---------------------------------------------------------+
| + processAndSanitize(raw: String, flag: boolean)        |
+---------------------------------------------------------+
       |                           |
       | (member inner)            | (static nested)
       v                           v
+------------------+     +------------------------+
|    AuditEntry    |     |     FilterCriteria     |
+------------------+     +------------------------+
```

## Verification
```bash
cd Week-09
javac *.java
java -ea Week9ObjectClassTest
```
