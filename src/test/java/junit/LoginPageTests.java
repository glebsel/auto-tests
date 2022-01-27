package junit;

import java.time.Duration;
import junit.pageobjects.LoginPO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPageTests {

  static Logger logger = LoggerFactory.getLogger(LoginPageTests.class);

  private WebDriver driver;
  private static ChromeOptions options;

  @BeforeAll
  public static void config(){

    logger.info("Тестовый прогон начался.");

      System.setProperty("webdriver.chrome.driver",
          "C:\\chromedriver.exe");
  }

  @Before
  public void setupTest(){
    options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    logger.info("ChromeDriver подготовлен к работе.");
  }

  @After
  public void teardown(){
    if(driver != null){
      driver.quit();

      logger.info("ChromeDriver выключен.");
    }
  }

  @Test
  public void loginRightData() throws InterruptedException {
    LoginPO loginPO = new LoginPO();
    Assert.assertTrue(loginPO.setDriver(driver)
        .getLoginPage()
        .writeLogin("fominaelena")
        .writePassword("1P73BP4Z")
        .clickLoginButton()
        .didWeGetMainPage(driver));
  }

  @Test
  public void loginWrongLogin() throws InterruptedException {
    LoginPO loginPO = new LoginPO();
    Assert.assertTrue(loginPO.setDriver(driver)
        .getLoginPage()
        .writeLogin("fominaelena1")
        .writePassword("1P73BP4Z")
        .clickLoginButtonAlert()
        .didWeGetAlert());
  }

  @Test
  public void loginWrongPassword() throws InterruptedException {
    LoginPO loginPO = new LoginPO();
    Assert.assertTrue(loginPO.setDriver(driver)
        .getLoginPage()
        .writeLogin("fominaelena")
        .writePassword("1P73BP")
        .clickLoginButtonAlert()
        .didWeGetAlert());
  }

  @Test
  public void loginEnptyFilds() throws InterruptedException {
    LoginPO loginPO = new LoginPO();
    Assert.assertTrue(loginPO.setDriver(driver)
        .getLoginPage()
        .writeLogin("")
        .writePassword("")
        .clickLoginButtonAlert()
        .didWeGetAlert());
  }

  @Test
  public void clickPasswordRecovery() throws InterruptedException {
    LoginPO loginPO = new LoginPO();
    Assert.assertTrue(loginPO.setDriver(driver)
        .getLoginPage()
        .clickPasswordRecovery()
        .didWeGetPasswordRecoveryPage(driver));
  }

}
