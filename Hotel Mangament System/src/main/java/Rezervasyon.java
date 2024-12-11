public class Rezervasyon {
    private final Double rezervasyonNo=Math.random();
    private String isimSoyisim ;
    private String cinsiyet;
    private int yas;
    private String tcKimlik;
    private String email;
    private String telefonNo;
    private String kalinacakTarihler;
    private int odaBilgisi;

    private String krediKartNo;

    public Double getRezervasyonNo() {
        return rezervasyonNo;
    }

    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getKalinacakTarihler() {
        return kalinacakTarihler;
    }

    public void setKalinacakTarihler(String kalinacakTarihler) {
        this.kalinacakTarihler = kalinacakTarihler;
    }

    public int getOdaBilgisi() {
        return odaBilgisi;
    }

    public void setOdaBilgisi(int odaBilgisi) {
        this.odaBilgisi = odaBilgisi;
    }

    public void rezervasyonYap(String isimSoyisim , String cinsiyet,int yas,String tcKimlik , String email , String telefonNo , String kalinacakTarihler , int odaBilgisi){


    }
    public void rezervasyonSil(double rezervasyonNo){

    }

    public void odemeYap(String krediKartNo){

    }
}