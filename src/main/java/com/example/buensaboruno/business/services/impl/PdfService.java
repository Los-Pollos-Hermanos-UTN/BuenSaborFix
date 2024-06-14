package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.domain.entities.Pedido;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public byte[] generateInvoicePdf(Pedido pedido) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Añadir la factura al documento
        Factura factura = pedido.getFactura();
        document.add(new Paragraph("Factura")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(18));
        document.add(new Paragraph("Fecha de Facturación: " + factura.getFechaFcturacion()));
        document.add(new Paragraph("Forma de Pago: " + factura.getFormaPago()));
        document.add(new Paragraph("Total de Venta: $" + factura.getTotalVenta()));

        // Añadir los detalles del pedido
        document.add(new Paragraph("Detalles del Pedido")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(18));
        Table table = new Table(new float[]{4, 1, 2, 2});
        table.addHeaderCell(new Cell().add(new Paragraph("Artículo")));
        table.addHeaderCell(new Cell().add(new Paragraph("Cantidad")));
        table.addHeaderCell(new Cell().add(new Paragraph("Precio Unitario")));
        table.addHeaderCell(new Cell().add(new Paragraph("Total")));

        for (DetallePedido detalle : pedido.getDetallePedidos()) {
            table.addCell(new Cell().add(new Paragraph(detalle.getArticulo().getDenominacion())));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(detalle.getCantidad()))));
            table.addCell(new Cell().add(new Paragraph("$" + detalle.getArticulo().getPrecioVenta())));
            table.addCell(new Cell().add(new Paragraph("$" + detalle.getArticulo().getPrecioVenta() * detalle.getCantidad())));
        }

        document.add(table);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}