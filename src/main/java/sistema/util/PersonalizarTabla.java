/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.util;

import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public class PersonalizarTabla {
    
    public void personalizarTabla(JTable tabla,int sizeTable){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(sizeTable);
    }
     public void personalizarTabla(JTable tabla,int sizeTable,int column){
        tabla.getColumnModel().getColumn(column).setPreferredWidth(sizeTable);
    }
    public void  personalizarTabla(JTable tabla,int sizeTable,int cantColum,int start,String tipo){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(sizeTable);
        for(int i=start;i<cantColum;i++){
        tabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas(tipo));
        }
    }
}
