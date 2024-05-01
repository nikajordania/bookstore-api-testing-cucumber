package com.bookstore.step_defs;

import com.bookstore.services.AssignNewBook;
import com.bookstore.services.DeleteBook;
import com.bookstore.services.GetAllBooks;
import com.bookstore.services.UpdateBook;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStore_StepDefs {

    GetAllBooks getAllBooks = new GetAllBooks();
    AssignNewBook assignNewBook = new AssignNewBook();
    UpdateBook updateBook = new UpdateBook();
    DeleteBook deleteBook = new DeleteBook();

    @When("Get All Books")
    public void get_all_books() {
        getAllBooks.getAllBooks();
    }

    @Then("Validate that all books are listed")
    public void validate_that_all_books_are_listed() {
        getAllBooks.validateThatAllBooksAreListed();
    }

    @When("Assign a new book to the user")
    public void assignANewBookToTheUser() {
        assignNewBook.assignNewBook();
    }

    @Then("Validate that the book is assigned to the user")
    public void validateThatTheBookIsAssignedToTheUser() {
        assignNewBook.validateThatBookIsAssigned();
    }

    @When("Update the existing book")
    public void updateTheExistingBook() {
        updateBook.updateBook();
    }

    @Then("Validate that the book is updated")
    public void validateThatTheBookIsUpdated() {
        updateBook.validateThatBookIsUpdated();
    }

    @When("Delete an existing book")
    public void delete_an_existing_book() {
        deleteBook.deleteAnExistingBook();
    }

    @Then("Validate that the book is removed")
    public void validate_that_the_book_is_removed() {
        deleteBook.validateBookIsRemoved();
    }
}
