package pageObjests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class BurgerServiceUserImpl implements pageObjects.BurgerServiceUser {
    private static final String CREATE_USER_ENDPOINT = "/api/auth/register";
    private static final String DELETE_USER_ENDPOINT = "api/auth/user";
    private final RequestSpecification requestSpecification;
    private final ResponseSpecification responseSpecification;

    public BurgerServiceUserImpl(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        this.requestSpecification = requestSpecification;
        this.responseSpecification = responseSpecification;
    }
    @Override
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(requestSpecification)
                .body(user)
                .post(CREATE_USER_ENDPOINT)
                .then()
                .spec(responseSpecification);
    }
    @Override
    public ValidatableResponse deleteUser(User user) {
        return given()
                .spec(requestSpecification)
                .delete(DELETE_USER_ENDPOINT)
                .then()
                .spec(responseSpecification);
    }
}
