package Krod.com.company.Ultra.Methods;

import java.util.HashMap;


public class Root{

    static protected HashMap<String, Object> getRoots = new HashMap<String, Object>();
    static protected HashMap<String, Object> postRoots = new HashMap<String, Object>();

    public Root(){ }

    static public  void add(String method , String path , Object action , String contollerMethod){
        path += ";"+contollerMethod;
        if(method.toUpperCase().equals("GET"))
            getRoots.put(path , action);

        if(method.toUpperCase().equals("POST"))
            postRoots.put(path , action);
    }

    static public HashMap<String, Object> getGetRoots() {
        return getRoots;
    }

    static public HashMap<String, Object> getPostRoots() {
        return postRoots;
    }

}
