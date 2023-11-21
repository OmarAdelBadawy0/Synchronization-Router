public class Device extends Thread {
    
    private String name;
    private String type;
    private Router router;
    
    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }
    
    public void connect(Router router) {
        this.router = router;
    }

    public String get_Name() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Router getRouter() {
        return router;
    }

    public void set_Name(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }


    public void doSomthing() {
        System.out.println("(" + name + ") (" + type + ") - login");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
    router.Occupy(this);
    doSomthing();
    router.exit(this);
    }
}
