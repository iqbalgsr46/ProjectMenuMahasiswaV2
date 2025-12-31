# ⚡ PANDUAN INSTALASI CEPAT

## 🚀 3 LANGKAH MUDAH

### 1️⃣ PERSIAPAN (5 menit)
```
✅ Install XAMPP
✅ Install NetBeans IDE
✅ Download MySQL Connector JAR
```

### 2️⃣ SETUP DATABASE (3 menit)
```
1. Buka XAMPP → Start MySQL
2. Browser → http://localhost/phpmyadmin
3. Klik tab SQL
4. Copy isi database.sql
5. Paste dan klik Go
✅ Database siap!
```

### 3️⃣ OPEN PROJECT DI NETBEANS (2 menit)
```
1. Buka NetBeans
2. File → Open Project (bukan New Project!)
3. Browse ke folder ProjectMenuMahasiswaV2
4. Klik "Open Project"
5. ✅ Source Packages akan muncul!
```

### 4️⃣ ADD MySQL CONNECTOR (1 menit)
```
1. Klik kanan project → Properties
2. Pilih "Libraries"
3. Klik "Add JAR/Folder"
4. Browse file mysql-connector-java-xxx.jar
5. Klik "OK"
```

### 5️⃣ RUN APLIKASI (1 menit)
```
1. Di Source Packages, buka main → MenuUtama.java
2. Klik kanan pada file → Run File
3. Atau tekan Shift + F6
✅ Aplikasi berjalan!
```

---

## 📥 DOWNLOAD LINKS

### XAMPP
- Windows: https://www.apachefriends.org/download.html
- Mac/Linux: Same link, pilih OS

### NetBeans
- Link: https://netbeans.apache.org/download/
- Atau download bundled with JDK

### MySQL Connector/J
- Link: https://dev.mysql.com/downloads/connector/j/
- Pilih: Platform Independent (ZIP)

---

## ⚙️ KONFIGURASI DATABASE

**Default Settings:**
```
Host:     localhost
Port:     3306
Database: db_mahasiswa
User:     root
Password: (kosong)
```

**Jika berbeda, edit `src/database/Koneksi.java`:**
```java
String password = "your_password";
```

---

## ✅ CHECKLIST

**Before Running:**
- [ ] XAMPP MySQL running (lampu hijau)
- [ ] Database imported successfully
- [ ] MySQL Connector added to project
- [ ] NetBeans project opened

**Testing:**
- [ ] Menu utama appears
- [ ] Can navigate to all menus
- [ ] Calculator works
- [ ] Can save student data
- [ ] Data shows in table

---

## 🐛 QUICK FIX

**Source Packages kosong?**
→ PENTING: Gunakan "Open Project" BUKAN "New Project"!
→ File → Open Project → Browse folder → Open
→ NetBeans akan auto-detect struktur project

**MySQL not running?**
→ Open XAMPP → Start MySQL

**Database not found?**
→ Import database.sql to phpMyAdmin

**ClassNotFoundException?**
→ Add mysql-connector.jar to Libraries

**Form blank?**
→ Clean and Build (Shift + F11)

---

## 🎯 NEXT STEPS

1. ✅ Test kalkulator
2. ✅ Input data mahasiswa
3. ✅ Cek data di phpMyAdmin
4. ✅ Test CRUD operations
5. ✅ Have fun! 🎉

**Need detailed help? → Read README.md**

---

**Happy Coding! 🚀**
