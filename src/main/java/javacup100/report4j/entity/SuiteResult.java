package javacup100.report4j.entity;

import java.util.List;

import javacup100.report4j.utils.time.dateUtil;

public class SuiteResult {

	List<TestRunResult> testRunResults;
	private int excludeNumber;
	private int passedNumber;
	private int failedNumber;
	private int skippedNumber;
	private int totalNumber;
	private String testsTime;
	private Double passRatio;
	private String suiteName;
	private Double duration;
	private String durationString;
	private long starttime;
	private long endtime;
	private String description;
	private List<String> output;
	private boolean isParallel;
	private int threadCount;

	public boolean isParallel() {
		return isParallel;
	}

	public void setParallel(boolean parallel) {
		isParallel = parallel;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public List<TestRunResult> getTestRunResults() {
		return testRunResults;
	}

	public void setTestRunResults(List<TestRunResult> testRunResults) {
		this.testRunResults = testRunResults;
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

	public int getSkippedNumber() {
		return skippedNumber;
	}

	public void setSkippedNumber(int skippedNumber) {
		this.skippedNumber = skippedNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getTestsTime() {
		return testsTime;
	}

	public void setTestsTime(String testsTime) {
		this.testsTime = testsTime;
	}

	public Double getPassRatio() {
		return passRatio;
	}

	public void setPassRatio(Double passRatio) {
		this.passRatio = passRatio;
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public String getDurationString() {
		return this.durationString;
	}
	public void setDurationString() {
		this.durationString= dateUtil.toTimeString(this.duration);
	}
	public double getDuration() {

		return this.duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public long getStarttime() {
		return starttime;
	}

	public String getStarttimeString() {
		return dateUtil.toDateString(starttime);
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public long getEndtime() {
		return endtime;
	}

	public String getEndtimeString() {
		return dateUtil.toDateString(endtime);
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

	public List<String> getOutput() {
		return output;
	}

	public void setOutput(List<String> output) {
		this.output = output;
	}
}
