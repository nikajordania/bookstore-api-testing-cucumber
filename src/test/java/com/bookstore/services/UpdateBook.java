package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class UpdateBook extends Globals {

    public void updateBook() {

        String body = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"isbn\": \"" + isbnNumbers.get(1) + "\"\n" +
                "}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .pathParam("isbn", isbnNumbers.get(0))
                .and()
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}")
                .prettyPeek();
    }

    public void validateThatBookIsUpdated() {
        //assert status code
        Assert.assertEquals(200, response.statusCode());

        //validate userId and username
        Assert.assertEquals(userId, response.path("userId"));
        Assert.assertEquals(username, response.path("username"));

        //validate isbn number
        Assert.assertEquals(isbnNumbers.get(1), response.path("books[0].isbn"));
    }
}
