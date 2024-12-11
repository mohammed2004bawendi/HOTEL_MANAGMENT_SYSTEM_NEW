import org.example.models.OdaAraEkrani;
import org.example.models.OdaListeleEkrani;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ResepsiyonEkrani extends JFrame {
    private JFrame previousFrame;
    public ResepsiyonEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;

        setTitle("Resepsiyon Ekranı");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Butonların manuel konumlandırılması

        // Menü çubuğu oluştur
        JMenuBar menuBar = new JMenuBar();

        // Geri Butonu
        JButton backButton = new JButton("⬅ Geri");
        backButton.addActionListener((ActionEvent e) -> {
            previousFrame.setVisible(true); // Önceki ekranı göster
            dispose(); // Mevcut ekranı kapat
        });

        // Yenile Butonu
        JButton refreshButton = new JButton("🔄 Yenile");
        refreshButton.addActionListener((ActionEvent e) -> {
            new ResepsiyonEkrani(previousFrame); // Bu ekranı yeniden başlat
            dispose(); // Mevcut ekranı kapat
        });

        // Menü çubuğuna butonları ekle
        menuBar.add(backButton);
        menuBar.add(refreshButton);

        // Menü çubuğunu pencereye ekle
        setJMenuBar(menuBar);

        // Butonlar
        JButton odaAraButton = new JButton("Oda Ara");
        JButton odaListeleButton = new JButton("Odaları Listele");
        JButton rezervasyonYapButton = new JButton("Rezervasyon Yap");
        JButton rezervasyonSilButton = new JButton("Rezervasyon Sil");

        // Butonların konumları
        odaAraButton.setBounds(100, 30, 200, 40);
        odaListeleButton.setBounds(100, 80, 200, 40);
        rezervasyonYapButton.setBounds(100, 130, 200, 40);
        rezervasyonSilButton.setBounds(100, 180, 200, 40);

        // Butonları eklemek
        add(odaAraButton);
        add(odaListeleButton);
        add(rezervasyonYapButton);
        add(rezervasyonSilButton);

        // Oda Ara butonuna tıklandığında oda arama ekranını aç
        odaAraButton.addActionListener(e -> {
            new OdaAraEkrani();
            dispose();
        });

        // Odaları Listele butonuna tıklandığında oda listeleme ekranını aç
        odaListeleButton.addActionListener(e -> {
            new OdaListeleEkrani(this);
            dispose();
        });

        // Rezervasyon Yap butonuna tıklandığında rezervasyon yapma ekranını aç
        rezervasyonYapButton.addActionListener(e -> {
            new RezervasyonYapEkrani(this);
            dispose();
        });

        // Rezervasyon Sil butonuna tıklandığında rezervasyon silme ekranını aç
        rezervasyonSilButton.addActionListener(e -> {
            new RezervasyonSilEkrani(this);
            dispose();
        });

        setVisible(true); // Ekranı görünür hale getir
    }
}
