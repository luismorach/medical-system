/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Administrador
 */
public class RendererList extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        label.setBorder(null);
        if (isSelected) {
            //label.setOpaque(true);
            //label.setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);
        } else {
            label.setOpaque(true);
            //label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        }
        if(cellHasFocus){
            label.setBorder(null);
        }
       
            label.setVisible(false);
        
        
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/img/list.png")));
        //label.setIconTextGap(50);
        label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.repaint();
        return label;
    }

}
