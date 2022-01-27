package junit.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPO implements PageObject {

  private String Url = "https://lmslite47vr.demo.mirapolis.ru/mira/";

  private WebDriver driver;

  private By LoginInput = By.name("user");

  private By PasswordInput = By.name("password");

  private By LoginButton = By.id("button_submit_login_form");

  private By PasswordRecoveryDiv = By.xpath("//*[text()='Забыли пароль?']/ancestor::a");

  public LoginPO setDriver(WebDriver driver){

    this.driver = driver;

    return this;

  }

  public LoginPO getLoginPage(){

    logger.info("Попытка перейти на страницу " + Url);

    driver.get(Url);

    logger.info("Выполнен переход на страницу " + Url);

    return this;
  }

  public LoginPO writeLogin(String login){

    logger.info("Попытка ввести логин " + login);

    driver.findElement(LoginInput).sendKeys(login);

    logger.info("Введен логин " + login);

    return this;
  }

  public LoginPO writePassword(String password){

    logger.info("Попытка ввести пароль " + password);

    driver.findElement(PasswordInput).sendKeys(password);

    logger.info("Введен пароль " + password);

    return this;
  }

  public MainPO clickLoginButton(){

    logger.info("Попытка нажать на кнопку логина.");

    driver.findElement(LoginButton).click();

    logger.info("Кнопка логина нажата.");

    return new MainPO();
  }

  public LoginPO clickLoginButtonAlert(){

    logger.info("Попытка нажать на кнопку логина с ожиданием алерта.");

    driver.findElement(LoginButton).click();

    logger.info("Кнопка логина нажата с ожиданием алерта.");

    return this;
  }

  public PasswordRecoveryPO clickPasswordRecovery(){

    logger.info("Попытка нажать на кнопку текст для восстановления пароля.");

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(PasswordRecoveryDiv));

    logger.info("Нажат текст для восстановления пароля.");

    return new PasswordRecoveryPO();
  }

  public Boolean didWeGetAlert(){

    logger.info("Проверка наличия алерта.");

    Alert alert = driver.switchTo().alert();
    return alert.getText().contains("Неверные данные для авторизации");
  }
}
