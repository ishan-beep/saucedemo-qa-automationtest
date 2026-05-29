# saucedemo-qa-automationtest
It is an automation testing of web-based system
A clean, professional end-to-end UI automation test suite built for the SauceDemo application (`https://www.saucedemo.com`). This project is engineered using Java and Selenium WebDriver, utilizing the Page Object Model (POM) architectural design pattern to ensure high scalability, clean separation of concerns, and robust test execution.

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java 17+
* **Automation Engine:** Selenium WebDriver (v4.18.1)
* **Testing Framework:** TestNG (v7.9.0)
* **Build & Automation Runner:** Gradle (Kotlin DSL)
* **Driver Binary Management:** WebDriverManager (v6.1.0) 
---

## 📐 Architecture & Project Structure

This framework implements the **Page Object Model (POM)**. Web components and locators are completely isolated from the functional test logic, ensuring that if front-end element classes change, edits are only made in a single page file.

saucedemo-qa-automation/
├── src/
│   ├── main/java/saucedemo/pages/     # Isolated Page Objects & Component Locators
│   │   ├── LoginPage.java
│   │   ├── InventoryPage.java
│   │   └── CheckOutPage.java
│   └── test/java/saucedemo/tests/     # Functional Assertion Test Suites
│       ├── Logintest.java
│       └── CheckoutTest.java
├── build.gradle.kts                   # Project configuration and auto-scan build logic

## TestCase Scenario
 1)LoginTest
  ->case 1 : tested with valid username and  valid password
  ->case 2 : tested with valid username and invalid password 
  ->case 3 : tested with invalid username and valid password
  ->case 4 : tested with empty field and valid password
  ->case 5 : tested with valid username and empty password

 2)CheckoutTest
 
  ->case 1 : Testing the product is added to the cart
  ->case 2 : Complete checkout flow with valid details
  ->case 3 : Negative validation test for missing First Name
  ->case 4 : Form Interruption or cancellation

## Setup Steps

💻 Part 1: Local Machine Setup

Before running the code, ensure your computer has the core tools installed:
    -> Java Development Kit (JDK 17 or higher)
    -> Google Chrome(WebDriverManager handles the driver file matching automatically, but it needs Chrome on the system).
    -> An IDE (Optional but recommended for edits) IntelliJ IDEA (Community or Ultimate Edition) or Eclipse with Gradle support.

🚀 Part 2: Step-by-Step Project Initialization

Follow these steps to pull your code and prepare it for execution:

Step 1: Clone the Project Repository
  Open your terminal or command prompt, navigate to the folder where you want to save the project, and run:

  git clone https://github.com/ishan-beep/saucedemo-qa-automationtest.git

Step 2: Open and Sync the Project (If using an IDE)
   -> Open IntelliJ IDEA.
   -> Select Open and choose the saucedemo-qa-automation root folder.
   -> IntelliJ will automatically detect the build.gradle.kts file and begin importing dependencies.
   -> Wait for the background Gradle sync processes to complete fully (you'll see a green checkmark or progress bar finish at the bottom).

🏃 Part 3: How to Run the Tests

Method A: Running via Terminal

 Run this command from your project root folder:

   On Windows (Command Prompt / PowerShell):
    -> gradlew test

   On Mac / Linux:
    -> chmod +x gradlew
     ./gradlew test

After that you can see the test case results in your project build file
  build/reports/tests/test/index.html

  Thank you!
