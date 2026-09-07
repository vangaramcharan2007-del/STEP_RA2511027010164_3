# Week 03 — Interfaces & Abstract Classes

## Concepts Covered
- Abstract `PaymentGateway` architecture.
- Interface `Refundable` implementing reverse-transaction semantics.
- Concrete gateways: `CreditCardPayment` (CVV/expiry validation) and `UPIPayment` (VPA handle validation).
- Meets SRM Category C problem specifications.

## Verification
```bash
javac *.java
java Week3PaymentTest
```
