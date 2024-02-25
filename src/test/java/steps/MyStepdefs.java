package steps;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class MyStepdefs {
    private static WebDriver driver;

    @Given("As an end user I want to open the WebdriverIO application on my IOS device")
    public void as_an_end_user_i_want_to_open_the_webdriver_io_application_on_my_android_device() throws MalformedURLException, InterruptedException {
        //setting up desired capabilities
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 15");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability(MobileCapabilityType.APP, "/Users/admin/Downloads/Payload-5/wdiodemoapp.app");
        dc.setCapability(PLATFORM_VERSION, "17.2");
        dc.setCapability("noReset", true);
        driver= new IOSDriver(new URL("http://0.0.0.1:4723/wd/hub"), dc);
        Thread.sleep(5000);
        System.out.println("Application started");
    }
    @When("I navigate to Login page and enter the credentials")
    public void i_navigate_to_login_page_and_enter_the_credentials() throws InterruptedException {

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Login\"]")).click();
        Thread.sleep(3000);
        System.out.println("Sending user credentials");
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"input-email\"]")).sendKeys("pratikshapk101@gmail.com");
        driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"input-password\"]")).sendKeys("happynewyear24");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"LOGIN\"]")).click();
    }


    @Then("I should be able to login successfully")
    public void I_should_be_able_to_login_successfully() throws InterruptedException {
        Boolean Display = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).isDisplayed();
        System.out.println("Element displayed is :" + Display);
        System.out.println("User registration completed");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
        Thread.sleep(2000);
        driver.quit();
    }


}





