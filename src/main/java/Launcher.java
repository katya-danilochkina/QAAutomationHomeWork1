import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void testTask1() {
        WebDriver driver = initChromeDriver();
        String initialAddress = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea";
        driver.get(initialAddress);
        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys("webinar.test@gmail.com");
        WebElement fieldPassword = driver.findElement(By.id("passwd"));
        fieldPassword.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement buttonSubmitLogin = driver.findElement(By.name("submitLogin"));
        buttonSubmitLogin.click();
        delayFunction();
        WebElement linkUser = driver.findElement(By.className("employee_avatar_small"));
        linkUser.click();
        WebElement linkLogout = driver.findElement(By.id("header_logout"));
        linkLogout.click();

        delayFunction();
        driver.quit();

    };

    public static void delayFunction() {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("Exception");
        }
    }

    public static void testTask2() {
        WebDriver driver = initChromeDriver();
        String initialAddress = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea";
        driver.get(initialAddress);

        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys("webinar.test@gmail.com");
        WebElement fieldPassword = driver.findElement(By.id("passwd"));
        fieldPassword.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement buttonSubmitLogin = driver.findElement(By.name("submitLogin"));
        buttonSubmitLogin.click();
        delayFunction();

        List<WebElement> menuElements = driver.findElements(By.className("maintab"));
        List<String> menuText = new ArrayList<String>();
        for(WebElement linkElement: menuElements){
            String ItemText = linkElement.getText();
            menuText.add(ItemText);
        }
        for(String itemText: menuText){
            WebElement SideMenuListItem = driver.findElement(By.linkText(itemText));
            SideMenuListItem.click();
            delayFunction();
            System.out.println(itemText);
            String urlAfterClick = driver.getCurrentUrl();
            driver.navigate().refresh();
            delayFunction();
            String urlAfterRefresh = driver.getCurrentUrl();
            if (urlAfterClick.equals(urlAfterRefresh)) {
                System.out.println("Correct URL");
            } else {
                System.out.println("Wrong URL");
            }

        }

        driver.quit();

    };

    public static void main(String[] args) {
        testTask1();
        testTask2();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}

