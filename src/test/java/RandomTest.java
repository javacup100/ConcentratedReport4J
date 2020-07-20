import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomTest {
    private long factor=1200;
    private long waitFor;

    public RandomTest(long waitFor) {
        this.waitFor = waitFor;
    }

    @Test
    public void printRandom()  {
        try{
            TimeUnit.MILLISECONDS.sleep(waitFor);
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertTrue(factor>waitFor);
    }
}
