package com.example.buensaboruno.business.services;

import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class PdfService {

    public ByteArrayInputStream generateFacturaPDF(FacturaDTO factura, PedidoDTO pedido) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(out)) {
            PdfDocument pdf = new PdfDocument(writer);

            Document document = new Document(pdf, PageSize.A4);
            document.setMargins(20, 20, 20, 20);

            document.add(new Paragraph("Factura"));
            document.add(new Paragraph("Fecha: " + factura.getFechaFcturacion()));
            document.add(new Paragraph("Forma de Pago: " + factura.getFormaPago()));

            document.add(new Paragraph("Detalles del Pedido:"));
            for (DetallePedidoDTO detalle : pedido.getDetallePedidos()) {
                String itemText = detalle.getArticulo().getDenominacion() + " x " + detalle.getCantidad();
                document.add(new Paragraph(itemText));
            }

            document.add(new Paragraph("Total Venta: " + factura.getTotalVenta()));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
