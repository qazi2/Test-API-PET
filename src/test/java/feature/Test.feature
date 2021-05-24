Feature: To Verify PET APIs for zooplus

  # Adding a new pet
  Scenario: Add a new pet to the store
    Given I want to execute pet endpoint
    When I submit the POST request
    Then I should get 200 success status code

#  Negative test for adding pet

  Scenario: Verify if the user is able to add a pet with invalid input
    Given I want to execute pet endpoint with invalid input
    When I submit the POST request with invalid input
    Then I should get 405 invalid input status code


# Uploadingimage
  Scenario: To verify if the user is able to upload an image of pet

    Given I want to execute uploadImage endpoint
    When I submit the POST request with pet image
    Then I should get 200 success status code successful operation

# Finding pet by id
  Scenario: To verify if the user is able to find pet by ID

    Given I want to execute find pet by ID endpoint
    When I submit the GET request with pet ID
    Then I should get 200 success status code with pet details

# Negative test case
  Scenario: To verify if the user is able to find pet by wrong ID

    Given I want to execute find pet by wrong ID
    When I submit the GET request with wrong pet ID
    Then I should get 404 status code pet not found

# Find pets by status available
  Scenario: To verify if the user is able to find the pets by status available

    Given I want to execute findByStatus available endpoint
    When I submit the GET request with status available
    Then I should get 200 status with pet available
#    And I should only get all pets with status available


#  Negative test case find pets by invalid status
  Scenario: To verify if the user is able to find the pets by invalid status

    Given I want to execute get pets by invalid status
    When I submit the GET request with invalid status
    Then I should get 400 status with invalid status value

# Find pets by status pending
  Scenario: To verify if the user is able to find the pets by status pending

    Given I want to execute findByStatus by pending
    When I submit the GET request with status pending
    Then I should get 200 status with pet in pending status
   # And I should only get all pets with status pending

# Find pets by status sold

  Scenario: To verify if the user is able to find the pets by status sold

    Given I want to execute findByStatus by sold
    When I submit the GET request with status sold
    Then I should get 200 status with pet in sold status
 #   And I should only get all pets with status sold

# Update an existing pet

  Scenario: To verify if the user is able to update the existing pet

    Given I want to execute update existing pet
    When I submit the PUT request of update an existing pet
    Then I should get 200 status


# Update a pet in the store with form data

  Scenario: To verify if the user is able to update a pet in the store with form data

    Given I want to execute update a pet with form data
    When I submit the POST request for update from form data
    Then I should get 200 status response

# Negative test case for update a pet in the store with form data by sending wrong status in body

  Scenario: To verify if the user is able to update a pet with wrong status

    Given I want to execute update a pet with wrong status
    When I submit the POST request invalid for form
    Then I should get 405 status

    

# Deletes a pet

  Scenario: To verify if the user is able to delete the pet

    Given I want to execute delete a pet endpoint
    When I submit the DELETE request
    Then I should get 200 status delete

# Delete a pet which is already removed from delete request

  Scenario: Verify the response for the pet already deleted

    Given I want to execute delete a pet already deleted
    When I submit the DELETE request for deleted pet
    Then I should get 404 status Pet not found