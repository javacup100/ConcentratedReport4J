import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.Random;

public class TestFactory {
    @Factory
    public Object[] factory() {
        ArrayList<RandomTest> testList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            long waitFor = (long) (new Random().nextInt(3000));
            testList.add(new RandomTest(waitFor));
        }
        return testList.toArray();
    }
}
