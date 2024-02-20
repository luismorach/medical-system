/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ModeloTabla extends DefaultTableModel {
    int row=-1;
    int column=-1;
    String[] columnNames;
    Object[][] datos;

    public ModeloTabla(Object[][] datos, String[] titulos) {
        super();
        this.columnNames = titulos;
        this.datos = datos;
        setDataVector(datos, titulos);
    }

    public void setEditable(int row, int column) {
        this.row=row;
        this.column=column;
    }

    /**
     *
     * @param row
     * @param column
     * @param c
     * @return
     */
    @Override
   /* public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }*/

    public boolean isCellEditable(int row, int column) {
        //Definimos si una celda puede ser o no editable
        return this.row==row && this.column == column;

    }
}
