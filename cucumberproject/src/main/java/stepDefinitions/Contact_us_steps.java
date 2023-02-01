package stepDefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.Module;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Contact_us_steps {
 private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("Webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I access the webdriver contact us page")
    public void i_access_the_webdriver_contact_us_page() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        Thread.sleep(20000);
    }
    @When("Ienter fairst name")
    public void ienter_fairst_name() {

        driver.findElement(By.name("first_name")).sendKeys("Abhishek");

    }
    @And("i enter last name")
    public void i_enter_last_name() {

        driver.findElement(By.name("last_name")).sendKeys("Abhishek");
    }
    @And("i enter Email")
    public void i_enter_email() {
        driver.findElement(By.name("email")).sendKeys("Abhishek@gmail.com");
    }
    @And("i enter discrebtion")
    public void i_enter_discrebtion() {
        driver.findElement(By.name("message")).sendKeys("Abhishek");
    }
    @And("i click on submitbutton")
    public void i_click_on_submitbutton() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        Thread.sleep(20000);
    }
    @Then("I should be presented sucessful msg")
    public void i_should_be_presented_sucessful_msg() {

        String Msgg = driver.findElement(By.xpath("//div[@id='contact_reply']/h1")).getText();
         Assert.assertEquals(Msgg , "Thank You for your Message!");

    }

    @When("i enterinvalid Email Id")
    public void i_enterinvalid_email_id() {
        driver.findElement(By.name("email")).sendKeys("Abhishekv");
    }
    @Then("I should be presented Error Message")
    public void i_should_be_presented_error_message() {
        String Msgg = driver.findElement(By.xpath("//br")).getText();
         Assert.assertTrue(Msgg.contains("Error"));

    }


    @After
    public void close(){
        driver.quit();
    }

}
