import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class annotation {
    private JavascriptExecutor js;
    private WebDriver driver;
    private final String url = "http://visjs.org/examples/network/other/manipulation.html";
    private Integer nodeId = 10;
    private Integer nodeId1 = 16;
    private Integer x = -300;
    private Integer y = 400;

    @Given("^Open visjs\\.org$")
    public void open_visjs_org() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = ((JavascriptExecutor) driver);

        driver.get(url);
        String tlt = driver.getTitle();
        Assert.assertEquals(tlt , "Network | Manipulation");
    }

    @When("^I select node$")
    public void i_select_node() throws Throwable {
        js.executeScript("network.selectNodes(["+nodeId+"]);");
        String selected_node = String.valueOf(js.executeScript("return network.getSelectedNodes();"));
        Assert.assertEquals("["+nodeId+"]" ,selected_node );
    }

    @Then("^I delete it$")
    public void i_delete_it() throws Throwable {
        js.executeScript("network.deleteSelected();");
        String res_after = String.valueOf(js.executeScript("return network.getPositions(["+nodeId+"]);"));
        Assert.assertEquals("{}" , res_after);
        driver.close();
    }

    // Second Scenario
    @Then("^I move node on x,y$")
    public void i_move_node_on_x_y() throws Throwable {
        //move node on x,y
        js.executeScript("network.moveNode("+nodeId1+","+x+","+y+");");
        driver.close();
        driver.quit();
    }
}
