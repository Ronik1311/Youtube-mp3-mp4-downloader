import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class mp3_mp4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("//put the location of where your drier is");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        //put the exact name of the video you want to download
        String name = "Army-Destroying Punch! | One Piece";

        //opens youtube
        driver.get("https://youtube.com");

        Thread.sleep(500);

        //finds the search bar and clicks it
        WebElement YouInp = driver.findElement(By.id("search"));
        YouInp.click();

        Thread.sleep(500);

        //puts the name of the video or song you want to download
        YouInp.sendKeys(name, Keys.ENTER);

        Thread.sleep(1000);

        //clicks the video
        WebElement Video = driver.findElement(By.xpath("//yt-formatted-string[text()= '" + name + "'][1]"));
        Video.click();

        Thread.sleep(500);

        //copies the url 
        String url = driver.getCurrentUrl();
        System.out.println(url);

        Thread.sleep(1000);

        //opens the mp3/mp4 youtube downloader
        driver.get("https://ytmp3.cc/youtubemp3/");

        Thread.sleep(1000);

        //loop
        while (true)
        {
            try {
                //asks what u want to download(mp3/mp40
                Scanner scanner = new Scanner(System.in);
                System.out.print("MP3/MP4?: ");
                int mp3_or_mp4 = scanner.nextInt();

                //if chosen mp3 then...
                if(mp3_or_mp4 == 3)
                {
                    //finds the input, puts the url and press enter
                    WebElement input = driver.findElement(By.id("input"));
                    input.sendKeys(url, Keys.ENTER);

                    Thread.sleep(500);

                    //finds download and clicks it
                    WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
                    download.click();
                    
                    // stops
                    return;
                }

                //if mp4 then...
                if(mp3_or_mp4 == 4)
                {
                    //finds the mp4 button and clicks it
                    WebElement mp4 = driver.findElement(By.id("mp4"));
                    mp4.click();

                    Thread.sleep(500);

                    //finds the input, puts the url and press enter
                    WebElement input = driver.findElement(By.id("input"));
                    input.sendKeys(url, Keys.ENTER);

                    Thread.sleep(500);
                    
                    //wait untill the download shows up because it might take more then 10 seconds
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Download']")));

                    //finds the download and clicks it
                    WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
                    download.click();

                    // stops
                    return;
                    
                // if you didnt enter 3 or 4 and u chose a random number then it will show this error
                } else {
                    System.out.println("");
                    System.out.println("-----------------------------------------");
                    System.out.println("E R R O R ! Please enter 3 = mp3/ 4 = mp4");
                    System.out.println("-----------------------------------------");
                    System.out.println("");
                }
            
            // if you pressed a word or something like that that isnt a number it will show an error    
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
