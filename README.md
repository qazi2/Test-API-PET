# PET API TEST

**About Project:**

This project uses Rest-Assured API, Cucumber, TESTNG to test the following API - https://petstore.swagger.io/

Following are the Test scenarios created for this project and can also be visualize in --> src/test/feature/Test.feature

1. Add a new pet to the store
2. Verify if the user is able to add a pet with invalid input
3. To verify if the user is able to upload an image of pet
4. To verify if the user is able to find pet by ID
5. To verify if the user is able to find pet by wrong ID
6. To verify if the user is able to find the pets by status available
7. To verify if the user is able to find the pets by invalid status
8. To verify if the user is able to find the pets by status pending
9. To verify if the user is able to find the pets by status sold
10. To verify if the user is able to update the existing pet
11. To verify if the user is able to update a pet in the store with form data
12. To verify if the user is able to update a pet with wrong status
13. To verify if the user is able to update a pet with wrong status
14. Verify the response for the pet already deleted


**Rest - Assured:**
Rest-Assured is an open-source Java DSL that simplifies REST service testing. It makes things easier by removing the need for boilerplate code when testing and validating complex replies. It can also handle XML and JSON requests and responses. For more information: http://rest-assured.io/

**Cucumber:**
Cucumber examines all of the executable tests and steps written in plain English and verifies what the software is supposed to do. For more information: https://cucumber.io/

**TestNG:**
We have used the TestNG library because it supports a wide range of annotations. It also has excellent Test Case management capabilities and, most crucially, a user-friendly reporting interface. For more information related to TestNG - https://testng.org/doc/
