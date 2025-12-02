/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2b.modul7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author Harits
 */
public class tugasModul7 extends JFrame{
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;
    
private JPanel createInputPanel() {
    JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    panel.add(new JLabel("Nama Siswa:"));
    txtNama = new JTextField();
    panel.add(txtNama);

    panel.add(new JLabel("Mata Pelajaran:"));
    String[] matkul = { "Matematika Dasar", "Bahasa Indonesia",
        "Algoritma dan Pemrograman I", "Praktikum Pemrograman II" };
    cmbMatkul = new JComboBox<>(matkul);
    panel.add(cmbMatkul);

    panel.add(new JLabel("Nilai (0-100):"));
    txtNilai = new JTextField();
    panel.add(txtNilai);
    
    JButton btnReset = new JButton("Reset Form");
        btnReset.addActionListener(e -> resetForm());
        panel.add(btnReset);

    JButton btnSimpan = new JButton("Simpan Data");
    panel.add(new JLabel("")); // Placeholder kosong agar tombol di kanan
    panel.add(btnSimpan);

    btnSimpan.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            prosesSimpan();
        }
    });
    
    

    return panel;
}

private JPanel createTablePanel() {
    JPanel panel = new JPanel(new BorderLayout());
    
    String[] kolom = { "Nama Siswa", "Mata Pelajaran", "Nilai", "Grade" };
    tableModel = new DefaultTableModel(kolom, 0);
    tableData = new JTable(tableModel);
    
    JScrollPane scrollPane = new JScrollPane(tableData);
    panel.add(scrollPane, BorderLayout.CENTER);
    
    JButton btnHapus = new JButton("Hapus Data Terpilih");
        
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableData.getSelectedRow();
                if (selectedRow > -1) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus terlebih dahulu!", 
                            "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnHapus);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
         return panel;
}

private void resetForm() {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
        txtNama.requestFocus();
    }

// Logika Validasi dan Penyimpanan Data
private void prosesSimpan() {
    String nama = txtNama.getText();
    String matkul = (String) cmbMatkul.getSelectedItem();
    String strNilai = txtNilai.getText();

    if (nama.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                "Error Validasi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama harus terdiri dari minimal 3 karakter!",
                    "Error Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

    int nilai;
    try {
        nilai = Integer.parseInt(strNilai);
        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                    "Error Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                "Error Validasi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String grade;
        switch (nilai / 10) {
            case 10: 
            case 9:  
            case 8:  
                grade = "A";
                break;
            case 7:  
                grade = "AB";
                break;
            case 6:  
                grade = "B";
                break;
            case 5:  
                grade = "BC";
                break;
            case 4:  
                grade = "C";
                break;
            case 3:  
                grade = "D";
                break;
            default: 
                grade = "E";
                break;
        }

    Object[] dataBaris = {nama, matkul, nilai, grade};
    tableModel.addRow(dataBaris);

    txtNama.setText("");
    txtNilai.setText("");
    cmbMatkul.setSelectedIndex(0);

    JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
    
    tabbedPane.setSelectedIndex(1);
}

public tugasModul7() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tugasModul7().setVisible(true);
        });
    }
}
