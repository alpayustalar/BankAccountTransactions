package baslatici;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entity.Hareket;
import entity.Hesap;
import service.DosyaImportService;
import service.HesaplaService;
import service.RaporService;

public class Calistir {
    public static void main(String[] args) {
        String hesaplarDosyasi = "hesaplar.csv";
        String hareketlerDosyasi = "hareketler.csv";

        DosyaImportService dosyaImportService = new DosyaImportService();
        List<Hesap> hesaplar = dosyaImportService.hesaplariOku(hesaplarDosyasi);
        List<Hareket> hareketler = dosyaImportService.hareketleriOku(hareketlerDosyasi);

        HesaplaService hesaplaService = new HesaplaService();
        List<Hesap> hesaplarDoldurulmus = hesaplaService.hesaplariDoldurveBakiyeHesapla(hesaplar, hareketler);

        try {
            RaporService raporService = new RaporService();
            raporService.pdfYazdir(hesaplarDoldurulmus);

            System.out.println("PDF dosyası oluşturuldu: hesaplar.pdf");
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println("PDF oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }
}

