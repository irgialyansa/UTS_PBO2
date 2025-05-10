import java.util.Scanner;
import java.util.ArrayList;

public class KASIRFIX {
 private static String semua = "";
 private static int totalTransaksiPembayaran = 0;
 private static int[] totalTransaksi = new int[100]; // Anggap maksimum 100 transaksi, sesuaikan jika diperlukan
 private static int[] totalPembelian = new int[100];
 private static int indeksTransaksi = 0;
 private static final String ADMIN_PASSWORD = "admin123";
 private static Scanner scanner = new Scanner(System.in);
 private static boolean ulangProgram = true;
 private static boolean ulangProgram1 = true;
 private static boolean balik = true;
 private static int hargaTerpilih = 0;
 private static int total = 0;
 private static ArrayList<String> obatDibeli = new ArrayList<>();
 private static ArrayList<Integer> hargaDibeli = new ArrayList<>();

 // BAGIAN PENENTUAN ADMIN ATAU USER //
 public static void main(String[] args) {
  ulangProgram = true;

  do {
   System.out.println("Selamat datang di Aplikasi Apotek!");
   System.out.println("==== Selamat Berbelanja! ====");
   System.out.println("--------------------------------------------");
   System.out.print("Apakah Anda pengguna (1) | admin (2)? ");

   char multi = scanner.next().charAt(0);

   if (multi == '1') {
    fiturUser();

   } else if (multi == '2') {
    System.out.print("\nMasukkan password admin: ");
    String password = scanner.next();

    if (password.equals(ADMIN_PASSWORD)) {
     fiturAdmin();

    } else {
     System.out.println("Password salah. Aplikasi akan ditutup.");
     System.exit(0);
    }

   } else {
    System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
    System.exit(0);
   }
   if (!tanyaUlangProgram()) {
    ulangProgram = false;
    break; // Keluar dari loop do-while di main
   }

  } while (ulangProgram);
  System.out.println("Terima kasih telah menggunakan Aplikasi Apotek. Sampai jumpa lagi!");
  scanner.close();
 }

 // BAGIAN ADMIN //

 private static void fiturAdmin() {
  int adminChoice;

  do {
   System.out.println("\n--- Fitur Admin ---");
   System.out.println("Selamat datang, admin! Silahkan pilih salah satu!");
   System.out.println("1. Kelola Stok Obat");
   System.out.println("2. Identifikasi Kadaluwarsa");
   System.out.println("3. Total Transaksi");
   System.out.println("4. Mengulang program (menu utama)");
   System.out.println("5. Keluar");
   System.out.print("Masukkan pilihan Anda (berupa angka): ");
   adminChoice = scanner.nextInt();

   switch (adminChoice) {
    case 1:
     fiturKelolaStokObat();
     break;
    case 2:
     fiturIdentifikasiKadaluwarsa();
     break;
    case 3:
     lihatTotalTransaksi();
     break;
    case 4:
     ulangProgram = true;
     return;
    case 5:
     System.out.println("..Keluar..");
     System.exit(0);
     break;
    default:
     System.out.println("=============================================================");
     System.out.println("Pilihan tidak sesuai (1),(2),(3) dan (4), Coba lagi!");
   }
  } while (adminChoice != 4);
 }

