package id.ac.unpas.modul08.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasilLuas = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitungLuas = new JButton("Hitung Luas");
    private JButton btnHitungKeliling = new JButton("Hitung Keliling");
    private JButton reset = new JButton("Reset");

    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6, 3, 15, 15));
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasilLuas);
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling);
        this.add(btnHitungLuas);
        this.add(btnHitungKeliling);
        this.add(reset);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public void setHasilKeliling(String hasil) {
        lblHasilKeliling.setText(String.valueOf(hasil));
    }

    public void setHasilLuas(String hasil) {
        lblHasilLuas.setText(String.valueOf(hasil));
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungLuasListener(ActionListener listener) {
        btnHitungLuas.addActionListener(listener);
    }

    public void addHitungKelilingListener(ActionListener listener) {
        btnHitungKeliling.addActionListener(listener);
    }
    public void addResetListener(ActionListener listener) {
        reset.addActionListener(listener);
    }

    public void resetInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
    }
}
