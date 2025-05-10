# UTS_PBO2
 # Sistem Kasir Apotek - Tugas OOP

[![PHP Version](https://img.shields.io/badge/PHP-7.4%2B-blue.svg)](https://php.net/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

Sistem manajemen transaksi pembelian obat untuk apotek dengan fitur resep dokter dan pembelian langsung.

## Fitur Utama
- 📝 Manajemen data pasien dan obat
- 💊 Pembuatan dan verifikasi resep dokter
- 💰 Transaksi dengan resep maupun langsung
- 📊 Laporan transaksi harian
- 🔒 Enkapsulasi data sensitif pasien

## Struktur Database
### Tabel Utama
| Tabel          | Kolom                          |
|----------------|--------------------------------|
| `pasien`       | id, nama, umur                |
| `obat`         | id, nama, harga, stok         |
| `resep`        | id, pasien_id, dokter_id, tanggal |
| `detail_resep` | resep_id, obat_id, jumlah     |
| `transaksi`    | id, pasien_id, total, tanggal |

## Konsep OOP yang Diimplementasikan
### 👨⚕ Inheritance
```php
abstract class TenagaMedis {
  abstract public function identifikasi();
}

class Dokter extends TenagaMedis {
  public function identifikasi() {
    return "Dokter bersertifikasi";
  }
}

class Apoteker extends TenagaMedis {
  public function identifikasi() {
    return "Apoteker profesional";
  }
}


🔀 Polymorphism
php
interface MetodeResep {
  public function verifikasi();
}

class ResepDokter implements MetodeResep {
  public function verifikasi() {
    return "Resep divalidasi oleh dokter";
  }
}

class ResepOTC implements MetodeResep {
  public function verifikasi() {
    return "Obat bebas terverifikasi";
  }
}
🔒 Encapsulation
php
class Transaksi {
  private $total;
  
  public function setTotal($jumlah) {
    $this->total = $jumlah * 1.1; // Tambah PPN 10%
  }
  
  public function getTotal() {
    return $this->total;
  }
}
Instalasi
Clone repositori

bash
git clone https://github.com/username/apotek-cashier.git
cd apotek-cashier
Setup database (MySQL)

sql
CREATE DATABASE apotek_db;
-- Import skema dari file database/schema.sql
Install dependencies

bash
composer install
Konfigurasi environment

bash
cp .env.example .env
Penggunaan
Contoh membuat transaksi baru:

php
$pasien = new Pasien("Budi", 25);
$obat = new Obat("Paracetamol", 5000, 100);
$resep = new ResepDokter($pasien, $dokter);
$resep->tambahObat($obat, 2);

$transaksi = new Transaksi();
$transaksi->prosesPembelian($resep);
echo $transaksi->total(); // Output: 11000 (termasuk PPN)
