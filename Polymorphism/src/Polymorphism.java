
class Firewall {

    public void tampilkanInfo() {
        System.out.println("Perangkat ini adalah Firewall.");
    }
}

// Subclass 1
class FortiGate60F extends Firewall {

    @Override
    public void tampilkanInfo() {
        System.out.println("FortiGate 60F digunakan untuk kantor kecil.");
    }
}

// Subclass 2
class FortiGate100F extends Firewall {

    @Override
    public void tampilkanInfo() {
        System.out.println("FortiGate 100F digunakan untuk perusahaan menengah.");
    }
}

// Main Class
public class Polymorphism {
    public static void main(String[] args) {

        Firewall fw1 = new FortiGate60F();
        Firewall fw2 = new FortiGate100F();

        fw1.tampilkanInfo();
        fw2.tampilkanInfo();
    }
}