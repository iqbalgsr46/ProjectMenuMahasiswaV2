# 🎓 SISTEM INFORMASI MAHASISWA

## Aplikasi Desktop Java dengan GUI Modern

### 📋 DESKRIPSI PROJECT

Aplikasi desktop berbasis Java Swing dengan tampilan modern dan gradient design yang terdiri dari 3 menu utama:

1. **🔢 KALKULATOR** - Kalkulator modern dengan operasi lengkap
2. **📝 PENDAFTARAN MAHASISWA** - Sistem CRUD lengkap dengan database MySQL
3. **📚 TUGAS** - Portfolio tampilan tugas-tugas yang telah dikerjakan

---

## ✨ FITUR UTAMA

### Menu 1: Kalkulator Modern
- ✅ Operasi matematika: +, -, ×, ÷, %
- ✅ Tombol angka 0-9
- ✅ Support angka desimal
- ✅ Fitur Clear (C) dan Delete (⌫)
- ✅ Toggle Plus/Minus (±)
- ✅ Validasi error (pembagian 0)
- ✅ Desain modern dengan gradient background
- ✅ Hover effects pada tombol

### Menu 2: Pendaftaran Mahasiswa
**Field Input (8 Field):**
- ✅ Nama Lengkap
- ✅ Jenis Kelamin (Dropdown)
- ✅ No. Telepon
- ✅ Program Studi (Dropdown - 5 pilihan)
- ✅ Tempat Lahir
- ✅ Alamat
- ✅ Email
- ✅ Tahun Masuk

**Fitur CRUD:**
- ✅ CREATE - Tambah data mahasiswa baru
- ✅ READ - Tampilkan data dalam tabel
- ✅ UPDATE - Edit data yang sudah ada
- ✅ DELETE - Hapus data dengan konfirmasi
- ✅ Auto-refresh tabel setelah operasi
- ✅ Validasi input
- ✅ Click tabel untuk edit

**Program Studi:**
1. Teknik Informatika
2. Sistem Informasi
3. Manajemen Informatika
4. Teknik Komputer
5. Rekayasa Perangkat Lunak

### Menu 3: Tugas
- ✅ Card layout modern dengan shadow
- ✅ Mockup visual Tugas 1 (Kalkulator)
- ✅ Mockup visual Tugas 2 (CRUD Mahasiswa)
- ✅ Daftar fitur setiap tugas
- ✅ Desain responsive dan menarik

---

## 🛠️ TEKNOLOGI

```
Language:       Java (JDK 8+)
GUI Framework:  Java Swing
Database:       MySQL
Server:         XAMPP
IDE:            NetBeans
JDBC Driver:    MySQL Connector/J
```

---

## 📁 STRUKTUR PROJECT

```
ProjectMenuMahasiswaV2/
│
├── src/
│   ├── main/
│   │   └── MenuUtama.java          # Menu utama dengan gradient
│   │
│   ├── kalkulator/
│   │   └── KalkulatorForm.java     # Kalkulator modern
│   │
│   ├── pendaftaran/
│   │   └── PendaftaranForm.java    # Form CRUD 8 field
│   │
│   ├── tugas/
│   │   └── TugasForm.java          # Portfolio tugas
│   │
│   └── database/
│       └── Koneksi.java            # Koneksi MySQL
│
├── database.sql                     # Script database
└── README.md                        # Dokumentasi ini
```

---

## 🚀 CARA INSTALASI

### 1. PERSIAPAN SOFTWARE

