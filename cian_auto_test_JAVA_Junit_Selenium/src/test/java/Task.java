import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Task {

    public static WebDriver driver;

    @BeforeClass
    public static void settings() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


    }
    @Test
    public void test() throws IOException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url= "https://www.cian.ru/";
        driver.get(url);

        XSSFWorkbook wb_out = new XSSFWorkbook();
        XSSFSheet sheet_out = wb_out.createSheet("OutData");


        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream("data.xlsx")) ;
        XSSFSheet sheet = book.getSheet("List");
        int lst_row=sheet.getLastRowNum(),counter=-1;
        //int colNum = sheet.getRow(0).getLastCellNum();
        WebDriverWait wait = new WebDriverWait(driver, 10);


        for (int i=0;i<lst_row;i++) {
            XSSFRow row = sheet.getRow(i + 1);
            String cell1="", cell2 = "", cell3 = "", cell4 = "", cell5 = "", cell6 = "", cell7 = "";

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

            //------------------------------------------------


            if (cell1.equals("Купить") || cell1.equals("Снять") || cell1.equals("Посуточно")) {
                String str = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span/";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "button"))).click();

                if (cell1.equals("Купить")) {
                   // driver.findElement(By.xpath(str + "div/div/div/div[1]")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "div/div/div/div[1]"))).click();
                } else if (cell1.equals("Снять")) {
                   // driver.findElement(By.xpath(str + "div/div/div/div[2]")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "div/div/div/div[2]"))).click();
                } else if (cell1.equals("Посуточно")) {
                    //driver.findElement(By.xpath(str + "div/div/div/div[3]")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "div/div/div/div[3]"))).click();
                    }
            }

            //------------------------------------------

            if (cell2.equals("Квартиру") || cell2.equals("Дом") || cell2.equals("Комната")) {
                String str = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div/";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "button"))).click();

                if (cell2.equals("Квартиру")) {
                    //driver.findElement(By.xpath(str + "div/div/div[1]/ul/li[1]/label/span")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Квартиру']/.."))).click();
                } else if (cell2.equals("Дом")) {
                    //driver.findElement(By.xpath(str + "div/div/div[1]/ul/li[4]/label/span")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Дом']/.."))).click();
                } else if (cell2.equals("Комната")) {
                    //driver.findElement(By.xpath(str + "div/div/div[1]/ul/li[2]/label/span")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Комната']/.."))).click();
                }
            }


            if (cell3.equals("Вторичка")) {
                String str = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "button"))).click();

                if (cell3.equals("Вторичка")) {
                    //driver.findElement(By.xpath(str + "div/div/div/ul/li[2]/label/span")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "div/div/div/ul/li[2]/label/span"))).click();
                }

            }


            if (cell4.equals("студия")) {
                String str = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/span/";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "button"))).click();

                if (cell4.equals("студия")) {
                    //driver.findElement(By.xpath(str + "div/div/div/div[1]/span/label")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str + "div/div/div/div[1]/span/label"))).click();
                }
            }

            if (!cell5.equals("0") || !cell5.equals("")) {
                //Send start price
                System.out.println("Start_price="+cell5);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@placeholder='от']"))).sendKeys(cell5);
            }

            if (!cell6.equals("0") || !cell6.equals("")) {
                //Send end price
                System.out.println("End_price="+cell6);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@placeholder='до']"))).sendKeys(cell6);
            }

            if (!cell7.equals("")) {
                System.out.println("City="+cell7);
                String str=".//*[text()='"+cell7+"']";

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='c_filters-suggest_input']"))).sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='c_filters-suggest_input']"))).sendKeys(cell7);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str))).click();
            }



            //Click find button
            wait.until(ExpectedConditions.elementToBeClickable(By.className("c-filters-field-button___1EBB-"))).click();
            //Check button on second page before start new iteration
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frontend-serp']/div/div[1]/div/div/div[2]/div[5]/button")));



            //Wait until loads offers then click
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"frontend-serp\"]/div/div[5]/div[1]"))).click();
            System.out.println("Click first offer in page");
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"frontend-serp\"]/div/div[4]/div[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.className("_93444fe79c-card--2Jgih"))).click();
            //Get Focus to tab 2
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));


            //Scroll-----------------START
            int cnt =  driver.findElements(By.cssSelector(".fotorama__nav__frame")).size();
            System.out.println("Kol-vo img:"+cnt);

            if (cnt>0){
                for (int k = 1; k <= cnt; k++)
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fotorama__arr.fotorama__arr--next"))).click();
            }
            //Scroll-----------------END

            //Getting data [START]----------------
            String str_data1="", str_data2="",str_data3="";
            str_data1 = driver.findElements(By.className("a10a3f92e9--title--2Widg")).get(0).getText();
            //Get info block
            str_data2 = driver.findElements(By.className("a10a3f92e9--info-block--3hCay")).get(0).getText();
            str_data2=str_data2.replace("\n"," ");
            //String[] words=str2.split("\n");

            //Get Address
            str_data3 = driver.findElements(By.className("a10a3f92e9--address--140Ec")).get(0).getText();
            str_data3=str_data3.replace("На карте","");

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
            try{
                File file = new File("Out.xlsx");
                FileOutputStream out = new FileOutputStream(file);
                wb_out.write(out);}
                //counter++;}
            catch (IOException e) {
                e.printStackTrace();}


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



