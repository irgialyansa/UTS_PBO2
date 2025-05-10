import java.util.Scanner;
public class FiturPengelolaIdentifikasiKadaluwarsa {
    public static void main(String[] args) {
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
}