package pageObjects;

import io.restassured.response.ValidatableResponse;
import pageObjests.User;

public interface BurgerServiceUser {
    ValidatableResponse createUser(User user);
    ValidatableResponse deleteUser(User user);
}
