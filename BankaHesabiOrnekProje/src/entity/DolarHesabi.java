package entity;

public class DolarHesabi extends Hesap {
	private static final double USD_EXCHANGE = 19.52;

	public DolarHesabi(Integer hesapNo, String hesapAdi, String paraBirimi) {
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
		double bakiyeTL = toplamTutar * USD_EXCHANGE;
        setBakiye(bakiyeTL);
	}
}
