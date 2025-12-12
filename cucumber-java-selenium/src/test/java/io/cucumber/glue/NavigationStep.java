package io.cucumber.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.GenericPage;
import io.cucumber.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationStep extends Context {
  public NavigationStep(Manager manager) {
    super(manager);
  }

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String url) {
    manager.getDriver().get(url);
    stash("exampleKey1", "exampleValue1");
  }
  @And("I navigate to '(.+)'$")
  public void go_To_Link(String linkText){
      HomePage homePage = new HomePage(getDriver());
      homePage.clickExampleLink(linkText);
  }

  @When("the 'Basic Auth' example is opened")
    public void navToBasicAuth(){
      GenericPage genericPage = new GenericPage(getDriver());
      HomePage homePage = new HomePage(getDriver());

      homePage.refresh();
      getDriver().get("https:admin:admin@the-internet.herokuapp.com/basic-auth");
      genericPage.waitForPageLoad();
  }

  @Then("Congratulations should be displayed")
    public void congratulationsShouldBeDisplayed(){
      WebElement element = getDriver().findElement(By.xpath("//p"));
      String message1 = "Congratulations! You must have the proper credentials.";
      Assertions.assertEquals(message1, element.getText());
  }
}