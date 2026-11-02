package com.inventory.api.domain.service;
import com.inventory.api.domain.model.Establishment;
import com.inventory.api.domain.model.Product;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.List;

@Service
public class PdfService {

    public byte[] generateProductPdf(List<Product> products, String establishmentName) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(
                    new Paragraph("Inventaire des équipements informatiques")
                            .setBold()
                            .setFontSize(16)
                            .setMarginBottom(15)
            );

            String establishment = establishmentName != null
                    ? establishmentName
                    : "Tous les établissements";

            document.add(
                    new Paragraph("Établissement : " + establishment)
                            .setFontSize(10)
            );

            String date = LocalDate.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            document.add(
                    new Paragraph("Date : " + date)
                            .setFontSize(10)
            );

            document.add(
                    new Paragraph("Nombre d'équipements : " + products.size())
                            .setFontSize(10)
                            .setMarginBottom(20)
            );

            // Criar tabela
            float[] columnWidths = {50f, 150f, 150f, 150f}; // Ajuste conforme necessário

            Table table = new Table(UnitValue.createPointArray(columnWidths));
            table.setWidth(UnitValue.createPercentValue(100));
            table.addHeaderCell(
                    new Cell()
                            .add(new Paragraph("N°"))
                            .setBold()
                            .setBackgroundColor(ColorConstants.LIGHT_GRAY)
            );
            table.addHeaderCell(
                    new Cell()
                            .add(new Paragraph("Nom"))
                            .setBold()
                            .setBackgroundColor(ColorConstants.LIGHT_GRAY)
            );
            table.addHeaderCell(
                    new Cell()
                            .add(new Paragraph("Numéro de série"))
                            .setBold()
                            .setBackgroundColor(ColorConstants.LIGHT_GRAY)
            );
            table.addHeaderCell(
                    new Cell()
                            .add(new Paragraph("Attribué à"))
                            .setBold()
                            .setBackgroundColor(ColorConstants.LIGHT_GRAY)
            );

            int index = 1;
            for (Product product : products) {

                table.addCell(String.valueOf(index++));
                table.addCell(product.getName() != null ? product.getName().toString() : "");
                table.addCell(product.getSerialNumber().toString());
                table.addCell(product.getProfessional() != null ? product.getProfessional().getName() : "");
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la génération du PDF", e);
        }
        return out.toByteArray();
    }
//etiqueta

    public byte[] gerarEtiqueta(String numeroSerie) {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);

            PageSize pageSize = new PageSize(142, 85);
            pdf.addNewPage(pageSize);

            Document document = new Document(pdf, pageSize);
            document.setMargins(0, 0, 0, 0);


            PdfPage page = pdf.getFirstPage();
            PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdf);

            // --- retângulo arredondado ---
            float margin = 5f;
            float width = pageSize.getWidth() - 2 * margin;
            float height = pageSize.getHeight() - 2 * margin;
            float x = margin;
            float y = margin;
            float radius = 5f;

            canvas.setLineWidth(1f);
            canvas.setStrokeColor(ColorConstants.BLACK);
            canvas.roundRectangle(x, y, width, height, radius);
            canvas.stroke();

            // --- áreas internas ---
            float centerX = pageSize.getWidth() / 2;


            // --- Inserindo a foto ---
            InputStream is = getClass().getClassLoader().getResourceAsStream("static/logo.png");
            Image foto = new Image(ImageDataFactory.create(is.readAllBytes()));
            foto.scaleToFit(width - 10, height * 0.6f);
            foto.setFixedPosition(centerX - (foto.getImageScaledWidth() / 2),
                    y + height - foto.getImageScaledHeight() - 5); // topo interno
            document.add(foto);

            // --- Inserindo o código de barras ---
            Barcode128 barcode = new Barcode128(pdf);
            barcode.setCode(numeroSerie);
            Image barcodeImage = new Image(barcode.createFormXObject(pdf));
            barcodeImage.scaleToFit(width - 10, height * 0.3f);
            barcodeImage.setFixedPosition(centerX - (barcodeImage.getImageScaledWidth() / 2),
                    y + height * 0.20f);
            document.add(barcodeImage);

            document.close();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar etiqueta", e);
        }

    }
}



