package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.LoginPage;
import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.junit.Assert;

public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user login")
    public void user_login() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        loginPage.login(username,password);
        System.out.println("user login");
    }
    @Then("user is on the dashboard")
    public void user_is_on_the_dashboard() {
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("Dashboard"));
    }


    @When("user login as {string}")
    public void userLoginAs(String username) {

        String password = ConfigurationReader.getProperty("password");

        loginPage.login(username,password);
        System.out.println("user login");

    }


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Given("the user logged in with username as {string} and password as {string}")
    public void theUserLoggedInWithUsernameAsAndPasswordAs(String username, String password) {
        loginPage.login(username,password);
    }
}
