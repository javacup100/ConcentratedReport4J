package javacup100.report4j.entity;

import java.util.Collection;
import java.util.List;

import javacup100.report4j.utils.time.dateUtil;
import org.testng.ITestNGMethod;

public class TestRunResult implements Comparable<TestRunResult> {
	private String name;
    private String suiteName;
	private Collection<ITestNGMethod> excludedMethods;
	private List<TestResult> failedTests;
	private List<TestResult> passedTests;
	private List<TestResult> allTests;
	private int excludeNumber;
	private int passedNumber;
	private int failedNumber;
	private int totalNumber;
	private double duration;
	private long starttime;
	private long endtime;
	private String description;

	public List<TestResult> getAllTests() {
		return allTests;
	}

	public void setAllTests(List<TestResult> allTests) {
		this.allTests = allTests;
	}

	public List<TestResult> getPassedTests() {
		return passedTests;
	}

	public void setPassedTests(List<TestResult> passedTests) {
		this.passedTests = passedTests;
	}

	public List<TestResult> getFailedTests() {
		return failedTests;
	}

	public void setFailedTests(List<TestResult> failedTests) {
		this.failedTests = failedTests;
	}

	public Collection<ITestNGMethod> getExcludedMethods() {
		return excludedMethods;
	}

	public void setExcludedMethods(Collection<ITestNGMethod> excludedMethods) {
		this.excludedMethods = excludedMethods;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public double getDuration() {
		return duration;
	}
	public String getDurationString() {
		return dateUtil.toTimeString(this.duration);
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}

	public long getStarttime() {
		return starttime;
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExcludeNumber() {
		return excludeNumber;
	}

	public void setExcludeNumber(int excludeNumber) {
		this.excludeNumber = excludeNumber;
	}

	public int getPassedNumber() {
		return passedNumber;
	}

	public void setPassedNumber(int passedNumber) {
		this.passedNumber = passedNumber;
	}

	public int getFailedNumber() {
		return failedNumber;
	}

	public void setFailedNumber(int failedNumber) {
		this.failedNumber = failedNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	@Override
	public int compareTo(TestRunResult o) {
		if (this.starttime >= o.getStarttime())
			return 1;
		else
			return -1;
	}

}
