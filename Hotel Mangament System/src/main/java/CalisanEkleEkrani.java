import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalisanEkleEkrani extends JFrame {
    private JFrame previousFrame;
    public CalisanEkleEkrani(JFrame previousFrame) {
        this.previousFrame = previousFrame;
        setTitle("Çalışan Ekle");
        setSize(300, 300);
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
            new CalisanEkleEkrani(previousFrame); // Bu ekranı yeniden başlat
            dispose(); // Mevcut ekranı kapat
        });

        // Menü çubuğuna butonları ekle
        menuBar.add(backButton);
        menuBar.add(refreshButton);

        // Menü çubuğunu pencereye ekle
        setJMenuBar(menuBar);

        // Bileşenler
        JLabel isimLabel = new JLabel("İsim Soyisim:");
        JTextField isimField = new JTextField();
        JLabel kimlikLabel = new JLabel("Kimlik:");
        JTextField kimlikField = new JTextField();
        JLabel gorevLabel = new JLabel("Görev:");
        JTextField gorevField = new JTextField();
        JLabel maasLabel = new JLabel("Maaş:");
        JTextField maasField = new JTextField();

        JButton ekleButton = new JButton("Ekle");

        isimLabel.setBounds(20, 20, 100, 30);
        isimField.setBounds(120, 20, 150, 30);
        kimlikLabel.setBounds(20, 60, 100, 30);
        kimlikField.setBounds(120, 60, 150, 30);
        gorevLabel.setBounds(20, 100, 100, 30);
        gorevField.setBounds(120, 100, 150, 30);
        maasLabel.setBounds(20, 140, 100, 30);
        maasField.setBounds(120, 140, 150, 30);
        ekleButton.setBounds(90, 200, 100, 30);

        add(isimLabel);
        add(isimField);
        add(kimlikLabel);
        add(kimlikField);
        add(gorevLabel);
        add(gorevField);
        add(maasLabel);
        add(maasField);
        add(ekleButton);

        ekleButton.addActionListener(e -> {
            // Çalışan bilgilerini veritabanına ekleyin
            String isim = isimField.getText();
            String kimlik = kimlikField.getText();
            String gorev = gorevField.getText();
            double maas = Double.parseDouble(maasField.getText());

            // Personel ekleme işlemi
            //Personel personel = new Personel();
            //personel.personelEkle(isim, kimlik, gorev, maas);

            JOptionPane.showMessageDialog(this, "Çalışan başarıyla eklendi!");
        });

        setVisible(true);
    }
}