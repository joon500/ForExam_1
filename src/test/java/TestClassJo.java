import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestClassJo {

    private WebDriver driver;

    @BeforeSuite()
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jon\\Desktop\\java\\chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);//все вызовы элементов driver.findElement()
        // будут продолжаться то тех пор,
        // пока элемент не будет найден или будет достигунта граница времени ожидания.
      //  driver.manage().window().maximize();
        System.out.println("Установка законченна");
    }

    @Test
    //найти поле, ввести значение, проверить введенное значение
    public void firstTest() throws InterruptedException {
        driver.get("https://yandex.ru/");

        String locatorForSearchInput = "//input[@class=\"input__control input__input mini-suggest__input\"]";
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);//все вызовы элементов driver.findElement() до нахождения элемента
        driver.findElement(By.xpath(locatorForSearchInput)).sendKeys("ruby");
    /*    WebElement weit  =    new WebDriverWait(driver, Duration.ofSeconds(5))
         .until(ExpectedConditions.presenceOfElementLocated(By.className("main-locationWrapper-R8itV")));// ожиданеи элемента если нету то пауза*/

        //получеие атрибута
        String findAttribute = driver.findElement(By.xpath(locatorForSearchInput)).getAttribute("value");

        Assert.assertEquals(findAttribute,"ruby","занчение не эквевалентно заданому");



    }
    @Test
    //сравнение стекста в элементе с заданным
    public void getButton(){
        String locatorButton = "//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']";

        Assert.assertEquals(driver.findElement(By.xpath(locatorButton)).getText().equals("Найти"),true,"несоответсвует заданному значению");
    }

    @Test
//получение текста новости и проверка его
    public void twoTest() throws InterruptedException {
        driver.get("https://kursk.ru/");
        String  getLocator = "//div[@class=\"news-widget\"]/div[1]/a[1]/span[1]";
        String getNews = driver.findElement(By.xpath(getLocator)).getText();
      //  Assert.assertEquals(getNews,"Поступило несколько сотен заявок от представителей курского бизнеса для участия в программе льготного кредитования");

    }
    @Test
//запрос и проверка результата
    public void threeTest() throws InterruptedException {
        driver.get("https://kursk.ru/");
String getLocator = "//main[@class=\"main\"]//input[@name='q']";
String getNewsLocator ="//div[@class=\"app\"]/main/div/div/div/div[2]/a[1]/span/text()[1]";
 driver.findElement(By.xpath(getLocator)).sendKeys("проект", Keys.ENTER);
 String  getNews = driver.findElement(By.xpath("//div[@class=\"app\"]/main/div/div/div/div[2]/a[1]/span")).getText();

        Assert.assertEquals(getNews.contains("Об утверждении"),true);


    }


    @AfterSuite
    public void cleanUp() {
        //  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));//поосто ожидание
       driver.quit();
        System.out.println("Все активноcти закрыты");
    }
}
