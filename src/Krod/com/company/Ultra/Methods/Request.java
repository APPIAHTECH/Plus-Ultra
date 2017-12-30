package Krod.com.company.Ultra.Methods;

import com.sun.net.httpserver.Headers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

final public class Request extends InputOutput implements ParseRequest{

    private static Map<String , String> paramsPrexisis = new HashMap<>();
    public static Map<String , String> params = new HashMap<>();

    static public String getRequestHeaders(){
        Headers headers = InputOutput.getHttpExchange().getRequestHeaders();
        Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
        String response = "";
        for (Map.Entry<String, List<String>> entry : entries)
            response += entry.toString() + "\n";

        return response;
    }

    public static Map<String, Object> bodyParse(){
        try{
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            InputStreamReader isr = new InputStreamReader(getHttpExchange().getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String query = br.readLine();
            System.out.println(query + " params : "+ parameters);
            parameters = ParseRequest.parseQuery(query, parameters);
            return parameters;

        }catch (Exception e){

        }

        return null;
    }

    static public Map<String, String> paramsPrexisis(){return paramsPrexisis;}

    public static Map<String, String> params() {
        return params;
    }
}
