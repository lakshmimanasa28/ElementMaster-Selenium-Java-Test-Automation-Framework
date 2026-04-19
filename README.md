# ElementMaster - Selenium Java Test Automation Framework

## Project Overview
This is a clean, reusable, and maintainable Selenium-Java automation framework built for the **demoqa.com** practice site as part of the GUVI Hackathon.

It follows the **Page Object Model (POM)** design pattern and uses **TestNG** for test execution, reporting, and data-driven testing.

## Features Implemented
- **Page Object Model** with BasePage utilities
- Explicit waits (`WebDriverWait`) – No `Thread.sleep()`
- Robust handling of **ads** and **footers** using CDP blocking + JS fallbacks
- Support for:
  - Forms (Practice Form)
  - Web Tables
  - Alerts, Frames & Windows
  - Widgets (Date Picker, Slider, Accordian)
- Retry mechanism for flaky tests
- Custom TestNG Listener for logging
- Configuration via `config.properties`
- ExtentReports ready (integrated via ExtentManager)

## Tech Stack
- Java 17
- Selenium 4.21.0
- TestNG 7.10.2
- WebDriverManager 5.x
- Maven
- ExtentReports

## Project Structure
ElementMasterWebsite/
├── src/main/java/
│   ├── base/BasePage.java
│   └── pages/ (HomePage, FormPage, etc.)
├── src/test/java/
│   ├── base/BaseTest.java
│   ├── tests/ (FormTest, AlertsTest, etc.)
│   ├── listeners/ (TestListener, RetryListener)
│   └── utils/ (ConfigReader, RetryAnalyzer, ExtentManager)
├── src/test/resources/
│   ├── config.properties
│   └── testdata/Excel.xlsx
├── testng.xml
├── pom.xml
└── README.md


## How to Run
1. Clone / Import the project in Eclipse/IntelliJ
2. Update `config.properties` (baseUrl, browser)
3. Right-click on `testng.xml` → **Run As → TestNG Suite**
4. Check reports in `test-output` or ExtentReports HTML

## Key Design Decisions
- All common actions in `BasePage` (click, type, waits)
- Strong ad-handling to avoid `ElementClickInterceptedException`
- RetryAnalyzer + RetryListener for flaky tests
- No hard-coded values (uses config + DataProviders)

## Team Contributions
- Every member contributed at least one Page class and one Test class (as per guidelines).



