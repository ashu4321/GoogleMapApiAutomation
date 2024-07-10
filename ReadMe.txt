Google Maps API Automation Framework
This project demonstrates automated testing of Google Maps API using Java with TestNG framework, integrating ExtentReports for test reporting and Log4j for logging.

Project Structure
GoogleMapApi/TestCases: Contains test cases using TestNG annotations.
GoogleMapApi/services: Includes service classes for API interaction.
GoogleMapApi/utilities: Utility classes for logging (Log4jClass) and reporting (SparkHTML).

Report Path : target/Spark2024-07-10T172943.071858.html

Pre-requisites
Java Development Kit (JDK): Ensure JDK is installed and configured.
Apache Maven: Dependency management tool used for this project.
IDE (Eclipse, IntelliJ): Integrated Development Environment for Java.
Setup Instructions
Clone the Repository:

bash
Copy code
git clone https://github.com/your_username/GoogleMapsAPIAutomation.git
cd GoogleMapsAPIAutomation
Import Project into IDE:

Open the project in your preferred IDE (Eclipse, IntelliJ).
Allow Maven to update dependencies.
Configure API Key:

Replace your_api_key in the test methods with your actual Google Maps API key.
Run Tests:

Execute test classes under GoogleMapApi/TestCases using TestNG.
Test results are automatically generated in ExtentReports format.
View Test Reports:

After running tests, open test-output/Spark.html to view ExtentReports.
Test Cases
Positive Test Cases: Validate API responses with valid input.
Negative Test Cases: Test scenarios with invalid inputs or edge cases.
Response Body Validation: Verify specific fields (location, accessPoints) in API response.
Dependencies
TestNG: Testing framework for organizing and running test cases.
RestAssured: Java library for testing RESTful APIs.
ExtentReports: Reporting library for generating interactive HTML reports.
Log4j: Logging framework for capturing and displaying detailed logs.
Contributors
Ashuvendra Kumar Patwa kumarashuvendra@gmail.com
License
This project is licensed under the MIT License - see the LICENSE file for details.

Adjust the paths, dependencies, and contributors section as per your project specifics. Include any additional setup instructions or customization details relevant to your project. This README template provides a structured overview to help users understand, setup, and utilize your Google Maps API automation framework effectively.
