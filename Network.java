import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Device extends Thread {
    private String name;
    private String type;
    Router router;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    public String get_name() {
        return this.name;
    }

    public String get_type() {
        return this.type;
    }



    public void perform_online_activity() {
        System.out.println(name  +" Login");
        System.out.println(name + "performs online activity\r");
        try {
            Thread.sleep((long) (Math.random() * 7000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void run(){
        router.connect(this);
        perform_online_activity();
        router.Log_out(this);
    }

}

class Semaphore {

    protected int value = 0;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int initial) {
        value = initial;
    }

    public synchronized void P(Device device) {
        value--;
        if (value < 0){
            System.out.println("(" + device.get_name() + ") (" + device.get_type() + ") arrived and waiting");
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        else{
            System.out.println("(" + device.get_name() + ") (" + device.get_type() + ") arrived");
        }
    }

    public synchronized void V() {
        value++;
        if (value <= 0)
            notify();
    }

}

class Router {
    private Semaphore semaphore;
    private ArrayList<Device> connections;
    private int size;

    public Router(int sz) {
        size = sz;
        connections = new ArrayList<>();
        this.semaphore = new Semaphore(size);
    }

    public void connect(Device device) {
        semaphore.P(device);
        if (connections.size() < size) {
            connections.add(device);
            System.out.println(device.get_name() + " Occupied");
        }
    }

    public void Log_out(Device device) {
        connections.remove(device);
        System.out.println(device.get_name() + " Logged out");
        semaphore.V();
    }
}
public class Network {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the max number of connected devices in the same time: ");
        int maxConnections = scanner.nextInt();
        System.out.println("Enter the number of devices: ");
        int totalDevices = scanner.nextInt();
        scanner.nextLine();

        List<Device> devices = new ArrayList<>();
        Router router = new Router(maxConnections);

        for (int i = 1; i <= totalDevices; i++) {
            String device_Name = "C" + i;
            System.out.println("Enter the type of device " + device_Name + ": ");
            String deviceType = scanner.nextLine();
            Device device = new Device(device_Name, deviceType, router);
            devices.add(device);
        }

        for (Device device : devices) {
            device.start();
        }
    }

}
