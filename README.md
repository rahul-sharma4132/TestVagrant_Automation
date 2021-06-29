# TestVagrant_Automation
This project has been created to make an automation framework for an assignment given by TestVagrant
# Work Flow Setup
This project contains the following salient components :-
1. A maven project with testng unit framework
2. Dependencies for Selenium for web testing and Rest Assured for API testing
3. The backend code is written in src/main/java. This means that all operations including initializing browser, fetching website temperature text, parsing API response JSON to get the temperature and also to convert temperature from Kelvin to Celsius
4. The test code is written is src/test/java. This contains all validations such as page validation, navigation validation, element validation and finally comparison(between web and API temperature in celsius)
# Iterations
iteration 1 :- Running tests sequentially to implement "DRY" at test level - Jun 28 23:53
iteration 2 :- Fixing surefire skip result issue which was causing build failure -  Jun 29 11:33
