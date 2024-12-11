import javax.swing.*;
import java.awt.event.ActionEvent;

public class MusteriEkrani extends JFrame {
    private JFrame previousFrame;
    public MusteriEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;

        setTitle("Müşteri Ekranı");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Butonların manuel yerleşimi

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
            new MusteriEkrani(previousFrame); // Bu ekranı yeniden başlat
            dispose(); // Mevcut ekranı kapat
        });

        // Menü çubuğuna butonları ekle
        menuBar.add(backButton);
        menuBar.add(refreshButton);

        // Menü çubuğunu pencereye ekle
        setJMenuBar(menuBar);

        // Butonlar
        JButton rezervasyonYapButton = new JButton("Rezervasyon Yap");
        JButton rezervasyonGorButton = new JButton("Rezervasyonu Gör");

        // Butonların konumları
        rezervasyonYapButton.setBounds(100, 30, 200, 40);
        rezervasyonGorButton.setBounds(100, 120, 200, 40);

        // Butonları eklemek
        add(rezervasyonYapButton);
        add(rezervasyonGorButton);

        // Rezervasyon Yap butonuna tıklandığında rezervasyon yapma ekranını aç
        rezervasyonYapButton.addActionListener(e -> {
            new RezervasyonYapEkrani(this);
            dispose();
        });

        // Rezervasyon Gör butonuna tıklandığında rezervasyonu görüntüleme ekranını aç
        rezervasyonGorButton.addActionListener(e -> {
            new RezervasyonGorEkrani(this);
            dispose();
        });

        setVisible(true); // Ekranı görünür hale getir
    }

}
