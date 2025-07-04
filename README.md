# 📰 Newsletter Signup Automation Test With Selenium

This is an automated browser testing project for a **Newsletter Signup** flow using **Java**, **Selenium WebDriver**, and **JUnit 5**, following the **Page Object Model (POM)** design pattern. It is fully integrated with **GitHub Actions CI** and supports both **local (Windows)** and **cloud-based (Linux)** execution.

---

## 🚀 Features

- ✅ Automated UI tests for signup, validation, and confirmation flows
- ✅ Structured using Page Object Model (POM)
- ✅ JUnit 5 lifecycle and assertions
- ✅ Runs on both Windows and Linux (GitHub Actions)
- ✅ CI pipeline with Slack build notifications

---

## 🧪 Tests Covered

- Empty email input validation
- Invalid email format check
- Valid email input success flow
- Confirmation page content and elements
- Return to signup page after dismissing confirmation

---
## 🛠️ Getting Started

### Prerequisites

- Java 21
- Maven 
- Chrome browser
- ChromeDriver (locally on Windows, should match the same version as that of your browser placed in `resources/`)
- IDE (IntelliJ IDEA)

### Run Locally

1. Clone this repository:
   ```bash
   git clone https://github.com/jaabless/NewsletterSeleniumTest.git
2. Open the project in your preferred IDE
3. Download  chromedriver that matches the version of your browser
3. Run the NewsletterTest.java file to run all tests.
   ```bash
   # Install dependencies
   mvn clean install
   
   # Run tests
   mvn test

---

## ⚙️ GitHub Actions CI
This project includes a GitHub Actions workflow that:

1. Runs tests on every push and pull request to main 
2. Installs Chrome and ChromeDriver in CI 
3. Sends a Slack notification via slack_notify.py

### Setting up GitHub Actions:
How to add secrets:

1. Go to your GitHub repo → Settings
2. Click Secrets and variables → Actions
3. Click New repository secret
4. Create a secret and modify the name in the .yml file (lastline)

## Slack Notification Setup
1. Create an Incoming Webhook in your Slack workspace. 
2. Add it to your GitHub repo as a secret:
  - Name: NEWSLETTER_CHANNEL (you can change and modify in yml)
  - Value: your Slack webhook URL

---

## 📸 Demo Pages
**Signup Page:** https://shimmering-hamster-bbee86.netlify.app/

**Confirmation Page:** Triggered after form submission

---
## 👨‍💻Author
**Jeffery Asamoah Anyimadu** 

**Software & QA Engineer**