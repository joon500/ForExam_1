import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.*;
import static org.testng.Assert.assertTrue;


public class JoTest_4 {
    WebDriver driver;


    @AfterClass
    public void afterClass() {
        //   MDC.put("test_step", "after_class"); // определяем метку test_step
        //     MDC.clear(); // очищаем метки
        // driver.close();
    }


    @BeforeClass
    public void beforeClass() {
        // MDC.put("test_name", "test1");      // определяем метку test_name
        //  MDC.put("test_step", "before_class"); // определяем метку test_step
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jon\\Desktop\\java\\chromedriver100.exe");

        driver = new ChromeDriver();

    }


    @Test(enabled = true, description = "")
    public void test1_step_01() throws Exception {
        try {
            //   MDC.put("test_step", "step_1");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://fix-online.sbis.ru/");
            driver.manage().window().maximize(); // задаем размеры браузера во все разрешение экрана
//Сайт открылся без ошибок. Отобразилось окно авторизации

            Assert.assertTrue(driver.findElement(By.xpath("//input[@name=\"Login\"]")).isDisplayed());

        } catch (Throwable e) {
            // Assistant.logException(e);
            assertTrue(true);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_02() {
        try {
            //   MDC.put("test_step", "step_2");
            //Авторизироваитьтся логин: newfix пароль: 123qwerty
            driver.findElement(By.xpath("//input[@name=\"Login\"]")).sendKeys("newfix");
            driver.findElement(By.xpath("//input[@name=\"Login\"]")).sendKeys(ENTER);
            driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("123qwerty");
            driver.findElement(By.xpath("//span[@data-qa=\"auth-AdaptiveLoginForm__signInButton\"]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//все вызовы элементов driver.findElement() оствнавливаются
            Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Сотрудники']")).isDisplayed());


        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(true);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_03() {
        try {
            //   MDC.put("test_step", "step_2");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//  В левом боковом меню два раза кликнуть на раздел "Сотрудники"
            driver.findElement(By.xpath("//span[text()='Сотрудники']")).click();
            //После первого клика открывается выпадающее меню.

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Навыки']")).isDisplayed());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // После второго клика открывается страница со списком созданных сотрудников
            driver.findElement(By.xpath("//span[text()='Сотрудники']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qa=\"sabyPage-addButton\"]")).isDisplayed());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(true);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_04() {
        try {
            //   MDC.put("test_step", "step_2");
//В левом верхнем углу кликнуть на кнопку "Плюс"
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//div[@data-qa=\"sabyPage-addButton\"]")).click();
            //Открывается выпадающий список с элементами: сотрудник,
            Assert.assertTrue(driver.findElement(By.xpath("//span[@title=\"Сотрудник\"]")).isDisplayed());


        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(true);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_05() {
        try {
            //   MDC.put("test_step", "step_2");
            // Нажать на элемент "Сотрудник"
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@title=\"Сотрудник\"]")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@templatename=\"EntityChoice/popup:Stack\"]//span[text()='1, МДОУ 123']")).click();


            //Открывается окно создания карточки сотрудника.
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertTrue(driver.findElement(By.xpath("//input[@name=\"firstName\"]")).isDisplayed());


        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_06() {
        try {
            //   MDC.put("test_step", "step_2");
            //В поле "Имя" ввести значение "Дамир"
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("Дамир");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"firstName\"]")).getAttribute("value"), "Дамир");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_07() {
        try {
            //   MDC.put("test_step", "step_2");
            //В поле "Фамилия" ввести значение "Галимов"
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Галимов");

            Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"lastName\"]")).getAttribute("value"), "Галимов");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_08() {
        try {
            //   MDC.put("test_step", "step_2");
            // В поле "Отчество" ввести значение "Ришадович"
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//input[@name=\"middleName\"]")).sendKeys("Ришадович");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"middleName\"]")).getAttribute("value"), "Ришадович");


        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_09() {
        try {
            //   MDC.put("test_step", "step_2");
            //Нажать на кнопку списка справа от поля "Должность". Выбрать произвольное значение из списка
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//div[1][@data-qa=\"Lookup__showSelector\"]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//div[@title=\"111\"]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//div[@title=\"Тестировщики\"]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//div[@title=\"ТЕСТЕР\"]")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//div[@title=\"ТЕСТЕР / ТЕСТЕР ВАН\"][text()='ТЕСТЕР']")).getText(), "ТЕСТЕР");
        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_10() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_11() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_12() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_13() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_14() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_15() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }

    @Test(enabled = true, description = "")
    public void test1_step_16() {
        try {
            //   MDC.put("test_step", "step_2");

        } catch (Throwable e) {
            //  Assistant.logException(e);
            assertTrue(false);
        }
    }


}
