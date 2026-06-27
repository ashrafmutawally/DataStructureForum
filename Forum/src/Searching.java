
import java.util.Scanner;

public class Searching {

    static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int target) {

        int kiri  = 0;
        int kanan = arr.length - 1;

        while (kiri <= kanan) {

            int tengah = (kiri + kanan) / 2;

            if (arr[tengah] == target) {
                return tengah;

            } else if (arr[tengah] < target) {
                kiri = tengah + 1;

            } else {
                kanan = tengah - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arrayAcak = { 42, 7, 19, 55, 3, 88, 24, 61 };

        int[] arrayUrut = { 3, 7, 15, 22, 34, 48, 67, 81, 95 };

        System.out.println("=================================================");
        System.out.println("     LATIHAN SEARCHING - Data Structure");
        System.out.println("=================================================");

        System.out.print("\nArray acak  (Linear Search) : ");
        for (int n : arrayAcak) System.out.print(n + " ");

        System.out.print("\nArray terurut (Binary Search): ");
        for (int n : arrayUrut) System.out.print(n + " ");

        System.out.println("\n");

        System.out.println("Pilih metode pencarian:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = scanner.nextInt();

        System.out.print("Masukkan angka yang ingin dicari: ");
        int target = scanner.nextInt();

        System.out.println();

        if (pilihan == 1) {

            System.out.println(">> Menggunakan LINEAR SEARCH...");
            System.out.println("   (Cek satu per satu dari index 0)");

            int hasil = linearSearch(arrayAcak, target);

            if (hasil != -1) {
                System.out.println("\nAngka " + target + " DITEMUKAN di index ke-" + hasil);
                System.out.println("(Index mulai dari 0, jadi ini elemen ke-" + (hasil + 1) + " dalam array)");
            } else {
                System.out.println("\nAngka " + target + " TIDAK ditemukan dalam array.");
            }

        } else if (pilihan == 2) {

            System.out.println(">> Menggunakan BINARY SEARCH...");
            System.out.println("   (Array wajib terurut! Cari dari tengah, bagi dua terus)");

            int hasil = binarySearch(arrayUrut, target);

            if (hasil != -1) {
                System.out.println("\nAngka " + target + " DITEMUKAN di index ke-" + hasil);
                System.out.println("(Index mulai dari 0, jadi ini elemen ke-" + (hasil + 1) + " dalam array)");
            } else {
                System.out.println("\nAngka " + target + " TIDAK ditemukan dalam array.");
            }

        } else {
            System.out.println("Pilihan tidak valid. Masukkan 1 atau 2.");
        }

        scanner.close();
    }
}
