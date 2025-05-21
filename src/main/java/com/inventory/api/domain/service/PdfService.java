package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Product;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import com.itextpdf.layout.property.UnitValue;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    public byte[] generateProductPdf(List<Product> products) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Liste de Produits"));

            // Criar tabela
            float[] columnWidths = {50f, 150f, 150f, 150f}; // Ajuste conforme necessário
            Table table = new Table(columnWidths);
            table.setWidth(UnitValue.createPercentValue(100));
            table.addCell("");
            table.addCell("Nom");
            table.addCell("Numero de série");
            table.addCell("Attribué à");

            int index = 0;
            for (Product product : products) {

                table.addCell(String.valueOf(index++));
                table.addCell(product.getName() != null ? product.getName().toString() : "");
                table.addCell(product.getSerialNumber().toString());
                table.addCell(product.getProfessional() != null ? product.getProfessional().getName() : "");
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
