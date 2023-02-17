package org.rh.test.webapi.integration;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.rh.test.conf.MySqlResource;

import static io.restassured.RestAssured.given;

@QuarkusTest
@QuarkusTestResource(MySqlResource.class)
public class BookControllerTest {

    private final String PATH_API = "/v1/book";

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get(PATH_API)
                .then()
                .statusCode(200);
    }
}
