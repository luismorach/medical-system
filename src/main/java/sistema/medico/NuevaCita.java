/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import Animacion.Fade;
import com.toedter.calendar.JDateChooser;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import sistema.alertas.Hecho;
import sistema.alertas.Informacion;
import sistema.database.CitasDTO;

import static sistema.medico.MisCitas.listCitas;
import sistema.medico.principal.date;

/**
 *
 * @author Administrador
 */
public class NuevaCita extends javax.swing.JDialog {

    /**
     * Creates new form NuevaCita
     */
    static String os = System.getProperty("os.name");
    int x, y;

    public NuevaCita(JFrame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setOpacity(0f);
        Fade.JDialogFadeIn(0f, 1f, 0.2f, 50, this);

    }

    public NuevaCita(JDialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setOpacity(0f);
        Fade.JDialogFadeIn(0f, 1f, 0.2f, 50, this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("static-access")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entrada = new javax.swing.JTextField();
        btbCancelar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        etiquetaNuevaCita = new javax.swing.JLabel();
        etiquetaFecha = new javax.swing.JLabel();
        entradaFecha = new javax.swing.JTextField();
        Fecha = new JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel1.setText("Nombre ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 114, 90, 20);

        entrada.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        entrada.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        entrada.addFocusListener(new EscucharBotones().focus(jLabel1, 0, 0, 153));
        entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaActionPerformed(evt);
            }
        });
        jPanel1.add(entrada);
        entrada.setBounds(60, 120, 190, 24);

