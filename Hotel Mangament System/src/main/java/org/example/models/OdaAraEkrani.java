package org.example.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdaAraEkrani extends JFrame {
    private JTextField txtOdaNumarasi, txtYeniDurum;
    private JButton btnGuncelle;

    public OdaAraEkrani() {
        setTitle("Oda Durumu Güncelle");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblOdaNumarasi = new JLabel("Oda Numarası:");
        lblOdaNumarasi.setBounds(20, 20, 100, 30);
        txtOdaNumarasi = new JTextField();
        txtOdaNumarasi.setBounds(130, 20, 150, 30);

        JLabel lblYeniDurum = new JLabel("Yeni Durum:");
        lblYeniDurum.setBounds(20, 60, 100, 30);
        txtYeniDurum = new JTextField();
        txtYeniDurum.setBounds(130, 60, 150, 30);

        btnGuncelle = new JButton("Güncelle");
        btnGuncelle.setBounds(100, 110, 100, 30);

        add(lblOdaNumarasi);
        add(txtOdaNumarasi);
        add(lblYeniDurum);
        add(txtYeniDurum);
        add(btnGuncelle);

        // زر تحديث حالة الغرفة
        btnGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int odaNumarasi = Integer.parseInt(txtOdaNumarasi.getText());
                    String yeniDurum = txtYeniDurum.getText();

                    OdaDAO.updateOdaDurum(odaNumarasi, yeniDurum);
                    JOptionPane.showMessageDialog(null, "Durum başarıyla güncellendi!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
