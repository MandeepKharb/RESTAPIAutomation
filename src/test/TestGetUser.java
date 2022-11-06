package test;

import main.helpers.UserServiceHelper;
import main.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestGetUser {

    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test
    public void testGetUser(){
        User user = userServiceHelper.getUser();
        assertNotNull(user, "User object is null");
    }

}
