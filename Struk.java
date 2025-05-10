import java.util.Scanner;

public class Struk {
public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int Harga_OBH =18000;
        int Harga_OD =25000;
        int Jml_OBH, Jml_OD, Hrg_Total, Uang_Pembeli, Kembalian;

        System.out.println("Masukan Jumlah Obat Batuk Berdahak yang dibeli");
        Jml_OBH = input.nextInt();

        System.out.println("Masukan Jumlah Obat Demam");
        Jml_OD = input.nextInt();

        Hrg_Total = Harga_OBH*Jml_OBH+Harga_OD*Jml_OD;

        System.out.println("Total Harga Kamu adalah " +Hrg_Total);

        System.out.println("Masukan Uang Anda");
        Uang_Pembeli = input.nextInt();
    
        Kembalian = Uang_Pembeli-Hrg_Total;

        System.out.println("Kembalian Kamu adalah " +Kembalian);
       
    }
}

