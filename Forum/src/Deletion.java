
import java.util.Scanner;

public class Deletion {

    static int hapusByIndex(int[] arr, int ukuran, int index) {

        if (index < 0 || index >= ukuran) {
            System.out.println("Index tidak valid!");
            return ukuran;
        }

        for (int i = index; i < ukuran - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return ukuran - 1;
    }

    static int hapusByNilai(int[] arr, int ukuran, int nilai) {

        int index = -1;
        for (int i = 0; i < ukuran; i++) {
            if (arr[i] == nilai) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Nilai " + nilai + " tidak ditemukan dalam array.");
            return ukuran;
        }

        System.out.println("Nilai " + nilai + " ditemukan di index ke-" + index + ", menghapus...");
        return hapusByIndex(arr, ukuran, index);
    }

    static void tampilArray(int[] arr, int ukuran) {
        System.out.print("Isi array : [ ");
        for (int i = 0; i < ukuran; i++) {
            System.out.print(arr[i]);
            if (i < ukuran - 1) System.out.print(", ");
        }
        System.out.println(" ]");
        System.out.println("Ukuran    : " + ukuran + " elemen");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = { 10, 25, 37, 48, 56, 63, 79, 0, 0, 0 };
        int ukuran = 7;

        System.out.println("=================================================");
        System.out.println("     LATIHAN DELETION - Data Structure");
        System.out.println("=================================================");

        System.out.println("\nData awal:");
        tampilArray(arr, ukuran);

        System.out.println("\nPilih metode penghapusan:");
        System.out.println("1. Hapus berdasarkan INDEX");
        System.out.println("2. Hapus berdasarkan NILAI");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = scanner.nextInt();

        System.out.println();

        if (pilihan == 1) {

            System.out.println(">> Hapus berdasarkan INDEX");
            System.out.print("Masukkan index yang ingin dihapus (0 - " + (ukuran - 1) + "): ");
            int index = scanner.nextInt();

            System.out.println("\nSebelum dihapus:");
            tampilArray(arr, ukuran);

            ukuran = hapusByIndex(arr, ukuran, index);

            System.out.println("\nSetelah elemen index ke-" + index + " dihapus:");
            tampilArray(arr, ukuran);

        } else if (pilihan == 2) {

            System.out.println(">> Hapus berdasarkan NILAI");
            System.out.print("Masukkan nilai yang ingin dihapus: ");
            int nilai = scanner.nextInt();

            System.out.println("\nSebelum dihapus:");
            tampilArray(arr, ukuran);

            ukuran = hapusByNilai(arr, ukuran, nilai);

            System.out.println("\nSetelah nilai " + nilai + " dihapus:");
            tampilArray(arr, ukuran);

        } else {
            System.out.println("Pilihan tidak valid. Masukkan 1 atau 2.");
        }

        scanner.close();
    }
}