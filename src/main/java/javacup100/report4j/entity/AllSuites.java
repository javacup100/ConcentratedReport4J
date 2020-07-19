package javacup100.report4j.entity;

import javacup100.report4j.utils.time.dateUtil;

public class AllSuites {
    private int totalNumber;
    private int passedNumber;
    private int failedNumber;
    private int skippedNumber;
    private Double duration;
    private String durationString;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
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

    public Double getDuration() {
        return duration;
    }
    public String getDurationString() {
        return this.durationString;
    }
    public void setDurationString() {
        this.durationString= dateUtil.toTimeString(this.duration);
    }
    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