        btbCancelar.setBackground(new java.awt.Color(0, 0, 153));
        btbCancelar.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        btbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btbCancelar.setText("Cancelar");
        btbCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btbCancelar);
        btbCancelar.setBounds(340, 200, 160, 29);

        btnAñadir.setBackground(new java.awt.Color(0, 0, 153));
        btnAñadir.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setText("Aceptar");
        // btnAñadir.addActionListener(new Acciones());
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAñadir);
        btnAñadir.setBounds(40, 200, 160, 29);

        etiquetaNuevaCita.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        etiquetaNuevaCita.setForeground(new java.awt.Color(0, 0, 102));
        etiquetaNuevaCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNuevaCita.setText("Nueva Cita");
        etiquetaNuevaCita.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }
        });
        etiquetaNuevaCita.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x - x, point.y - y);
            }
        });
        etiquetaNuevaCita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        etiquetaNuevaCita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(etiquetaNuevaCita);
        etiquetaNuevaCita.setBounds(0, -1, 540, 50);

        etiquetaFecha.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaFecha.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        etiquetaFecha.setText("Fecha ");
        etiquetaFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        etiquetaFecha.setFocusable(false);
        jPanel1.add(etiquetaFecha);
        etiquetaFecha.setBounds(290, 114, 156, 20);

        entradaFecha.setEditable(false);
        entradaFecha
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.add(entradaFecha);
        entradaFecha.setBounds(290, 120, 160, 24);

        Fecha.setBackground(new java.awt.Color(255, 255, 255));
        Fecha.setOpaque(false);
        
        Fecha.addPropertyChangeListener(new date(entradaFecha, Fecha, etiquetaFecha));
        jPanel1.add(Fecha);
        Fecha.setBounds(290, 120, 200, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540,
                                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260,
                                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_entradaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_entradaActionPerformed

    private void btbCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btbCancelarActionPerformed
        // this.dispose();
        Fade.JDialogFadeOut(1f, 0f, 0.2f, 50, this, Fade.DISPOSE);
    }// GEN-LAST:event_btbCancelarActionPerformed

    // private String actualizar(){
    // }
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAñadirActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd - MM - yyyy");
        String fechaAviso = "";
        Calendar fecha=new GregorianCalendar();
        try {
            fecha.setTime(formato.parse(entradaFecha.getText()));
            fecha.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE),
            23, 59, 59);
            
        } catch (ParseException ex) {
            Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        if (entrada.getText().equals("") || entradaFecha.getText().equals("")) {
            new sistema.alertas.Error(this, true, "\n TODOS LOS CAMPOS SON REQUERIDOS").setVisible(true);
        } else if (fecha.before(calendar.getTime())) {
            new sistema.alertas.Error(this, true, " NO SE PUEDE ESTABLECER UNA CITA PARA UNA FECHA PASADA")
                    .setVisible(true);
        } else {
            int result = 0;
            Collection<CitasDTO> coll = Facade.ConsultarCitas(entrada.getText().toUpperCase());
            for (CitasDTO dto : coll) {
                result = dto.getFilasAfectadas();
            }
            if (result == 0) {

                try {
                    if (etiquetaNuevaCita.getText().equals("Editar Cita")) {
                        coll = Facade.ConsultarCitas(listCitas.getValueAt(listCitas.getSelectedRow(), 1).toString());
                        for (CitasDTO dto : coll) {
                            MisCitas.eliminar(dto.getNombre());
                        }
                    }
                    int day =fecha.get(Calendar.DAY_OF_MONTH);
                    int month = (fecha.get(Calendar.MONTH) + 1);
                    int year = fecha.get(Calendar.YEAR);
                    String fechaCita;
                    String fechaExpir;
                    if ((day - 1) < 10) {
                        fechaAviso = "0" + (day - 1) + "/";
                    } else {
                        fechaAviso = "" + (day - 1) + "/";
                    }
                    if (day < 10) {
                        fechaCita = "0" + day + "/";
                    } else {
                        fechaCita = "" + day + "/";
                    }
                    if ((day + 1) < 10) {
                        fechaExpir = "0" + (day + 1) + "/";
                    } else {
                        fechaExpir = "" + (day + 1) + "/";
                    }

                    if ((month - 1) < 10) {
                        fechaAviso += "0" + month + "/";
                    } else {
                        fechaAviso += month + "/";
                    }
                    if (month < 10) {
                        fechaCita += "0" + month + "/";
                    } else {
                        fechaCita += month + "/";
                    }
                    if ((month + 1) < 10) {
                        fechaExpir += "0" + month + "/";
                    } else {
                        fechaExpir += month + "/";
                    }
                    fechaAviso += year;
                    fechaCita += year;
                    fechaExpir += year;
                    if (!os.equals("Linux")) {
                        Runtime tiempoEjecucion = Runtime.getRuntime();

                        String comando = "cmd.exe /C " + "schtasks /create "
                                + "/SC daily /MO 1 /TN " + entrada.getText().toUpperCase() + "_recordatotio_previo"
                                + " /TR \"C:\\Users\\Administrador\\Desktop\\programa.exe SE INFORMA"
                                + " QUE POSEE UNA CITA AGENDADA PARA EL DIA DE MAÑANA "
                                + " QUE LLEVA POR NOMBRE " + entrada.getText() + "\" "
                                + "/SD " + fechaAviso + " /ED " + fechaCita + " /ST 14:05 /F";
                        String comando1 = "cmd.exe /C " + "schtasks /create "
                                + "/SC daily /MO 1 /TN " + entrada.getText().toUpperCase() + "_recordatorio_actual"
                                + " /TR \"C:\\Users\\Administrador\\Desktop\\programa.exe SE INFORMA"
                                + " QUE POSEE UNA CITA AGENDADA PARA EL DIA DE HOY "
                                + " QUE LLEVA POR NOMBRE " + entrada.getText() + "\" "
                                + "/SD " + fechaCita + " /ED " + fechaExpir + " /ST 14:05 /F";

                        formato = new SimpleDateFormat("dd/MM/yyyy");
                        fecha.setTime(formato.parse(fechaAviso));
                        fecha.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE),
                        23, 59, 59);
                        calendar = Calendar.getInstance();
                        if (!fecha.before(calendar.getTime())) {
                            result++;
                            tiempoEjecucion.exec(comando);
                        }
                        Process proceso = tiempoEjecucion.exec(comando1);

                        result++;
                        InputStreamReader isr = new InputStreamReader(proceso.getInputStream());
                        BufferedReader br = new BufferedReader(isr);
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                        br.close();
                    }
                    formato = new SimpleDateFormat("dd - MM - yyyy");
                    fecha.setTime(formato.parse(entradaFecha.getText()));
                    CitasDTO cita = new CitasDTO();
                    cita.setNombre(entrada.getText().toUpperCase());
                    cita.setFecha(formato.format(fecha.getTime()));
                    cita.setAvisos(result);
                    Facade.AñadirCitas(cita);
                    new Hecho(this, true).setVisible(true);
                    Fade.JDialogFadeOut(1f, 0f, 0.2f, 50, this, Fade.DISPOSE);
                } catch (IOException | ParseException ex) {
                    Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (etiquetaNuevaCita.getText().equals("Editar Cita")) {
                    coll = Facade.ConsultarCitas(listCitas.getValueAt(listCitas.getSelectedRow(), 1).toString());
                    for (CitasDTO dto : coll) {
                        if (entrada.getText().toUpperCase().equals(dto.getNombre())
                                && entradaFecha.getText().toUpperCase().equals(dto.getFecha())) {
                            new Informacion(this, true, "\n NO HA MODIFICADO LA CITA").setVisible(true);
                        } else {
                            new sistema.alertas.Error(this, true, "\n YA EXISTE UNA CITA CON ESE NOMBRE")
                                    .setVisible(true);
                        }

                    }
                } else {
                    new sistema.alertas.Error(this, true, "\n YA EXISTE UNA CITA CON ESE NOMBRE").setVisible(true);
                }
            }
        }
    }// GEN-LAST:event_btnAñadirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevaCita dialog = new NuevaCita(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JButton btbCancelar;
    public javax.swing.JButton btnAñadir;
    public javax.swing.JTextField entrada;
    public javax.swing.JTextField entradaFecha;
    public javax.swing.JLabel etiquetaFecha;
    public javax.swing.JLabel etiquetaNuevaCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
