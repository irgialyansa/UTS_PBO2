import java.util.Scanner;

public class KasirApotekFinal {

    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Aplikasi Apotek");
        System.out.println("Apakah Anda pengguna (1) atau admin (2)?");
        int role = scanner.nextInt();

        if (role == 1) {
            fiturUser();
        } else if (role == 2) {
            System.out.print("Masukkan password admin: ");
            String password = scanner.next();

            if (password.equals(ADMIN_PASSWORD)) {
                fiturAdmin();
            } else {
                System.out.println("Password salah. Aplikasi akan ditutup.");
            }
        } else {
            System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
        }
    }
    private static void fiturUser() {
        // The fiturIdentifikasiKadaluwarsa() is removed from here
        // as it is now part of fiturAdmin()
        System.out.println("\n--- Fitur User ---");
        System.out.println("1. Pembayaran");
        System.out.println("2. Exit");
        System.out.print("Masukkan pilihan Anda: ");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                fiturPembayaran();
            case 2:
                System.out.println("...Terimakasih 1....");
                break;
            default:
                System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
        }
    }

    private static void fiturAdmin() {
        System.out.println("\n--- Fitur Admin ---");
        System.out.println("1. Kelola Stok Obat");
        System.out.println("2. Identifikasi Kadaluwarsa");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan Anda: ");

        Scanner scanner = new Scanner(System.in);
        int adminChoice = scanner.nextInt();

        switch (adminChoice) {
            case 1:
                fiturKelolaStokObat();
                break;
            case 2:
                fiturIdentifikasiKadaluwarsa();
                break;
            case 3:
                System.out.println("..Terima kasih 2..");
                break;
            default:
                System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
        }
    }

    private static void fiturKelolaStokObat() {
        // Implementasi fiturKelolaStokObat
        
            String[][] stokObat = {
                { "Obat Batuk", "20" },
                { "Obat Pilek", "20" },
                { "Obat Pusing", "20" }
            };
            Scanner scanner = new Scanner(System.in);
        
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
                        System.out.println("..Terima kasih 3..");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Harap masukkan angka antara 1 dan 4.");
                }
            } 
            while (pilihan != 4);
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
            Scanner scanner0 = new Scanner(System.in);
            String nama = scanner0.nextLine();
            boolean ditemukan = false;
            for (String[] obat : obatList) {
                if (obat[0].equalsIgnoreCase(nama)) {
                    boolean inputValid = false;
                    int jumlah = 0;
                    while (!inputValid) {
                        System.out.print("Masukkan jumlah stok yang akan ditambahkan untuk " + obat[0] + ": ");
                        String inputJumlah = scanner0.nextLine();
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
            Scanner scanner1 = new Scanner(System.in);
            String nama = scanner1.nextLine();
            boolean ditemukan = false;
            for (String[] obat : obatList) {
                if (obat[0].equalsIgnoreCase(nama)) {
                    boolean inputValid = false;
                    int jumlah = 0;
                    while (!inputValid) {
                        System.out.print("Masukkan jumlah yang akan dikurangi dari stok " + obat[0] + ": ");
                        String inputJumlah = scanner1.nextLine();
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
        
    

    private static void fiturIdentifikasiKadaluwarsa() {
            Scanner input = new Scanner (System.in);
            
            char Tgl_Kadaluwarsa, metode_pembuangan;
        
            System.out.println("Obat kadaluwarsa? \na.Iya \nb.Tidak");
            Tgl_Kadaluwarsa = input.next().charAt(0);
        
            if (Tgl_Kadaluwarsa == 'a' ) {
                System.out.println("Pilih metode pembuangan :\na) Penghancuran dengan penghancur obat khusus,\nb) Pengembalian ke pemasok obat, \nc) Pembuangan di tempat pembuangan obat yang aman,yang biasanya dikelola oleh pemerintah setempat.");
                metode_pembuangan = input.next().charAt(0);
                if (metode_pembuangan == 'a'){
                    System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
                }
                else if (metode_pembuangan == 'b'){
                    System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
                }
                else if (metode_pembuangan == 'c'){
                    System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
                }
                else {
                    System.out.println("Terjadi Kesalahan");
                }
            }
            else if (Tgl_Kadaluwarsa == 'b') {
                System.out.println("Obat masih valid");    
            }
            else {
                System.out.println("Terjadi Kesalahan");
            }
        }

    private static void fiturPembayaran() {
    Scanner sc = new Scanner(System.in);

    int total = 0;
    String[] jenisObatan = {"Obat Batuk", "Obat Pilek", "Obat Pusing"};

    System.out.println("Daftar Jenis Obat di Apotek:");
    for (int i = 0; i < jenisObatan.length; i++) {
        System.out.println((i + 1) + ". " + jenisObatan[i]);
    }

    System.out.print("Masukkan nomor jenis obat yang ingin Anda pilih: ");
    int nomorJenisObat = sc.nextInt();

    if (nomorJenisObat >= 1 && nomorJenisObat <= jenisObatan.length) {
        String namaJenisObat = jenisObatan[nomorJenisObat - 1];
        System.out.println("Anda memilih jenis obat: " + namaJenisObat + "\n");

        boolean memilihObatLagi = true;
        while (memilihObatLagi) {
            String[] namaObat;
            int[] hargaObat;

            if (namaJenisObat.equals("Obat Batuk")) {
                namaObat = new String[]{"Actifed cough", "Woods Antitussive", "Sanadryl DMP", "Siladex Antitussive", "Vicks Formula 44 Syrup", "Benadryl Original", "Bodrex Flu & Batuk PE", "Konidin", "Anadex", "Vectrine Dry Syrup"};
                hargaObat = new int[]{20000, 25000, 22000, 18000, 30000, 19000, 21000, 28000, 24000, 26000};
            } else if (namaJenisObat.equals("Obat Pilek")) {
                namaObat = new String[]{"Actifed Plus Expectorant", "Siladex Batuk dan Pilek", "Triaminic Expectorant & Pilek", "OBH Tropica Extra", "Pim-Tra-Kol", "Po Loong Pills", "Nalgestan", "Triaminic Batuk & Pilek", "Paratusin", "Silex"};
                hargaObat = new int[]{22000, 26000, 23000, 21000, 25000, 27000, 24000, 20000, 23000, 25000};
            } else {
                namaObat = new String[]{"Puyer Bintang Toedjoe", "Panadol Extra Tablet", "Bodrex", "Paramex", "Poldan Mig", "Tolak Angin Tablet", "Biogesic", "Decolgen Fx Tablet", "Pamol"};
                hargaObat = new int[]{15000, 18000, 16000, 20000, 19000, 17000, 21000, 22000, 17000};
            }

            System.out.println("\nDaftar Nama Obat untuk jenis " + namaJenisObat + ":");
            for (int i = 0; i < namaObat.length; i++) {
                System.out.println((i + 1) + ". " + namaObat[i] + " - Harga: Rp." + hargaObat[i] + ",-");
            }

            System.out.print("Masukkan nomor obat yang Anda pilih: ");
            int nomorObat1 = sc.nextInt();

            if (nomorObat1 >= 1 && nomorObat1 <= namaObat.length) {
                String obatTerpilih = namaObat[nomorObat1 - 1];
                int hargaTerpilih = hargaObat[nomorObat1 - 1];
                System.out.println("\n" + "Obat yang Anda pilih adalah: " + obatTerpilih);
                System.out.println("Harga obat yang Anda pilih: Rp." + hargaTerpilih + ",-");
                total += hargaTerpilih;
            } else {
                System.out.println("Mohon pilih nomor obat yang benar.");
            }

            System.out.print("Apakah Anda ingin memilih obat lain (y/t)? : " + "\n");
            String pilihan = sc.next();
            if (pilihan.equalsIgnoreCase("t")) {
                memilihObatLagi = false;
                System.out.println("\nTotal harga obat yang dipilih : Rp." + total + ",-");
            if (total > 100000) {
                System.out.println("\nApakah Anda ingin mendapatkan diskon (y/t)? ");
                String inginDiskonInput = sc.next();
                if (inginDiskonInput.equalsIgnoreCase("y")) {
                    System.out.println("Apakah Anda mempunyai kartu member (y/t)? ");
                    String kartuMember = sc.next();
                    if (kartuMember.equalsIgnoreCase("y")) {
                        if (total >= 100000 && total <= 500000) {
                            double dis = 0;
                            int poin = 0;
                            if (total < 200000) {
                                dis = 0.2;
                                poin = 5;
                            } else if (total < 300000) {
                                dis = 0.25;
                                poin = 10;
                            } else if (total < 400000) {
                                dis = 0.3;
                                poin = 15;
                            } else if (total <= 500000) {
                                dis = 0.35;
                                poin = 20;
                            }
                            double diskonAmount = total * dis;
                            System.out.println("Selamat Anda dapat diskon " + (dis * 100) + "% dan mendapatkan tambahan poin " + poin + ", silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize" + "\n" + "Total harga yang harus ada bayar adalah :" + (total - (total * dis)));
                        }
    
                    } else {
                        System.out.println("Daftar sekarang! Isi biodata Anda!");
                        System.out.print("Nama: ");
                        String nama = sc.next();
                        System.out.print("Umur: ");
                        String umur = sc.next();
                        System.out.print("Tempat Tanggal Lahir: ");
                        String tmptTglLahir = sc.next();
                        System.out.print("Alamat: ");
                        String alamat = sc.next();
                        System.out.print("Email: ");
                        String email = sc.next();
                        System.out.print("Password: ");
                        String password = sc.next();
                        System.out.println("Selamat dengan nama\n" + nama + "\ntelah menjadi Member Premium");
                
                    }
                } else {
                    System.out.println("Total harga yang harus dibayar sebanyak : Rp." + total + ",-");
                    break;
                    }
                } 
            } 
        }
    }
} 
    }
