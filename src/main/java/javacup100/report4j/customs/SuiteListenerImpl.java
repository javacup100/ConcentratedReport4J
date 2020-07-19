package javacup100.report4j.customs;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListenerImpl implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("suite "+suite.getName()+" starts......");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("suite "+suite.getName()+" ends......");
    }
}
