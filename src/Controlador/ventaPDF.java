/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Ventas_CRUD;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import Vista.Ventas_CRUD;
import java.awt.Desktop;
import javax.swing.JTextField;
import modelo.VentaPOO;

/**
 *
 * @author alexs
 */
public class ventaPDF extends Conexion {

    private String nombreCliente;
    private String pelicula;
    private String sala;
    private String asiento;
    private String fecha;
    private String nombreArchivoPDFVenta = "";
    String sentenciaSQL;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void datosFactura(int id_venta) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM ventas WHERE id_venta = '" + id_venta + "'";
        try {
            ps = (PreparedStatement) con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery(sentenciaSQL);
            while (rs.next()) {
                // VentaPOO vent = new VentaPOO();
                nombreCliente = rs.getString("cliente");
                pelicula = rs.getString("pelicula");
                sala = rs.getString("sala");
                asiento = rs.getString("asiento");
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER DATOS VENTA" + ex);
        }
    }

    public void generarFactura() {

        String clienteNombre = Ventas_CRUD.jtfCliente != null ? Ventas_CRUD.jtfCliente.getText() : "N/A";
        String pelicula = Ventas_CRUD.cbxPelicula != null ? Ventas_CRUD.cbxPelicula.getSelectedItem().toString() : "N/A";
        String sala = Ventas_CRUD.cbxSala != null ? Ventas_CRUD.cbxSala.getSelectedItem().toString() : "N/A";
        String asiento = Ventas_CRUD.jtfAsientos != null ? Ventas_CRUD.jtfAsientos.getText() : "N/A";
        try {

            Date date = new Date();
            fecha = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String fechaNueva = "";
            for (int i = 0; i < fecha.length(); i++) {
                if (fecha.charAt(i) == '/') {
                    fechaNueva = fecha.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Venta_" + clienteNombre + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/imagenes/Cinemania_2.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: 001" + "\nFecha: " + fechaNueva + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//Quitar borde de la tabla
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);
            String nombre = "CINEMANIA";
            String telefono = "228-555-0055";
            String direccion = "VILLAGE COUNTY";
            Encabezado.addCell("");
            Encabezado.addCell("\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("CLIENTE: " + clienteNombre + "\nPELICULA: " + pelicula + "\nSALA: " + sala + "\nAsiento: " + asiento + ",");
            doc.add(cliente);

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("NOMBRE", negrita));
            cliente1.setBorder(0);
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(clienteNombre);
            doc.add(tablaCliente);

            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            float[] ColumnaProducto = new float[]{20f, 40f, 20f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            String[] headers = {"CANTIDAD", "PRODUCTO", "TIPO", "TOTAL"};
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header, negrita));
                headerCell.setBorder(0);
                headerCell.setBackgroundColor(BaseColor.BLACK);
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setPadding(5);
                headerCell.setBackgroundColor(BaseColor.WHITE);
                tablaProducto.addCell(headerCell);
            }

            for (int i = 0; i < Ventas_CRUD.tblItems.getRowCount(); i++) {
                String cantidad = Ventas_CRUD.tblItems.getValueAt(i, 2).toString();
                String producto = Ventas_CRUD.tblItems.getValueAt(i, 0).toString();
                String tipo = Ventas_CRUD.tblItems.getValueAt(i, 1).toString();
                String precio = Ventas_CRUD.tblItems.getValueAt(i, 3).toString();

                PdfPCell cellCantidad = new PdfPCell(new Phrase(cantidad));
                cellCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCantidad.setPadding(3);
                cellCantidad.setBorder(0);
                tablaProducto.addCell(cellCantidad);

                PdfPCell cellProducto = new PdfPCell(new Phrase(producto));
                cellProducto.setPadding(3);
                cellProducto.setBorder(0);
                tablaProducto.addCell(cellProducto);

                PdfPCell cellTipo = new PdfPCell(new Phrase(tipo));
                cellTipo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTipo.setPadding(3);
                cellTipo.setBorder(0);
                tablaProducto.addCell(cellTipo);

                PdfPCell cellPrecio = new PdfPCell(new Phrase(String.format("%.2f", Double.parseDouble(precio))));
                cellPrecio.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellPrecio.setPadding(3);
                cellPrecio.setBorder(0);
                tablaProducto.addCell(cellPrecio);

            }
            doc.add(tablaProducto);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("TOTAL A PAGAR: " + Ventas_CRUD.jtfTotalPagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("CANCELACION Y FIRMA \n\n");
            firma.add("_________________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("GRACIAAS POR SU COMPRA :D");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN :" + e);
        }

    }

}
