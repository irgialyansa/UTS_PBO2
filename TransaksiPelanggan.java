import java.util.Scanner;
// LOOP DO WHILE DAN NESTED IF
public class TransaksiPelanggan {
    public static void main(String args[]) {
        int jumlah = 0, counter = 0, obat, total,poin,diskon,jmlhObat,bayar;
        float rata = 0;
        String kartuMember,nama,umur,tmptTglLahir,alamat,gmail,password;
        char jawab;
        double dis;
        Scanner sc = new Scanner(System.in);
        
    do {
        System.out.println("Masukkan Harga Obat (ketikan 0 untuk berhenti) : ");
        obat = sc.nextInt();    
        if (obat >= 0) {
            jumlah += obat;
            ++counter;
        }
    } while (obat != 0);
    rata = jumlah / counter;
    System.out.printf("Total harga dari %d obat adalah %d\n", --counter, jumlah);
    System.out.println("Apakah pelanggan ingin mendapatkan diskon (y atau t)? "); 
    Scanner sc1 = new Scanner(System.in);
    kartuMember = sc1.nextLine();
        if (kartuMember.equalsIgnoreCase("y")) {
            System.out.println("Apakah Pelanggan mempunyai kartu member (y atau t)? ");
        kartuMember = sc1.nextLine();
        if (kartuMember.equalsIgnoreCase("y")){
        System.out.println("Harga total yang anda beli " + jumlah);
        total = sc.nextInt();
        if (jumlah >= 100000 && jumlah < 200000 ) {     
            System.out.println("Selamat anda dapat diskon 20% dan mendapatkan tambahan poin 5, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
        } 
            else if (jumlah >= 200000 && jumlah < 300000 ){
            System.out.println("Selamat anda dapat diskon 25% dan mendapatkan tambahan poin 10, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
        }
            else if (jumlah >= 300000 && jumlah < 400000 ){
            System.out.println("Selamat anda dapat diskon 30% dan mendapatkan tambahan poin 15, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
        }
            else if (jumlah >= 400000 && jumlah <= 500000 ){
            System.out.println("Selamat anda dapat diskon 35% dan mendapatkan tambahan poin 20, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
        }   
            else if (jumlah >=500000){
        }
            else if (total >=500000){
            System.out.println("Selamat anda dapat diskon 40% dan mendapatkan tambahan poin 25, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize");
            }
            
            else {
            System.out.println("Mohon maaf, terkait pendapatan diskon dan poin minimal nominal pembelian harus Rp.100.000,-");
        }
            else {
                System.out.println("Terjadi kesalahan");
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
        System.out.println("Selamat dengan nama\n" + nama + "\ntelah menjadi Member Premium");

    }
        } 
    } 
}