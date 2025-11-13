package Phonebook.tests;

import Phonebook.core.TestBase;
import Phonebook.utils.MyRetryAnalyzer;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.core.ApplicationManager.softAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {
        // int i = (int) ((System.currentTimeMillis()/1000)%3600);
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }


    @Test(retryAnalyzer = MyRetryAnalyzer.class)
    public void existedUserRegisterNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        app.getUser().clickOnRegistrationButton();
        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();


    }
}
