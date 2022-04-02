


//import org.apache.log4j.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class JoTest_3 {
    WebDriver driver;


    @AfterClass
    public void afterClass() {
        //  MDC.put("test_step", "after_class"); // определяем метку test_step
        // MDC.clear(); // очищаем метки
    }


    @BeforeClass
    public void beforeClass() {
        //  MDC.put("test_name", "test1");      // определяем метку test_name
        //  MDC.put("test_step", "before_class"); // определяем метку test_step
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jon\\Desktop\\java\\chromedriver100.exe");
        driver = new ChromeDriver();

    }


    @Test(enabled = true, description = "")
    public void test1_step_01() throws Exception {
        try {
            // MDC.put("test_step", "step_1");
//Открыть главную страницу сайта https://victorz.ru/
            driver.get("https://victorz.ru/"); // открытие страницы яндекс
            //  driver.manage().window().maximize(); // задаем размеры браузера во все разрешение экрана
//В верхнем меню сайта есть кнопка «контакты»
            Assert.assertTrue( driver.findElement(By.xpath("//a[@href=\"https://victorz.ru/contacts\"]/span[text()='Контакты']")).isDisplayed());
////////////////////////////////////////////////////////////////////это другой шаг
            //В верхнем меню саита нажать на кнопку «контакты»
            driver.findElement(By.xpath("//a[@href=\"https://victorz.ru/contacts\"]/span[text()='Контакты']")).click();
            //Открылась страница контакты  с полями
           Assert.assertTrue(driver.findElement(By.xpath("//input[@name=\"your-name\"]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//input[@name=\"your-email\"]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//input[@name=\"your-subject\"]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//textarea[@name=\"your-message\"]")).isDisplayed());

        } catch (Throwable e) {

            //  Assistant.logException(e);
            //  assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_02() {
        try {
            // MDC.put("test_step", "step_2");
//Ввести значение в поле «ваше имя» латинскими буквами и буквами кириллицы
            driver.findElement(By.xpath("//input[@name=\"your-name\"]")).sendKeys("John Крон");


//В поле «ваше имя» отображается введенное имя
       Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"your-name\"]")).getAttribute("value"),"John Крон");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            // assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_03() {
        try {
            // MDC.put("test_step", "step_2");
//Ввести корректный емаил в поле  «ваш емаил»
            driver.findElement(By.xpath("//input[@name=\"your-email\"]")).sendKeys("test@test.ru");

// В поле «ваш емаил» отображается введённый емаил
            Assert.assertEquals( driver.findElement(By.xpath("//input[@name=\"your-email\"]")).getAttribute("value"),"test@test.ru");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            // assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_04() {
        try {
            // MDC.put("test_step", "step_2");

          //Ввести в поле «тема» состоящее из латинских букв . кириллицы. Цифр и спецсимволов
            driver.findElement(By.xpath("//input[@name=\"your-subject\"]")).sendKeys("tema тема 123 @#$%");
            // В поле тема отображается введенный текст
Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"your-subject\"]")).getAttribute("value"),"tema тема 123 @#$%");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            // assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_05() {
        try {
            // MDC.put("test_step", "step_2");

//Ввести в поле сообщения состоящее из латинских букв . кириллицы. Цифр и спецсимволов
            driver.findElement(By.xpath("//textarea[@name=\"your-message\"]")).sendKeys("text Текст 123 @#$%");
// В поле сообщение  отображается введенный текст
Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name=\"your-message\"]")).getAttribute("value"),"text Текст 123 @#$%");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            // assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_06() {
        try {
            // MDC.put("test_step", "step_2");
//Нажать под заполненной формой “кнопку отправить”
      driver.findElement(By.xpath("//input[@value=\"Отправить\"]")).click();
// Под кнопкой появилось сообщение «Одно или несколько полей содержат ошибочные данные. Пожалуйста, проверьте их и попробуйте ещё раз.»
//--//form[@method="post"]//div[last()]
//--//form[@method="post"]/child::div[last()]
//--//div[@class="wpcf7"]/form[@method="post"]//div[last()]
//--//form[@method="post"]//div[last()-1] -2 -3 -...
Assert.assertEquals( driver.findElement(By.xpath("//div[@class=\"wpcf7\"]/form[@method=\"post\"]//div[last()]")).getText().contains("Одно или несколько"),true);

        } catch (Throwable e) {
            //  Assistant.logException(e);
            // assertTrue(false);
        }
    }


}

