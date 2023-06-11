package entity;

public class TLHesabi extends Hesap {

    public TLHesabi(Integer hesapNo, String hesapAdi, String paraBirimi) {
        super(hesapNo, hesapAdi, paraBirimi);
    }

    @Override
    public void bakiyeHesapla() {
        double toplamTutar = 0;
        for (Hareket hareket : getGelenGidenHareketler()) {
            if (hareket.getGonderenHesapNo().equals(getHesapNo())) {
                toplamTutar -= hareket.getTutar();
            } else if (hareket.getAliciHesapNo().equals(getHesapNo())) {
                toplamTutar += hareket.getTutar();
            }
        }
        setBakiye(toplamTutar);
    }
}
