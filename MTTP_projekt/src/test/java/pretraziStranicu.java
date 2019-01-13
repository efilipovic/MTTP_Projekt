import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class pretraziStranicu {

    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.index.hr/oglasi/";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }
    @Test
    public void pretraziStranicu() throws InterruptedException {
// driver.manage().window().maximize();
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@id=\"formInCenter\"]/div/div[1]/div/input[1]"));
        searchTextBox.sendKeys("stan");
        searchTextBox.submit();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[2]/div[1]/a/span/span[1]/span[1]"));
        testLink.getText().toLowerCase().contains("stan");
        System.out.print(testLink.getText());
    }

    @Test
    public void odaberiKategoriju() throws InterruptedException {
        WebElement kategorijaOglasa = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/a/span[1]"));
        kategorijaOglasa.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("/html/body/div[4]/div/div/h1"));
        Assert.assertEquals(testLink.getText().toLowerCase(), "osobni automobili");
        System.out.print(testLink.getText());
    }
    @Test
    public void filtrirajAutomobile() throws InterruptedException{
        WebElement kategorijaOglasa = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/a/span[1]"));
        kategorijaOglasa.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("/html/body/div[4]/div/div/h1"));
        Assert.assertEquals(testLink.getText().toLowerCase(), "osobni automobili");
        WebElement gornjaGranica = driver.findElement(By.xpath("//*[@id=\"price_to\"]"));
        WebElement donjaGranica = driver.findElement(By.xpath("//*[@id=\"price_from\"]"));
        WebElement gumbFiltriraj = driver.findElement(By.xpath("//*[@id=\"myForm1\"]/ul[5]/li[2]/input"));
        donjaGranica.sendKeys("500");
        gornjaGranica.sendKeys("10000");
        Thread.sleep(2000);
        gumbFiltriraj.click();
        Thread.sleep(2000);
        WebElement nazivOglasa = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div[2]/div[1]/a/span/span[1]/span[1]"));
        WebElement cijenaOglasa = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div[2]/div[1]/a/span/span[2]/span/span"));
        System.out.println("Naziv: " + nazivOglasa.getText() + " Cijena: "+ cijenaOglasa.getText());
    }

    @Test
    public void pogledajSveOglase() throws InterruptedException{
        WebElement kategorijaOglasa = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/a/span[1]"));
        kategorijaOglasa.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("/html/body/div[4]/div/div/h1"));
        Assert.assertEquals(testLink.getText().toLowerCase(), "osobni automobili");
        WebElement odabraniOglas = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div[2]/div[1]/a/span/span[1]/span[1]"));
        odabraniOglas.click();
        Thread.sleep(3000);
        WebElement gumbPrikaziSve = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div[1]/a"));
        gumbPrikaziSve.click();
        Thread.sleep(2000);


    }
    @Test
    public void Login() throws InterruptedException{
        WebElement gumbPrijava = driver.findElement(By.xpath("//*[@id=\"home_photo\"]/nav/ul[2]/li[2]/a"));
        gumbPrijava.click();
        Thread.sleep(3000);
        WebElement textBoxEmail = driver.findElement(By.xpath("//*[@id=\"korisnicko_ime\"]"));
        WebElement textBoxLozinka = driver.findElement(By.xpath("//*[@id=\"lozinka\"]"));
        WebElement gumbPrijaviMe = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/ul/li[4]/input"));
        textBoxEmail.sendKeys("ehafilipovic@gmail.com");
        textBoxLozinka.sendKeys("test.123");
        Thread.sleep(2000);
        gumbPrijaviMe.click();
        Thread.sleep(3000);
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}


