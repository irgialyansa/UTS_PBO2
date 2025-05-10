    import java.util.Scanner;
public class FiturStokObat {
    // ARRAY 2 DIMENSI DAN NESTED LOOP
    private static final String[][] stokObat = {
        { "Obat Batuk", "20" },
        { "Obat Pilek", "20" },
        { "Obat Pusing", "20" }
    };
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n--- Menu Kelola Stok Obat ---");
            System.out.println("1. Tampilkan Detail Stok Obat");
            System.out.println("2. Tambah Stok Obat");
            System.out.println("3. Kurangi Stok Obat");
            System.out.println("4. Keluar");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanDetailStok(stokObat);
                    break;
                case 2:
                    tambahStok(stokObat);
                    break;
                case 3:
                    kurangiStok(stokObat);
                    break;
                case 4:
                    System.out.println("..Terima kasih..");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Harap masukkan angka antara 1 dan 4.");
            }
        } while (pilihan != 4);
    }

    private static void tampilkanDetailStok(String[][] obatList) {
        System.out.println("\nDetail Stok Obat:");
        for (String[] obat : obatList) {
            int stok = Integer.parseInt(obat[1]);
            System.out.println("Obat: " + obat[0] + ", Stok: " + stok);

            // Nested loop untuk mencetak karakter '*' sebanyak stok obat
            for (int i = 0; i < stok; i++) {
                System.out.print("*");
            }
            System.out.println(); // Pindah baris setelah mencetak stok obat
        }
    }

    private static void tambahStok(String[][] obatList) {
        System.out.print("Masukkan nama obat untuk menambah stok: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;
        for (String[] obat : obatList) {
            if (obat[0].equalsIgnoreCase(nama)) {
                boolean inputValid = false;
                int jumlah = 0;
                while (!inputValid) {
                    System.out.print("Masukkan jumlah stok yang akan ditambahkan untuk " + obat[0] + ": ");
                    String inputJumlah = scanner.nextLine();
                    if (inputJumlah.matches("\\d+")) {
                        jumlah = Integer.parseInt(inputJumlah);
                        if (jumlah >= 0) {
                            inputValid = true;
                        } else {
                            System.out.println("Jumlah stok tidak boleh negatif.");
                        }
                    } else {
                        System.out.println("Masukkan angka yang valid.");
                    }
                }
                int stokSaatIni = Integer.parseInt(obat[1]);
                obat[1] = Integer.toString(stokSaatIni + jumlah);
                ditemukan = true;
                System.out.println("Stok obat " + obat[0] + " ditambahkan sebanyak " + jumlah);
                System.out.println("Jumlah stok saat ini: " + obat[1]);
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Obat tidak ditemukan dalam daftar stok.");
        }
    }

    private static void kurangiStok(String[][] obatList) {
        System.out.print("Masukkan nama obat untuk mengurangi stok: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;
        for (String[] obat : obatList) {
            if (obat[0].equalsIgnoreCase(nama)) {
                boolean inputValid = false;
                int jumlah = 0;
                while (!inputValid) {
                    System.out.print("Masukkan jumlah yang akan dikurangi dari stok " + obat[0] + ": ");
                    String inputJumlah = scanner.nextLine();
                    if (inputJumlah.matches("\\d+")) {
                        jumlah = Integer.parseInt(inputJumlah);
                        int stokSaatIni = Integer.parseInt(obat[1]);
                        if (jumlah >= 0 && jumlah <= stokSaatIni) {
                            inputValid = true;
                        } else {
                            System.out.println("Jumlah tidak valid. Tidak boleh negatif atau lebih dari stok saat ini.");
                        }
                    } else {
                        System.out.println("Masukkan angka yang valid.");
                    }
                }
                int stokSaatIni = Integer.parseInt(obat[1]);
                obat[1] = Integer.toString(stokSaatIni - jumlah);
                ditemukan = true;
                System.out.println("Stok obat " + obat[0] + " dikurangi sebanyak " + jumlah);
                System.out.println("Jumlah stok saat ini: " + obat[1]);
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Obat tidak ditemukan dalam daftar stok.");
        }
    }
}
    

