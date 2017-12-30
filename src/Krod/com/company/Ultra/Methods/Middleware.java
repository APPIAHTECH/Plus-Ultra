package Krod.com.company.Ultra.Methods;

import Krod.com.company.Ultra.Global.Helper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Middleware implements HttpHandler{

    public Middleware(){}

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String fileId = httpExchange.getRequestURI().getPath();
        File file = getFile(fileId);

        if (file == null) {
            String response = "Error 404 File not found.";
            httpExchange.sendResponseHeaders(404, response.length());
            OutputStream output = httpExchange.getResponseBody();
            output.write(response.getBytes());
            output.flush();
            output.close();
        } else {
            httpExchange.sendResponseHeaders(200, 0);
            OutputStream output = httpExchange.getResponseBody();
            FileInputStream fs = new FileInputStream(file);
            final byte[] buffer = new byte[0x10000];
            int count = 0;
            while ((count = fs.read(buffer)) >= 0) {
                output.write(buffer, 0, count);
            }
            output.flush();
            output.close();
            fs.close();
        }
        
    }

    private File getFile(String fileId) {
        String workingDir = Helper.__dirname;
        workingDir = workingDir+"Web"+fileId;
        File resoure = new File(workingDir);
        if(resoure.isFile()){
            return resoure;
        }
        return null;
    }
}
