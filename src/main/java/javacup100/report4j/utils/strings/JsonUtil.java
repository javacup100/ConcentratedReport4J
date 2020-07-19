package javacup100.report4j.utils.strings;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    public static <T>  String fromObjToString(T obj){
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(obj);
        return json;
    }
}
