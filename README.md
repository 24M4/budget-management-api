# Budget Management API

## 📌 Project Overview
The **Budget Management API** is a **Spring Boot** application that allows users to **manage their budgets**, **track expenses**, and **generate financial reports**.

## 🚀 Features
### **User Management**
✅ User Registration & Authentication (JWT-based)
✅ Role-based access control (Admin/User)

### **Budget Management**
✅ Add, edit, and delete budget categories
✅ Record income and expenses
✅ Retrieve financial summaries (income, expenses, balance)

### **Report Generation**
✅ Generate financial reports (income vs expenses)
✅ Filter reports by **category** and **date range**
✅ Display reports using an **HTML page**

### **Security**
✅ Secure endpoints using **Spring Security (JWT)**
✅ Role-based authorization (`USER`, `ADMIN`)
✅ Whitelisted authentication endpoints (`/users/register`, `/users/login`)

### **Internationalization & Localization**
✅ Supports **English and French** (`messages_en.properties`, `messages_fr.properties`)
✅ Localized error messages and API responses

### **Database & JPA**
✅ Uses **JPA/Hibernate** for database interaction (H2 Database)
✅ Implements **relationships** (Users, Categories, Transactions)
✅ Avoids raw SQL queries

### **Testing & CI/CD**
✅ Includes **Unit Tests** for core business logic
✅ CI/CD Pipeline with **GitHub Actions**
✅ **Integration Tests** for API validation
✅ **Postman Collection** for testing endpoints

---

## 🛠️ Setup Instructions
### **1️⃣ Clone the Repository**
```sh
git clone <your-repo-link>
cd budget-management-api
```

### **2️⃣ Run the Application**
```sh
mvn clean install
mvn spring-boot:run
```

### **3️⃣ Access API**
- **H2 Database Console:** [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)
- **Swagger API Docs:** [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 📡 API Endpoints
### **User Authentication**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/users/register` | Register a new user |
| `POST` | `/users/login` | Authenticate user and return JWT |

### **Budget Management**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/api/budgets/category` | Create a new budget category |
| `GET`  | `/api/budgets/categories` | Get all budget categories |
| `PUT`  | `/api/budgets/category/{id}` | Update a category |
| `DELETE` | `/api/budgets/category/{id}` | Delete a category |

### **Transactions**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/api/transactions/add` | Add an income/expense transaction |
| `GET`  | `/api/transactions/list` | Get all transactions |

### **Reports**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/api/reports/summary?category=Food&startDate=2024-01-01&endDate=2024-01-31` | Get financial summary |

---

## 🔑 Security & Authentication
1. **Register User:**
```json
{
  "username": "almir",
  "password": "password",
  "role": "USER"
}
```
2. **Login to Get JWT Token:**
```json
{
  "username": "almir",
  "password": "password"
}
```
✅ **Use JWT in all protected requests:**
```
Authorization: Bearer <token>
```

---

## 📊 Running Tests
Run **unit tests**:
```sh
mvn test
```
Run **integration tests**:
```sh
mvn verify
```

---

## 🔄 CI/CD Pipeline
- **GitHub Actions Workflow** automatically runs tests on every push.
- Ensures **code quality** and **deployment readiness**.

---

## 📌 Contributors
- **Almir** Developer
- **Project Link:** (https://github.com/24M4/budget-management-api)

---

