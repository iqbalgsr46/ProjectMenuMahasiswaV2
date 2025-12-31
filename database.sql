-- ============================================
-- DATABASE MAHASISWA
-- Sistem Pendaftaran Mahasiswa Baru
-- ============================================

-- Buat database
CREATE DATABASE IF NOT EXISTS db_mahasiswa;

-- Gunakan database
USE db_mahasiswa;

-- Hapus tabel jika sudah ada (untuk fresh install)
DROP TABLE IF EXISTS mahasiswa;

-- Buat tabel mahasiswa dengan field lengkap
CREATE TABLE mahasiswa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    jenis_kelamin VARCHAR(15) NOT NULL,
    no_telpon VARCHAR(20),
    prodi VARCHAR(100),
    tempat_lahir VARCHAR(100),
    alamat TEXT,
    email VARCHAR(100),
    tahun_masuk VARCHAR(4),
    tanggal_daftar TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_nama (nama),
    INDEX idx_prodi (prodi)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data sample
INSERT INTO mahasiswa (nama, jenis_kelamin, no_telpon, prodi, tempat_lahir, alamat, email, tahun_masuk) VALUES
('Ahmad Rizki Pratama', 'Laki-laki', '081234567890', 'Teknik Informatika', 'Jakarta', 'Jl. Merdeka No. 123, Jakarta Selatan', 'ahmad.rizki@email.com', '2024'),
('Siti Nurhaliza', 'Perempuan', '081234567891', 'Sistem Informasi', 'Bandung', 'Jl. Soekarno Hatta No. 45, Bandung', 'siti.nur@email.com', '2024'),
('Budi Santoso', 'Laki-laki', '081234567892', 'Teknik Informatika', 'Bogor', 'Jl. Pajajaran No. 78, Bogor', 'budi.santoso@email.com', '2024'),
('Dewi Lestari', 'Perempuan', '081234567893', 'Manajemen Informatika', 'Surabaya', 'Jl. Ahmad Yani No. 99, Surabaya', 'dewi.lestari@email.com', '2023'),
('Eko Prasetyo', 'Laki-laki', '081234567894', 'Teknik Komputer', 'Semarang', 'Jl. Pemuda No. 56, Semarang', 'eko.prasetyo@email.com', '2023');

-- Tampilkan semua data
SELECT * FROM mahasiswa;

-- Query untuk statistik
SELECT 
    COUNT(*) as total_mahasiswa,
    COUNT(CASE WHEN jenis_kelamin = 'Laki-laki' THEN 1 END) as total_laki,
    COUNT(CASE WHEN jenis_kelamin = 'Perempuan' THEN 1 END) as total_perempuan
FROM mahasiswa;

-- Query data per prodi
SELECT prodi, COUNT(*) as jumlah 
FROM mahasiswa 
GROUP BY prodi 
ORDER BY jumlah DESC;

-- ============================================
-- CATATAN PENTING:
-- ============================================
-- 1. Jalankan script ini di phpMyAdmin
-- 2. Pastikan XAMPP MySQL sudah running
-- 3. Setelah berhasil, data sample akan muncul
-- 4. Aplikasi Java siap digunakan
-- ============================================