 private static void fiturKelolaStokObat() {
  int pilihan;

  String[][] stokObat = {
    { "Batuk", "20" },
    { "Pilek", "20" },
    { "Pusing", "20" }
  };

  do {
   System.out.println("\n--- Menu Kelola Stok Obat ---");
   System.out.println("1. Tampilkan Detail Stok Obat");
   System.out.println("2. Tambah Stok Obat");
   System.out.println("3. Kurangi Stok Obat");
   System.out.println("4. Kembali ke menu");
   System.out.println("5. Keluar");
   System.out.print("\nMasukkan pilihan Anda (berupa angka):  ");

   pilihan = scanner.nextInt();

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
     System.out.println("----------------------------");
     System.out.println("...kembali ke menu...");
     return;
    case 5:
     System.out.println("..Keluar..");
     System.exit(0);
     break;
    default:
     System.out.println("Pilihan tidak valid, harap masukkan angka 1-4!");
   }
  } while (pilihan != 5);
 }

 private static void tampilkanDetailStok(String[][] obatList) {
  System.out.println("\nDetail Stok Obat:");
  for (String[] obat : obatList) {
   int stok = Integer.parseInt(obat[1]);
   System.out.println("Obat: " + obat[0] + ", Stok: " + stok);

   for (int i = 0; i < stok; i++) {
    System.out.print("*");
   }
   System.out.println();
  }

 }

 private static void tambahStok(String[][] obatList) {
  scanner.nextLine();
  System.out.print("\nMasukkan nama obat untuk menambah stok : ");
  String nama = scanner.nextLine();

  boolean ditemukan = false;

  for (String[] obat : obatList) {
   if (obat[0].equalsIgnoreCase(nama)) {
    boolean inputValid = false;
    int jumlah = 0;

    while (!inputValid) {
     System.out.print("\nMasukkan jumlah stok yang akan ditambahkan untuk " + obat[0] + ": ");

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
    System.out.println("----------------------------------------------------------");
    System.out.println("Stok " + obat[0] + " ditambahkan sebanyak : " + jumlah);
    System.out.println("Jumlah stok saat ini: " + obat[1]);
    return;
   }
  }

  if (!ditemukan) {
   System.out.println("\nObat tidak ditemukan dalam daftar stok.");
   System.out.println("Masukkan yang benar!");
   System.out.println("\n...kembali ke menu kelola..");
   return;
  }
  scanner.close();
 }

 private static void kurangiStok(String[][] obatList) {
  scanner.nextLine();
  System.out.print("\nMasukkan nama obat untuk mengurangi stok : ");
  String nama = scanner.nextLine();
  boolean ditemukan = false;

  for (String[] obat : obatList) {
   if (obat[0].equalsIgnoreCase(nama)) {
    boolean inputValid = false;
    int jumlah = 0;

    while (!inputValid) {
     System.out.print("\nMasukkan jumlah yang akan dikurangi dari stok " + obat[0] + ": ");
     String inputJumlah = scanner.nextLine();

     if (inputJumlah.matches("\\d+")) {
      jumlah = Integer.parseInt(inputJumlah);
      int stokSaatIni = Integer.parseInt(obat[1]);

      if (jumlah >= 0 && jumlah <= stokSaatIni) {
       inputValid = true;
       break;

      } else {
       System.out
         .println("Jumlah tidak valid. Tidak boleh negatif atau lebih dari stok saat ini.");
      }
     } else {
      System.out.println("Masukkan angka yang valid.");
     }
    }

    int stokSaatIni = Integer.parseInt(obat[1]);
    obat[1] = Integer.toString(stokSaatIni - jumlah);
    ditemukan = true;
    System.out.println("Stok " + obat[0] + " dikurangi sebanyak : " + jumlah);
    System.out.println("Jumlah stok saat ini: " + obat[1]);
    return;
   }
  }

  if (!ditemukan) {
   System.out.println("Obat tidak ditemukan dalam daftar stok.");
   System.out.println("Masukkan yang benar!");
   System.out.println("\n...kembali ke menu kelola..");
   return;
  }
  scanner.close();
 }

 private static void fiturIdentifikasiKadaluwarsa() {
  Scanner input = new Scanner(System.in);
  char Tgl_Kadaluwarsa, metode_pembuangan;
  boolean ulangLagi = true;

  do {
   System.out.println("\n--- Menu kelola obat kadaluwarsa ---");
   System.out.println("Obat kadaluwarsa? | a.Iya | b.Tidak |");
   System.out.print("Masukkan disini (a) / (b) : ");
   Tgl_Kadaluwarsa = input.next().charAt(0);

   if (Tgl_Kadaluwarsa == 'a') {
    System.out.println(
      "\nPilih metode pembuangan :\na) Penghancuran dengan penghancur obat khusus,\nb) Pengembalian ke pemasok obat, \nc) Pembuangan di tempat pembuangan obat yang aman,yang biasanya dikelola oleh pemerintah setempat.");
    System.out.print("Pilih salah satu : ");
    metode_pembuangan = input.next().charAt(0);

    if (metode_pembuangan == 'a') {
     System.out.println("------------------------------------------------------------------------");
     System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
     System.exit(0);
    }

    else if (metode_pembuangan == 'b') {
     System.out.println("------------------------------------------------------------------------");
     System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
     System.exit(0);

    } else if (metode_pembuangan == 'c') {
     System.out.println("------------------------------------------------------------------------");
     System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
     System.exit(0);

    } else {
     System.out.println("----------------------------------------------------");
     System.out.println("Terjadi Kesalahan! Pilih sesuai yang tertera!");
     System.out.println("\n.....Kembali ke pertanyaan obat kadaluwarsa....");
     ulangLagi = false;
    }
   }

   else if (Tgl_Kadaluwarsa == 'b') {
    System.out.println("------------------------");
    System.out.println("Obat masih valid.");
    System.out.println(".....keluar.....");
    System.exit(0);
   }

   else {
    System.out.println("----------------------------------------------------");
    System.out.println("Terjadi kesalahan! Pilih sesuai yang tertera!"); // Obat kadaluwarsa iya apa tidak
    ulangLagi = false;
   }
  } while (!ulangLagi);
  System.out.println();

  input.close();
 }

 private static void lihatTotalTransaksi() {
    System.out.println("\n----------- Total Transaksi ---------------");
    System.out.println("BERIKUT MERUPAKAN LAPORAN PENDAPATAN TRANSAKSI PADA HARI INI");
    for (int i = 0; i < indeksTransaksi; i++) {
        System.out.println("\nTransaksi ke-" + (i + 1) + ": Rp." + totalPembelian[i] + ",-\n");
  
        if (totalPembelian[i] > 100000) {
            double diskon = hitungDiskon(totalPembelian[i]);
            double hargaSebelumDiskon = totalPembelian[i];
            double hargaSetelahDiskon = hargaSebelumDiskon - (hargaSebelumDiskon * diskon);
  
            System.out.println("  Harga Sebelum Diskon: Rp." + hargaSebelumDiskon + ",-");
            System.out.println("  Diskon " + (diskon * 100) + "%: Rp." + (hargaSebelumDiskon * diskon) + ",-");
            System.out.println("  Harga Sesudah Diskon: Rp." + hargaSetelahDiskon + ",-");
          
        }
    }
  
    int totalKeseluruhan = 0;
    for (int i = 0; i < indeksTransaksi; i++) {
        totalKeseluruhan += totalPembelian[i];
    }
    System.out.println("Total Keseluruhan: Rp." + totalKeseluruhan + ",-");
    ulangProgram = tanyaUlangProgram();
  }

 // BAGIAN USER //

 private static void fiturUser() {
  System.out.println("\n--- Fitur User ---");
  System.out.println("(1) Yuk, Berbelanja!  || (2) ..Yah Sampai Jumpa..");
  System.out.print("Masukkan pilihan Anda (Berupa angka): ");
  int userChoice = scanner.nextInt();

  switch (userChoice) {
   case 1:
    fiturPembayaran();
    break;

   case 2:
    System.out.println("======================================");
    System.out.println("Terimakasih! Bye bye~ ^_^");
    System.exit(0);

   default:
    System.out.println("Pilihan tidak sesuai (2) / (1). Aplikasi akan ditutup.");
    System.exit(0);
  }

 }

 private static int fiturPembayaran() {
  int nomorObat1, nomorJenisObat;
  String obatTerpilih;
  String semua = " ";
  char pilihan;
  String[] namaObat;
  int[] hargaObat;
  String namaJenisObat;
  total = 0;
  String[] jenisObatan = { "Obat Batuk", "Obat Pilek", "Obat Pusing" };
  String pilihObatLagi;
  boolean memilihObatLagi;
  boolean mengulang = false;
  balik = true;
  hargaTerpilih = 0;

  do {
   System.out.println("\nDaftar Jenis Obat di Apotek:");
   for (int i = 0; i < jenisObatan.length; i++) {
    System.out.println((i + 1) + ". " + jenisObatan[i]);
   }

   System.out.print("Masukkan nomor jenis obat yang ingin Anda pilih (harus angka): ");
   nomorJenisObat = scanner.nextInt();

   if (nomorJenisObat >= 1 && nomorJenisObat <= jenisObatan.length) {
    namaJenisObat = jenisObatan[nomorJenisObat - 1];
    System.out.println("Anda memilih jenis obat: " + namaJenisObat);

    if (namaJenisObat.equals("Obat Batuk")) {
     namaObat = new String[] { "Actifed cough", "Woods Antitussive", "Sanadryl DMP",
       "Siladex Antitussive", "Vicks Formula 44 Syrup", "Benadryl Original",
       "Bodrex Flu & Batuk PE", "Konidin", "Anadex", "Vectrine Dry Syrup" };
     hargaObat = new int[] { 20000, 25000, 22000, 18000, 30000, 19000, 21000, 28000, 24000, 26000 };

    } else if (namaJenisObat.equals("Obat Pilek")) {
     namaObat = new String[] { "Actifed Plus Expectorant", "Siladex Batuk dan Pilek",
       "Triaminic Expectorant & Pilek", "OBH Tropica Extra", "Pim-Tra-Kol", "Po Loong Pills",
       "Nalgestan", "Triaminic Batuk & Pilek", "Paratusin", "Silex" };
     hargaObat = new int[] { 22000, 26000, 23000, 21000, 25000, 27000, 24000, 20000, 23000, 25000 };

    } else {
     namaObat = new String[] { "Puyer Bintang Toedjoe", "Panadol Extra Tablet", "Bodrex", "Paramex",
       "Poldan Mig", "Tolak Angin Tablet", "Biogesic", "Decolgen Fx Tablet", "Pamol" };
     hargaObat = new int[] { 15000, 18000, 16000, 20000, 19000, 17000, 21000, 22000, 17000 };
    }

    do {
     System.out.println("\n\nDaftar Nama Obat untuk jenis " + namaJenisObat + ":\n");
     for (int i = 0; i < namaObat.length; i++) {
      System.out.println((i + 1) + "." + namaObat[i] + "\nHarga: Rp." + hargaObat[i] + ",-\n");
     }

     System.out.print("Masukkan nomor obat yang Anda pilih (harus angka): ");
     nomorObat1 = scanner.nextInt();

     if (nomorObat1 >= 1 && nomorObat1 <= namaObat.length) {

      obatTerpilih = namaObat[nomorObat1 - 1];
      semua += obatTerpilih + ", ";
      hargaTerpilih = hargaObat[nomorObat1 - 1];
      obatDibeli.add(obatTerpilih);
      hargaDibeli.add(hargaTerpilih);
      System.out.println("\n" + "Obat yang Anda pilih adalah: " + obatTerpilih);
      System.out.println("Harga obat yang Anda pilih: Rp." + hargaTerpilih + ",-");
      System.out.println("-----------------------------------");
      total += hargaTerpilih;
      System.out.println("Total semua harga obat yang dipesan : Rp." + total + ",-");

      break;

     } else {
      System.out.println(
        "\nMohon pilih nomor obat yang benar!");
      System.out.println("Pesanan obat anda akan hangus!");
      System.out.println("============================");
      System.out.println("1. Kembali ke menu awal.");
      System.out.println("2. Keluar. ");
      System.out.println("----------------------------");
      System.out.print("Pilihan Anda: ");
      pilihan = scanner.next().charAt(0);

      if (pilihan == '1') {
       total = 0;
       fiturPembayaran();
       break;
      } else if (pilihan == '2') {
       System.out.println("...Terimakasih....");
       System.exit(0);
      } else {
       System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
       System.exit(0);
      }
     }
    } while (!mengulang);
    memilihObatLagi = true;
    pilihObatLagi = String.valueOf(memilihObatLagi);
    System.out.print("Apakah Anda ingin memesan obat lagi (y) / cukup (t)? : ");
    pilihObatLagi = scanner.next();

    if (pilihObatLagi.equalsIgnoreCase("y")) {
     memilihObatLagi = true;
     
    }

    else if (pilihObatLagi.equalsIgnoreCase("t")) {
     boolean cobaLagi = true;

     do {
      if (!semua.isEmpty()) {
       semua = semua.substring(0, semua.length() - 2); // untuk menghilangkan koma terakhir
      }
      obatTerpilih = namaObat[nomorObat1 - 1];
     
      break;
     } while (balik);
     System.out.println();
    
    
     do {

      if (total < 100000) {
       tampilkanRingkasanPembelian();
       break;
      }

      else if (total >= 100000) {

       System.out.print("\nApakah Anda ingin mendapatkan diskon (y/t)? ");
       String inginDiskonInput = scanner.next();

       if (inginDiskonInput.equalsIgnoreCase("y")) {
        System.out.print("\nApakah Anda mempunyai kartu member (y/t)? ");
        String kartuMember = scanner.next();
        double dis = 0;
        int poin = 0;

        if (kartuMember.equalsIgnoreCase("y")) {
         if (total >= 100000 && total <= 500000) {
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

          System.out.println("\n\nSelamat! Anda mendapatkan diskon " + (dis * 100)
            + "% & tambahan poin " + poin + "! [Doorprize = 50++ poin]");
            tampilkanRingkasanPembelian();
         }

        } else if (kartuMember.equalsIgnoreCase("t")) {
         System.out.println("\nDAFTAR SEKARANG! ISI BIODATA ANDA! ");
         System.out.print("Nama (Isi nama panggilan): ");
         String nama = scanner.next();
         System.out.print("Umur (Isi angka saja): ");
         String umur = scanner.next();
         System.out.print("Tempat lahir (kota saja): ");
         String tmptLahir = scanner.next();
         System.out.print("Tanggal lahir (Angka saja): ");
         int TglLahir = scanner.nextInt();
         System.out.print("Bulan (ketik huruf): ");
         String bulan = scanner.next();
         System.out.print("Tahun (angka saja) : ");
         int tahun = scanner.nextInt();
         System.out.print("Email: ");
         String email = scanner.next();
         System.out.print("Password (Huruf saja,tanpa spasi): ");
         String password = scanner.next();
         System.out.println("------------------------------------------");
         System.out.println(
           "Selamat! dengan pengguna " + nama + " telah menjadi Member Premium!");

         if (total >= 100000 && total <= 500000) {
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

          System.out.println("Pengguna dengan nama " + nama + " mendapatkan diskon "
            + (dis * 100) + "% & tambahan poin " + poin
            + "! [Doorprize = 50++ poin]");
          System.out.println("----------------------------------------------------");
          System.out.println("Total harga yang harus anda bayar adalah : "
            + (total - (total * dis)));
          tampilkanRingkasanPembelian();
          break;
         }

        } else {
         System.out.println("~~");
         System.out.println("INPUT PILIHAN YANG BENAR! (y) / (t)! ");
         System.out.println("...kembali ke pertanyaan diskon....");
         cobaLagi = false;
         break;
        }

       } else if (inginDiskonInput.equalsIgnoreCase("t")) {
        tampilkanRingkasanPembelian();
        break;

       } else {
        System.out.println("~");
        System.out.println("SILAHKAN INPUT YANG BENAR! (y) / (t)!");
        cobaLagi = false;
        break;
       }
      }

     } while (!cobaLagi);
     System.out.println();
     // Menyimpan total pembelian pada array totalPembelian
     totalPembelian[indeksTransaksi] = total;

     // Menyimpan total transaksi pada array totalTransaksi
     totalTransaksi[indeksTransaksi++] = totalTransaksiPembayaran += total;

    
     break;
    }

    else {
     System.out.println("-----------------------------------------------------");
     System.out.println("Input salah. Pilih (y) / (t) saja.");
     System.out.println("WARNING! PILIH YANG BENAR! SISTEM PEMESANAN AKAN DIULANG DARI AWAL! (pemesanan tetap sama)");
     
     balik(); // Panggil metode balik untuk mengonfirmasi pilihan
     break;
    }
   } else {
    System.out.println("Nomor obat tidak valid. Silakan coba lagi.");
    pilihObatLagi = "true";
    memilihObatLagi = Boolean.parseBoolean(pilihObatLagi);
    memilihObatLagi = true;
   }

  } while (memilihObatLagi);
  System.out.println();

  return total;

 }

 private static double hitungDiskon(double totalPembelian) {
  double diskon = 0;

  if (totalPembelian >= 100000 && totalPembelian <= 500000) {
   if (totalPembelian < 200000) {
    diskon = 0.2;
   } else if (totalPembelian < 300000) {
    diskon = 0.25;
   } else if (totalPembelian < 400000) {
    diskon = 0.3;
   } else if (totalPembelian <= 500000) {
    diskon = 0.35;
   }
  }

  return diskon;
 }

 public static void tampilkanRingkasanPembelian() {
 
  System.out.println("\n========== STRUK PEMBELIAN ==========");
  System.out.printf("%-30s%-15s\n", "Nama Obat", "Harga (Rp)");
  System.out.println("-------------------------------------");
  double totalHargaAsli = 0; // Total harga sebelum diskon

  for (int i = 0; i < obatDibeli.size(); i++) {
  int hargaAsli = hargaDibeli.get(i);
   totalHargaAsli += hargaAsli; // Menambahkan harga asli ke total
   System.out.printf("%-30s%-15s\n", obatDibeli.get(i), hargaAsli);
  }

  double diskon = hitungDiskon(totalHargaAsli); // Menghitung diskon berdasarkan total harga asli
  double totalDiskon = totalHargaAsli * diskon; // Menghitung total nilai diskon
  double totalSetelahDiskon = totalHargaAsli - totalDiskon; // Total harga setelah diskon diterapkan

  System.out.println("-------------------------------------");
  System.out.printf("%-30s%-15s\n", "Total Harga", totalHargaAsli);
  System.out.printf("%-30s%-15s\n", "Diskon", diskon * 100 + "%");
  System.out.printf("%-30s%-15s\n", "Total Setelah Diskon", totalSetelahDiskon);
  System.out.println("=====================================");

  System.out.println("\nSilahkan melakukan transaksi pembayaran via cash/debit/credit/Qris dll dengan penjaga kasir! ");
  System.out.println("~~~~~~~~~~");
  System.out.println("Terima kasih telah melakukan pembelian di apotek kami! Have a great day!");
  obatDibeli.clear();
  ulangProgram1 = true;
 }

 private static boolean balik() {
  System.out.print("\nApakah anda ingin memesan obat ulang (y) / cukup (t)?");
  char pilihan = scanner.next().charAt(0);

  if (pilihan == 'y' || pilihan == 'Y') {
    total = 0;
   fiturPembayaran();
   
   
  }

  else if (pilihan == 't' || pilihan == 'T') {
   tampilkanRingkasanPembelian();

  }

  else {
   System.out.println("Warning! Input tidak valid secara terus menerus!");
   System.out.println("..Sistem akan ditutup...");
   System.exit(0);
  }
  return pilihan == 'y' || pilihan == 't';
 }

 private static boolean tanyaUlangProgram() {
  System.out.print("\nApakah Anda ingin memulai kembali program? (y/t): ");
  char pilihan = scanner.next().charAt(0);

  if (pilihan == 'y' || pilihan == 'Y') {

    
   return true;
   
  } else if (pilihan == 't' || pilihan == 'T') {
   System.out.println("Terimakasih sudah berbelanja! Sampai bertemu lagi!");
   System.exit(0);
   return false;
   
  } else {
   System.out.println("\nWarning! Input tidak valid! tidak (y) / (t)!");
   System.out.println("..Sistem akan ditutup...");
   System.exit(0);
  }
  return false;

 }

 private static boolean tanyaUlangProgram1() {
    System.out.print("\n1Apakah Anda ingin memulai kembali program? (y/t): ");
    char pilihan = scanner.next().charAt(0);
    
    if (pilihan == 't' || pilihan == 'T') {
   System.out.println("Terimakasih sudah berbelanja! Sampai bertemu lagi!");
   System.exit(0);
   return false;

  } else {
   System.out.println("\nWarning! Input tidak valid! tidak (y) / (t)!");
   System.out.println("..Sistem akan ditutup...");
   System.exit(0);
  }
    return (pilihan == 'y' || pilihan == 'Y');
    }
}