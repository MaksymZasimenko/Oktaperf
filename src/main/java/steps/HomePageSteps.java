package steps;

import impls.HomePageImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {
    private HomePageImpl impl = new HomePageImpl();

    @Given("I navigate to Octoperf homepage")
    public void iNavigateToOctoperfHomepage(){
        impl.navigateToHomepage();
    }

    @Then("I validate current page")
    public void verifyCurrentPage(){
        impl.verifyCurrentPage();
    }

    @Then("I should see sign in logo")
    public void verifySignInLogoIsThere(){
        impl.verifySignInLogoIsThere();
    }

    @Then("I enter {string} in the {string} input box")
    public void enterValue(String value, String inputBox){
        impl.enterValidValue(value, inputBox);
    }

    @Then("I should see a {string} button")
    public void loginButton(String button){
        impl.verifyLogInButton(button);
    }

    @Then("I click on {string} button")
    public void clickLogIn(String button){
        impl.clickLogInButton(button);
    }

    @Then("I should see log in failed message")
    public void verifyFailedMessage(){
        impl.verifyFailedMessage();
    }

}
