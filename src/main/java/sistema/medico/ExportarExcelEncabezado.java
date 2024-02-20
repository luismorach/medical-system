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
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Administrador
 */
public class ExportarExcelEncabezado {

    public static void exportarExcel(JTable t, int costado, String ruta,int numrow, int sheet, int ownLine) throws IOException {
        InputStream inp = new FileInputStream(ruta);;
        Workbook libro = new HSSFWorkbook(inp);
        Sheet hoja = libro.getSheetAt(sheet);

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
        int row = hoja.getLastRowNum()-(numrow);

        Row fila;
        Cell celda;
        if (ownLine == 1||ownLine==2) {
            fila = hoja.getRow(row);
        } else {
            fila = hoja.createRow(row += 1);
            celda = fila.createCell(0 + ownLine);
            celda.setCellValue(t.getColumnName(0));
            celda.setCellStyle(estilo1);
            celda = fila.createCell(1 + ownLine);
            celda.setCellStyle(estilo1);
            //fila = hoja.createRow(row+1);
        }
        fila.setHeightInPoints(20f);
        if (costado == 1 && ownLine == 0) {
            hoja.addMergedRegion(new CellRangeAddress(row, row, 0, 1));
        }

        if (costado == 1) {
            for (int c = costado; c < t.getColumnCount(); c++) {
                celda = fila.createCell(c + 1);
                celda.setCellValue(t.getColumnName(c));
                celda.setCellStyle(estilo1);
            }
        } else {
            switch (ownLine) {
                case 1:
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        hoja.addMergedRegion(new CellRangeAddress(row, row, c + c + 2, c + c + 3));
                        celda = fila.createCell(c + c + 2);
                        celda.setCellValue(t.getColumnName(c));
                        celda.setCellStyle(estilo1);

                    }
                    break;
                case 2:
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        celda = fila.createCell(c + 2);
                        celda.setCellValue(t.getColumnName(c));
                        celda.setCellStyle(estilo1);

                    }
                    break;
                default:
                    hoja.addMergedRegion(new CellRangeAddress(row, row, 0, 1));
                    celda = fila.createCell(0);
                    celda.setCellValue(tratarCadena(t.getColumnName(1)));
                    celda.setCellStyle(estilo1);
                    for (int i = 2; i < 15; i++) {
                        celda = fila.createCell(i);
                        celda.setCellStyle(estilo1);
                    }
                    break;
            }
        }
        File archivoXLS = new File(ruta);
        FileOutputStream archivo = new FileOutputStream(archivoXLS);
        libro.write(archivo);
        archivo.close();
        libro.close();
    }
    private static String tratarCadena(String cadena){
        String Cadena="";
        for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == '<') {
                    while (cadena.charAt(i) != '>') {
                        i++;
                    }
                    continue;
                }

                Cadena += cadena.charAt(i);
            }
        return Cadena;
    }

}
