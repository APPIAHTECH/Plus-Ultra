package Krod.com.company.Ultra.Methods;

import com.sun.net.httpserver.HttpExchange;

public class InputOutput {

    static public HttpExchange httpExchange;

    public InputOutput(){}

    public static void setHttpExchange(HttpExchange httpExchange) {
        InputOutput.httpExchange = httpExchange;
    }

    public static HttpExchange getHttpExchange(){return httpExchange;}
}
