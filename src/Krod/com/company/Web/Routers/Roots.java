package Krod.com.company.Web.Routers;

import Krod.com.company.Ultra.Methods.Root;
import Krod.com.company.Web.Controllers.Home;

public class Roots extends Root{

    public Roots(){

        Root.add("GET" , "/" , new Home(), "init");
        Root.add("GET" , "/about" , new Home(), "about");
        Root.add("POST" , "/login" , new Home(), "login");
    }
}
