package PENGELOLA;
import java.util.Scanner;
// IF ELSE 
public class FiturAdminIdentifikasiStok {

    public static void main(String[] args) {
        Scanner input = new Scanner(System. in);

        // mengambil contoh salah satu obat, yaitu obat batuk \\
        System.out.println ("Masukkan stok obat batuk yang tersedia :");
        int Stok_obatBatuk = input.nextInt();

        if (Stok_obatBatuk<20) {
            System.out.println("segera hubungi supplier untuk restock!");
        }
        else {
            System.out.println("Tidak usah restock.");
        }
    }
}