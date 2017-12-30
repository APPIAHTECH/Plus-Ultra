package Krod.com.company.Ultra.Methods;

import com.sun.net.httpserver.Headers;
import java.util.*;

final public class Request extends InputOutput implements ParseRequest{

    static public String getRequestHeaders(){
        Headers headers = InputOutput.getHttpExchange().getRequestHeaders();
        Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
        String response = "";
        for (Map.Entry<String, List<String>> entry : entries)
            response += entry.toString() + "\n";

        return response;
    }

}
