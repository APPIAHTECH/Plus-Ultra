package Krod.com.company.Web.Controllers;
import Krod.com.company.Ultra.Global.Helper;
import Krod.com.company.Ultra.Methods.Response;

import java.util.Map;

public class Home  {

    protected final String homeView = Helper.__dirname + "Web/View/Home.View.html";
    protected final String aboutView = Helper.__dirname + "Web/View/About.View.html";
    //protected final String singleApp = Helper.__dirname + "Web/assets/DropIt/dist/index.html";


    public void init(){
        Response.sendHtml(homeView);
    }

    public void about(){ Response.sendHtml(aboutView); }

    public void login(){
        String name = "" , password = "";
        Map<String, Object> parameters = Response.bodyParse();
        name = parameters.get("name").toString();
        password = parameters.get("password").toString();
        Response.send("<h1>Name</h1><br/>"+name+"<h1>Password</h1><br/>"+password);
    }

}
