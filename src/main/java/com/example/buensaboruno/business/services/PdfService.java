package com.example.buensaboruno.business.services;

import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
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

            // Add title
            Paragraph title = new Paragraph("FACTURA")
                    .setFontSize(20)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            // Add invoice details
            Table table = new Table(UnitValue.createPercentArray(3))
                    .useAllAvailableWidth();
            table.addHeaderCell(new Cell().add(new Paragraph("N° DE FACTURA").setBold()).setBorder(Border.NO_BORDER));
            table.addHeaderCell(new Cell().add(new Paragraph("FECHA").setBold()).setBorder(Border.NO_BORDER));
            table.addHeaderCell(new Cell().add(new Paragraph("N° DE PEDIDO").setBold()).setBorder(Border.NO_BORDER));

            table.addCell(new Cell().add(new Paragraph(String.valueOf(factura.getId()))).setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(pedido.getFechaPedido().toString())).setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(pedido.getId())).setMarginBottom(10)).setBorder(Border.NO_BORDER));

            document.add(table);


            table = new Table(UnitValue.createPercentArray(3))
                    .useAllAvailableWidth();

            Cell cell = new Cell().add(new Paragraph("FACTURAR A")
                            .setBold())
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("TIPO ENVIO")
                            .setBold())
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("")
                            .setBold())
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);


            cell = new Cell().add(new Paragraph(String.valueOf(pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido())))
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph(String.valueOf(pedido.getTipoEnvio())).setMarginBottom(20))
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("").setMarginBottom(20))
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);

            document.add(table);

            table = new Table(UnitValue.createPercentArray(3))
                    .useAllAvailableWidth();

            if (pedido.getTipoEnvio().toString() == "TAKE_AWAY") {
                cell = new Cell().add(new Paragraph("RETIRAR EN")
                                .setBold())
                        .setBorder(Border.NO_BORDER);
                table.addCell(cell);
            }

            if (pedido.getTipoEnvio().toString() == "DELIVERY") {
                cell = new Cell().add(new Paragraph("ENVIAR A")
                                .setBold())
                        .setBorder(Border.NO_BORDER);
                table.addCell(cell);
            }

            cell = new Cell().add(new Paragraph(pedido.getDomicilio().getCalle()+ " " +pedido.getDomicilio().getNumero() + ", "+ pedido.getDomicilio().getLocalidad().getNombre()+", "+pedido.getDomicilio().getLocalidad().getProvincia().getNombre()).setMarginBottom(20))
                    .setBorder(Border.NO_BORDER);
            table.addCell(cell);


            document.add(table);

            // Add items table
            table = new Table(UnitValue.createPercentArray(new float[]{1, 3, 1, 1}))
                    .useAllAvailableWidth();
            table.addHeaderCell(new Cell().add(new Paragraph("CANT.").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("DESCRIPCIÓN").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("PRECIO UNITARIO").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("IMPORTE").setBold()));

            for (DetallePedidoDTO detalle : pedido.getDetallePedidos()) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detalle.getCantidad()))));
                table.addCell(new Cell().add(new Paragraph(detalle.getArticulo().getDenominacion())));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detalle.getArticulo().getPrecioVenta()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detalle.getArticulo().getPrecioVenta() * detalle.getCantidad()))));
            }

            table.addCell(new Cell(1, 3).add(new Paragraph("TOTAL")).setBold().setTextAlignment(TextAlignment.RIGHT));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(factura.getTotalVenta()))));

            document.add(table);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
