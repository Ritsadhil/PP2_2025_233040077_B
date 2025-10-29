/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2b.Modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Harits
 */
public class tugas {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                JFrame frame = new JFrame("Jendela Pertamaku");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                JLabel label = new JLabel("Label ada di atas (NORTH)");
                JButton button = new JButton("Tombol SOUTH");
                JButton button1 = new JButton("Tombol WEST");
                JButton button2 = new JButton("Tombol EAST");
                JButton button3 = new JButton("Tombol Center");
                button.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                button1.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });
                button2.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });
                button3.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });
                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                frame.add(button1, BorderLayout.WEST);
                frame.add(button2, BorderLayout.EAST);
                frame.add(button3, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });
    }
}
