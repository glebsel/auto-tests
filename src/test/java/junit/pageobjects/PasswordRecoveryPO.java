package junit.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPO implements PageObject {

  private By PasswordRecoveryDiv = By.xpath("//*[contains(text(),'Восстановление пароля')]");

  public void didWeGetPasswordRecoveryPage(WebDriver driver){

    logger.info("Проверка перехода на страницу восстановления пароля.");

    Assert.assertTrue(driver.findElements(PasswordRecoveryDiv).size() > 0);

    logger.info("Переход на страницу восстановления пароля выполнен.");
  }
}