**Download & Install:**
- ✅ [XAMPP](https://www.apachefriends.org/download.html) - Apache + MySQL
- ✅ [NetBeans IDE](https://netbeans.apache.org/download/) - atau IntelliJ IDEA
- ✅ [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) - JDBC Driver

---

### 2. SETUP DATABASE

#### A. Start MySQL
```
1. Buka XAMPP Control Panel
2. Start Apache
3. Start MySQL
```

#### B. Import Database
```
1. Buka browser → http://localhost/phpmyadmin
2. Klik tab "SQL"
3. Copy seluruh isi file database.sql
4. Paste ke textarea SQL
5. Klik tombol "Go" / "Kirim"
6. Database db_mahasiswa akan terbuat
```

**Atau cara alternatif:**
```
1. Klik "New" di phpMyAdmin
2. Nama database: db_mahasiswa
3. Klik "Import"
4. Choose file → pilih database.sql
5. Klik "Go"
```

#### C. Verifikasi Database
```sql
-- Cek di phpMyAdmin
USE db_mahasiswa;
SELECT * FROM mahasiswa;

-- Harusnya ada 5 data sample
```

---

### 3. SETUP PROJECT DI NETBEANS

#### Opsi A: Import Project (Recommended)

```
1. Extract file ZIP project
2. Buka NetBeans
3. File → Open Project
4. Browse ke folder ProjectMenuMahasiswaV2
5. Klik "Open Project"
```

#### Opsi B: Buat Project Baru

```
1. File → New Project
2. Java → Java Application
3. Project Name: ProjectMenuMahasiswaV2
4. ☐ Uncheck "Create Main Class"
5. Finish
6. Copy semua folder dari src/ ke project NetBeans
7. Refresh project (F5)
```

---

### 4. ADD MySQL Connector

```
1. Klik kanan project → Properties
2. Pilih "Libraries"
3. Klik "Add JAR/Folder"
4. Browse file mysql-connector-java-x.x.xx.jar
5. Klik "OK"
```

**Download MySQL Connector:**
- Link: https://dev.mysql.com/downloads/connector/j/
- Pilih: Platform Independent (ZIP)
- Extract → ambil file .jar

---

### 5. KONFIGURASI DATABASE (Jika Perlu)

Edit file: `src/database/Koneksi.java`

```java
String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
String user = "root";        // Sesuaikan username
String password = "";        // Sesuaikan password
```

---

### 6. JALANKAN APLIKASI

```
1. Pastikan MySQL di XAMPP running (lampu hijau)
2. Di NetBeans, buka src/main/MenuUtama.java
3. Klik kanan → Run File
4. Atau tekan Shift + F6
```

**✅ Aplikasi siap digunakan!**

---

## 💻 CARA MENGGUNAKAN

### Menu Utama
```
1. Pilih menu yang ingin diakses
2. Klik tombol menu:
   - 🔢 KALKULATOR
   - 📝 PENDAFTARAN MAHASISWA
   - 📚 TUGAS
   - 🚪 KELUAR
```

### Kalkulator
```
1. Input angka pertama
2. Pilih operator (+, -, ×, ÷, %)
3. Input angka kedua
4. Tekan = untuk hasil
5. C untuk clear all
6. ⌫ untuk delete digit terakhir
```

### Pendaftaran Mahasiswa

**Tambah Data Baru:**
```
1. Isi semua field form
2. Klik tombol "💾 Simpan"
3. Data tersimpan ke database
4. Tabel otomatis refresh
```

**Edit Data:**
```
1. Klik data di tabel
2. Data muncul di form
3. Edit yang diperlukan
4. Klik "✏️ Update"
```

**Hapus Data:**
```
1. Klik data di tabel
2. Klik "🗑️ Hapus"
3. Konfirmasi hapus
4. Data terhapus dari database
```

**Bersihkan Form:**
```
Klik tombol "🔄 Bersihkan"
```

---

## 🎨 DESAIN & UI/UX

### Color Scheme

**Menu Utama:**
- Gradient: Turquoise → Ocean Blue
- Buttons: Blue, Green, Purple, Red
- Background: Gradient smooth

**Kalkulator:**
- Background: Dark gray gradient
- Numbers: Dark buttons
- Operators: Orange
- Equals: Blue

**Pendaftaran:**
- Gradient: Blue → Green
- Form: White with transparency
- Table: Professional design

**Tugas:**
- Gradient: Purple theme
- Cards: White with shadow
- Modern card layout

### Typography
```
Primary Font:   Segoe UI
Title:          Bold, 28-32px
Subtitle:       Regular, 16px
Button:         Bold, 14-18px
Text:           Regular, 12-14px
```

---

## 🗄️ DATABASE STRUCTURE

```sql
Table: mahasiswa
┌────────────────┬──────────────┬──────────┐
│ Field          │ Type         │ Extra    │
├────────────────┼──────────────┼──────────┤
│ id             │ INT          │ AI, PK   │
│ nama           │ VARCHAR(100) │          │
│ jenis_kelamin  │ VARCHAR(15)  │          │
│ no_telpon      │ VARCHAR(20)  │          │
│ prodi          │ VARCHAR(100) │          │
│ tempat_lahir   │ VARCHAR(100) │          │
│ alamat         │ TEXT         │          │
│ email          │ VARCHAR(100) │          │
│ tahun_masuk    │ VARCHAR(4)   │          │
│ tanggal_daftar │ TIMESTAMP    │ DEFAULT  │
└────────────────┴──────────────┴──────────┘
```

---

## ⚠️ TROUBLESHOOTING

### ❌ Error: Communications link failure
**Solusi:**
```
1. Pastikan XAMPP MySQL running
2. Cek lampu hijau di MySQL
3. Test koneksi di phpMyAdmin
```

### ❌ Error: ClassNotFoundException
**Solusi:**
```
1. Download MySQL Connector/J
2. Add ke Libraries project
3. Clean and Build (Shift + F11)
```

### ❌ Error: Unknown database 'db_mahasiswa'
**Solusi:**
```
1. Buka phpMyAdmin
2. Import database.sql
3. Verify database created
```

### ❌ Form tidak muncul / blank
**Solusi:**
```
1. Clean and Build project
2. Restart NetBeans
3. Run ulang aplikasi
```

### ❌ Data tidak tersimpan
**Solusi:**
```
1. Cek koneksi database
2. Lihat console error
3. Verify MySQL running
4. Cek tabel di phpMyAdmin
```

---

## 📊 FITUR UNGGULAN

### 1. Modern Gradient Design
- ✅ Gradient background di setiap form
- ✅ Smooth color transitions
- ✅ Professional look and feel

### 2. Responsive UI
- ✅ Hover effects pada semua tombol
- ✅ Smooth interactions
- ✅ Visual feedback

### 3. Complete CRUD
- ✅ Full database integration
- ✅ Real-time data update
- ✅ Error handling lengkap

### 4. User Friendly
- ✅ Intuitive interface
- ✅ Clear button labels with icons
- ✅ Easy navigation
- ✅ Confirmation dialogs

### 5. Professional Code
- ✅ Clean code structure
- ✅ Proper error handling
- ✅ Commented code
- ✅ Modular design

---

## 📝 CATATAN PENTING

⚠️ **Harus diperhatikan:**
- MySQL **HARUS** running sebelum jalankan aplikasi
- Database **HARUS** sudah dibuat
- MySQL Connector **HARUS** ditambahkan
- Main Class: `main.MenuUtama`

💡 **Tips:**
- Backup database secara berkala
- Ganti password MySQL default untuk keamanan
- Test semua fitur sebelum deployment
- Baca error messages di console

---

## 🎯 COCOK UNTUK

✅ Tugas kuliah Pemrograman Java
✅ Belajar Java Swing GUI
✅ Portfolio project
✅ Latihan database JDBC
✅ Referensi CRUD application
✅ Final project mata kuliah

---

## 📚 LEARNING OUTCOMES

Setelah menggunakan project ini, Anda akan paham:
- ✅ Java Swing & JFrame
- ✅ Event handling & listeners
- ✅ JDBC & MySQL integration
- ✅ CRUD operations
- ✅ PreparedStatement
- ✅ ResultSet handling
- ✅ Graphics2D untuk custom drawing
- ✅ Layout management
- ✅ Error handling
- ✅ UI/UX design

---

## 🔐 KEAMANAN

**Best Practices:**
```
1. Gunakan PreparedStatement (anti SQL injection)
2. Validasi input di client side
3. Ganti password MySQL default
4. Buat user database khusus
5. Jangan hardcode password
6. Use environment variables
```

---

## 🚀 PENGEMBANGAN LANJUT

**Fitur yang bisa ditambahkan:**
- [ ] Login system & authentication
- [ ] Role-based access (admin/user)
- [ ] Export data ke Excel/PDF
- [ ] Import data dari file
- [ ] Foto/upload dokumen mahasiswa
- [ ] Pencarian & filter advanced
- [ ] Pagination untuk data banyak
- [ ] Statistik & grafik
- [ ] Print kartu mahasiswa
- [ ] Email notification
- [ ] Backup & restore database
- [ ] History log aktivitas
- [ ] Dashboard analytics

---

## 📞 BANTUAN

**Jika ada error:**
1. Cek console NetBeans untuk error message
2. Pastikan semua requirements terinstall
3. Follow instalasi step by step
4. Verify database connection
5. Test dengan data sample

**Error yang sering muncul:**
- Communications link failure → MySQL belum running
- ClassNotFoundException → MySQL Connector belum ditambah
- Unknown database → Database belum dibuat
- SQLException → Cek syntax SQL atau koneksi

---

## 📄 LISENSI

Project ini dibuat untuk keperluan pembelajaran.
Free to use, modify, and distribute for educational purposes.

---

## 👨‍💻 DEVELOPER NOTES

**Technology Stack:**
```
Frontend:  Java Swing
Backend:   Java SE
Database:  MySQL
Server:    XAMPP
IDE:       NetBeans
Version:   1.0.0
Status:    Production Ready ✅
```

---

## ✅ CHECKLIST SETUP

**Sebelum mulai:**
- [ ] XAMPP installed
- [ ] NetBeans installed
- [ ] MySQL Connector downloaded
- [ ] Project files extracted

**Setup database:**
- [ ] MySQL running
- [ ] Database db_mahasiswa created
- [ ] Table mahasiswa created
- [ ] Sample data inserted

**Setup project:**
- [ ] Project imported to NetBeans
- [ ] MySQL Connector added to Libraries
- [ ] Main class set: main.MenuUtama
- [ ] Clean and Build successful

**Testing:**
- [ ] Menu utama displays
- [ ] Kalkulator berfungsi
- [ ] Form pendaftaran bisa simpan data
- [ ] Data muncul di tabel
- [ ] Edit & delete berfungsi
- [ ] Kembali ke menu works

---

## 🎉 SELESAI!

Project ini **production ready** dan siap digunakan!

**Next Steps:**
1. ✅ Test semua fitur
2. ✅ Input data mahasiswa
3. ✅ Cek di phpMyAdmin
4. ✅ Customize sesuai kebutuhan
5. ✅ Deploy!

---

**Made with ❤️ for learning Java**

**Happy Coding! 🚀💻**

---

Version: 1.0.0  
Last Updated: December 2024  
Status: ✅ Production Ready
