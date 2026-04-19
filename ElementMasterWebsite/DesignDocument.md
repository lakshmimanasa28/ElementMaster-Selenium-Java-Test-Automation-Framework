# ElementMaster Framework - Design & Plan Document

## 1. Objective
Develop a reusable Selenium-Java framework for https://demoqa.com covering:
- Forms, Web Tables, Alerts/Frames/Windows, Widgets

## 2. Framework Architecture
- **Base Layer**: BaseTest + BasePage (waits, click with ad handling, alerts, frames)
- **Page Layer**: POM classes (HomePage, FormPage, AlertsPage, etc.)
- **Test Layer**: TestNG test classes with @Test, @DataProvider
- **Utilities**: ConfigReader, RetryAnalyzer, TestListener, ExtentManager
- **Reporting**: TestNG default + ExtentReports + Screenshots on failure

## 3. Key Design Principles Followed
- No Thread.sleep() → Only explicit waits
- Clean separation: No WebDriver code in Test classes
- Reusable methods in BasePage
- Aggressive ad & footer handling using CDP + JavascriptExecutor
- Retry mechanism for flaky tests (Form page navigation)
- Config driven (browser, URL, timeout)

## 4. Modules Covered
- Forms → Student Registration Form (text, radio, dropdown, date, file upload, submit)
- Web Tables → Add/Verify/Delete rows
- Alerts, Frames & Windows
- Widgets (Date Picker, Slider, Accordian)

## 5. Non-Functional
- Maintainable & Readable code
- Meaningful method names
- Screenshot on failure (planned in listener)
- Data-driven where possible

## 6. Future Enhancements
- Full ExtentReports integration with screenshots
- Parallel execution
- More DataProviders from Excel

**Prepared for Hackathon Evaluation**