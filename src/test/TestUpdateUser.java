package test;

import main.helpers.UserServiceHelper;
import main.model.UpdatedUser;
import main.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestUpdateUser {
    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test
    public void testUpdateUser(){
    userServiceHelper.updateUser();

    }
}
