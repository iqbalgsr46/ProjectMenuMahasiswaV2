package tugas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.MenuUtama;

public class TugasForm extends JFrame {
    
    private JButton btnKembali;
    
    public TugasForm() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        setTitle("Kumpulan Tugas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
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
                Color color1 = new Color(155, 89, 182);
                Color color2 = new Color(142, 68, 173);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        backgroundPanel.setBounds(0, 0, 1000, 750);
        backgroundPanel.setLayout(null);
        
        // Title
        JLabel lblTitle = new JLabel("📚 KUMPULAN TUGAS", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(50, 30, 900, 45);
        backgroundPanel.add(lblTitle);
        
        JLabel lblSubtitle = new JLabel("Portfolio Tugas Pemrograman Java", SwingConstants.CENTER);
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSubtitle.setForeground(new Color(255, 255, 255, 200));
        lblSubtitle.setBounds(50, 75, 900, 25);
        backgroundPanel.add(lblSubtitle);
        
        // Container Panel
        JPanel containerPanel = new JPanel();
        containerPanel.setBounds(30, 120, 940, 550);
        containerPanel.setLayout(null);
        containerPanel.setOpaque(false);
        
        // Tugas 1 Panel
        JPanel tugas1Panel = createTugasPanel(
            "TUGAS 1: KALKULATOR JAVA",
            "Membuat Aplikasi Kalkulator menggunakan Java Swing",
            new String[]{
                "• GUI dengan Java Swing",
                "• Operasi: +, -, ×, ÷, %",
                "• Fitur Clear dan Delete",
                "• Support angka desimal",
                "• Validasi error handling",
                "• Desain modern & responsive"
            },
            new Color(52, 152, 219),
            20, 0
        );
        containerPanel.add(tugas1Panel);
        
        // Tugas 2 Panel
        JPanel tugas2Panel = createTugasPanel(
            "TUGAS 2: CRUD DATA MAHASISWA",
            "Sistem CRUD Pendaftaran Mahasiswa dengan Database",
            new String[]{
                "• Database MySQL Integration",
                "• Create: Input data mahasiswa",
                "• Read: Tampilkan data di tabel",
                "• Update: Edit data existing",
                "• Delete: Hapus data",
                "• Form lengkap 8 field data"
            },
            new Color(46, 204, 113),
            480, 0
        );
        containerPanel.add(tugas2Panel);
        
        backgroundPanel.add(containerPanel);
        
        // Back Button
        btnKembali = new JButton("← Kembali ke Menu Utama");
        btnKembali.setBounds(350, 680, 300, 50);
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 16));
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
    
