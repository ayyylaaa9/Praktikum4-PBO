# Tugas Praktikum 4: Array, List, Iterator

## Noer Afdila (L0325033)

# Source Code dan Penjelasan

## 1. Class AsetIT

### Source Code

```java
public class AsetIT {

    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;

    // Constructor
    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }

    // Method untuk menampilkan informasi aset
    public void tampilkanInfoAset() {
        System.out.println("ID Aset        : " + idAset);
        System.out.println("Nama Perangkat : " + namaPerangkat);
        System.out.println("Lokasi         : " + lokasi);
        System.out.println("Status Kondisi : " + statusKondisi);
        System.out.println("--------------------------------");
    }
}
```

### Penjelasan

Class `AsetIT` digunakan untuk merepresentasikan sebuah aset IT dalam program. Setiap objek yang dibuat dari class ini akan memiliki informasi mengenai ID aset, nama perangkat, lokasi, dan kondisi perangkat.

Pada class ini terdapat empat atribut, yaitu:

- `idAset` digunakan untuk menyimpan ID atau kode unik dari aset.
- `namaPerangkat` digunakan untuk menyimpan nama perangkat IT.
- `lokasi` digunakan untuk menyimpan lokasi tempat perangkat berada.
- `statusKondisi` digunakan untuk menyimpan kondisi perangkat, misalnya baik atau rusak.

Keempat atribut tersebut menggunakan tipe data `String` karena data yang disimpan berupa teks.

Pada program ini atribut tidak menggunakan `private`, sehingga atribut dapat diakses secara langsung oleh class lain yang membutuhkan data tersebut. Contohnya pada proses penghapusan aset di class `ManajemenAset`, nilai `idAset` dapat dipanggil secara langsung menggunakan `aset.idAset`.

Selanjutnya terdapat constructor:

```java
public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi)
```

Constructor digunakan untuk memberikan nilai awal pada atribut ketika sebuah objek `AsetIT` dibuat.

Sebagai contoh:

```java
new AsetIT("A001", "Server", "Ruang Server", "Baik");
```

Kode tersebut membuat sebuah objek aset dengan ID `A001`, nama perangkat `Server`, lokasi `Ruang Server`, dan status kondisi `Baik`.

Penggunaan `this` pada constructor digunakan untuk membedakan atribut milik objek dengan parameter constructor. Contohnya:

```java
this.idAset = idAset;
```

Artinya nilai parameter `idAset` dimasukkan ke atribut `idAset` milik objek.

Class ini juga memiliki method `tampilkanInfoAset()`. Method tersebut digunakan untuk menampilkan seluruh informasi aset ke dalam console, yaitu ID aset, nama perangkat, lokasi, dan status kondisi.

---

## 2. Class ManajemenAset

### Source Code

```java
import java.util.ArrayList;
import java.util.Iterator;

public class ManajemenAset {

    // ArrayList untuk menyimpan data aset
    ArrayList<AsetIT> daftarAset;

    // Constructor
    public ManajemenAset() {
        daftarAset = new ArrayList<>();
    }

    // Method untuk menambahkan aset
    public void tambahAset(AsetIT asetbaru) {
        daftarAset.add(asetbaru);
        System.out.println("Aset berhasil ditambahkan.");
    }

    // Method untuk menampilkan semua aset
    public void tampilkanSemuaAset() {

        if (daftarAset.isEmpty()) {
            System.out.println("Belum ada data aset.");
            return;
        }

        System.out.println("\n===== DAFTAR SEMUA ASET IT =====");

        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }

    // Method untuk menghapus aset berdasarkan ID
    public void hapusAset(String idAset) {

        Iterator<AsetIT> iterator = daftarAset.iterator();

        while (iterator.hasNext()) {

            AsetIT aset = iterator.next();

            if (aset.idAset.equals(idAset)) {
                iterator.remove();

                System.out.println(
                    "Aset dengan ID " + idAset + " berhasil dihapus."
                );

                return;
            }
        }

        System.out.println(
            "Peringatan: Aset dengan ID " + idAset + " tidak ditemukan."
        );
    }
}
```

