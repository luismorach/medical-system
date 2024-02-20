/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Administrador
 */
public class CustomUI extends BasicComboBoxUI {

    //private ImageIcon espacio = new ImageIcon(getClass().getResource("/org/bolivia/res/espacio.png"));
    private Color blue = new Color(0, 0, 153);
    static int firstFile = 0;
    static JComboBox<?> combo;
    JComboBox<?> combo1;

    public static ComboBoxUI createUI(JComponent c) {
        firstFile = 0;
        return new CustomUI();
    }

    public static ComboBoxUI createUI(int firstFile) {
        CustomUI.firstFile = firstFile;
        return new CustomUI();
    }

    public CustomUI() {

    }

    @Override

    protected JButton createArrowButton() {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(getClass().getResource("/img/iconoDesplegar.png"))); // NOI18N
        btn.setBorder(null);
        btn.setOpaque(true);
        btn.setBackground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        return btn;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g,
            Rectangle bounds,
            boolean hasFocus
    ) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    //Pinta los items
    //@Override
    

    @Override
    protected ListCellRenderer<Object> createRenderer() {
        return new DefaultListCellRenderer() {

            @Override

            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected,
                    boolean cellHasFocus
            ) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setPreferredSize(new Dimension(getPreferredSize().width,30));
                if (isSelected) {
                    setBackground(blue);
                    setForeground(Color.WHITE);

                } else {
                    setBackground(Color.WHITE);
                    setForeground(new Color(70, 70, 70));
                }

                if (index == 0 && firstFile == 0) {
                    setBackground(new Color(153, 153, 153));
                    setForeground(Color.GRAY);
                }
                
                return this;
            }
        };
    }

    @Override
    protected ComboBoxEditor createEditor() {
        return new MyComboBoxEditor();

    }
}

class MyComboBoxEditor extends BasicComboBoxEditor {

    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private Object selectedItem;

    public MyComboBoxEditor() {
        label.setOpaque(false);
        label.setFont(new Font("Bookman Old Style", 0, 12));
        label.setForeground(Color.BLACK);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
        panel.add(label);
        panel.setBackground(Color.white);
    }

    @Override
    public Component getEditorComponent() {
        return this.panel;
    }

    @Override

    public Object getItem() {
        return this.selectedItem;
    }

    @Override
    public void setItem(Object item) {
        if (item == null) {
            label.setText("");
        } else {
            this.selectedItem = item;
            label.setText(item.toString());
        }
    }
}
