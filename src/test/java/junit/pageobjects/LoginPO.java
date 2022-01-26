package junit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPO implements PageObject {

  private String url = "https://lmslite47vr.demo.mirapolis.ru/mira/";

  private By LoginInput = By.name("user");

  private By PasswordInput = By.name("password");

  private By LoginButton = By.id("button_submit_login_form");

  private By PasswordRecoveryDiv = By.xpath("//*[text()='Забыли пароль?']/ancestor::a");

  public LoginPO getLoginPage(WebDriver driver){

    logger.info("Попытка перейти на страницу " + url);

    driver.get(url);

    logger.info("Выполнен переход на страницу " + url);

    return new LoginPO();
  }

  public LoginPO writeLogin(String login, WebDriver driver){

    logger.info("Попытка ввести логин " + login);

    driver.findElement(LoginInput).sendKeys(login);

    logger.info("Введен логин " + login);

    return new LoginPO();
  }

  public LoginPO writePassword(String password, WebDriver driver){

    logger.info("Попытка ввести пароль " + password);

    driver.findElement(PasswordInput).sendKeys(password);

    logger.info("Введен пароль " + password);

    return new LoginPO();
  }

  public MainPO clickLoginButton(WebDriver driver){

    logger.info("Попытка нажать на кнопку логина.");

    driver.findElement(LoginButton).click();

    logger.info("Кнопка логина нажата.");

    return new MainPO();
  }

  public PasswordRecoveryPO clickPasswordRecovery(WebDriver driver){

    logger.info("Попытка нажать на кнопку текст для восстановления пароля.");

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(PasswordRecoveryDiv));

    logger.info("Нажат текст для восстановления пароля.");

    return new PasswordRecoveryPO();
  }
}
