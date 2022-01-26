package junit.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPO implements PageObject {

  private By LogoImage = By.xpath("//*[@*='image mira-logo-image-class']");;

  public void didWeGetMainPage(WebDriver driver){

    logger.info("Проверка перехода на главную страницу.");

    Assert.assertTrue(driver.findElements(LogoImage).size() > 0);

    logger.info("Переход на главную страницу выполнен.");
  }

  public void didWeGetAlert(WebDriver driver){

    logger.info("Проверка наличия алерта.");

    Alert alert = driver.switchTo().alert();
    Assert.assertTrue(alert.getText().contains("Неверные данные для авторизации"));

    logger.info("Алерт присутствует.");
  }
}