### Penjelasan

Class `ManajemenAset` digunakan untuk mengelola kumpulan data aset IT. Class ini bertanggung jawab terhadap proses penambahan, penampilan, dan penghapusan data aset.

Pada bagian awal terdapat:

```java
import java.util.ArrayList;
import java.util.Iterator;
```

`ArrayList` digunakan untuk menyimpan kumpulan objek `AsetIT`, sedangkan `Iterator` digunakan untuk melakukan proses pencarian dan penghapusan aset.

Class ini memiliki atribut:

```java
ArrayList<AsetIT> daftarAset;
```

`daftarAset` digunakan sebagai tempat untuk menyimpan seluruh objek aset IT. Karena menggunakan `ArrayList<AsetIT>`, data yang disimpan dalam list berupa objek dari class `AsetIT`.

Constructor:

```java
public ManajemenAset() {
    daftarAset = new ArrayList<>();
}
```

digunakan untuk membuat objek `ArrayList` sehingga `daftarAset` dapat digunakan untuk menyimpan data aset.

### Method tambahAset()

Method:

```java
public void tambahAset(AsetIT asetbaru)
```

digunakan untuk menambahkan aset baru ke dalam `ArrayList`.

Parameter `asetbaru` merupakan objek dari class `AsetIT`. Objek tersebut kemudian dimasukkan menggunakan:

```java
daftarAset.add(asetbaru);
```

Setiap kali method ini dipanggil, satu data aset akan ditambahkan ke dalam daftar.

Contohnya:

```java
manajemen.tambahAset(
    new AsetIT("A001", "Server", "Ruang Server", "Baik")
);
```

Kode tersebut membuat objek `AsetIT` kemudian memasukkannya ke dalam `daftarAset`.

### Method tampilkanSemuaAset()

Method:

```java
public void tampilkanSemuaAset()
```

digunakan untuk menampilkan seluruh data aset yang tersimpan.

Sebelum menampilkan data, program memeriksa apakah `ArrayList` kosong menggunakan:

```java
if (daftarAset.isEmpty())
```

Jika tidak ada data, program akan menampilkan:

```text
Belum ada data aset.
```

Jika terdapat data, program menggunakan perulangan **For-Each**:

```java
for (AsetIT aset : daftarAset) {
    aset.tampilkanInfoAset();
}
```

For-Each digunakan untuk mengambil setiap objek `AsetIT` yang ada di dalam `daftarAset`. Kemudian method `tampilkanInfoAset()` dipanggil untuk menampilkan informasi dari setiap aset.

### Method hapusAset()

Method:

```java
public void hapusAset(String idAset)
```

digunakan untuk menghapus aset berdasarkan ID.

Pada proses ini digunakan `Iterator`:

```java
Iterator<AsetIT> iterator = daftarAset.iterator();
```

Iterator digunakan untuk menelusuri setiap data aset yang terdapat dalam `ArrayList`.

Perulangan:

```java
while (iterator.hasNext())
```

digunakan untuk memastikan masih terdapat data yang dapat diperiksa.

Kemudian:

```java
AsetIT aset = iterator.next();
```

digunakan untuk mengambil objek aset berikutnya.

Karena atribut `idAset` tidak menggunakan `private`, ID dapat diakses secara langsung menggunakan:

```java
aset.idAset
```

Kemudian ID tersebut dibandingkan dengan ID yang diberikan melalui parameter:

```java
if (aset.idAset.equals(idAset))
```

Jika ID ditemukan, data dihapus menggunakan:

```java
iterator.remove();
```

Penggunaan `iterator.remove()` digunakan karena penghapusan dilakukan ketika data sedang ditelusuri menggunakan `Iterator`.

Jika aset berhasil ditemukan dan dihapus, program menampilkan pesan bahwa aset berhasil dihapus.

Jika seluruh data sudah diperiksa tetapi ID yang dicari tidak ditemukan, program akan menampilkan pesan peringatan bahwa aset tidak ditemukan.

---

## 3. Class MainAset

### Source Code

