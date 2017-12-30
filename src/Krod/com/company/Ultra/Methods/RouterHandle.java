package Krod.com.company.Ultra.Methods;

import com.sun.net.httpserver.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.io.*;

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
        ObjectCallHandle();
        //this.requestMethodHandle();
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
}
