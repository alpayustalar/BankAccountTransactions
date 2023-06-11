package diger;

public class SabitVeriler {
	public static final double DOLAR_KURU = 19.52;
	public static final double EURO_KURU = 21.88;

	public static Double getKur(String gonderenParaBirimi, String aliciParaBirimi) {

		if (gonderenParaBirimi.equals("USD") && aliciParaBirimi.equals("TL")) {

			return DOLAR_KURU;
		} else

		if (gonderenParaBirimi.equals("EUR") && aliciParaBirimi.equals("TL")) {

			return EURO_KURU;
		}

		return

		null;
	}
}
