import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalisanListeleEkrani extends JFrame {
    private JFrame previousFrame;
    public CalisanListeleEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;

        setTitle("Çalışanları Gör");
        setSize(400, 400);
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
            new RezervasyonListeEkrani(previousFrame); // Bu ekranı yeniden başlat
            dispose(); // Mevcut ekranı kapat
        });

        // Menü çubuğuna butonları ekle
        menuBar.add(backButton);
        menuBar.add(refreshButton);

        // Menü çubuğunu pencereye ekle
        setJMenuBar(menuBar);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 20, 350, 300);
        textArea.setEditable(false);

        // Rezervasyonları listeleme
        //Rezervasyon rezervasyon = new Rezervasyon();
        //rezervasyon.rezervasyonListele(); // Rezervasyonları listeleme işlemi (veritabanı üzerinden)

        // Örnek: Rezervasyon verisi yazdırma (gerçek veritabanı sorgusuyla bu dinamik hale gelir)
        textArea.setText("Rezervasyon No: 12345, Oda: 101, İsim: Ahmet Kaya\n");
        textArea.append("Rezervasyon No: 67890, Oda: 102, İsim: Elif Yılmaz\n");

        add(textArea);

        setVisible(true);
    }
}
