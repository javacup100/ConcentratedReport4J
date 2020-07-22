package javacup100.report4j.entity;

import org.apache.commons.lang.StringUtils;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ModelFactory {
    public static SuiteResult getSuiteResult(ISuite suite) {
        SuiteResult suiteResult = new SuiteResult();
//overallinfo
        suiteResult.setSuiteName(suite.getName());
        Map<String, ISuiteResult> results = suite.getResults();
        List<TestRunResult> list = new ArrayList<>();
        int passed = 0, failed = 0, skipped = 0;
        for (String key : results.keySet()) {
            ITestContext context = results.get(key).getTestContext();
            TestRunResult tModel = getTestRunResult(context);
            passed += tModel.getPassedNumber();
            failed += tModel.getFailedNumber();
            skipped += tModel.getExcludeNumber();
            list.add(tModel);
        }
        suiteResult.setTotalNumber(passed + failed + skipped);
        Collections.sort(list);
        suiteResult.setTestRunResults(list);
        long start = list.get(0).getStarttime();
        long end = list.get(list.size() - 1).getEndtime();

        suiteResult.setStarttime(start);
        suiteResult.setEndtime(end);
        suiteResult.setDuration((double) (end - start) / 1000);
//pass/fail/skipinfo
        suiteResult.setPassedNumber(passed);
        suiteResult.setFailedNumber(failed);
        suiteResult.setSkippedNumber(skipped);

//ratio
        double ratio = (double) passed / (double) (passed + failed + skipped);
        suiteResult.setPassRatio(ratio);

        return suiteResult;
    }

    public static TestRunResult getTestRunResult(ITestContext context) {
        TestRunResult testRun = new TestRunResult();
        testRun.setName(context.getName());
        testRun.setSuiteName(context.getSuite().getName());
        testRun.setStarttime(context.getStartDate().getTime());
        testRun.setEndtime(context.getEndDate().getTime());
        testRun.setDuration(
                (double) (testRun.getEndtime() - testRun.getEndtime()) / 1000
        );
        testRun.setExcludedMethods(context.getExcludedMethods());
        testRun.setFailedNumber(context.getFailedTests().size());
        testRun.setPassedNumber(context.getPassedTests().size());
        testRun.setExcludeNumber(testRun.getExcludedMethods().size());
        testRun.setTotalNumber(testRun.getExcludeNumber() + testRun.getFailedNumber() + testRun.getPassedNumber());
        List<TestResult> list = new ArrayList<>();
        List<TestResult> all_list = new ArrayList<>();
        for (ITestResult res : context.getPassedTests().getAllResults()) {
            TestResult testResult = getTestResultModel(res);
            list.add(testResult);
            all_list.add(testResult);
        }
        Collections.sort(list);
        testRun.setPassedTests(list);
        list = new ArrayList<>();
        for (ITestResult res :
                context.getFailedTests().getAllResults()) {
            TestResult testResult = getTestResultModel(res);
            list.add(testResult);
            all_list.add(testResult);
        }
        Collections.sort(list);
        testRun.setFailedTests(list);
        Collections.sort(all_list);
        System.out.print("*****the size of cases*****:" + all_list.size());
        testRun.setAllTests(all_list);
        return testRun;
    }

    public static TestResult getTestResultModel(ITestResult res) {
        TestResult testResult = new TestResult();
        List<String> groups = new ArrayList<>();
        for (String group : res.getMethod().getGroups()) {
            groups.add(group);
        }
        testResult.setGroups(groups);
        testResult.setClassName(res.getTestClass().getName());
        testResult.setMethodName(res.getMethod().getMethodName());
        testResult.setName(res.getName());
        testResult.setTestRunName(res.getTestName());
        testResult.setStatus(TestStatus.getStatus(res.getStatus()));
        testResult.setDescription(res.getMethod().getDescription());
        testResult.setStarttime(res.getStartMillis());
        testResult.setEndtime(res.getEndMillis());
        testResult.setDuration(
                (double) (testResult.getEndtime() - testResult.getStarttime()) / 1000
        );
        testResult.setDependMethod(res.getMethod().getMethodsDependedUpon().toString());
        testResult.setParameters(StringUtils.join(res.getParameters(), ","));
        if (res.getThrowable() != null)
            testResult.setStackTrace(StringUtils.join(res.getThrowable().getStackTrace(),"<br>"));
        return testResult;
    }

}

