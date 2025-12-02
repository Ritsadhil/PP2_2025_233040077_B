/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2b.Modul6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Harits
 */
public class Latihan2 {
    public static void main(String[] args) {
         JFrame frame = new JFrame("Latihan 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        JTextField textField = new JTextField();
        JLabel celc = new JLabel("Celcius:");
        JButton konv = new JButton("Konversi");
        JLabel fahr = new JLabel("Fahrenheit");
        JLabel hasil = new JLabel("");
        
        
       ActionListener konverte = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double c = Double.parseDouble(textField.getText());
                    double f = (c * 9 / 5) + 32;
                    hasil.setText(String.valueOf(f));
                } catch (NumberFormatException ex) {
                    hasil.setText("Input Invalid");
                }
            }
        };
       
       konv.addActionListener(konverte);
       frame.setLayout(new GridLayout(3, 2, 4, 5));
        frame.add(celc);
        frame.add(textField);
        frame.add(fahr);
        frame.add(hasil);
        frame.add(konv);
        
       
        frame.setVisible(true);
    }
}
