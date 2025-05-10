# UTS_PBO2


```java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Abstract Class TenagaMedis
abstract class TenagaMedis {
    protected String nama;
    protected String id;

    public TenagaMedis(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }
    
    public abstract String identifikasi();
}

// Inheritance
class Dokter extends TenagaMedis {
    public Dokter(String nama, String id) {
        super(nama, id);
    }

    @Override
    public String identifikasi() {
        return "Dokter " + nama + " (ID: " + id + ")";
    }
}

class Apoteker extends TenagaMedis {
    public Apoteker(String nama, String id) {
        super(nama, id);
    }

    @Override
    public String identifikasi() {
        return "Apoteker " + nama + " (ID: " + id + ")";
    }
}

// Polymorphism Interface
interface MetodeResep {
    String verifikasi();
}

// Encapsulation Class
class Pasien {
    private String id;
    private String nama;
    private int umur;

    public Pasien(String id, String nama, int umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }

    // Getter methods
    public String getId() { return id; }
    public String getNama() { return nama; }
    public int getUmur() { return umur; }
}

class Obat {
    private String id;
    private String nama;
    private double harga;
    private int stok;

    public Obat(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter methods
    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }
}

class Resep {
    private String id;
    private Pasien pasien;
    private TenagaMedis dokter;
    private Date tanggal;
    private List<DetailResep> detailResep = new ArrayList<>();

    public Resep(String id, Pasien pasien, TenagaMedis dokter, Date tanggal) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.tanggal = tanggal;
    }

    public void tambahObat(Obat obat, int jumlah) {
        detailResep.add(new DetailResep(obat, jumlah));
    }
}

class DetailResep {
    private Obat obat;
    private int jumlah;

    public DetailResep(Obat obat, int jumlah) {
        this.obat = obat;
        this.jumlah = jumlah;
    }
}

class Transaksi {
    private String id;
    private Pasien pasien;
    private double total;
    private Date tanggal;

    public Transaksi(String id, Pasien pasien, Date tanggal) {
        this.id = id;
        this.pasien = pasien;
        this.tanggal = tanggal;
    }

    // Encapsulation method
    public void hitungTotal(List<DetailResep> items) {
        this.total = items.stream()
            .mapToDouble(d -> d.getObat().getHarga() * d.getJumlah())
            .sum() * 1.1; // Tambah PPN 10%
    }
}

// Implementasi Polymorphism
class ResepDokter implements MetodeResep {
    @Override
    public String verifikasi() {
        return "Resep dokter telah divalidasi";
    }
}

class ResepOTC implements MetodeResep {
    @Override
    public String verifikasi() {
        return "Obat bebas terverifikasi";
    }
}

public class SistemApotek {
    public static void main(String[] args) {
        // Contoh penggunaan
        Dokter dokter = new Dokter("Dr. Andi", "D001");
        Apoteker apoteker = new Apoteker("Budi", "A001");
        Pasien pasien = new Pasien("P001", "John Doe", 30);
        
        Obat obat1 = new Obat("O001", "Paracetamol", 5000, 100);
        Obat obat2 = new Obat("O002", "Vitamin C", 15000, 50);
        
        Resep resep = new Resep("R001", pasien, dokter, new Date());
        resep.tambahObat(obat1, 2);
        resep.tambahObat(obat2, 1);
        
        Transaksi transaksi = new Transaksi("T001", pasien, new Date());
        transaksi.hitungTotal(resep.getDetailResep());
        
        // Verifikasi resep
        MetodeResep verifikasiResep = new ResepDokter();
        System.out.println(verifikasiResep.verifikasi());
        
        System.out.println("Total transaksi: Rp" + transaksi.getTotal());
    }
}
```

Program ini mengimplementasikan:
1. **Inheritance**: Kelas `Dokter` dan `Apoteker` mewarisi dari abstract class `TenagaMedis`
2. **Polymorphism**: Interface `MetodeResep` dengan implementasi berbeda di `ResepDokter` dan `ResepOTC`
3. **Encapsulation**: Data pasien dan obat dienkapsulasi dengan access modifier private
4. **Abstract Class**: `TenagaMedis` sebagai abstract class dengan method abstrak `identifikasi()`

Untuk integrasi dengan database, Anda perlu:
1. Menambahkan JDBC driver
2. Membuat DAO (Data Access Object) untuk setiap entitas
3. Mengimplementasikan CRUD operations
4. Menggunakan prepared statement untuk keamanan

Anda bisa menambahkan fitur berikut:
- Validasi stok obat
- Pencatatan riwayat transaksi
- Notifikasi obat hampir kadaluarsa
- Sistem autentikasi user
