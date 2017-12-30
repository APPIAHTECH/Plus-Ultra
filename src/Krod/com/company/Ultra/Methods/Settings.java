package Krod.com.company.Ultra.Methods;

public class Settings {

    private String defaultAssets;
    private String host;
    private int port;

    public Settings(){
        this.defaultAssets = "public";
    }

    public Settings(String defaultAssets ,String host , int port){
        this.setDefaultAssets(defaultAssets);
        this.setPort(port);
        this.setHost(host);

    }

    public String getDefaultAssets() {
        return defaultAssets;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDefaultAssets(String defaultAssets) {
        this.defaultAssets = defaultAssets;
    }

}
