Feature: BookStore Flow Test

  Scenario: Bookstore flow
    When Get All Books
    Then Validate that all books are listed
    When Add new User
    Then Validate that the new user is posted
    When Generate Token
    Then Validate that the token is generated
    When Authorize User
    Then Validate that the user is authorized
    When Assign a new book to the user
    Then Validate that the book is assigned to the user
    When Update the existing book
    Then Validate that the book is updated
    When Delete an existing book
    Then Validate that the book is removed