package org.example.models;

public class OdaDTO {
    private int odaNumarasi;
    private int kapasite;
    private double fiyat;
    private String durum;
    private String manzara;

    // Getters and Setters
    public int getOdaNumarasi() {
        return odaNumarasi;
    }

    public void setOdaNumarasi(int odaNumarasi) {
        this.odaNumarasi = odaNumarasi;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getManzara() {
        return manzara;
    }

    public void setManzara(String manzara) {
        this.manzara = manzara;
    }
}
