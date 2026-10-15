# ☕ JEE Lab 1: Advanced Java OOP & Software Architecture

[![Java Version](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Lombok](https://img.shields.io/badge/Lombok-Enabled-FF4444?style=for-the-badge)](https://projectlombok.org/)
[![Architecture](https://img.shields.io/badge/Design_Pattern-DAO-blue?style=for-the-badge)](#)
[![Academic](https://img.shields.io/badge/FSEGS-LFI_3-green?style=for-the-badge)](#)

A structured Java project developed as part of the **JEE Course (LFI 3 - FSEGS Sfax)**.  
It demonstrates best practices in object-oriented programming (OOP), functional programming (`Stream` & `Optional` APIs), polymorphic inheritance, and architectural decoupling using the **DAO (Data Access Object)** pattern.

---

## 📂 Project Structure

```text
src/
├── Clubs/
│   ├── Club.java              # Club management managing a Set of students
│   ├── Etudiant.java          # Student entity with dynamic age calculation
│   └── Main.java              # Execution and demonstration for Exercise 1
│
└── Factures/
    ├── Client.java            # Customer entity
    ├── CategorieClient.java   # Customer category enum (FIDELE, PASSAGER, BLACK_LISTED)
    ├── Facture.java           # Invoice entity with aggregated payment records
    ├── Reglement.java         # Base payment class
    ├── Cash.java              # Cash payment subclass
    ├── Cheque.java            # Cheque payment subclass (bank, cheque number, due date)
    ├── CarteVisa.java         # Credit card subclass (card number, owner, expiry date)
    ├── IDAOFactures.java      # DAO interface for persistence abstraction
    ├── IGestionFactures.java  # Business service interface
    ├── GestionFactures.java   # Business service implementation (loose coupling)
    └── Main.java              # Execution with in-memory DAO simulation
```

---

## 🎯 Modules & Features

### 1️⃣ Exercise 1: Student Clubs Management (`Clubs`)
- **Dynamic Age Calculation:** Derived on the fly from `dateNais` using `java.time.Period.between()`.
- **Set Uniqueness:** Members are stored in a `Set<Etudiant>` with identity enforced through `@EqualsAndHashCode(of = "email")`.
- **Null-Safe Stream Operations:** Safe member lookup using `membres.stream().filter(...).findFirst()`, wrapped inside an `Optional<Etudiant>`.
- **Hash Bucket Integrity:** When updating an email (`setEmailMember`), the student object is safely removed from the `Set`, mutated, and re-added to maintain correct hash indexing.

### 2️⃣ Exercise 2: Invoice & Payment Processing (`Factures`)
- **Polymorphic Payments:** `Facture` maintains a generic list of `List<Reglement>`, supporting runtime polymorphism with `Cash`, `Cheque`, and `CarteVisa`.
- **DAO Pattern & Loose Coupling:** `GestionFactures` depends strictly on the interface `IDAOFactures`, keeping business logic independent of any concrete database technology.
- **Defensive Programming:** Safe null and empty checks prevent `NullPointerException` when processing invoices or querying database records.
- **Clear String Representations:** Proper inheritance chaining using Lombok `@ToString(callSuper = true)` to display specialized fields for each payment type.

---

## 🛠️ Tech Stack & Tools
- **Language:** Java 17+ (Java 25)
- **Library:** [Project Lombok](https://projectlombok.org/) (`@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, `@AllArgsConstructor`)
- **IDE:** Spring Tool Suite (STS) / Visual Studio Code
- **VCS:** Git & GitHub

---

## 🚀 How to Run

Both modules provide independent, standalone `Main` entry points:

### 1. Run Club Management:
Execute `src/Clubs/Main.java`:
- Creates student entities and clubs.
- Tests membership uniqueness, student lookup, and email updates.

### 2. Run Invoice & Payment Management:
Execute `src/Factures/Main.java`:
- Instantiates clients with categories.
- Generates invoices with mixed payments (Cash, Cheque, Visa).
- Tests persistence verification and payment report rendering through the DAO service.


