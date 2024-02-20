/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

/**
 *
 * @author AdminOmarGuevara
 */
public class clsExportarExcel {
 static Picture pict;
    public clsExportarExcel() {

    }

    public static void exportarExcel(JTable t, int costado, String ruta, String nameSheet, File archivoXLS) throws IOException {
        InputStream inp;
         Workbook libro;
        if (archivoXLS.exists()) {
            inp = new FileInputStream(ruta);
            libro= new HSSFWorkbook(inp);
        }else{
            archivoXLS.createNewFile();
            libro= new HSSFWorkbook();
            
        }
        try (FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
            Sheet hoja = libro.createSheet(nameSheet);
            hoja.setZoom(17);
            hoja.setDisplayGridlines(true);
            
            HSSFCellStyle estilo = (HSSFCellStyle) libro.createCellStyle();
            HSSFCellStyle estilo1 = (HSSFCellStyle) libro.createCellStyle();
            estilo.setAlignment(HorizontalAlignment.CENTER);
            estilo.setVerticalAlignment(VerticalAlignment.CENTER);
            estilo.setBorderBottom(BorderStyle.THIN);
            estilo.setBorderLeft(BorderStyle.THIN);
            estilo.setBorderRight(BorderStyle.THIN);
            estilo.setBorderTop(BorderStyle.THIN);
            
            estilo1.setAlignment(HorizontalAlignment.CENTER);
            estilo1.setVerticalAlignment(VerticalAlignment.CENTER);
            estilo1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            estilo1.setFillForegroundColor(IndexedColors.AQUA.index);
            estilo1.setBorderBottom(BorderStyle.THIN);
            estilo1.setBorderLeft(BorderStyle.THIN);
            estilo1.setBorderRight(BorderStyle.THIN);
            estilo1.setBorderTop(BorderStyle.THIN);
            hoja.addMergedRegion(new CellRangeAddress(6, 6, costado + 1, 7));

            Row fila = hoja.createRow(6);
            Cell celda = fila.createCell(costado);
            celda.setCellValue(principal.etiquetaRegion.getText());
            celda.setCellStyle(estilo);
            celda = fila.createCell(costado + 1);
            celda.setCellValue(principal.etiquetaMesAño.getText());
            celda.setCellStyle(estilo);
            fila.setHeightInPoints(20f);
            fila = hoja.createRow(7);

            if (costado == 1) {
                hoja.addMergedRegion(new CellRangeAddress(7, 7, 0, 1));
            }
            celda = fila.createCell(0);
            celda.setCellValue(t.getColumnName(0));
            hoja.setColumnWidth(0, 20 * 300);
            celda.setCellStyle(estilo1);
            celda = fila.createCell(1);
            celda.setCellStyle(estilo1);
            fila.setHeightInPoints(20f);

            if (costado == 1) {
                for (int c = costado; c < t.getColumnCount(); c++) {
                    celda = fila.createCell(c + 1);
                    celda.setCellValue(t.getColumnName(c));
                    celda.setCellStyle(estilo1);
                }
            } else {
                for (int c = costado; c < t.getColumnCount(); ++c) {
                    celda = fila.createCell(c);
                    celda.setCellValue(t.getColumnName(c));
                    celda.setCellStyle(estilo1);
                }
            }

            libro.write(archivo);
            archivo.close();
            libro.close();
        }
    }

   public static void insertarImagen(Workbook wb, Sheet sheet) {
        try (InputStream inputStream = new FileInputStream("/home/luis/mvn/medical-system/src/main/resources/img/logo.png");) {
            System.out.println("insertaré la imagen");
            byte[] imageBytes = IOUtils.toByteArray(inputStream);
            int pictureureIdx = wb.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);
            inputStream.close();
            CreationHelper helper = wb.getCreationHelper();
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();            
            pict = drawing.createPicture(anchor, pictureureIdx);
            pict.resize();
            System.out.println("imagen insertada");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void exportarExcel( String ruta, String nameSheet, File archivoXLS) throws IOException {
        InputStream inp;
         Workbook libro;
        if (archivoXLS.exists()) {
            inp = new FileInputStream(ruta);
            libro= new HSSFWorkbook(inp);
        }else{
            archivoXLS.createNewFile();
            libro= new HSSFWorkbook();
            
        }
        try (FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
            Sheet hoja = libro.createSheet(nameSheet);
            hoja.setZoom(100);
            hoja.setDisplayGridlines(true);

            HSSFCellStyle estilo = (HSSFCellStyle) libro.createCellStyle();
            HSSFCellStyle estilo1 = (HSSFCellStyle) libro.createCellStyle();
            estilo.setAlignment(HorizontalAlignment.CENTER);
            estilo.setVerticalAlignment(VerticalAlignment.CENTER);
            estilo1.setAlignment(HorizontalAlignment.CENTER);
            estilo1.setVerticalAlignment(VerticalAlignment.CENTER);
            estilo1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            estilo1.setFillForegroundColor(IndexedColors.AQUA.index);
            estilo1.setBorderBottom(BorderStyle.THIN);
            estilo1.setBorderLeft(BorderStyle.THIN);
            estilo1.setBorderRight(BorderStyle.THIN);
            estilo1.setBorderTop(BorderStyle.THIN);
            
            hoja.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));
            hoja.addMergedRegion(new CellRangeAddress(6, 6, 2, 14));
            Row fila = hoja.createRow(6);
            Cell celda = fila.createCell(0);
            celda.setCellValue(principal.etiquetaRegion.getText());
            celda.setCellStyle(estilo);
            celda = fila.createCell(2);
            celda.setCellValue(principal.etiquetaMesAño.getText());
            celda.setCellStyle(estilo);
            fila.setHeightInPoints(20f);
            libro.write(archivo);
            archivo.close();
            libro.close();
        }

    }

}
