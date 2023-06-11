package entity;

import java.util.List;

public abstract class Hesap {
    private Integer hesapNo;
    private String hesapAdi;
    private String paraBirimi;
    protected Double bakiye;
    protected List<Hareket> gelenGidenHareketler;

    public Hesap(Integer hesapNo, String hesapAdi, String paraBirimi) {
        this.hesapNo = hesapNo;
        this.hesapAdi = hesapAdi;
        this.paraBirimi = paraBirimi;
    }

    public Integer getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(Integer hesapNo) {
        this.hesapNo = hesapNo;
    }

    public String getHesapAdi() {
        return hesapAdi;
    }

    public void setHesapAdi(String hesapAdi) {
        this.hesapAdi = hesapAdi;
    }

    public String getParaBirimi() {
        return paraBirimi;
    }

    public void setParaBirimi(String paraBirimi) {
        this.paraBirimi = paraBirimi;
    }

    public Double getBakiye() {
        return bakiye;
    }

    public void setBakiye(Double bakiye) {
        this.bakiye = bakiye;
    }

    public List<Hareket> getGelenGidenHareketler() {
        return gelenGidenHareketler;
    }

    public void setGelenGidenHareketler(List<Hareket> gelenGidenHareketler) {
        this.gelenGidenHareketler = gelenGidenHareketler;
    }

    public abstract void bakiyeHesapla();
}
