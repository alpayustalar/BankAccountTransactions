package service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entity.Hesap;

public class RaporService {
    public void pdfYazdir(List<Hesap> hesaplar) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("hesaplar.pdf"));
        document.open();

        Paragraph baslik = new Paragraph("Hesap Raporu");
        document.add(baslik);

        PdfPTable table = new PdfPTable(4);
        table.addCell("Hesap No");
        table.addCell("Hesap Adı");
        table.addCell("Hesap Para Birimi");
        table.addCell("Hesap Bakiye");

        for (Hesap hesap : hesaplar) {
            table.addCell(hesap.getHesapNo().toString());
            table.addCell(hesap.getHesapAdi());
            table.addCell(hesap.getParaBirimi());
            table.addCell(hesap.getBakiye().toString());
        }

        document.add(table);

        document.close();
    }
}
