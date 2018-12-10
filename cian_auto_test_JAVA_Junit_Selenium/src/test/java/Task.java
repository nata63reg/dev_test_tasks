import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Task {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static XSSFSheet sheet_out;
    private static XSSFSheet sheet;
    private static XSSFWorkbook wb_out;
    private static String url = "https://www.cian.ru/";

    @BeforeClass
    public static void setup() {
        //WebDriver driver;
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
        assertTrue(driver.getTitle().contains("ЦИАН"));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void body() throws IOException{
        wb_out = new XSSFWorkbook();
        sheet_out = wb_out.createSheet("OutData");
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("data.xlsx"));
        sheet = book.getSheet("List");

        int lst_row = sheet.getLastRowNum(), counter = -1;
        for (int i=0; i < lst_row; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            String cell1 = "", cell2 = "", cell3 = "", cell4 = "", cell5 = "", cell6 = "", cell7 = "";

            if (row.getCell(0) != null)
                cell1 = row.getCell(0).getStringCellValue();

            if (row.getCell(1) != null)
                cell2 = row.getCell(1).getStringCellValue();

            if (row.getCell(2) != null)
                cell3 = row.getCell(2).getStringCellValue();

            if (row.getCell(3) != null)
                cell4 = row.getCell(3).getStringCellValue();

            if (row.getCell(4) != null)
                cell5 = NumberToTextConverter.toText(row.getCell(4).getNumericCellValue());

            if (row.getCell(5) != null)
                cell6 = NumberToTextConverter.toText(row.getCell(5).getNumericCellValue());

            if (row.getCell(6) != null)
                cell7 = row.getCell(6).getStringCellValue();

            //--------------First field----------------------------------

            if (cell1.equals("Купить") || cell1.equals("Снять") || cell1.equals("Посуточно")) {
                wait.until(ExpectedConditions.elementToBeClickable(Pom.buy_button)).click();


                if (cell1.equals("Купить")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.buy)).click();
                    String buy = driver.findElement(Pom.buy_button).getText();
                    assertEquals(buy, "Купить");

                } else if (cell1.equals("Снять")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.rent)).click();

                    String rent = driver.findElement(Pom.buy_button).getText();
                    assertEquals(rent, "Снять");

                } else if (cell1.equals("Посуточно")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.daily)).click();
                    String daily = driver.findElement(Pom.buy_button).getText();
                    assertEquals(daily, "Посуточно");
                }
            }

            //-------------Second field-----------------------------

            if (cell2.equals("Квартиру") || cell2.equals("Дом") || cell2.equals("Комната")) {
                wait.until(ExpectedConditions.elementToBeClickable(Pom.flat_button)).click();

                if (cell2.equals("Квартиру")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.flat)).click();
                    String flat = driver.findElement(Pom.flat).getText();
                    assertEquals(flat, "Квартиру");

                } else if (cell2.equals("Дом")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.home)).click();
                    String home = driver.findElement(Pom.home).getText();
                    assertEquals(home, "Дом");

                } else if (cell2.equals("Комната")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.room)).click();
                    String room = driver.findElement(Pom.room).getText();
                    assertEquals(room, "Комната");
                }
            }

            // -----------Third field--------------------
            if (cell3.equals("Вторичка")) {
                wait.until(ExpectedConditions.elementToBeClickable(Pom.second_button)).click();

                if (cell3.equals("Вторичка")) {
                    wait.until(ExpectedConditions.elementToBeClickable(Pom.secondary)).click();
                    String smarket = driver.findElement(Pom.second_button).getText();
                    assertEquals(smarket, "Во вторичке");
                }
            }

            if (cell4.equals("студия")) {
                wait.until(ExpectedConditions.elementToBeClickable(Pom.studia_button)).click();

                if (cell4.equals("студия")) {

                    wait.until(ExpectedConditions.elementToBeClickable(Pom.studia)).click();
                    String studia = driver.findElement(Pom.studia).getText();
                    assertEquals(studia, "Студия");
                }
            }

            if (!cell5.equals("0") || !cell5.equals("")) {
                //Send start price
                System.out.println("Start_price=" + cell5);
                wait.until(ExpectedConditions.elementToBeClickable(Pom.from)).sendKeys(cell5);
                String attr1 = driver.findElement(Pom.from).getAttribute("value");
                assertEquals(cell5, attr1);
            }

            if (!cell6.equals("0") || !cell6.equals("")) {
                //Send end price
                System.out.println("End_price=" + cell6);
                wait.until(ExpectedConditions.elementToBeClickable(Pom.to)).sendKeys(cell6);
                String attr2 = driver.findElement(Pom.to).getAttribute("value");
                assertEquals(cell6, attr2);
            }

            if (!cell7.equals("")) {
                System.out.println("City=" + cell7);
                String str = ".//*[text()='" + cell7 + "']";

                wait.until(ExpectedConditions.elementToBeClickable(Pom.city)).sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b");
                wait.until(ExpectedConditions.elementToBeClickable(Pom.city)).sendKeys(cell7);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str))).click();
                String attr3 = driver.findElement(Pom.city).getAttribute("value");
                assertEquals(cell7, attr3);
            }

            //Click find button
            wait.until(ExpectedConditions.elementToBeClickable(Pom.click_find)).click();
            //Check button on second page before start new iteration
            wait.until(ExpectedConditions.elementToBeClickable(Pom.find_button));

            //Wait until loads offers then click

            System.out.println("Click first offer in page");
            wait.until(ExpectedConditions.elementToBeClickable(Pom.click_offer)).click();
            //Get Focus to tab 2
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));

            //Scroll-----------------START
            int cnt = driver.findElements(Pom.get_quantity).size();

            System.out.println("Kol-vo img:" + cnt);

            if (cnt > 0) {
                for (int k = 1; k <= cnt; k++)
                    wait.until(ExpectedConditions.presenceOfElementLocated(Pom.click_arrow)).click();
                                }
            //Scroll-----------------END

            //Getting data [START]----------------
            //String str_data1 = "", str_data2 = "", str_data3 = "";
            String str_data1 = driver.findElements(Pom.get_data1).get(0).getText();
            //Get info block
            String str_data2 = driver.findElements(Pom.get_data2).get(0).getText();
            str_data2 = str_data2.replace("\n", " ");
            //String[] words=str2.split("\n");

            //Get Address
            String str_data3 = driver.findElements(Pom.get_data3).get(0).getText();
            str_data3 = str_data3.replace("На карте", "");

            System.out.println(str_data1);
            System.out.println(str_data2.trim());
            System.out.println(str_data3);
            System.out.println("-----------------------");

            //Getting data [END]---------------------

            //--Writing data to excel-----[START]----
            counter++;
            Row row_out1 = sheet_out.createRow(counter);
            row_out1.createCell(0).setCellValue(str_data1);
            counter++;
            Row row_out2 = sheet_out.createRow(counter);
            row_out2.createCell(0).setCellValue(str_data2.trim());
            counter++;
            Row row_out3 = sheet_out.createRow(counter);
            row_out3.createCell(0).setCellValue(str_data3);
            counter++;
            Row row_out4 = sheet_out.createRow(counter);
            row_out4.createCell(0).setCellValue("----------------------------------------------------------------");
            //Row row_out = sheet_out.createRow(counter++);

            //Write to file
            try {
                File file = new File("Out.xlsx");
                FileOutputStream out = new FileOutputStream(file);
                wb_out.write(out);
            }
            //counter++;}
            catch (IOException e) {
                e.printStackTrace();
            }


            //--Writing data to excel-----[END]------

            //Scroll images
            driver.close();
            driver.switchTo().window(tabs2.get(0));

            //Back to main page
            //driver.navigate().back();

            driver.get(url);
        }
    }

}