```java
public class MainAset {

    public static void main(String[] args) {

        // Membuat objek ManajemenAset
        ManajemenAset manajemen = new ManajemenAset();

        // Menambahkan data aset IT
        manajemen.tambahAset(
            new AsetIT("A001", "Server", "Ruang Server", "Baik")
        );

        manajemen.tambahAset(
            new AsetIT("A002", "Router", "Ruang Jaringan", "Baik")
        );

        manajemen.tambahAset(
            new AsetIT("A003", "Switch", "Ruang Jaringan", "Rusak")
        );

        manajemen.tambahAset(
            new AsetIT("A004", "PC", "Laboratorium", "Baik")
        );

        // Menampilkan semua aset
        System.out.println("\n--- DATA AWAL ASET ---");
        manajemen.tampilkanSemuaAset();

        // Menghapus aset berdasarkan ID
        System.out.println("\n--- PROSES PENGHAPUSAN ---");
        manajemen.hapusAset("A003");

        // Menampilkan kembali semua aset
        System.out.println("\n--- DATA SETELAH PENGHAPUSAN ---");
        manajemen.tampilkanSemuaAset();
    }
}
```

### Penjelasan

Class `MainAset` merupakan class utama yang digunakan untuk menjalankan program. Method `main()` menjadi titik awal ketika program dijalankan.

Pertama, dibuat objek dari class `ManajemenAset`:

```java
ManajemenAset manajemen = new ManajemenAset();
```

Objek `manajemen` digunakan untuk memanggil method yang terdapat pada class `ManajemenAset`.

### Menambahkan Data Aset

Program kemudian menambahkan empat data aset IT.

Data pertama:

```java
manajemen.tambahAset(
    new AsetIT("A001", "Server", "Ruang Server", "Baik")
);
```

Data tersebut memiliki ID `A001`, nama perangkat `Server`, lokasi `Ruang Server`, dan kondisi `Baik`.

Data kedua:

```java
manajemen.tambahAset(
    new AsetIT("A002", "Router", "Ruang Jaringan", "Baik")
);
```

Data tersebut merupakan perangkat Router dengan ID `A002`.

Data ketiga:

```java
manajemen.tambahAset(
    new AsetIT("A003", "Switch", "Ruang Jaringan", "Rusak")
);
```

Data tersebut merupakan perangkat Switch dengan ID `A003` dan kondisi `Rusak`.

Data keempat:

```java
manajemen.tambahAset(
    new AsetIT("A004", "PC", "Laboratorium", "Baik")
);
```

Data tersebut merupakan perangkat PC dengan ID `A004`.

Keempat objek tersebut kemudian disimpan ke dalam `ArrayList` melalui method `tambahAset()`.

### Menampilkan Data Awal

Setelah seluruh data ditambahkan, program menjalankan:

```java
manajemen.tampilkanSemuaAset();
```

Method tersebut menampilkan seluruh aset yang tersimpan di dalam `ArrayList`.

Pada tahap ini akan ditampilkan empat aset, yaitu `A001`, `A002`, `A003`, dan `A004`.

### Menghapus Data Aset

Selanjutnya program menghapus aset dengan ID `A003` menggunakan:

```java
manajemen.hapusAset("A003");
```

Program akan mencari aset dengan ID tersebut menggunakan `Iterator`.

Jika ID `A003` ditemukan, data aset akan dihapus dari `ArrayList`.

Dalam contoh ini, aset yang dihapus adalah perangkat Switch.

### Menampilkan Data Setelah Penghapusan

Setelah proses penghapusan selesai, program kembali menjalankan:

```java
manajemen.tampilkanSemuaAset();
```

Tujuannya adalah untuk melihat perubahan data setelah proses penghapusan.

Sebelum penghapusan terdapat empat aset:

```text
A001 - Server
A002 - Router
A003 - Switch
A004 - PC
```

Setelah aset `A003` dihapus, data yang tersisa adalah:

```text
A001 - Server
A002 - Router
A004 - PC
```

Dengan demikian dapat diketahui bahwa proses penghapusan berhasil dilakukan.

