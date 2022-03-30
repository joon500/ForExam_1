import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestFromDZ {
    String locatorLogin = "//a[contains(@class,'login-new-item_enter')]/div[@class='desk-notif-card__login-new-item-title']";

    WebDriver driver;
    String url = "https://www.ozon.ru";

    @BeforeSuite
    public void setUp() {


        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\jon\\Desktop\\java\\chromedriver.exe");
        driver = new ChromeDriver();

        System.out.println("Данные для теста подготовлены");
    }

    @BeforeClass
    public void appSetup() {
        driver.get(url);
        System.out.println("Страница открыта");
    }

    @Test
    public void ClickOn1Button() throws InterruptedException {

        String Зарабатывай_с_Озон = "/html/body/div[1]/div/div[1]/div[1]/div/ul/li[4]/div/a/span";
        WebElement input = driver.findElement(By.xpath(Зарабатывай_с_Озон));
        input.click();
        Thread.sleep(300);
    }
    @Test
    public void ClickOn2Button() {
        String Хочу_зарабатывать = "/html/body/div[1]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[1]/a";
        WebElement input = driver.findElement(By.xpath(Хочу_зарабатывать));
        input.click();
    }
    @Test
    public void ClickOn3Button() throws InterruptedException {
        String Подробнее = "/html/body/div[1]/div/div[1]/div/div[2]/div/div[3]/div/div[2]/div[4]/div[3]/a";
        WebElement input = driver.findElement(By.xpath(Подробнее));
        input.click();
        Thread.sleep(1000);
    }

    @Test
    public void ClickOn4Button() {
        String ОставитьЗаявку = "/html/body/div[1]/div[1]/div[1]/div[3]/div[2]/div/div[1]/div/div[1]/div[2]/a[1]";
        WebElement input = driver.findElement(By.xpath(ОставитьЗаявку));
        input.click();
    }

    @Test
    public void checkForm() {

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"postamats\"]")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("555 555 55 55");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/div[2]/div/div[6]/form/div[3]/div[1]/div[1]/div[1]/input")).sendKeys("Курск г, Курская Область");
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/div[2]/div/div[6]/form/label/div[1]")).click();
        System.out.println("Форма заполнена");
    }




    @AfterTest
    public void reportReady() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        System.out.println("Тест закончен");
    }
    @AfterSuite
    public void cleanUp() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        System.out.println("Активность завершена");
    }

}

