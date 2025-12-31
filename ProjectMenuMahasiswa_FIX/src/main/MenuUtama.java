package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import kalkulator.KalkulatorForm;
import pendaftaran.PendaftaranForm;
import tugas.TugasForm;

public class MenuUtama extends JFrame {
    
    private JButton btnKalkulator, btnPendaftaran, btnTugas, btnKeluar;
    private JLabel lblJudul, lblSubjudul, lblFooter;
    private JPanel panelHeader, panelMenu, panelFooter;
    
    public MenuUtama() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        setTitle("Sistem Informasi Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setResizable(false);
        setLayout(null);
        
        // Gradient Background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(26, 188, 156);
                Color color2 = new Color(46, 134, 193);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        backgroundPanel.setBounds(0, 0, 600, 700);
        backgroundPanel.setLayout(null);
        
        // Header Panel
        panelHeader = new JPanel();
        panelHeader.setBounds(0, 0, 600, 150);
        panelHeader.setOpaque(false);
        panelHeader.setLayout(null);
        
        // Judul
        lblJudul = new JLabel("SISTEM INFORMASI", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setBounds(50, 30, 500, 45);
        panelHeader.add(lblJudul);
        
        lblSubjudul = new JLabel("MAHASISWA UPB", SwingConstants.CENTER);
        lblSubjudul.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblSubjudul.setForeground(new Color(255, 255, 255, 200));
        lblSubjudul.setBounds(50, 75, 500, 40);
        panelHeader.add(lblSubjudul);
        
        backgroundPanel.add(panelHeader);
        
        // Menu Panel
        panelMenu = new JPanel();
        panelMenu.setBounds(50, 170, 500, 450);
        panelMenu.setBackground(new Color(255, 255, 255, 250));
        panelMenu.setLayout(null);
        panelMenu.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 100), 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        // Welcome Label
        JLabel lblWelcome = new JLabel("Pilih Menu", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblWelcome.setForeground(new Color(52, 73, 94));
        lblWelcome.setBounds(50, 20, 400, 30);
        panelMenu.add(lblWelcome);
        
        // Tombol Kalkulator
        btnKalkulator = createStyledButton("KALKULATOR", new Color(52, 152, 219), 80);
        btnKalkulator.addActionListener(e -> bukaKalkulator());
        panelMenu.add(btnKalkulator);
        
        // Tombol Pendaftaran
        btnPendaftaran = createStyledButton("PENDAFTARAN MAHASISWA", new Color(46, 204, 113), 160);
        btnPendaftaran.addActionListener(e -> bukaPendaftaran());
        panelMenu.add(btnPendaftaran);
        
        // Tombol Tugas
        btnTugas = createStyledButton("TUGAS", new Color(155, 89, 182), 240);
        btnTugas.addActionListener(e -> bukaTugas());
        panelMenu.add(btnTugas);
        
        // Tombol Keluar
        btnKeluar = createStyledButton("KELUAR", new Color(231, 76, 60), 340);
        btnKeluar.addActionListener(e -> keluar());
        panelMenu.add(btnKeluar);
        
        backgroundPanel.add(panelMenu);
        
        // Footer
        lblFooter = new JLabel("© 2025 Sistem Informasi Mahasiswa: by Iqbaal", SwingConstants.CENTER);
        lblFooter.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblFooter.setForeground(new Color(255, 255, 255, 180));
        lblFooter.setBounds(50, 630, 500, 20);
        backgroundPanel.add(lblFooter);
        
        add(backgroundPanel);
    }
    
    private JButton createStyledButton(String text, Color bgColor, int yPosition) {
        JButton btn = new JButton(text);
        btn.setBounds(50, yPosition, 400, 60);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(bgColor.brighter());
                btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(bgColor);
                btn.setBorder(null);
            }
        });
        
        return btn;
    }
    
    private void bukaKalkulator() {
        this.setVisible(false);
        KalkulatorForm kalkulator = new KalkulatorForm();
        kalkulator.setVisible(true);
    }
    
    private void bukaPendaftaran() {
        this.setVisible(false);
        PendaftaranForm pendaftaran = new PendaftaranForm();
        pendaftaran.setVisible(true);
    }
    
    private void bukaTugas() {
        this.setVisible(false);
        TugasForm tugas = new TugasForm();
        tugas.setVisible(true);
    }
    
    private void keluar() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Apakah Anda yakin ingin keluar?",
            "Konfirmasi Keluar",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> new MenuUtama().setVisible(true));
    }
}
