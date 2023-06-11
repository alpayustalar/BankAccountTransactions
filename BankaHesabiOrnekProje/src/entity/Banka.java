package entity;

import java.util.ArrayList;
import java.util.List;

public class Banka {
    private List<Hesap> hesaplar;

    public Banka() {
        hesaplar = new ArrayList<>();
    }

    public List<Hesap> getHesaplar() {
        return hesaplar;
    }

    public void hesapEkle(Hesap hesap) {
        hesaplar.add(hesap);
    }

    public void hesapSil(Hesap hesap) {
        hesaplar.remove(hesap);
    }

    public void bakiyeHesapla() {
        for (Hesap hesap : hesaplar) {
            hesap.bakiyeHesapla();
        }
    }
}
