
import java.util.Scanner;


class Mahasiswa {

	// Atribut yang dimiliki setiap mahasiswa
    String nama;
    String nim;
    String jurusan;
    private double ipk; // private = hanya bisa diakses lewat getter/setter

    // Constructor 
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama    = nama;
        this.nim     = nim;
        this.jurusan = jurusan;
        this.ipk     = ipk;
    }

    // Getter - satu-satunya cara baca nilai ipk dari luar class
    public double getIpk() {
        return ipk;
    }

    // Setter - satu-satunya cara ubah nilai ipk dari luar class
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Method untuk tampilkan semua info mahasiswa ke konsol
    public void tampilkanInfo() {
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK     : " + ipk);
    }

    // Method cek status kelulusan 
    public void cekKelulusan() {
        if (ipk >= 3.00) {
            System.out.println("Status  : Lulus");
        } else {
            System.out.println("Status  : Belum Lulus");
        }
    }

    // Method untuk update IPK mahasiswa
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }

    // Method untuk hitung dan tampilkan predikat akademik berdasarkan IPK
    public void hitungPredikat() {
        String predikat;

        if (ipk >= 3.75) {
            predikat = "Dengan Pujian";
        } else if (ipk >= 3.50) {
            predikat = "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            predikat = "Memuaskan";
        } else {
            predikat = "Perlu Perbaikan";
        }

        System.out.println("Predikat: " + predikat);
    }
}

public class Main {

    public static void main(String[] args) {

        // Buat array untuk menyimpan 5 objek mahasiswa
        Mahasiswa[] daftar = new Mahasiswa[5];

        // Isi data masing-masing mahasiswa ke dalam array
        daftar[0] = new Mahasiswa("Andi Pratama",   "2440001", "Teknik Informatika", 3.75);
        daftar[1] = new Mahasiswa("Budi Santoso",   "2440002", "Sistem Informasi",   3.40);
        daftar[2] = new Mahasiswa("Citra Lestari",  "2440003", "Teknik Informatika", 3.90);
        daftar[3] = new Mahasiswa("Joni Suhartono", "2440004", "Teknik Industri",    3.00);
        daftar[4] = new Mahasiswa("Bulan Suci",     "2440005", "Akuntansi",          3.20);

        // Tampilkan semua data mahasiswa dulu sebelum ada update
        System.out.println("=== Data Mahasiswa ===");
        for (int i = 0; i < daftar.length; i++) {
            daftar[i].tampilkanInfo();
            System.out.println();
        }

        // Scan input pengguna
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.nextLine();

        System.out.print("Masukkan IPK baru: ");
        double ipkBaru = scanner.nextDouble();

        // Cari mahasiswa yang NIM-nya cocok dengan input
        boolean ketemu = false;
        for (int i = 0; i < daftar.length; i++) {
            if (daftar[i].nim.equals(nimInput)) {

                daftar[i].updateIpk(ipkBaru);

                // Tampilkan info terbaru + status kelulusan
                System.out.println("\nData berhasil diperbarui!");
                System.out.println("=== Data Mahasiswa ===");
                daftar[i].tampilkanInfo();
                daftar[i].cekKelulusan();

                ketemu = true;
                break; // stop looping setelah ketemu
            }
        }

        if (!ketemu) {
            System.out.println("NIM tidak ditemukan di dalam data.");
        }

        // Tampilkan data lengkap semua mahasiswa beserta predikat akademiknya
        System.out.println("\n=== Data Lengkap Semua Mahasiswa (Dengan Predikat) ===");
        for (int i = 0; i < daftar.length; i++) {
            System.out.println("-------------------------------");
            daftar[i].tampilkanInfo();
            daftar[i].cekKelulusan();
            daftar[i].hitungPredikat();
            System.out.println();
        }

        scanner.close();
    }
}
