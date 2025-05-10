package USER;
import java.util.Scanner;
// ARRAY 1 DIMENSI
public class DataObat {
    public static void main(String args[]) {
        int jumlah = 0, counter = 0, obat, total, poin, diskon, jmlhObat, bayar;
        float rata = 0;
        String kartuMember, nama, umur, tmptTglLahir, alamat, gmail, password, hargaBayar;
        char jawab;
        double dis;
        Scanner sc = new Scanner(System.in);
        String[] obatObatan = {"Paracetamol", "Amoxicillin", "Lansoprazole", "Ibuprofen", "Cetirizine"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Daftar Nama Obat di Apotek:");
        for (int i = 0; i < obatObatan.length; i++) {
            System.out.println((i + 1) + ". " + obatObatan[i]);
        }
        
        System.out.print("Masukkan nomor obat yang ingin Anda pilih: ");
        int nomorObat = scanner.nextInt();

        if (nomorObat >= 1 && nomorObat <= obatObatan.length) 
        {                                                                                                                                                               
            String namaObat = obatObatan[nomorObat - 1];
            System.out.println("Obat yang Anda pilih adalah: " + namaObat);
        do 
        {
            System.out.println("Masukkan Harga Obat (ketik 0 untuk berhenti) : ");
            obat = sc.nextInt();
            if (obat >= 0) {
                jumlah += obat;
                ++counter;
            }
        } while (obat != 0);
        rata = jumlah / counter;
        System.out.printf("Total harga dari %d obat adalah %d\n",--counter,jumlah);
        System.out.println("Apakah pelanggan ingin mendapatkan diskon (y atau t)? ");
        Scanner sc1 = new Scanner(System.in);
        hargaBayar = sc1.nextLine();
        if (hargaBayar.equalsIgnoreCase("y")) {
            System.out.println("Apakah Pelanggan mempunyai kartu member (y atau t)? ");
            kartuMember = sc1.nextLine();
            if (kartuMember.equalsIgnoreCase("y")) {
                System.out.println("Masukkan harga total obat yang dibeli");
                total = sc.nextInt();
                if (total >= 100000 && total < 200000) {
                    System.out.println("Selamat anda dapat diskon 20% dan mendapatkan tambahan poin 5, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
                } else if (total >= 200000 && total < 300000) {
                    System.out.println("Selamat anda dapat diskon 25% dan mendapatkan tambahan poin 10, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
                } else if (total >= 300000 && total < 400000) {
                    System.out.println("Selamat anda dapat diskon 30% dan mendapatkan tambahan poin 15, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
                } else if (total >= 400000 && total <= 500000) {
                    System.out.println("Selamat anda dapat diskon 35% dan mendapatkan tambahan poin 20, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
                } else {
                    System.out.println("Selamat anda dapat diskon 40% dan mendapatkan tambahan poin 25, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
                }
            } else {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Daftar sekarang! Isi biodata anda!");
                System.out.println("nama : ");
                nama = sc2.nextLine();
                System.out.println("umur : ");
                umur = sc2.nextLine();
                System.out.println("tempat Tanggal Lahir : ");
                tmptTglLahir = sc2.nextLine();
                System.out.println("alamat : ");
                alamat = sc2.nextLine();
                System.out.println("email : ");
                gmail = sc2.nextLine();
                System.out.println("password : ");
                password = sc2.nextLine();
                System.out.println("Selamat dengan nama\n" + nama + "\ntelah menjadi Member Premium");
            }
        }        
        else 
        {
            System.out.println("Total harga yang harus dibayar sebanyak : Rp." + jumlah + ",-" );
        }
        } 
        else {
            System.out.println("Nomor obat tidak valid. Masukkan nomor obat yang benar!");
        }
    }
}