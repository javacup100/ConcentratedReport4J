package javacup100.report4j.entity;

public class TestStatus {
    public static String getStatus(int code){
        switch (code){
            case -1:
                return "CREATED";
            case 1:
                return "SUCCESS";
            case 2:
                return "FAILURE";
            case 3:
                return "SKIP";
            case 4:
                return "SUCCESS_PERCENTAGE_FAILURE";
            case 16:
                return "STARTED";
            default:
                return "none";
        }
    }
}
