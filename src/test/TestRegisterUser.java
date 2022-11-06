package test;

import main.helpers.UserServiceHelper;
import main.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static org.testng.Assert.assertNotNull;

public class TestRegisterUser {

    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test
    public void testRegisterUser(){
        String id  = userServiceHelper.registerUser();
        System.out.println(id);

    }
}
