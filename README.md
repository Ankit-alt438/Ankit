# Employee Management System (EMS)

> **Developed entirely from scratch by [avdeshjadon](https://github.com/avdeshjadon)**

## 📖 Overview
The **Employee Management System (EMS)** is a robust, scalable backend application designed to manage an organization's core workforce data. It provides seamless handling of employee records and departmental structures using a modern Java stack. The system is built with maintainability and enterprise patterns in mind, utilizing the DAO (Data Access Object) design pattern and a well-defined service layer.

## 🚀 Key Features
- **Employee Management:** Create, Read, Update, and Delete (CRUD) operations for employee profiles.
- **Department Management:** Manage departments, ensuring a structured organizational hierarchy.
- **Relational Mapping:** Robust mapping between Employees and Departments (e.g., One-to-Many or Many-to-One relationships).
- **Automated Database Generation:** Automatic schema creation and updates via Hibernate's DDL features.
- **Modular Architecture:** Clean separation of concerns with distinct Entity, DAO, Service, and Utility layers.

## 🛠️ Technology Stack
- **Language:** Java 17
- **Build Tool:** Maven 3+
- **ORM Framework:** Hibernate (v5.6.15.Final)
- **Database:** MySQL 8
- **Design Patterns:** DAO, Service Layer, Singleton (for SessionFactory)

## 📁 Project Architecture
The project follows a standard multi-tiered architecture:
- **`com.ems.entity`**: Contains JPA/Hibernate annotated domain models (`Employee.java`, `Department.java`).
- **`com.ems.dao`**: Data Access Interfaces and their Implementations for direct database interactions.
- **`com.ems.service`**: Business logic layer that bridges the DAO and the main application flow.
- **`com.ems.util`**: Utility classes, primarily `HibernateUtil.java`, which manages the Hibernate `SessionFactory`.
- **`com.ems.main`**: The entry point of the application containing the `Main.java` executable class.
- **`sql/schema.sql`**: SQL scripts for manual schema inspection (tables are auto-created by Hibernate).

## ⚙️ Setup & Installation Instructions

### Prerequisites
- JDK 17 installed and configured in your environment.
- Maven installed (`mvn` command available).
- MySQL Server installed and running.

### 1. Database Configuration
Update the database connection details in `src/main/resources/hibernate.cfg.xml`. You will need to provide your MySQL username, password, and the database URL.

```xml
<!-- Example configuration inside hibernate.cfg.xml -->
<property name="connection.url">jdbc:mysql://localhost:3306/ems_db?useSSL=false</property>
<property name="connection.username">root</property>
<property name="connection.password">your_password</property>
```

### 2. Build the Project
Open your terminal or command prompt, navigate to the root directory of the project, and run:
```bash
mvn clean install
```
This will compile the code, download all necessary dependencies (Hibernate, MySQL Connector), and package the application.

### 3. Run the Application
Execute the main application using the Maven Exec Plugin:
```bash
mvn exec:java
```
Upon execution, the application will initialize the database (if it doesn't already exist) and run the logic defined in the `Main` class.

## 👤 Developer Info
- **Developer:** avdeshjadon
- **GitHub:** [avdeshjadon](https://github.com/avdeshjadon)

---
*If you find this project useful, feel free to give it a star on GitHub!*
