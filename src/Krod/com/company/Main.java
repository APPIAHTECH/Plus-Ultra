package Krod.com.company;

import Krod.com.company.Ultra.Methods.PlusUltra;
import Krod.com.company.Ultra.Methods.Settings;
import Krod.com.company.Ultra.Server;

public class Main {

    public static void main(String[] args) {
        Settings set = new Settings("/assets", "localhost" , 3500);
        PlusUltra rapid = new PlusUltra(set);
        rapid.ultra();
    }
}
