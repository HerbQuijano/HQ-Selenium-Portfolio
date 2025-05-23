[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![Smoke Test](https://github.com/HerbQuijano/HQ-Selenium-Portfolio/actions/workflows/smoke-test.yml/badge.svg)

> ⚠️ This project is for learning and demonstration purposes. It is not intended for production use.

# 🧪 Automation Testing Framework (Selenium + Java + TestNG)

Welcome to my personal automation testing framework, built using **Selenium 4**, **Java**, and **TestNG**.  
This project is part of my professional **QA Automation portfolio** and is designed following the **Page Object Model (POM)** architecture for clean, maintainable, and scalable UI automation.

---

## 📁 Project Structure

```pgsql
src/
├── main/
│   └── java/
│       ├── base/               → BasePage class with reusable web actions
│       ├── core/               → DriverFactory for browser management
│       └── pages/              → Page Objects for each UI screen
├── test/
│   └── java/
│       ├── utils/              → ConfigReader for reading config files
│       └── tests/              → Test classes using TestNG
resources/
└── config.properties           → Externalized configuration (URL, etc.)
```
## 🔧 Technologies Used

- ✅ **Java 17+**
- ✅ **Selenium 4+**
- ✅ **TestNG**
- ✅ **Maven** for dependency management
- ✅ **Page Object Model (POM)** design pattern
- ✅ **System properties + config files** for flexible setup

---

## ⚙️ Features

- 🔹 **DriverFactory**: Unified creation of Chrome, Firefox, Edge (local or Selenium Grid).
- 🔹 **Headless Mode**: Toggle via system property `-Dheadless=true`.
- 🔹 **Remote Support**: Easily run tests via Selenium Grid with `-Dremote=true`.
- 🔹 **Environment Config**: Manage test environment URL via `config.properties`.
- 🔹 **Reusable BasePage**: Centralized helper methods for waiting, clicking, input, scrolling, etc.
- 🔹 **Test Isolation**: Each test uses fresh page object instances via `@BeforeMethod`.
- 🔹 **Clean Assertions**: Tests validate page title, UI content, and buttons.

---

## 🏁 Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/HerbQuijano/HQ-Selenium-Portfolio.git
```

### 2️⃣ Configure settings
``` properties
baseUrl=https://practice-automation.com/
```
### 3️⃣ Run the tests
```bash
mvn clean test -Psmoke
```
### Optional: Run with system properties
```
mvn test -Dbrowser=firefox -Dheadless=true -Dremote=false
```
---

## ✅ Sample Tests
### (LandingPageTest.java)
Current test cases (LandingPageTest) include:

testTitle() → Validates page title

testHeadingText() → Verifies welcome header

testNumberOfButtons() → Checks correct number of homepage links

---

## 🧠 Design Principles
| Concept                  | How It's Applied                                |
|--------------------------|-------------------------------------------------|
| Page Object Model        | Each page is a class with locators and actions  |
| Reusability              | BasePage has shared helper methods              |
| Configuration Management | Externalized using .properties                  |
| Maintainability          | Readable test classes, minimal duplication      |
| Scalability              | Easily extendable to new pages and environments |

---

## 🔮 Roadmap
This is an actively evolving framework. Planned features:

* 🔍 Allure or ExtentReports integration for rich reporting

* 📊 Data-driven testing with TestNG @DataProvider or YAML

* 🧪 Parallel test execution

* 🧱 Component-level Page Object composition

* ☁️ CI/CD integration (e.g., GitHub Actions or Jenkins)

---

## 💼 About Me
Hi, I'm Herbert Quijano — a passionate QA Automation Engineer and software quality advocate.
I built this framework to demonstrate clean test automation practices and strengthen my portfolio for QA roles.

Feel free to reach out on LinkedIn or message me about QA, Selenium, or test architecture.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/herbert-quijano-acu%C3%B1a-11838639/)