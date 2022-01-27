package junit.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPO implements PageObject {

  private By PasswordRecoveryDiv = By.xpath("//*[contains(text(),'Восстановление пароля')]");

  public Boolean didWeGetPasswordRecoveryPage(WebDriver driver){

    logger.info("Проверка перехода на страницу восстановления пароля.");

    return driver.findElements(PasswordRecoveryDiv).size() > 0;
  }
}
