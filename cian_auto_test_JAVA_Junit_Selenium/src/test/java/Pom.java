
import org.openqa.selenium.By;

public class Pom {

    public static String buy_gen = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span/";
    public static By buy_button = By.xpath(buy_gen + "button");
    public static By buy = By.xpath(buy_gen + "div/div/div/div[1]");
    public static By rent = By.xpath(buy_gen + "div/div/div/div[2]");
    public static By daily = By.xpath(buy_gen + "div/div/div/div[3]");

    public static By flat_button = By.xpath("//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div/button");
    public static By flat = By.xpath(".//*[text()='Квартиру']/..");
    public static By home = By.xpath(".//*[text()='Дом']/..");
    public static By room = By.xpath(".//*[text()='Комната']/..");

    public static String second_main = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/";
    public static By second_button = By.xpath(second_main + "button");
    public static By secondary = By.xpath(second_main + "div/div/div/ul/li[2]/label/span");

    public static String studia_str = "//*[@id='mainpage___R6E7C']/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/span/";
    public static By studia_button = By.xpath(studia_str + "button");
    public static By studia = By.xpath(studia_str + "div/div/div/div[1]/span/label");

    public static By from = By.xpath(".//*[@placeholder='от']");
    public static By to = By.xpath(".//*[@placeholder='до']");

    public static By city = By.xpath("//*[@id='c_filters-suggest_input']");

    public static By click_find = By.className("c-filters-field-button___1EBB-");
    public static By find_button = By.xpath("//*[@id='frontend-serp']/div/div[1]/div/div/div[2]/div[5]/button");
    public static By click_offer = By.className("_93444fe79c-card--2Jgih");
    public static By get_quantity = By.cssSelector(".fotorama__nav__frame");
    public static By click_arrow = By.cssSelector(".fotorama__arr.fotorama__arr--next");
    public static By get_data1 = By.className("a10a3f92e9--title--2Widg");
    public static By get_data2 = By.className("a10a3f92e9--info-block--3hCay");
    public static By get_data3 = By.className("a10a3f92e9--address--140Ec");

}
