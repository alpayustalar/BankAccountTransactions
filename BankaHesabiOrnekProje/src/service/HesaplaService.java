package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diger.SabitVeriler;
import entity.Hareket;
import entity.Hesap;

public class HesaplaService {
    public List<Hesap> hesaplariDoldurveBakiyeHesapla(List<Hesap> hesaplar, List<Hareket> hareketler) {
        Map<Integer, Hesap> hesapMap = new HashMap<>();
        
        for (Hesap hesap : hesaplar) {
            hesapMap.put(hesap.getHesapNo(), hesap);
        }

        for (Hareket hareket : hareketler) {
            Integer gonderenHesapNo = hareket.getGonderenHesapNo();
            Integer aliciHesapNo = hareket.getAliciHesapNo();
            Double tutar = hareket.getTutar();

            if (hesapMap.containsKey(gonderenHesapNo) && hesapMap.containsKey(aliciHesapNo)) {
                Hesap gonderenHesap = hesapMap.get(gonderenHesapNo);
                Hesap aliciHesap = hesapMap.get(aliciHesapNo);

                String gonderenParaBirimi = gonderenHesap.getParaBirimi();
                String aliciParaBirimi = aliciHesap.getParaBirimi();

                Double kur = SabitVeriler.getKur(gonderenParaBirimi, aliciParaBirimi);

                Double gonderenBakiye = gonderenHesap.getBakiye();
                Double aliciBakiye = aliciHesap.getBakiye();

                Double gonderenHesapTutar = tutar * kur;
                Double aliciHesapTutar = tutar;

                gonderenHesap.setBakiye(gonderenBakiye - gonderenHesapTutar);
                aliciHesap.setBakiye(aliciBakiye + aliciHesapTutar);
            }
        }

        return hesaplar;
    }
}
