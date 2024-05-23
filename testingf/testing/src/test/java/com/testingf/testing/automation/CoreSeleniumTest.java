package com.testingf.testing.automation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, properties = { "server.port=8090" })
public class CoreSeleniumTest {

  private String appUrl = "http://localhost:8090";

  private WebDriver driver;

  @BeforeEach
  public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get(appUrl);
  }

  @Test
  public void test_web_title_should_be_valid() {
    String title = driver.getTitle();
    assertEquals("Selenium & JUnit Testing", title);
  }

  @Test
  public void test_get_all_select_options() {
    List<String> actual = List.of("content", "demo");

    WebElement findSelectOptions = driver.findElement(By.id("items"));
    Select selectOptions = new Select(findSelectOptions);
    List<WebElement> options = selectOptions.getOptions();

    List<String> expected = options.stream().map(option -> option.getText()).toList();

    assertEquals(expected.get(0), actual.get(0));
    assertEquals(expected.size(), actual.size());
  }

  @Test
  public void test_read_button_exists() {

    WebElement button = driver.findElement(By.id("read"));

    assertNotNull(button);
    assertEquals(button.getText(), "read");
  }

  @Test
  public void test_read_content() {

    WebElement selectElement = driver.findElement(By.id("items"));
    Select select = new Select(selectElement);
    select.selectByVisibleText("content");

    WebElement button = driver.findElement(By.id("read"));
    button.click();

    WebElement resultDiv = driver.findElement(By.id("result"));
    String resultText = resultDiv.getText();

    assertTrue(resultText.contains("this is reading from the content"));
  }

  @AfterEach
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

}
