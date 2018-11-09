import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class debug {

    public static WebDriver driver;

    @BeforeClass
    public static void settings() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Evgen\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }

    @Test
    public void debug()throws InvalidFormatException, IOException  {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://saratov.cian.ru/sale/flat/194104616/");

        driver.get("https://saratov.cian.ru/cat.php?deal_type=sale&engine_version=2&offer_type=flat&region=4969&room1=1&room2=1");


        for (int k=1;k<=5;k++){



            System.out.println("Click first offer in page");
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frontend-serp']/div/div[4]/div[1]"))).click();
            driver.findElement(By.className("_93444fe79c-card--2Jgih")).click();
                                         //*[@id="frontend-serp"]/div/div[5]/div[1]
            System.out.println("Get array");
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));




            //Scroll-----------------START
            int cnt =  driver.findElements(By.cssSelector(".fotorama__nav__frame")).size();
            System.out.println("Kol-vo img:"+cnt);

            if (cnt>0){
                for (int j = 1; j <= cnt; j++)
                    driver.findElement(By.cssSelector(".fotorama__arr.fotorama__arr--next")).click();
                    //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fotorama__arr.fotorama__arr--next"))).click();
            }
            //Scroll-----------------END


            driver.close();
            driver.switchTo().window(tabs2.get(0));



        }




    }
}