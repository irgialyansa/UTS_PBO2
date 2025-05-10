import java.util.Scanner;
public class KartuMember {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
            String kartu_member,nama,umur,tmpt_tgl_Lahir,alamat,gmail,password;
            double dis;
            int poin,hrg_total_obat;

            System.out.println("Punya kartu member? \na.Iya \nb.Tidak");
            kartu_member = input.nextLine();
            if (kartu_member.equalsIgnoreCase("a"))
            {
               System.out.print("Masukkan harga total obat yang dibeli : ");
               hrg_total_obat = input.nextInt();

               if (hrg_total_obat >= 100000 && hrg_total_obat < 200000)
                {
                dis =+ 0.2; 
                poin =+ 5;
                System.out.println("Selamat anda dapat diskon 20% dan mendapatkan tambahan poin 5, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize!");
                }

                else if (hrg_total_obat >= 200000 && hrg_total_obat < 300000)
                {
                dis =+ 0.25; 
                poin =+ 10;
                System.out.println("Selamat anda dapat diskon 25% dan mendapatkan tambahan poin 10, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize!");
                }

                else if (hrg_total_obat >= 300000 && hrg_total_obat < 400000)
                {
                dis =+ 0.3; 
                poin =+ 15;
                System.out.println("Selamat anda dapat diskon 30% dan mendapatkan tambahan poin 15, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize!");
                }

                else if (hrg_total_obat >= 400000 && hrg_total_obat < 500000)
                {
                dis =+ 0.35; 
                poin =+ 20;
                System.out.println("Selamat anda dapat diskon 35% dan mendapatkan tambahan poin 20, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize!");
                }

                else {
                
                dis =+ 0.4; 
                poin =+ 25;
                System.out.println("Selamat anda dapat diskon 40% dan mendapatkan tambahan poin 25, silahkan dikumpulkan sampai 100 poin jika ingin mendapatkan doorprize!");
                }

            }

            else if (kartu_member.equalsIgnoreCase("b")) 
            {
                System.out.println("Daftar sekarang! Isi biodata anda!");
                
                System.out.print("Nama : ");
                nama = input.nextLine();

                System.out.print("Umur : ");
                umur = input.nextLine();

                System.out.print("Tempat, Tanggal Lahir : ");
                tmpt_tgl_Lahir = input.nextLine();

                System.out.print("Alamat : ");
                alamat = input.nextLine();   

                System.out.println("Terimakasih, atas nama " + nama + "\numur " + umur + "\ntempat, tanggal lahir " + tmpt_tgl_Lahir + "\nAlamat " + alamat + "\nsudah terdaftar sebagai member kami! silahkan!");
            }
                

            else {
                System.out.println("Terjadi Kesalahan");
            }



    }
}
