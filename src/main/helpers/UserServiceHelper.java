package main.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.constants.Endpoints;
import main.model.RegisterUser;
import main.model.UpdateUser;
import main.model.UpdatedUser;
import main.model.User;
import main.utils.ConfigManager;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserServiceHelper {

private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");

public UserServiceHelper(){
    RestAssured.baseURI = BASE_URL;
    RestAssured.useRelaxedHTTPSValidation();
}

public User getUser(){
    Response response = RestAssured.given().
                            log().all().
                            contentType(ContentType.JSON).
                            get(Endpoints.GET_USER).andReturn();

    Type type = new TypeReference<User>(){}.getType();
    User user = response.as(type);
    return user;
}

    public String registerUser(){
        RegisterUser registerUser = new RegisterUser();
        registerUser.setPassword("pistol");
        registerUser.setEmail("eve.holt@reqres.in");
        Response response = RestAssured.given().
                log().all().
                contentType(ContentType.JSON).
                body(registerUser).
                post(Endpoints.REGISTER_USER).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "created");
       String id = response.jsonPath().getString("id");


        return id;
    }

    public UpdatedUser updateUser(){
        UpdateUser updateUser = new UpdateUser();
        updateUser.setJob("zion resident");
        updateUser.setName("morpheus");

        Response response = RestAssured.given().
                log().all().
                contentType(ContentType.JSON).
                body(updateUser).
                put(Endpoints.UPDATE_USER).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "updated");

        Type type = new TypeReference<UpdatedUser>(){}.getType();
        UpdatedUser updatedUser = response.as(type);
        assertNotNull(updatedUser, "User object is null");
        return updatedUser;



    }

    public void deleteUser(){
        Response response = RestAssured.given().
                log().all().
                contentType(ContentType.JSON).
                delete(Endpoints.DELETE_USER).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_NO_CONTENT, "deleted");

    }




}
