package org.acme.forminterceptor;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.ws.rs.core.MediaType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestHTTPEndpoint(AuthResource.class)
class AuthResourceTest {

    @Test
    public void testLoginUsingBeanParam() {
        RestAssured.given()
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body("username=admin&password=secret")
            .post("beanparam")
            .then()
            .statusCode(200)
            .body(Matchers.is("true"));
    }

    @Test
    public void testLoginUsingFormParam() {
        RestAssured.given()
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body("username=admin&password=secret")
            .post("formparam")
            .then()
            .statusCode(200)
            .body(Matchers.is("true"));
    }

    @Test
    public void testLoginUsingMultivaluedMap() {
        RestAssured.given()
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body("username=admin&password=secret")
            .post("multivaluedmap")
            .then()
            .statusCode(200)
            .body(Matchers.is("true"));
    }
}
