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
import org.apache.poi.ss.util.RegionUtil;

/**
 *
 * @author Administrador
 */
public class ExportarExcelCostado {

    public static void exportarExcel(JTable t, int numrow, String ruta, int sheet, int ownLine, String typeStyle) throws IOException {
        InputStream inp = new FileInputStream(ruta);
        HSSFWorkbook wb = new HSSFWorkbook(inp);

        HSSFCellStyle estilo = (HSSFCellStyle) wb.createCellStyle();
        estilo.setAlignment(HorizontalAlignment.CENTER);
        estilo.setVerticalAlignment(VerticalAlignment.CENTER);
        estilo.setBorderBottom(BorderStyle.THIN);
        estilo.setBorderLeft(BorderStyle.THIN);
        estilo.setBorderRight(BorderStyle.THIN);
        estilo.setBorderTop(BorderStyle.THIN);
        estilo.setWrapText(true);

        HSSFCellStyle estilo1 = (HSSFCellStyle) wb.createCellStyle();
        estilo1.setAlignment(HorizontalAlignment.CENTER);
        estilo1.setVerticalAlignment(VerticalAlignment.CENTER);
        estilo1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilo1.setFillForegroundColor(IndexedColors.AQUA.index);
        estilo1.setBorderBottom(BorderStyle.THIN);
        estilo1.setBorderLeft(BorderStyle.THIN);
        estilo1.setBorderRight(BorderStyle.THIN);
        estilo1.setBorderTop(BorderStyle.THIN);
        estilo1.setWrapText(true);

        Sheet hoja = wb.getSheetAt(sheet);

        int row;
        Row fila;
        Cell celda;
        row = hoja.getLastRowNum() + 1;
        if (ownLine == 1) {
            row = hoja.getLastRowNum() - 1;
            fila = hoja.getRow(row);
        } else {
            fila = hoja.createRow(row);
        }

        String cadena = "";
        for (int k = 0; k < t.getColumnCount(); k++) {
            if (ownLine == 1) {
                celda = fila.createCell(14 + k);
                hoja.addMergedRegion(new CellRangeAddress(row, numrow + row - 1, 14, 14));
            } else {
                celda = fila.createCell(k);
                hoja.addMergedRegion(new CellRangeAddress(row, numrow + row - 1, k, k));
            }
            for (int i = 0; i < t.getColumnName(k).length(); i++) {
                if (t.getColumnName(k).charAt(i) == '<') {
                    while (t.getColumnName(k).charAt(i) != '>') {
                        i++;
                    }
                    continue;
                }

                cadena += t.getColumnName(k).charAt(i);
            }
            celda.setCellValue(cadena);
            if (typeStyle.equals("normal")) {
                celda.setCellStyle(estilo);
            } else {
                celda.setCellStyle(estilo1);
            }
            cadena = "";
        }
        border(hoja);
        File archivoXLS = new File(ruta);
        FileOutputStream fileOut = new FileOutputStream(archivoXLS);
        wb.write(fileOut);
        fileOut.close();
        wb.close();

    }

    public static void border(Sheet hoja) {
        org.apache.poi.ss.util.CellRangeAddress add;
        for (int i = 0; i < hoja.getNumMergedRegions(); i++) {
            add = hoja.getMergedRegion(i);
            System.out.println(add);
            RegionUtil.setBorderTop(BorderStyle.THIN, add, hoja);
            RegionUtil.setBorderLeft(BorderStyle.THIN, add, hoja);
            RegionUtil.setBorderRight(BorderStyle.THIN, add, hoja);
            RegionUtil.setBorderBottom(BorderStyle.THIN, add, hoja);
        }
    }
   
}
