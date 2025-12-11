import java.util.Scanner;

public class PemesananCafe10 {

    static String[] daftarMenu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
    static int[] daftarHarga = {15000, 22000, 12000, 18000};

    static String[] namaPelangganData = new String[100];
    static int[] nomorMejaData = new int[100];
    static int[][] jumlahPerItemData = new int[100][4];
    static int[] totalHargaData = new int[100];
    static int jumlahPesanan = 0;
    
    static Scanner scanner = new Scanner(System.in);
    
    static void tampilMenuUtama() {
        System.out.println("===== MENU UTAMA =====");
        System.out.println("1. Tambahkan Pesanan");
        System.out.println("2. Tampilkan Daftar Pesanan");
        System.out.println("3. Keluar");
    }

    static void tampilMenuKafe() {
        System.out.println("\n===== MENU KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15.000");
        System.out.println("2. Latte      - Rp 22.000");
        System.out.println("3. Teh Tarik  - Rp 12.000");
        System.out.println("4. Mie Goreng - Rp 18.000");
    }

    static void tampilDaftarPesanan() {
        System.out.println("\n===== DAFTAR PESANAN =====");
        while (jumlahPesanan == 0) {
            System.out.println("Belum ada pesanan.");
            System.out.println();
            return;
        }
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Nama pelanggan: " + namaPelangganData[i]);
            System.out.println("Nomor meja: " + nomorMejaData[i]);
            System.out.println("Detail pesanan:");
            for (int j = 0; j < daftarMenu.length; j++) {
                if (jumlahPerItemData[i][j] > 0) {
                    System.out.println("- " + daftarMenu[j] + " x " + jumlahPerItemData[i][j] + " = Rp " + (daftarHarga[j] * jumlahPerItemData[i][j]));
                }
            }
            System.out.println("Total harga pesanan: Rp " + totalHargaData[i]);
            System.out.println("-------------------------");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan = 0;
        while (pilihan != 3) {
            tampilMenuUtama();
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            if (pilihan == 1) {
                System.out.print("\nMasukkan nama pelanggan: ");
                String namaPelanggan = sc.next();
                System.out.print("Masukkan nomor meja: ");
                int nomorMeja = sc.nextInt();
                tampilMenuKafe();
                int totalHarga = 0;
                int[] jumlahPerItem = new int[4];
                while (true) {
                    System.out.print("\nPilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
                    int pesanan = sc.nextInt();
                    if (pesanan == 0) {
                        break;
                    } else if (pesanan == 1) {
                        System.out.print("Masukkan jumlah item untuk " + daftarMenu[0] + ": ");
                        int jumlahItem = sc.nextInt();
                        jumlahPerItem[0] = jumlahItem;
                        totalHarga += daftarHarga[0] * jumlahItem;
                        continue;
                    } else if (pesanan == 2) {
                        System.out.print("Masukkan jumlah item untuk " + daftarMenu[1] + ": ");
                        int jumlahItem = sc.nextInt();
                        jumlahPerItem[1] = jumlahItem;
                        totalHarga += daftarHarga[1] * jumlahItem;
                        continue;
                    } else if (pesanan == 3) {
                        System.out.print("Masukkan jumlah item untuk " + daftarMenu[2] + ": ");
                        int jumlahItem = sc.nextInt();
                        jumlahPerItem[2] = jumlahItem;
                        totalHarga += daftarHarga[2] * jumlahItem;
                        continue;
                    } else if (pesanan == 4) {
                        System.out.print("Masukkan jumlah item untuk " + daftarMenu[3] + ": ");
                        int jumlahItem = sc.nextInt();
                        jumlahPerItem[3] = jumlahItem;
                        totalHarga += daftarHarga[3] * jumlahItem;
                        continue;
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
                namaPelangganData[jumlahPesanan] = namaPelanggan;
                nomorMejaData[jumlahPesanan] = nomorMeja;
                jumlahPerItemData[jumlahPesanan] = jumlahPerItem;
                totalHargaData[jumlahPesanan] = totalHarga;
                jumlahPesanan++;
                System.out.println("Pesanan berhasil ditambahkan.");
                System.out.println("Total harga pesanan: Rp " + totalHarga);
            } else if (pilihan == 2) {
                tampilDaftarPesanan();
            } else if (pilihan == 3) {
                System.out.println("Terima kasih telah menggunakan aplikasi pemesanan kafe.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        sc.close();
    }
}