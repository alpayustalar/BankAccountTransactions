package entity;

public class EuroHesabi extends Hesap {
    private static final double EURO_EXCHANGE = 21.88;

    public EuroHesabi(Integer hesapNo, String hesapAdi, String paraBirimi) {
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
        double bakiyeTL = toplamTutar * EURO_EXCHANGE;
        setBakiye(bakiyeTL);
    }
}
