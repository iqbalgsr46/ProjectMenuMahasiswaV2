package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection conn;
    
    public static Connection getKoneksi() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
                String user = "root";
                String password = "";
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Koneksi database berhasil!");
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, 
                "Driver MySQL tidak ditemukan!\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Gagal koneksi ke database!\n" +
                "Pastikan XAMPP MySQL sudah running.\n\n" + 
                e.getMessage(),
                "Error Koneksi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void tutupKoneksi() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Koneksi database ditutup!");
            }
        } catch (SQLException e) {
            System.err.println("Error menutup koneksi: " + e.getMessage());
        }
    }
}
