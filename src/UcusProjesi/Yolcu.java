package UcusProjesi;

import java.util.Locale;

public class Yolcu {
    private String adSoyad;
    private int yas;
    private String local;
    private String sehir;
    private String ucusSekli;

    public Yolcu() {
    }
    protected Yolcu(String adSoyad, int yas, String local, String sehir, String ucusSekli) {
        this.adSoyad = adSoyad;
        this.yas = yas;
        this.local = local;
        this.sehir = sehir;
        this.ucusSekli = ucusSekli;
    }

    public String getAdSoyad() {
        return adSoyad.toUpperCase();
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getYas() {
        if (yas<0){
            yas*=-1;
        }
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getLocal() {
        return local.toUpperCase();
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSehir() {
        return sehir.toUpperCase();
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getUcusSekli() {
        return ucusSekli.toLowerCase();
    }

    public void setUcusSekli(String ucusSekli) {
        this.ucusSekli = ucusSekli;
    }

    @Override
    public String toString() {
        return "Yolcu{" +
                "adSoyad='" + adSoyad + '\'' +
                ", yas=" + yas +
                ", local=" + local +
                ", sehir=" + sehir +
                ", ucusSekli=" + ucusSekli +
                '}';
    }
}