    private JPanel createTugasPanel(String title, String subtitle, String[] features, Color themeColor, int x, int y) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // White background with shadow
                g2d.setColor(new Color(0, 0, 0, 30));
                g2d.fillRoundRect(5, 5, getWidth() - 5, getHeight() - 5, 20, 20);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth() - 5, getHeight() - 5, 20, 20);
            }
        };
        
        panel.setBounds(x, y, 440, 550);
        panel.setLayout(null);
        panel.setOpaque(false);
        
        // Header with theme color
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(themeColor);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        headerPanel.setBounds(0, 0, 435, 80);
        headerPanel.setLayout(null);
        headerPanel.setOpaque(false);
        
        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(10, 15, 415, 25);
        headerPanel.add(lblTitle);
        
        JLabel lblSubtitle = new JLabel(subtitle, SwingConstants.CENTER);
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSubtitle.setForeground(new Color(255, 255, 255, 200));
        lblSubtitle.setBounds(10, 42, 415, 20);
        headerPanel.add(lblSubtitle);
        
        panel.add(headerPanel);
        
        // Mockup Area
        JPanel mockupPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (title.contains("KALKULATOR")) {
                    drawCalculatorMockup(g2d);
                } else {
                    drawCRUDMockup(g2d);
                }
            }
        };
        mockupPanel.setBounds(20, 100, 395, 280);
        mockupPanel.setBackground(new Color(240, 240, 240));
        mockupPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        panel.add(mockupPanel);
        
        // Features List
        JLabel lblFeatures = new JLabel("Fitur & Kemampuan:");
        lblFeatures.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFeatures.setForeground(new Color(52, 73, 94));
        lblFeatures.setBounds(20, 390, 200, 25);
        panel.add(lblFeatures);
        
        int featureY = 420;
        for (String feature : features) {
            JLabel lblFeature = new JLabel(feature);
            lblFeature.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lblFeature.setForeground(new Color(52, 73, 94));
            lblFeature.setBounds(20, featureY, 395, 20);
            panel.add(lblFeature);
            featureY += 20;
        }
        
        return panel;
    }
    
    private void drawCalculatorMockup(Graphics2D g2d) {
        // Calculator background
        g2d.setColor(new Color(60, 60, 60));
        g2d.fillRoundRect(50, 20, 295, 240, 15, 15);
        
        // Display
        g2d.setColor(new Color(40, 40, 40));
        g2d.fillRoundRect(65, 35, 265, 45, 8, 8);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 24));
        g2d.drawString("123456", 240, 65);
        
        // Buttons
        String[][] buttons = {
            {"C", "DEL", "%", "÷"},
            {"7", "8", "9", "×"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"±", "0", ".", "="}
        };
        
        Color[] colors = {
            new Color(255, 149, 0),  // Operators
            new Color(80, 80, 80),   // Numbers
            new Color(52, 152, 219)  // Equals
        };
        
        int btnX = 65;
        int btnY = 90;
        int btnSize = 58;
        int gap = 7;
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Color btnColor;
                if (i == 0 || j == 3) {
                    btnColor = colors[0]; // Operators
                } else if (buttons[i][j].equals("=")) {
                    btnColor = colors[2]; // Equals
                } else {
                    btnColor = colors[1]; // Numbers
                }
                
                g2d.setColor(btnColor);
                g2d.fillRoundRect(btnX + (j * (btnSize + gap)), btnY + (i * (btnSize + gap)), 
                                  btnSize, btnSize, 10, 10);
                
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Segoe UI", Font.BOLD, 18));
                FontMetrics fm = g2d.getFontMetrics();
                int textX = btnX + (j * (btnSize + gap)) + (btnSize - fm.stringWidth(buttons[i][j])) / 2;
                int textY = btnY + (i * (btnSize + gap)) + (btnSize + fm.getAscent()) / 2 - 3;
                g2d.drawString(buttons[i][j], textX, textY);
            }
        }
    }
    
    private void drawCRUDMockup(Graphics2D g2d) {
        // Header
        g2d.setColor(new Color(52, 152, 219));
        g2d.fillRoundRect(20, 15, 355, 35, 8, 8);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 14));
        g2d.drawString("FORM PENDAFTARAN MAHASISWA", 75, 37);
        
        // Form Fields
        String[] labels = {"Nama:", "Jenis Kelamin:", "No. Telpon:", "Program Studi:", 
                          "Tempat Lahir:", "Alamat:", "Email:", "Tahun Masuk:"};
        
        int formY = 65;
        g2d.setColor(new Color(52, 73, 94));
        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        
        for (int i = 0; i < 4; i++) {
            // Left column
            g2d.drawString(labels[i], 25, formY + 15);
            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(120, formY, 100, 25, 5, 5);
            g2d.setColor(new Color(200, 200, 200));
            g2d.drawRoundRect(120, formY, 100, 25, 5, 5);
            
            // Right column (if exists)
            if (i + 4 < labels.length) {
                g2d.setColor(new Color(52, 73, 94));
                g2d.drawString(labels[i + 4], 230, formY + 15);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(315, formY, 60, 25, 5, 5);
                g2d.setColor(new Color(200, 200, 200));
                g2d.drawRoundRect(315, formY, 60, 25, 5, 5);
            }
            
            formY += 35;
            g2d.setColor(new Color(52, 73, 94));
        }
        
        // Buttons
        String[] btnTexts = {"Simpan", "Update", "Hapus", "Bersih"};
        Color[] btnColors = {
            new Color(46, 204, 113),
            new Color(52, 152, 219),
            new Color(231, 76, 60),
            new Color(149, 165, 166)
        };
        
        int btnX = 25;
        formY += 10;
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 10));
        for (int i = 0; i < btnTexts.length; i++) {
            g2d.setColor(btnColors[i]);
            g2d.fillRoundRect(btnX, formY, 75, 25, 5, 5);
            g2d.setColor(Color.WHITE);
            FontMetrics fm = g2d.getFontMetrics();
            int textX = btnX + (75 - fm.stringWidth(btnTexts[i])) / 2;
            g2d.drawString(btnTexts[i], textX, formY + 17);
            btnX += 85;
        }
        
        // Table Header
        formY += 40;
        g2d.setColor(new Color(52, 73, 94));
        g2d.fillRect(25, formY, 350, 25);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 9));
        g2d.drawString("ID", 30, formY + 17);
        g2d.drawString("NAMA", 70, formY + 17);
        g2d.drawString("JK", 150, formY + 17);
        g2d.drawString("TELP", 200, formY + 17);
        g2d.drawString("PRODI", 270, formY + 17);
        
        // Sample Data
        String[][] data = {
            {"1", "Ahmad Rizki", "L", "081234567", "TI"},
            {"2", "Siti Nurhaliza", "P", "081234568", "SI"},
            {"3", "Budi Santoso", "L", "081234569", "TI"}
        };
        
        formY += 25;
        g2d.setColor(new Color(52, 73, 94));
        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 8));
        
        for (String[] row : data) {
            g2d.drawString(row[0], 30, formY + 15);
            g2d.drawString(row[1], 70, formY + 15);
            g2d.drawString(row[2], 150, formY + 15);
            g2d.drawString(row[3], 200, formY + 15);
            g2d.drawString(row[4], 270, formY + 15);
            
            g2d.setColor(new Color(200, 200, 200));
            g2d.drawLine(25, formY + 20, 375, formY + 20);
            g2d.setColor(new Color(52, 73, 94));
            formY += 22;
        }
    }
    
    private void kembaliKeMenu() {
        this.dispose();
        MenuUtama menu = new MenuUtama();
        menu.setVisible(true);
    }
}
