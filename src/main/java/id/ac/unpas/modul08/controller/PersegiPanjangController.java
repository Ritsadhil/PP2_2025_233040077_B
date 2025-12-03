package id.ac.unpas.modul08.controller;

import id.ac.unpas.modul08.model.PersegiPanjangModel;
import id.ac.unpas.modul08.view.PersegiPanjangView;

public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        this.view.addHitungLuasListener(new HitungListenerLuas());
        this.view.addHitungKelilingListener(new HitungListenerKeliling());
        this.view.addResetListener(new ResetListener());
    }

    class HitungListenerLuas implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungLuas();

                double hasil = model.getLuas();

                view.setHasilLuas(String.valueOf(hasil));

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Input tidak valid. Harap masukkan angka yang valid.");
            }
        }
    }

     class HitungListenerKeliling implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungKeliling();

                double keliling = model.getKeliling();

                view.setHasilKeliling(String.valueOf(keliling));

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Input tidak valid. Harap masukkan angka yang valid.");
            }
        }
    }

    class ResetListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            view.resetInput();
            model.setPanjang(0);
            model.setLebar(0);
            view.setHasilLuas("-");
            view.setHasilKeliling("-");
        }
    }
}
