package io.cucumber.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage {

  protected ChromeDriver driver;
  protected WebDriverWait wait;


  private static WebDriverWait getWebDriverInstance (WebDriver driver,int seconds){
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
      wait.ignoring(NoSuchElementException.class, TimeoutException.class);
      wait.pollingEvery(Duration.ofSeconds(1));
      return wait;
  }
  public static void waitForElementForVisibility(WebDriver driver,int seconds, By elementBy){
      getWebDriverInstance(driver,seconds).until(ExpectedConditions.visibilityOfElementLocated(elementBy));
  }

  public GenericPage(ChromeDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    waitForPageLoad();
  }

  public void waitForPageLoad() {
    try {
      Thread.sleep(Duration.ofSeconds(5));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void clickElement(WebElement element){
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(45));
      wait.until(ExpectedConditions.elementToBeClickable(element));
      element.click();
  }
}