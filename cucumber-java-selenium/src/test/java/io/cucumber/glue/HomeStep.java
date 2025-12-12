package io.cucumber.glue;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.HomePage;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class HomeStep extends Context {

  public HomeStep(Manager manager) {
    super(manager);
  }
  HomePage homePage = new HomePage(getDriver());

  @When("I check the list of example")
  public void i_check_the_list_of_example_displayed(){
      Assertions.assertTrue(homePage.getExampleLists()!=null);;
  }

  @And("valid credentials are supplied")
    public void validCredentialsAreSupplied(){
      getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
  }

    @Then("the expected example links should be visible")
    public void the_expected_example_links_is_Visible() {
        List<String> homePageExampleLinks = homePage.getExampleLists();
        List<String> expected = Arrays.asList(
        "A/B Testing",
        "Add/Remove Elements",
        "Basic Auth (user and pass: admin)",
        "Broken Images",
        "Challenging DOM",
        "Context Menu",
        "Digest Authentication (user and pass: admin)",
        "Disappearing Elements",
        "Drag and Drop Dropdown",
        "Dynamic Content",
        "Dynamic Controls",
        "Dynamic Loading",
        "Entry Ad",
        "Exit Intent",
        "File Download",
        "File Upload",
        "Floating Menu",
        "Forgot Password",
        "Form Authentication",
        "Geolocation",
        "Horizontal Slider",
        "Infinite Scroll",
        "Inputs",
        "JavaScript Alerts",
        "JavaScript onload event error",
        "Key Presses",
        "Large & Deep DOM",
        "Multiple Windows",
        "Nested Frames",
        "Notification Messages",
        "Redirect Link",
        "Secure File Download",
        "Shadow DOM",
        "Shifting Content",
        "Slow Resources",
        "Sortable Data Tables",
        "Status Codes",
        "Typos",
        "WYSIWYG Editor"
        );

        Assertions.assertEquals(expected,homePageExampleLinks);
        System.out.println("printing shared stash :" + getTestStash().toString());
    }
}