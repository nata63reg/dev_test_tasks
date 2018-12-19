import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Division {

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"12","0.083333336"},
                {"-10", "-0.1"},
                {"1", "1.0"},
                {"0","Wrong value!"}
        };
    }

    @Test(dataProvider = "data")
    //@Test
    public void test1(String numbers, String expected){
        System.setIn(new ByteArrayInputStream(numbers.getBytes()));

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));


        App.input();

        String out = myOut.toString();
        String actual = out.replaceAll("\r\n", "");

        Assert.assertEquals(actual, expected);


    }
}
