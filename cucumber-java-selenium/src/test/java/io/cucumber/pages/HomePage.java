package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends GenericPage {

  public HomePage(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  public WebElement getTitle() {
    return title;
  }

  public List<String> getExampleLists(){
      List<WebElement> elements = driver.findElements(By.xpath("//li"));
      return elements.stream().map(WebElement::getText).toList();
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }

  public void clickExampleLink(String title){
      WebElement element = driver.findElement(By.linkText(title));
      clickElement(element);
  }
}
