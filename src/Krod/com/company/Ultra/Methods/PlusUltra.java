package Krod.com.company.Ultra.Methods;

import Krod.com.company.Ultra.Server;
import Krod.com.company.Web.Routers.Roots;

import java.util.HashMap;

public class PlusUltra{

    private Roots roots;
    private Server server;
    private RouterHandle routerHandle;
    public static Settings settings;

    public PlusUltra(){}

    public PlusUltra(Settings settings){
        PlusUltra.settings = settings;
        server =  new Server(settings.getPort() , settings.getHost());
        roots = new Roots();
    }

    public void ultra(){
        getCalls();
        postCalls();
        server.getServer().createContext(this.settings.getDefaultAssets() , new Middleware());
        server.getServer().start();
    }

    private void getCalls(){
        String path = "" , meth = "";
        HashMap<String , Object> getRoots = roots.getGetRoots();
        String response = "";
        for (String key : getRoots.keySet()){
            path = getPath(key);
            meth = getMethods(key);
            System.out.println(" GET : Path -> "+path);
            System.out.println("Meth -> "+meth);
            routerHandle =  new RouterHandle(getRoots.get(key) , meth);
            response += key + " = " + getRoots.get(key) + "\n";
            server.getServer().createContext(path , routerHandle);
        }
    }

    private void postCalls(){
        String path = "" , meth = "";
        HashMap<String , Object> getRoots = roots.getPostRoots();
        String response = "";
        for (String key : getRoots.keySet()){
            path = getPath(key);
            meth = getMethods(key);
            System.out.println("POST : Path -> "+path);
            System.out.println("Meth -> "+meth);
            routerHandle =  new RouterHandle(getRoots.get(key) , meth);
            response += key + " = " + getRoots.get(key) + "\n";
            server.getServer().createContext(path , routerHandle);
        }
    }

    private String getPath(String path){
        int pos = path.indexOf(";");
        return path.substring(0 , pos);
    }

    private String getMethods(String path){
        int pos = path.indexOf(";");
        return path.substring(pos+1);
    }

}
