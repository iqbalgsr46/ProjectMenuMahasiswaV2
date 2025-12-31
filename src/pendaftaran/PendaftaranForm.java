package pendaftaran;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import database.Koneksi;
import main.MenuUtama;

public class PendaftaranForm extends JFrame {
    
    private JLabel lblTitle, lblNama, lblJK, lblTelp, lblProdi, lblTempat, lblAlamat, lblEmail, lblTahun;
    private JTextField txtNama, txtTelp, txtTempat, txtAlamat, txtEmail, txtTahun;
    private JComboBox<String> cmbJK, cmbProdi;
    private JButton btnSimpan, btnUpdate, btnHapus, btnBersih, btnKembali;
    private JTable tabelMahasiswa;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JPanel contentPanel;
    
    public PendaftaranForm() {
        initComponents();
        buatTabel();
        loadData();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        setTitle("Pendaftaran Mahasiswa Baru");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 750);
        setResizable(false);
        setLayout(null);
        
        // Background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(52, 152, 219);
                Color color2 = new Color(46, 204, 113);
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        backgroundPanel.setBounds(0, 0, 1100, 750);
        backgroundPanel.setLayout(null);
        
        // Title
        lblTitle = new JLabel("FORM PENDAFTARAN MAHASISWA BARU", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(50, 20, 1000, 40);
        backgroundPanel.add(lblTitle);
        
        // Content Panel
        contentPanel = new JPanel();
        contentPanel.setBounds(30, 80, 1040, 620);
        contentPanel.setBackground(new Color(255, 255, 255, 250));
        contentPanel.setLayout(null);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255), 3),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Form Section Label
        JLabel lblFormSection = new JLabel("DATA MAHASISWA");
        lblFormSection.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblFormSection.setForeground(new Color(52, 73, 94));
        lblFormSection.setBounds(20, 15, 300, 25);
        contentPanel.add(lblFormSection);
        
        int leftCol = 20;
        int rightCol = 530;
        int labelWidth = 150;
        int fieldWidth = 330;
        int startY = 55;
        int gap = 45;
        
        // KOLOM KIRI
        // Nama Lengkap
        lblNama = createLabel("Nama Lengkap:", leftCol, startY);
        contentPanel.add(lblNama);
        txtNama = createTextField(leftCol + labelWidth, startY, fieldWidth);
        contentPanel.add(txtNama);
        
        // Jenis Kelamin
        lblJK = createLabel("Jenis Kelamin:", leftCol, startY + gap);
        contentPanel.add(lblJK);
        String[] jenisKelamin = {"Laki-laki", "Perempuan"};
        cmbJK = createComboBox(jenisKelamin, leftCol + labelWidth, startY + gap, fieldWidth);
        contentPanel.add(cmbJK);
        
        // No Telepon
        lblTelp = createLabel("No. Telepon:", leftCol, startY + gap * 2);
        contentPanel.add(lblTelp);
        txtTelp = createTextField(leftCol + labelWidth, startY + gap * 2, fieldWidth);
        contentPanel.add(txtTelp);
        
        // Program Studi
        lblProdi = createLabel("Program Studi:", leftCol, startY + gap * 3);
        contentPanel.add(lblProdi);
        String[] prodi = {
            "Teknik Informatika", 
            "Sistem Informasi", 
            "Manajemen Informatika",
            "Teknik Komputer",
            "Rekayasa Perangkat Lunak"
        };
        cmbProdi = createComboBox(prodi, leftCol + labelWidth, startY + gap * 3, fieldWidth);
        contentPanel.add(cmbProdi);
        
        // KOLOM KANAN
        // Tempat Lahir
        lblTempat = createLabel("Tempat Lahir:", rightCol, startY);
        contentPanel.add(lblTempat);
        txtTempat = createTextField(rightCol + labelWidth, startY, fieldWidth);
        contentPanel.add(txtTempat);
        
        // Alamat
        lblAlamat = createLabel("Alamat:", rightCol, startY + gap);
        contentPanel.add(lblAlamat);
        txtAlamat = createTextField(rightCol + labelWidth, startY + gap, fieldWidth);
        contentPanel.add(txtAlamat);
        
        // Email
        lblEmail = createLabel("Email:", rightCol, startY + gap * 2);
        contentPanel.add(lblEmail);
        txtEmail = createTextField(rightCol + labelWidth, startY + gap * 2, fieldWidth);
        contentPanel.add(txtEmail);
        
        // Tahun Masuk
        lblTahun = createLabel("Tahun Masuk:", rightCol, startY + gap * 3);
        contentPanel.add(lblTahun);
        txtTahun = createTextField(rightCol + labelWidth, startY + gap * 3, fieldWidth);
        contentPanel.add(txtTahun);
        
        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 250, 1000, 60);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setOpaque(false);
        
        btnSimpan = createStyledButton("💾 Simpan", new Color(46, 204, 113));
        btnSimpan.addActionListener(e -> simpanData());
        buttonPanel.add(btnSimpan);
        
        btnUpdate = createStyledButton("✏️ Update", new Color(52, 152, 219));
        btnUpdate.addActionListener(e -> updateData());
        buttonPanel.add(btnUpdate);
        
        btnHapus = createStyledButton("🗑️ Hapus", new Color(231, 76, 60));
        btnHapus.addActionListener(e -> hapusData());
        buttonPanel.add(btnHapus);
        
        btnBersih = createStyledButton("🔄 Bersihkan", new Color(149, 165, 166));
        btnBersih.addActionListener(e -> bersihkanForm());
        buttonPanel.add(btnBersih);
        
        contentPanel.add(buttonPanel);
        
        // Table Section
        JLabel lblTableSection = new JLabel("DATA MAHASISWA TERDAFTAR");
        lblTableSection.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTableSection.setForeground(new Color(52, 73, 94));
        lblTableSection.setBounds(20, 320, 400, 25);
        contentPanel.add(lblTableSection);
        
        backgroundPanel.add(contentPanel);
        
        // Back Button
        btnKembali = new JButton("← Kembali ke Menu");
        btnKembali.setBounds(30, 710, 200, 40);
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnKembali.setBackground(new Color(52, 73, 94));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.setBorderPainted(false);
        btnKembali.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKembali.addActionListener(e -> kembaliKeMenu());
        
        btnKembali.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnKembali.setBackground(new Color(52, 73, 94).brighter());
            }
            public void mouseExited(MouseEvent e) {
                btnKembali.setBackground(new Color(52, 73, 94));
            }
        });
        
        backgroundPanel.add(btnKembali);
        add(backgroundPanel);
    }
    
    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(52, 73, 94));
        label.setBounds(x, y, 150, 30);
        return label;
    }
    
    private JTextField createTextField(int x, int y, int width) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, 35);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return textField;
    }
    
    private JComboBox<String> createComboBox(String[] items, int x, int y, int width) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, 35);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }
    
    private JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(180, 45));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(color.brighter());
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });
        
        return btn;
    }
    
    private void buatTabel() {
        String[] kolom = {
            "ID", "Nama Lengkap", "Jenis Kelamin", "No. Telepon", 
            "Program Studi", "Tempat Lahir", "Alamat", "Email", "Tahun Masuk"
        };
        model = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabelMahasiswa = new JTable(model);
        tabelMahasiswa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tabelMahasiswa.setRowHeight(30);
        tabelMahasiswa.setSelectionBackground(new Color(52, 152, 219));
        tabelMahasiswa.setSelectionForeground(Color.WHITE);
        tabelMahasiswa.setGridColor(new Color(189, 195, 199));
        
        JTableHeader header = tabelMahasiswa.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBackground(new Color(52, 73, 94));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        
        tabelMahasiswa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tabelMahasiswa.getSelectedRow();
                if (row != -1) {
                    txtNama.setText(model.getValueAt(row, 1).toString());
                    cmbJK.setSelectedItem(model.getValueAt(row, 2).toString());
                    txtTelp.setText(model.getValueAt(row, 3).toString());
                    cmbProdi.setSelectedItem(model.getValueAt(row, 4).toString());
                    txtTempat.setText(model.getValueAt(row, 5).toString());
                    txtAlamat.setText(model.getValueAt(row, 6).toString());
                    txtEmail.setText(model.getValueAt(row, 7).toString());
                    txtTahun.setText(model.getValueAt(row, 8).toString());
                }
            }
        });
        
        scrollPane = new JScrollPane(tabelMahasiswa);
        scrollPane.setBounds(20, 350, 1000, 230);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 2));
        contentPanel.add(scrollPane);
    }
    
    private void simpanData() {
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Nama harus diisi!", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            txtNama.requestFocus();
            return;
        }
        
        try {
            Connection conn = Koneksi.getKoneksi();
            if (conn != null) {
                String sql = "INSERT INTO mahasiswa (nama, jenis_kelamin, no_telpon, prodi, tempat_lahir, alamat, email, tahun_masuk) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtNama.getText());
                ps.setString(2, cmbJK.getSelectedItem().toString());
                ps.setString(3, txtTelp.getText());
                ps.setString(4, cmbProdi.getSelectedItem().toString());
                ps.setString(5, txtTempat.getText());
                ps.setString(6, txtAlamat.getText());
                ps.setString(7, txtEmail.getText());
                ps.setString(8, txtTahun.getText());
                
                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, 
                        "✅ Data berhasil disimpan!", 
                        "Sukses", 
                        JOptionPane.INFORMATION_MESSAGE);
                    bersihkanForm();
                    loadData();
                }
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error Database", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void updateData() {
        int row = tabelMahasiswa.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, 
                "Pilih data yang akan diupdate!", 
                "Peringatan", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Connection conn = Koneksi.getKoneksi();
            if (conn != null) {
                int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                String sql = "UPDATE mahasiswa SET nama=?, jenis_kelamin=?, no_telpon=?, prodi=?, " +
                             "tempat_lahir=?, alamat=?, email=?, tahun_masuk=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtNama.getText());
                ps.setString(2, cmbJK.getSelectedItem().toString());
                ps.setString(3, txtTelp.getText());
                ps.setString(4, cmbProdi.getSelectedItem().toString());
                ps.setString(5, txtTempat.getText());
                ps.setString(6, txtAlamat.getText());
                ps.setString(7, txtEmail.getText());
                ps.setString(8, txtTahun.getText());
                ps.setInt(9, id);
                
                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, 
                        "✅ Data berhasil diupdate!", 
                        "Sukses", 
                        JOptionPane.INFORMATION_MESSAGE);
                    bersihkanForm();
                    loadData();
                }
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error Database", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void hapusData() {
        int row = tabelMahasiswa.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, 
                "Pilih data yang akan dihapus!", 
                "Peringatan", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection conn = Koneksi.getKoneksi();
                if (conn != null) {
                    int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                    String sql = "DELETE FROM mahasiswa WHERE id=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    
                    int result = ps.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, 
                            "✅ Data berhasil dihapus!", 
                            "Sukses", 
                            JOptionPane.INFORMATION_MESSAGE);
                        bersihkanForm();
                        loadData();
                    }
                    ps.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error: " + e.getMessage(), 
                    "Error Database", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void loadData() {
        model.setRowCount(0);
        try {
            Connection conn = Koneksi.getKoneksi();
            if (conn != null) {
                String sql = "SELECT * FROM mahasiswa ORDER BY id DESC";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("jenis_kelamin"),
                        rs.getString("no_telpon"),
                        rs.getString("prodi"),
                        rs.getString("tempat_lahir"),
                        rs.getString("alamat"),
                        rs.getString("email"),
                        rs.getString("tahun_masuk")
                    };
                    model.addRow(row);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error load data: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void bersihkanForm() {
        txtNama.setText("");
        txtTelp.setText("");
        txtTempat.setText("");
        txtAlamat.setText("");
        txtEmail.setText("");
        txtTahun.setText("");
        cmbJK.setSelectedIndex(0);
        cmbProdi.setSelectedIndex(0);
        tabelMahasiswa.clearSelection();
        txtNama.requestFocus();
    }
    
    private void kembaliKeMenu() {
        this.dispose();
        MenuUtama menu = new MenuUtama();
        menu.setVisible(true);
    }
}
