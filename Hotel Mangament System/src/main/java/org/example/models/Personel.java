public class Personel {
    private String isimSoyisim;
    private String personelKimlik;
    private String gorevAlani;
    private double salary;

    // Constructor
    public Personel(String isimSoyisim, String personelKimlik, String gorevAlani, double salary) {
        this.isimSoyisim = isimSoyisim;
        this.personelKimlik = personelKimlik;
        this.gorevAlani = gorevAlani;
        this.salary = salary;
    }

    // Getters and Setters
    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public String getPersonelKimlik() {
        return personelKimlik;
    }

    public void setPersonelKimlik(String personelKimlik) {
        this.personelKimlik = personelKimlik;
    }

    public String getGorevAlani() {
        return gorevAlani;
    }

    public void setGorevAlani(String gorevAlani) {
        this.gorevAlani = gorevAlani;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Personel [isimSoyisim=" + isimSoyisim + ", personelKimlik=" + personelKimlik +
                ", gorevAlani=" + gorevAlani + ", salary=" + salary + "]";
    }
}