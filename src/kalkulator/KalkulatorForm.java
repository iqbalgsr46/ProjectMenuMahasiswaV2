package kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.MenuUtama;

public class KalkulatorForm extends JFrame {
    
    private JTextField txtDisplay;
    private JButton[] btnAngka;
    private JButton btnTambah, btnKurang, btnKali, btnBagi;
    private JButton btnSamaDengan, btnClear, btnDelete, btnTitik, btnPersen, btnPlusMinus;
    private JButton btnKembali;
    
    private double angka1 = 0, angka2 = 0, hasil = 0;
    private String operator = "";
    private boolean mulai = true;
    
    public KalkulatorForm() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        setTitle("Kalkulator Modern");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 650);
        setResizable(false);
        setLayout(null);
        
        // Background Panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(67, 67, 67);
                Color color2 = new Color(34, 34, 34);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        backgroundPanel.setBounds(0, 0, 450, 650);
        backgroundPanel.setLayout(null);
        
        // Title
        JLabel lblTitle = new JLabel("KALKULATOR", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(50, 20, 350, 35);
        backgroundPanel.add(lblTitle);
        
        // Display Panel
        JPanel displayPanel = new JPanel();
        displayPanel.setBounds(25, 70, 400, 80);
        displayPanel.setBackground(new Color(60, 60, 60));
        displayPanel.setLayout(null);
        displayPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        
        txtDisplay = new JTextField("0");
        txtDisplay.setBounds(10, 10, 380, 60);
        txtDisplay.setFont(new Font("Segoe UI", Font.BOLD, 36));
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        txtDisplay.setEditable(false);
        txtDisplay.setBackground(new Color(60, 60, 60));
        txtDisplay.setForeground(Color.WHITE);
        txtDisplay.setBorder(null);
        displayPanel.add(txtDisplay);
        backgroundPanel.add(displayPanel);
        
        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(25, 170, 400, 380);
        buttonPanel.setLayout(new GridLayout(6, 4, 8, 8));
        buttonPanel.setOpaque(false);
        
        // Initialize number buttons
        btnAngka = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnAngka[i] = createNumberButton(String.valueOf(i));
            final int angka = i;
            btnAngka[i].addActionListener(e -> inputAngka(angka));
        }
        
        // Operation buttons
        btnClear = createOperatorButton("C", new Color(255, 149, 0));
        btnClear.addActionListener(e -> clear());
        
        btnDelete = createOperatorButton("⌫", new Color(255, 149, 0));
        btnDelete.addActionListener(e -> delete());
        
        btnPersen = createOperatorButton("%", new Color(255, 149, 0));
        btnPersen.addActionListener(e -> setOperator("%"));
        
        btnBagi = createOperatorButton("÷", new Color(255, 149, 0));
        btnBagi.addActionListener(e -> setOperator("/"));
        
        btnKali = createOperatorButton("×", new Color(255, 149, 0));
        btnKali.addActionListener(e -> setOperator("*"));
        
        btnKurang = createOperatorButton("-", new Color(255, 149, 0));
        btnKurang.addActionListener(e -> setOperator("-"));
        
        btnTambah = createOperatorButton("+", new Color(255, 149, 0));
        btnTambah.addActionListener(e -> setOperator("+"));
        
        btnPlusMinus = createOperatorButton("±", new Color(100, 100, 100));
        btnPlusMinus.addActionListener(e -> toggleSign());
        
        btnTitik = createNumberButton(".");
        btnTitik.addActionListener(e -> inputTitik());
        
        btnSamaDengan = createOperatorButton("=", new Color(52, 152, 219));
        btnSamaDengan.addActionListener(e -> hitung());
        
        // Add buttons in order
        // Row 1
        buttonPanel.add(btnClear);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnPersen);
        buttonPanel.add(btnBagi);
        
        // Row 2
        buttonPanel.add(btnAngka[7]);
        buttonPanel.add(btnAngka[8]);
        buttonPanel.add(btnAngka[9]);
        buttonPanel.add(btnKali);
        
        // Row 3
        buttonPanel.add(btnAngka[4]);
        buttonPanel.add(btnAngka[5]);
        buttonPanel.add(btnAngka[6]);
        buttonPanel.add(btnKurang);
        
        // Row 4
        buttonPanel.add(btnAngka[1]);
        buttonPanel.add(btnAngka[2]);
        buttonPanel.add(btnAngka[3]);
        buttonPanel.add(btnTambah);
        
        // Row 5
        buttonPanel.add(btnPlusMinus);
        buttonPanel.add(btnAngka[0]);
        buttonPanel.add(btnTitik);
        buttonPanel.add(btnSamaDengan);
        
        backgroundPanel.add(buttonPanel);
        
        // Back Button
        btnKembali = new JButton("← Kembali ke Menu");
        btnKembali.setBounds(25, 565, 400, 50);
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
    
    private JButton createNumberButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 24));
        btn.setBackground(new Color(80, 80, 80));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(100, 100, 100));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(80, 80, 80));
            }
        });
        
        return btn;
    }
    
    private JButton createOperatorButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 24));
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
    
    private void inputAngka(int angka) {
        if (mulai) {
            txtDisplay.setText(String.valueOf(angka));
            mulai = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + angka);
        }
    }
    
    private void inputTitik() {
        if (!txtDisplay.getText().contains(".")) {
            txtDisplay.setText(txtDisplay.getText() + ".");
        }
    }
    
    private void setOperator(String op) {
        angka1 = Double.parseDouble(txtDisplay.getText());
        operator = op;
        mulai = true;
    }
    
    private void toggleSign() {
        double nilai = Double.parseDouble(txtDisplay.getText());
        nilai = nilai * -1;
        txtDisplay.setText(String.valueOf(nilai));
    }
    
    private void hitung() {
        angka2 = Double.parseDouble(txtDisplay.getText());
        
        switch (operator) {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Tidak bisa dibagi dengan 0!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    clear();
                    return;
                }
                break;
            case "%":
                hasil = angka1 % angka2;
                break;
        }
        
        // Format result
        if (hasil == (long) hasil) {
            txtDisplay.setText(String.valueOf((long) hasil));
        } else {
            txtDisplay.setText(String.valueOf(hasil));
        }
        mulai = true;
    }
    
    private void clear() {
        txtDisplay.setText("0");
        angka1 = 0;
        angka2 = 0;
        hasil = 0;
        operator = "";
        mulai = true;
    }
    
    private void delete() {
        String text = txtDisplay.getText();
        if (text.length() > 1) {
            txtDisplay.setText(text.substring(0, text.length() - 1));
        } else {
            txtDisplay.setText("0");
            mulai = true;
        }
    }
    
    private void kembaliKeMenu() {
        this.dispose();
        MenuUtama menu = new MenuUtama();
        menu.setVisible(true);
    }
}
