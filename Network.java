import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the max number of conected devices in same time: ");
        int capacity = input.nextInt();
        Router router = new Router(capacity);
        
        int deviceCount;
        System.out.println("Enter the number of devices: ");
        deviceCount = input.nextInt();
        Device[] devices = new Device[deviceCount];

        for (int i = 0; i < deviceCount; i++) {

            System.out.println("Enter the type of device " + (i + 1) + ": ");
            String type = input.next();
            devices[i] = new Device("C" + (i + 1), type, router);
        }
        for (int i = 0; i < deviceCount; i++) {
            devices[i].start();
        }



    }
}
