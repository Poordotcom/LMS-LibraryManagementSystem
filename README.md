# LMS - Library Management System

A Java-based Library Management System (LMS) that allows librarians and users to manage books, members, borrowing records, and returns efficiently.

## 📌 Features

- Add, update, and delete books
- Register and manage library members
- Borrow and return books
- Search books by title, author, or ISBN
- Track borrowing history

## 🛠️ Technologies Used

- **Language:** Java
- **IDE:** IntelliJ IDEA / Eclipse / NetBeans
- **Build Tool:** Maven / Gradle (optional)
- **Database:** MySQL / SQLite (optional)

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher installed
- Git installed ([Download Git](https://git-scm.com/downloads))
- Git Bash (comes with Git for Windows)

---

## 🔗 How to Connect Your Existing Project Using Git Bash

Follow these steps to link your local Java project to this GitHub repository using **Git Bash**:

### 1. Open Git Bash

Open Git Bash inside your project folder (right-click inside the folder → **Git Bash Here**).

### 2. Initialize a Local Git Repository

```bash
git init
```

### 3. Add All Project Files

```bash
git add .
```

### 4. Create Your First Commit

```bash
git commit -m "Initial commit - Library Management System"
```

### 5. Connect to the Remote GitHub Repository

```bash
git remote add origin https://github.com/Poordotcom/LMS-LibraryManagementSystem.git
```

### 6. Push Your Project to GitHub

```bash
git branch -M main
git push -u origin main
```

> **Note:** If you are pushing to an existing branch, you may need to pull first:
> ```bash
> git pull origin main --allow-unrelated-histories
> git push -u origin main
> ```

---

## 📂 Project Structure

```
LMS-LibraryManagementSystem/
├── src/
│   └── main/
│       └── java/
│           └── com/library/
│               ├── Main.java
│               ├── models/
│               ├── services/
│               └── utils/
├── README.md
└── LICENSE
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
