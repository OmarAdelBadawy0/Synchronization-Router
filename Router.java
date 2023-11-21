import java.util.ArrayList;
import java.util.List;


public class Router {
    
    private List<Device> devices = new ArrayList<>();
    private int capacity;
    private Semaphore semaphore;

    public Router(int capacity) {
        this.capacity = capacity;
        this.semaphore = new Semaphore(capacity);
        this.devices = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Device> getdevices() {
        return devices;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setdevices(List<Device> devices) {
        this.devices = devices;
    }


    public synchronized void Occupy(Device device) {
        semaphore.P();

        if (capacity != 0) {
            capacity--;
            devices.add(device);
            System.out.println("(" + device.get_Name() + ") (" + device.getType() + ")" + " arrived");
            System.out.println(" " +device.get_Name() + " occupied");
        } else {
            System.out.println("(" + device.get_Name() + ") (" + device.getType() + ") - Waiting");
        }
    }

    public synchronized void exit(Device device) {
        capacity++;
        devices.remove(device);
        System.out.println(" " + device.get_Name() + " Logged out");
        semaphore.V();
    }

}

