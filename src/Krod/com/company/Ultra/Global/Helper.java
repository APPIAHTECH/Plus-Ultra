package Krod.com.company.Ultra.Global;

import java.io.OutputStream;
import java.util.Map;

public class Helper {

    static public final String __dirname = System.getProperty("user.dir")+"/out/production/PlusUltra/Krod/com/company/";

    public static void printBodyParseMap(Map<String, Object> parameters){
        String response = "";
        for (String key : parameters.keySet())
            response += key + " = " + parameters.get(key) + "\n";
        System.out.println(response);
    }

    public static void printMaps(Map<? , ?> map){
        System.out.println(map);
    }
}
