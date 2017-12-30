package Krod.com.company.Ultra.Methods;

import Krod.com.company.Ultra.Global.Helper;
import com.sun.net.httpserver.*;
import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class RouterHandle implements HttpHandler {

    private HttpExchange httpExchange;
    private Object someObject;
    private String methodName;

    public  RouterHandle(){ }

    public RouterHandle(Object someObject , String methodName){
        this.someObject = someObject;
        this.methodName = methodName;
    }

    @Override
    public void handle(HttpExchange he ) throws IOException {
        setHttpExchange(he);
        InputOutput.setHttpExchange(this.getHttpExchange());
        llistenParams();
        ObjectCallHandle();
    }

    protected void setHttpExchange(HttpExchange exchange){this.httpExchange = exchange;}
    protected  HttpExchange getHttpExchange(){return this.httpExchange;}

    private void ObjectCallHandle(){

        try {
            String className = this.someObject.getClass().getName();
            Class<?> clazz = Class.forName(className);
            Constructor<?> ctor = clazz.getConstructor();
            Object object = ctor.newInstance();
            Method method = this.someObject.getClass().getDeclaredMethod(this.methodName);
            method.invoke(object);

        } catch (SecurityException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void llistenParams(){
        String query = getHttpExchange().getRequestURI().getPath();
        boolean gotParams = false;
        for (String key : Request.paramsPrexisis().keySet()){
            if(query.toLowerCase().contains(key.toLowerCase())){
                gotParams = true;
                break;
            }
        }

        if(gotParams){

            String newQuery = stringIntersection(query);
            String querSplit[] = query.split("/");
            String paramsSplited[] = paramsSplitUp(querSplit , newQuery);
            String parPrexisis = Request.paramsPrexisis().get(newQuery);
            String fields[] = parPrexisis.split("/");
            removeDots(fields);
            associateParamsFields(paramsSplited , fields);
        }
    }

    private String stringIntersection(String query) {
        String intersection = "";
        for (String key : Request.paramsPrexisis().keySet()){
            for (int i = 0; i < key.length(); i++)
                if(query.charAt(i) == key.charAt(i))
                    intersection += query.charAt(i);
        }

        return intersection;
    }

    private void removeDots(String camps[]){
        String temp = "";
        int posDos = -55;
        for (int i = 0; i < camps.length; i++) {
            if(camps[i].contains(":")){
                posDos = camps[i].indexOf(":");
                temp = camps[i].substring(posDos+1);
                camps[i] = temp;
            }
        }
    }

    private String[] paramsSplitUp(String camps[] , String newQuery){
        String[] par = new String[camps.length];
        String caracter = " ";
        int posDos = -55 , j = 0;
        for (int i = 1; i < camps.length; i++) {
            caracter = camps[i];
            if(! (newQuery.toLowerCase().contains(caracter.toLowerCase())) ){
                par[j] = caracter;
                j++;
            }
        }

        return par;
    }

    private void associateParamsFields(String pars[] , String camps[]){
        int i = 0;
        for (String camp:camps) {
            Request.params.put(camp , pars[i]);
            i++;
        }
    }


}
