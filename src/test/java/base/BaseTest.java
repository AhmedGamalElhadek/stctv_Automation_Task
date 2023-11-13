package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
    public BaseTest() {
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver.get("https://subscribe.stctv.com/");
        this.homePage = new HomePage(this.driver);
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}