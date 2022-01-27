package junit.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPO implements PageObject {

  private By LogoImage = By.xpath("//*[@*='image mira-logo-image-class']");;

  public Boolean didWeGetMainPage(WebDriver driver){

    logger.info("Проверка перехода на главную страницу.");

    return driver.findElements(LogoImage).size() > 0;
  }
}
