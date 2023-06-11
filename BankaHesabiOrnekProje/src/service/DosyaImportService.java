package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.DolarHesabi;
import entity.EuroHesabi;
import entity.Hareket;
import entity.Hesap;
import entity.TLHesabi;

public class DosyaImportService {
    public List<Hesap> hesaplariOku(String dosyaAdi) {
        List<Hesap> hesaplar = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    Integer hesapNo = Integer.parseInt(tokens[0].trim());
                    String hesapAdi = tokens[1].trim();
                    String paraBirimi = tokens[2].trim();
                    Double bakiye = Double.parseDouble(tokens[3].trim());
                    Hesap hesap;
                    if (paraBirimi.equals("TL")) {
                        hesap = new TLHesabi(hesapNo, hesapAdi, paraBirimi);
                    } else if (paraBirimi.equals("USD")) {
                        hesap = new DolarHesabi(hesapNo, hesapAdi, paraBirimi);
                    } else if (paraBirimi.equals("EUR")) {
                        hesap = new EuroHesabi(hesapNo, hesapAdi, paraBirimi);
                    } else {
                        throw new IllegalArgumentException("Geçersiz para birimi: " + paraBirimi);
                    }
                    hesap.setBakiye(bakiye);
                    hesaplar.add(hesap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hesaplar;
    }

    public List<Hareket> hareketleriOku(String dosyaAdi) {
        List<Hareket> hareketler = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    Integer gonderenHesapNo = Integer.parseInt(tokens[0].trim());
                    Integer aliciHesapNo = Integer.parseInt(tokens[1].trim());
                    Double tutar = Double.parseDouble(tokens[2].trim());
                    Hareket hareket = new Hareket(gonderenHesapNo, aliciHesapNo, tutar);
                    hareketler.add(hareket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hareketler;
    }
}
