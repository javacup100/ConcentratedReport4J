package javacup100.report4j.entity;

import javacup100.report4j.utils.time.dateUtil;

import java.util.List;

public class TestResult implements Comparable<TestResult> {
	private String methodName;
	private String className;
	private String status;
	private String name;
	private String testRunName;
	private Double duration;
	private String durationString;
	private long starttime;
	private long endtime;
	private String parameters;
	private String description;
	private String dependMethod;
	private Throwable throwable;
	private String stackTrace;
	private List<String> groups;

	public void setDurationString(String durationString) {
		this.durationString = durationString;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTestRunName() {
		return testRunName;
	}

	public void setTestRunName(String testRunName) {
		this.testRunName = testRunName;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public String getDurationString() {
		return this.durationString;
	}
	public void setDurationString() {
		this.durationString= dateUtil.toTimeString(this.duration);
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

	public String getEndtimeString() {
		return dateUtil.toDateString(endtime);
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDependMethod() {
		return dependMethod;
	}

	public void setDependMethod(String dependMethod) {
		this.dependMethod = dependMethod;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public String getStackTrace() {
		return this.stackTrace==null?" ":this.stackTrace;
	}

	public void setStackTrace(String stackTrace) {

				this.stackTrace = stackTrace;
	}

	@Override
	public int compareTo(TestResult o) {
		if (this.starttime >= o.getStarttime())
			return 1;
		else
			return -1;
	}
}
