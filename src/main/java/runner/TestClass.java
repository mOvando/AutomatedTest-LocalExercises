package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestClass {
    public static final String CHROME_DRIVER_PATH = "chromedriver.exe";
    private WebDriver driver;
    private String appURL = "file:///C:/Users/Daniel/Documents/automated%20testing/Local%20Webs/busqueda/index.html";
    private String GOOGLE_INPUT_ID = "searchbox";
    private By GOOGLE_SEARCH_BUTTTON = By.xpath("//img[@class='mic']");
    private String SEARCH_RANDOM = "random";
    private String GOOGLE_TITLE = "Google";

    @BeforeClass
    // Setting chromedriver driver
    public void testSetUp() {
        // Call chromedriver.
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        //Disable barInfo
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
    }

    @Test
    // Ejecuting Test
    public void scenario1() {
        By FIRST_LINK = By.xpath("//div[1]/a");
        By SECOND_CAT = By.xpath("//a[2]/img");
        String SEARCH_CATS = "gatos";
        String CAT_TITLE = "derp.jpg";
        //Open Page
        driver.get(appURL);
        //Fill out search input
        driver.findElement(By.id(GOOGLE_INPUT_ID)).sendKeys(SEARCH_CATS);
        //Press search button
        driver.findElement(GOOGLE_SEARCH_BUTTTON).click();
        //Wait till link is present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FIRST_LINK));
        //Press the link
        element.click();
        //Pick the second cat
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        WebElement elementCat = wait.until(ExpectedConditions.elementToBeClickable(SECOND_CAT));
        elementCat.click();
        //Check if that cat is the right cat
        String getTitle = driver.getTitle();
        Assert.assertTrue(getTitle.contains(CAT_TITLE));
    }

    @Test
    // Ejecuting Test
    public void scenario2(){
        By WIKI_LINK = By.xpath("//div[2]/a");
        //Open Page
        driver.get(appURL);
        //Fill out search input
        driver.findElement(By.id(GOOGLE_INPUT_ID)).sendKeys(SEARCH_RANDOM);
        //Press search button
        driver.findElement(GOOGLE_SEARCH_BUTTTON).click();
        //Wait till link is present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(WIKI_LINK));
        //Press search button
        element.click();
        //Verify Wikipedia Title
        String titleGet = driver.getTitle();
        String titleHave = SEARCH_RANDOM + " " + "Wikia";
        Assert.assertEquals(titleGet, titleHave);
    }

    @Test
    // Ejecuting Test
    public void scenario3(){
        String FOOD = "la comida";
        String foodURL = ("file:///C:/Users/Daniel/Documents/automated%20testing/Local%20Webs/noticias/la%20comida.html");
        By NEWS_LINK = By.xpath("//div[3]/a");
        By IMG_LINK = By.xpath("//a/div[@class='news4']");
        //Open Page
        driver.get(appURL);
        //Fill out search input
        driver.findElement(By.id(GOOGLE_INPUT_ID)).sendKeys(FOOD);
        //Press search button
        driver.findElement(GOOGLE_SEARCH_BUTTTON).click();
        //Wait till link is present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement newsLink = wait.until(ExpectedConditions.elementToBeClickable(NEWS_LINK));
       //Press search button
        newsLink.click();
        //Wait till link with img is present
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(IMG_LINK).click();
        //Verify URL
        String getURL = driver.getCurrentUrl();
        Assert.assertEquals(getURL, foodURL);
    }
//
    @Test
    // Ejecuting Test
    public void scenario4(){
        By MOVIE_LINK = By.xpath("//div[4]/a");
        By IMG_MOVIE = By.xpath("//img[@alt=\"John Cena in Ferdinand (2017)\"]");
        //Open Page
        driver.get(appURL);
        //Fill out search input
        driver.findElement(By.id(GOOGLE_INPUT_ID)).sendKeys(SEARCH_RANDOM);
        //Press search button
        driver.findElement(GOOGLE_SEARCH_BUTTTON).click();
        //Wait till link is present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement movieLink = wait.until(ExpectedConditions.elementToBeClickable(MOVIE_LINK));
        //Press search button
        movieLink.click();
        //Search and press img
        driver.findElement(IMG_MOVIE).click();
        //Verify URL
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, GOOGLE_TITLE);
    }

    @Test
    // Ejecuting Test
    public void scenario5(){
        By FREE_LINK = By.xpath("//div[5]/a");
        By PRODUCT_LINK = By.xpath("//a[@title='FlashGet']");
        By SOFTONIC_LINK = By.xpath("regexp:softonic.+$");
        //Open Page
        driver.get(appURL);
        //Fill out search input
        driver.findElement(By.id(GOOGLE_INPUT_ID)).sendKeys(SEARCH_RANDOM);
        //Press search button
        driver.findElement(GOOGLE_SEARCH_BUTTTON).click();
        //Wait till link is present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement freeLink = wait.until(ExpectedConditions.elementToBeClickable(FREE_LINK));
        //Press search button
        freeLink.click();
        //Find and click correct link
        driver.findElement(PRODUCT_LINK).click();
        //Verify URL
        String getTitle = driver.getTitle();
        Assert.assertNotEquals(getTitle, SOFTONIC_LINK);
    }

    @Test
    // Ejecuting Test
    public void scenario6(){
        String SEARCH_NOTEBOOK = "notebook";
        By BUY_LINK = By.xpath("//div[7]/a");
        By NOTEBOOK_IMG = By.xpath("//img[@alt='hp-m6.jpg']");
        //Open Page
        driver.get(appURL);
        //Fill out search input
        driver.findElement(By.id(GOOGLE_INPUT_ID)).sendKeys(SEARCH_NOTEBOOK);
        //Press search button
        driver.findElement(GOOGLE_SEARCH_BUTTTON).click();
        //Wait till link is present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement buyLink = wait.until(ExpectedConditions.elementToBeClickable(BUY_LINK));
        //Press search button
        buyLink.click();
        //Find and click correct link
        driver.findElement(NOTEBOOK_IMG).click();
        //Verify URL
        String getTitle = driver.getTitle();
        Assert.assertNotEquals(getTitle, appURL);
    }

      @AfterClass
    // Closing Browser when finish the test
    public void tearDown() {
        driver.quit();
    }
}
