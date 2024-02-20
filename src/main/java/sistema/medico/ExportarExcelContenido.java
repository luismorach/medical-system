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
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author Administrador
 */
public class ExportarExcelContenido {

    public static void exportarExcel(JTable t, int costado, String ruta,int numRow, String typeStyle, int ownLine, boolean porcentaje,int sheet,int posText) throws IOException {
        InputStream inp = new FileInputStream(ruta);
        HSSFWorkbook wb = new HSSFWorkbook(inp);
        HSSFFont font = wb.createFont();
        if (typeStyle.equals("normal")) {
            font.setColor(IndexedColors.GREEN.index);
        } else {
            font.setColor(IndexedColors.WHITE.index);
        }
        HSSFCellStyle style = (HSSFCellStyle) wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);

        HSSFCellStyle stylePorcentaje = (HSSFCellStyle) wb.createCellStyle();
        stylePorcentaje.setAlignment(HorizontalAlignment.CENTER);
        stylePorcentaje.setFont(font);
        stylePorcentaje.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        stylePorcentaje.setBorderBottom(BorderStyle.THIN);
        stylePorcentaje.setBorderLeft(BorderStyle.THIN);
        stylePorcentaje.setBorderRight(BorderStyle.THIN);
        stylePorcentaje.setBorderTop(BorderStyle.THIN);

        HSSFCellStyle especialstylePorcentaje = (HSSFCellStyle) wb.createCellStyle();
        especialstylePorcentaje.setAlignment(HorizontalAlignment.CENTER);
        especialstylePorcentaje.setFont(font);
        especialstylePorcentaje.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        especialstylePorcentaje.setBorderBottom(BorderStyle.THIN);
        especialstylePorcentaje.setBorderLeft(BorderStyle.THIN);
        especialstylePorcentaje.setBorderRight(BorderStyle.THIN);
        especialstylePorcentaje.setBorderTop(BorderStyle.THIN);
        especialstylePorcentaje.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        especialstylePorcentaje.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

        HSSFCellStyle styleEspecialNumeric = (HSSFCellStyle) wb.createCellStyle();
        styleEspecialNumeric.setAlignment(HorizontalAlignment.CENTER);
        styleEspecialNumeric.setFont(font);
        styleEspecialNumeric.setBorderBottom(BorderStyle.THIN);
        styleEspecialNumeric.setBorderLeft(BorderStyle.THIN);
        styleEspecialNumeric.setBorderRight(BorderStyle.THIN);
        styleEspecialNumeric.setBorderTop(BorderStyle.THIN);
        styleEspecialNumeric.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleEspecialNumeric.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

        HSSFCellStyle estilo = (HSSFCellStyle) wb.createCellStyle();
        estilo.setAlignment(HorizontalAlignment.CENTER);
        estilo.setVerticalAlignment(VerticalAlignment.CENTER);

        HSSFCellStyle estilo1 = (HSSFCellStyle) wb.createCellStyle();
        estilo1.setBorderBottom(BorderStyle.THIN);
        estilo1.setBorderLeft(BorderStyle.THIN);
        estilo1.setBorderRight(BorderStyle.THIN);
        estilo1.setBorderTop(BorderStyle.THIN);

        HSSFCellStyle estilo2 = (HSSFCellStyle) wb.createCellStyle();
        estilo2.setBorderBottom(BorderStyle.THIN);
        estilo2.setBorderLeft(BorderStyle.THIN);
        estilo2.setBorderRight(BorderStyle.THIN);
        estilo2.setBorderTop(BorderStyle.THIN);
        estilo2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilo2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

        Sheet hoja = wb.getSheetAt(sheet);        
        int row ;

        if (costado >0) {
            row= hoja.getLastRowNum()-(numRow);
            Row fila;
            /*if (ownLine == 1) {
                fila = hoja.getRow(row);
            } else {
                fila = hoja.createRow(row +=1);
            }*/
            hoja.setColumnWidth(1, 20 * 1226);
            for (int f = 0; f < t.getRowCount(); f++) {
                /*if (f != 0) {
                    fila = hoja.createRow(row += 1);
                }*/
                fila=hoja.getRow(row+f);
                for (int c = costado; c < t.getColumnCount() + 1; c++) {
                    Cell celda = fila.createCell(c);
                    fila.setHeightInPoints(15f);
                    if (t.getValueAt(f, c - 1) instanceof Double) {
                        celda.setCellValue(Double.parseDouble(t.getValueAt(f, c - 1).toString()));
                    } else if (t.getValueAt(f, c - 1) instanceof Float) {
                        celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c - 1)));
                    } else {

                        if (typeStyle.equals("normal")) {
                            celda.setCellStyle(estilo1);
                        } else {
                            celda.setCellStyle(estilo2);
                        }
                        if (t.getColumnCount() - 1 == c - 1 && porcentaje) {
                            celda.setCellValue(Double.parseDouble(tratarCadena(String.valueOf(t.getValueAt(f, c - 1))))/100);
                            celda.setCellStyle(stylePorcentaje);
                             if (typeStyle.equals("especial")) {
                                celda.setCellStyle(especialstylePorcentaje);
                            }

                        } else if (c - 1 == 0) {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c - 1)));

                        } else {
                            celda.setCellValue(Integer.parseInt(String.valueOf(t.getValueAt(f, c - 1))));
                            celda.setCellStyle(style);
                            if (typeStyle.equals("especial")) {
                                celda.setCellStyle(styleEspecialNumeric);
                            }
                        }
                    }
                }
            }
        } else {
             row= hoja.getLastRowNum();
            if(hoja.getColumnWidth(1)==20 * 1226&&posText==0)
                hoja.addMergedRegion(new CellRangeAddress(row+1,row+1, 0, 1));
            else
                hoja.setColumnWidth(posText, 20*588);
            for (int f = 0; f < t.getRowCount(); f++) {                
                Row fila = hoja.createRow(row += 1);                
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda; 
                    if(hoja.getColumnWidth(1)==20 * 1226&& c>0 && posText==0){                       
                         celda = fila.createCell(c+1);
                    }else                       
                        celda = fila.createCell(c);
                    fila.setHeightInPoints(15f);
                    if (t.getValueAt(f, c) instanceof Double) {
                        celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                    } else if (t.getValueAt(f, c) instanceof Float) {
                        celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                    } else {
                        if (typeStyle.equals("normal")) {
                            celda.setCellStyle(estilo1);
                        } else {
                            celda.setCellStyle(estilo2);
                        }
                        if (t.getColumnCount() - 1 == c && porcentaje ) {
                            celda.setCellValue(Integer.parseInt(tratarCadena(String.valueOf(t.getValueAt(f, c)))));
                            celda.setCellStyle(stylePorcentaje);
                            if (typeStyle.equals("especial")) {
                                celda.setCellStyle(especialstylePorcentaje);
                            }
                        } else if (c == posText) {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));

                        } else {
                            celda.setCellValue(Integer.parseInt(String.valueOf(t.getValueAt(f, c))));
                            celda.setCellStyle(style);
                            if (typeStyle.equals("especial")) {
                                celda.setCellStyle(styleEspecialNumeric);
                            }
                        }
                    }
                }
            }
        }       
        File archivoXLS = new File(ruta);
        FileOutputStream fileOut = new FileOutputStream(archivoXLS);
        wb.write(fileOut);
        fileOut.close();
        wb.close();

    }

    private static String tratarCadena(String cadena) {
        String Cadena = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != '%') {
                Cadena += cadena.charAt(i);
            }
        }
        return Cadena;
    }
}
