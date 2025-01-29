import io.github.bonigarcia.wdm.WebDriverManager;  // якщо використовуєте WebDriverManager
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSauceDemoTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        // Якщо не хочете вручну качати chromedriver,
        // WebDriverManager автоматично завантажить/запустить потрібний драйвер
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        // Ініціалізуємо драйвер Chrome
        driver = new ChromeDriver();
    }

    @Test
    void openSauceDemoTest() {
        // 1) Відкриваємо сторінку
        driver.get("https://www.saucedemo.com/");

        // 2) Перевіряємо заголовок сторінки (title)
        String pageTitle = driver.getTitle();
        // За замовчуванням на saucedemo.com заголовок "Swag Labs"
        Assertions.assertEquals("Swag Labs", pageTitle,
                "Заголовок сторінки має бути 'Swag Labs'");
    }

    @AfterEach
    void tearDown() {
        // Закриваємо браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
