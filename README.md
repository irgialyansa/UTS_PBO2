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
