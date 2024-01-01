# Selenium WebDriver TestNG Framework

This repository contains a basic TestNG framework for Selenium WebDriver, designed for web automation testing. The framework is structured to demonstrate essential features like parameterization, data-driven testing, and logging.

## Features

- **Parameterization:** Use TestNG's `@Parameters` annotation to run the same test with different sets of data.

- **Data-Driven Testing:** Leverage TestNG's `@DataProvider` to perform data-driven testing with various input values.

- **Logging:** Implement logging using Log4j to capture and analyze test execution details.
- **Web Scraping with Selenium and JSoup:** Prints all links (<a> elements with an href attribute) found on the webpage.

## Prerequisites

- Java Development Kit (JDK)
- Maven
- ChromeDriver (or other WebDriver executable)

## Setup

1. Clone the repository:
   git clone "repo url"
   cd selenium-testng-framework
2. Install dependencies:
mvn clean install
3. Run tests:
mvn test

## Usage
- Adjust the TestNG XML file (testng.xml) to customize test execution parameters.

- Modify the TestExample class and associated methods to add your test logic.

- Explore and extend the framework based on your project requirements.

## Project Structure
- src/test/java: Contains test classes and related Java files.
- src/test/resources: Includes configuration files, such as TestNG XML and Log4j configuration.
