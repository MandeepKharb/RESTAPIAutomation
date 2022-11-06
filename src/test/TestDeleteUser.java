package test;

import main.helpers.UserServiceHelper;
import main.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestDeleteUser {
    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test
    public void testDeleteUser(){
      userServiceHelper.deleteUser();
    }
}
