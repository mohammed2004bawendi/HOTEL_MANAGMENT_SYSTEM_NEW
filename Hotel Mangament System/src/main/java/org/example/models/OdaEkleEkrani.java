package org.example.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdaEkleEkrani extends JFrame {
    private JTextField txtOdaNumarasi, txtKapasite, txtFiyat, txtDurum, txtManzara;
    private JButton btnEkle;
    private JFrame previousFrame; // الشاشة السابقة

    // باني يقبل الشاشة السابقة كوسيط
    public OdaEkleEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;

        setTitle("Oda Ekle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // الحقول والنصوص
        JLabel lblOdaNumarasi = new JLabel("Oda Numarası:");
        lblOdaNumarasi.setBounds(20, 20, 100, 30);
        txtOdaNumarasi = new JTextField();
        txtOdaNumarasi.setBounds(130, 20, 200, 30);

        JLabel lblKapasite = new JLabel("Kapasite:");
        lblKapasite.setBounds(20, 60, 100, 30);
        txtKapasite = new JTextField();
        txtKapasite.setBounds(130, 60, 200, 30);

        JLabel lblFiyat = new JLabel("Fiyat:");
        lblFiyat.setBounds(20, 100, 100, 30);
        txtFiyat = new JTextField();
        txtFiyat.setBounds(130, 100, 200, 30);

        JLabel lblDurum = new JLabel("Durum:");
        lblDurum.setBounds(20, 140, 100, 30);
        txtDurum = new JTextField();
        txtDurum.setBounds(130, 140, 200, 30);

        JLabel lblManzara = new JLabel("Manzara:");
        lblManzara.setBounds(20, 180, 100, 30);
        txtManzara = new JTextField();
        txtManzara.setBounds(130, 180, 200, 30);

        btnEkle = new JButton("Ekle");
        btnEkle.setBounds(130, 230, 100, 30);

        // إضافة الحقول والأزرار إلى النافذة
        add(lblOdaNumarasi);
        add(txtOdaNumarasi);
        add(lblKapasite);
        add(txtKapasite);
        add(lblFiyat);
        add(txtFiyat);
        add(lblDurum);
        add(txtDurum);
        add(lblManzara);
        add(txtManzara);
        add(btnEkle);

        // زر العودة إلى الشاشة السابقة
        JButton backButton = new JButton("⬅ Geri");
        backButton.setBounds(10, 300, 100, 30);
        add(backButton);

        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });

        // زر الإضافة (معالجة الخطأ عند الإدخال المكرر)
        btnEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int odaNumarasi = Integer.parseInt(txtOdaNumarasi.getText());
                    int kapasite = Integer.parseInt(txtKapasite.getText());
                    double fiyat = Double.parseDouble(txtFiyat.getText());
                    String durum = txtDurum.getText();
                    String manzara = txtManzara.getText();

                    // تحقق مما إذا كانت الغرفة موجودة
                    if (OdaDAO.isOdaExists(odaNumarasi)) {
                        JOptionPane.showMessageDialog(null,
                                "Bu oda zaten mevcut (Oda No: " + odaNumarasi + ")",
                                "Hata",
                                JOptionPane.ERROR_MESSAGE);
                        return; // إنهاء العملية إذا كانت الغرفة موجودة
                    }

                    // إنشاء كائن الغرفة وإضافته إلى قاعدة البيانات
                    OdaDTO oda = new OdaDTO();
                    oda.setOdaNumarasi(odaNumarasi);
                    oda.setKapasite(kapasite);
                    oda.setFiyat(fiyat);
                    oda.setDurum(durum);
                    oda.setManzara(manzara);

                    OdaDAO.insertOda(oda);
                    JOptionPane.showMessageDialog(null, "Oda başarıyla eklendi!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Lütfen tüm alanları doğru formatta doldurun!",
                            "Hata",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Hata: " + ex.getMessage(),
                            "Hata",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
