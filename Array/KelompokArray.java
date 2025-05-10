import java.util.Scanner;

public class KelompokArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan banyaknya jumlah Nilai: \n");
        int jumlahNilai = input.nextInt();

        int[] array = new int[jumlahNilai];

        for (int i = 0; i < jumlahNilai; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        int nilaiTertinggi = array[0];
        int nilaiTerendah = array[0];
        int total = array[0];

        for (int i = 1; i < jumlahNilai; i++) {
            if (array[i] > nilaiTertinggi) {
                nilaiTertinggi = array[i];
            }
            if (array[i] < nilaiTerendah) {
                nilaiTerendah = array[i];
            }
            total += array[i];
        }

        double rataRata = (double) total / jumlahNilai;

        System.out.println("Nilai Tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai Terendah: " + nilaiTerendah);
        System.out.println("Rata-Rata: " + rataRata);
    }
}
