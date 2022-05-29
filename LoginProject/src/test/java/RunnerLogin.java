import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class RunnerLogin extends BrowserDriver {

    @Test
    public void homePage(){
        testFunctions.signInBtnClick()
                .loginSection();
                //.assertPageTitle();
    }

    @Test
    public void loginCorrect(){
        testFunctions.signInBtnClick()
                .loginSection()
                .setCorrectEmail()
                .setCorrectPassword()
                .loginBtnClick();
                //.assertPageTitle();
    }


    @Test
    public void loginFalsePswrd(){
        testFunctions.signInBtnClick()
                .loginSection()
                .setInCorrectPassword()
                .setCorrectPassword()
                .loginBtnClick();
                //.assertPageTitle();
    }

    @Test
    public void loginFalseUsrnme(){
        testFunctions.signInBtnClick()
                .loginSection()
                .setInCorrectPassword()
                .setCorrectPassword()
                .loginBtnClick();
                //.assertPageTitle();
    }

}