public class Device {
    
    private String name;
    private String type;
    private Router router;
    
    public Device(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public void connect(Router router) {
        this.router = router;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Router getRouter() {
        return router;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    
}
