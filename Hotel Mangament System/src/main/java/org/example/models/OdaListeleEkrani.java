package org.example.models;

import javax.swing.*;
import java.util.ArrayList;

public class OdaListeleEkrani extends JFrame {
    private JTextArea txtAreaOdalar;
    private JButton btnListele;
    private JFrame previousFrame; // الشاشة السابقة

    // باني جديد يقبل الشاشة السابقة كوسيط
    public OdaListeleEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;

        setTitle("Odaları Listele");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // منطقة النص لعرض الغرف
        txtAreaOdalar = new JTextArea();
        txtAreaOdalar.setBounds(20, 20, 340, 250);
        txtAreaOdalar.setEditable(false);

        // زر قائمة الغرف
        btnListele = new JButton("Listele");
        btnListele.setBounds(150, 290, 100, 30);

        // إضافة المكونات إلى النافذة
        add(txtAreaOdalar);
        add(btnListele);

        // زر العودة إلى الشاشة السابقة
        JButton backButton = new JButton("⬅ Geri");
        backButton.setBounds(10, 330, 100, 30);
        add(backButton);

        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });

        // ربط زر القائمة بوظيفة عرض الغرف
        btnListele.addActionListener(e -> {
            txtAreaOdalar.setText(""); // تنظيف منطقة النص
            ArrayList<String> odalar = OdaDAO.getAllOdaAsList();
            for (String oda : odalar) {
                txtAreaOdalar.append(oda + "\n");
            }
        });

        setVisible(true);
    }
}
