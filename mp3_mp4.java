import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class mp3_mp4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("//placement where the driver is");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        //put the exact name of the video you want to download
        String name = "Army-Destroying Punch! | One Piece";

        driver.get("https://youtube.com");

        Thread.sleep(500);

        WebElement YouInp = driver.findElement(By.id("search"));

        YouInp.click();

        Thread.sleep(500);

        YouInp.sendKeys(name, Keys.ENTER);

        Thread.sleep(1000);

        WebElement Video = driver.findElement(By.xpath("//yt-formatted-string[text()= '" + name + "'][1]"));
        Video.click();

        Thread.sleep(500);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        Thread.sleep(1000);

        //------------------------------------------------------------------------------------------------------

        driver.get("https://ytmp3.cc/youtubemp3/");

        Thread.sleep(1000);

        while (true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("MP3/MP4?: ");
                int mp3_or_mp4 = scanner.nextInt();

                if(mp3_or_mp4 == 3)
                {
                    WebElement input = driver.findElement(By.id("input"));
                    input.sendKeys(url, Keys.ENTER);

                    Thread.sleep(500);

                    WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
                    download.click();
                    return;
                }

                if(mp3_or_mp4 == 4)
                {
                    WebElement mp4 = driver.findElement(By.id("mp4"));
                    mp4.click();

                    Thread.sleep(500);

                    WebElement input = driver.findElement(By.id("input"));
                    input.sendKeys(url, Keys.ENTER);

                    Thread.sleep(500);

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Download']")));

                    WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
                    download.click();

                    return;
                } else {
                    System.out.println("");
                    System.out.println("-----------------------------------------");
                    System.out.println("E R R O R ! Please enter 3 = mp3/ 4 = mp4");
                    System.out.println("-----------------------------------------");
                    System.out.println("");
                }

            } catch (RuntimeException e)
            {
                System.out.println("");
                System.out.println("-----------------------------------------");
                System.out.println("E R R O R ! Please enter 3 = mp3/ 4 = mp4");
                System.out.println("-----------------------------------------");
                System.out.println("");
            }
        }
    }
}
