package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class AssignNewBook extends Globals {

    public void assignNewBook() {

        String body = """
                {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(userId, isbnNumbers.get(0));

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .and()
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatBookIsAssigned() {
        //assert status code
        Assert.assertEquals(201, response.statusCode());

        //validate that isbn number is correct
        String actualIsbn = response.path("books.isbn[0]");
        Assert.assertEquals(isbnNumbers.get(0), actualIsbn);
    }
}
