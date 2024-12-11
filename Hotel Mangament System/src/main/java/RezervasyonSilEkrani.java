import javax.swing.*;
import java.awt.event.ActionEvent;

public class RezervasyonSilEkrani extends JFrame {
    private JFrame previousFrame;
    public RezervasyonSilEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;

        setTitle("Rezervasyon Sil");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

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
            new RezervasyonSilEkrani(previousFrame); // Bu ekranı yeniden başlat
            dispose(); // Mevcut ekranı kapat
        });

        // Menü çubuğuna butonları ekle
        menuBar.add(backButton);
        menuBar.add(refreshButton);

        // Menü çubuğunu pencereye ekle
        setJMenuBar(menuBar);

        // Bileşenler
        JLabel rezervasyonNoLabel = new JLabel("Rezervasyon No:");
        JTextField rezervasyonNoField = new JTextField();
        JButton silButton = new JButton("Sil");

        rezervasyonNoLabel.setBounds(20, 20, 150, 30);
        rezervasyonNoField.setBounds(170, 20, 100, 30);
        silButton.setBounds(100, 80, 100, 30);

        add(rezervasyonNoLabel);
        add(rezervasyonNoField);
        add(silButton);

        silButton.addActionListener(e -> {
            double rezervasyonNo = Double.parseDouble(rezervasyonNoField.getText());

            // Rezervasyon silme işlemi
            System.out.println("Rezervasyon silindi: " + rezervasyonNo);

            // Gerçek rezervasyon silme işlemi veritabanı ile yapılabilir.
        });

        setVisible(true);
    }
}
