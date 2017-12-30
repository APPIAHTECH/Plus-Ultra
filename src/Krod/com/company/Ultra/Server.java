package Krod.com.company.Ultra;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private int port;
    private String address;
    private HttpServer server;

    public Server(){
        this(4200 , "127.0.0.1");
    }

    public Server(int port , String address) {

        try {
            this.setPort(port);
            this.setAddress(address);
            this.server = HttpServer.create(new InetSocketAddress(this.address ,this.port), 0);
            System.out.println("server started at " +this.getAddress()+" : "+this.getPort());
            server.setExecutor(null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPort(int port){
        if(port > 0 && port < 99999)
            this.port = port;
        else
            new Exception("Ivalid port");

    }

    public void setAddress(String address){
        if(!address.isEmpty())
            this.address = address;
        else
            new Exception("Ivalid ip address");

    }

    public int getPort() {
        return port;
    }

    public String getAddress() {
        return address;
    }

    public HttpServer getServer(){return this.server;}

}
