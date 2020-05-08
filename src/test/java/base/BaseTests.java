package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        /* find elements returns a list of webelements */
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());
        WebElement inputLink = driver.findElement(By.linkText("Inputs"));
        inputLink.click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> inputLists = driver.findElements(By.tagName("li"));
        System.out.print(inputLists.size());
//      driver.manage().window().fullscreen();
//        driver.manage().window().setSize(new Dimension(375,812));

        driver.quit(); //closes the whole session
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
