/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.alertas;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrador
 */
public class Desplazar {

    static int x, y;

    static class mousepoint implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
            x = me.getX();
            y = me.getY();
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }
    static class FrameDraw implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent me) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.getWindowAncestor(me.getComponent()).setLocation(point.x - x, point.y - y);
        }

        @Override
        public void mouseMoved(MouseEvent me) {
           
        }
        
    }

}
