

class Firewall {
    String brand;
    String ipAddress;

    public Firewall(String brand, String ipAddress) {
        this.brand = brand;
        this.ipAddress = ipAddress;
    }

    public void tampilkanInfo() {
        System.out.println("Brand      : " + brand);
        System.out.println("IP Address : " + ipAddress);
    }
}

// Subclass
class FortiGate extends Firewall {
    String model;
    String serialNumber;

    public FortiGate(String brand, String ipAddress,
                     String model, String serialNumber) {

        super(brand, ipAddress);
        this.model = model;
        this.serialNumber = serialNumber;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Model      : " + model);
        System.out.println("Serial No  : " + serialNumber);
    }
}

// Main Class
public class Inheritance {
    public static void main(String[] args) {

        FortiGate fg1 = new FortiGate(
                "Fortinet",
                "192.168.1.1",
                "FortiGate 100F",
                "FG100F123456789"
        );

        System.out.println("=== Data Firewall ===");
        fg1.tampilkanInfo();
    }
}