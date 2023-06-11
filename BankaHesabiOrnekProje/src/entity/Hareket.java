package entity;

public class Hareket {
    private Integer gonderenHesapNo;
    private Integer aliciHesapNo;
    private Double tutar;

    public Hareket(Integer gonderenHesapNo, Integer aliciHesapNo, Double tutar) {
        this.gonderenHesapNo = gonderenHesapNo;
        this.aliciHesapNo = aliciHesapNo;
        this.tutar = tutar;
    }

    public Integer getGonderenHesapNo() {
        return gonderenHesapNo;
    }

    public void setGonderenHesapNo(Integer gonderenHesapNo) {
        this.gonderenHesapNo = gonderenHesapNo;
    }

    public Integer getAliciHesapNo() {
        return aliciHesapNo;
    }

    public void setAliciHesapNo(Integer aliciHesapNo) {
        this.aliciHesapNo = aliciHesapNo;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }
}
