/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import Animacion.Fade;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sistema.alertas.Hecho;
import sistema.database.CitasDTO;
import sistema.util.GestionEncabezado;
import sistema.util.Instancia;
import sistema.util.ModeloTabla;
import sistema.util.PersonalizarTabla;

/**
 *
 * @author Administrador
 */
public class MisCitas extends javax.swing.JDialog {

    /**
     * Creates new form MisCitas
     */
    int x, y;
    static String os = System.getProperty("os.name");

    public MisCitas(JFrame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setOpacity(0f);
        llenarListaCitas();
        Fade.JDialogFadeIn(0f, 1f, 0.2f, 50, this);
    }

    public static void llenarListaCitas() {
        PersonalizarTabla personalizar = (PersonalizarTabla) Instancia.getInstancia("util.PersonalizarTabla");

        personalizar.personalizarTabla(listCitas, 20, 3, 0, "paciente");
        personalizar.personalizarTabla(listCitas, 140, 1);
        personalizar.personalizarTabla(listCitas, 20, 2);

        DefaultTableModel modelo = (DefaultTableModel) listCitas.getModel();
        modelo.setNumRows(0);
        Collection<CitasDTO> coll = Facade.ConsultarCitas();
        coll.forEach((dto) -> {
            modelo.addRow(new Object[] {
                    Integer.toString(dto.getID()), dto.getNombre(), dto.getFecha()
            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btbCancelar = new javax.swing.JButton();
        etiquetaConexionServidor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listCitas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorderE = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorderE.setShowRightShadow(true);
        dropShadowBorderE.setShowLeftShadow(true);
        dropShadowBorderE.setShowTopShadow(true);
        dropShadowBorderE.setShowBottomShadow(true);

        jPanel1.setBorder(dropShadowBorderE);
        jPanel1.setLayout(null);

        btbCancelar.setBackground(new java.awt.Color(0, 0, 153));
        btbCancelar.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        btbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btbCancelar.setText("Cancelar");
        btbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btbCancelar);
        btbCancelar.setBounds(380, 450, 130, 29);

        etiquetaConexionServidor.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        etiquetaConexionServidor.setForeground(new java.awt.Color(0, 0, 102));
        etiquetaConexionServidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaConexionServidor.setText("<html><br>Mis citas </html>");
        etiquetaConexionServidor.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }
        });
        etiquetaConexionServidor.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x - x, point.y - y);
            }
        });
        jPanel1.add(etiquetaConexionServidor);
        etiquetaConexionServidor.setBounds(0, -1, 540, 50);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel3.setText("Citas Agendadas");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 70, 310, 29);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 153));
        jSeparator3.setOpaque(true);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(30, 100, 480, 2);

        btnEliminar.setBackground(new java.awt.Color(0, 0, 153));
        btnEliminar.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        // btnAñadir.addActionListener(new Acciones());
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(210, 450, 130, 29);

        ModeloTabla modelo = new ModeloTabla(
                new Object[][] {

                },
                new String[] {
                        "Nº", "Nombre", "Fecha"
                }

        );
        listCitas.setModel(modelo);
        listCitas.setFocusTraversalPolicyProvider(true);
        listCitas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        // listCitas.addMouseListener(new Acciones());
        listCitas.setRowHeight(25);
        JTableHeader jtableHeader = listCitas.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezado());
        listCitas.setTableHeader(jtableHeader);
        listCitas.setBackground(new Color(255, 255, 255));
        jScrollPane4.getViewport().setBackground(new Color(255, 255, 255));
        jScrollPane4.setViewportView(listCitas);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(30, 110, 480, 330);

        btnEditar.setBackground(new java.awt.Color(0, 0, 153));
        btnEditar.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        // btnAñadir.addActionListener(new Acciones());
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarKeyPressed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(30, 450, 130, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540,
                                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508,
                                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btbCancelarActionPerformed
        Fade.JDialogFadeOut(1f, 0f, 0.2f, 50, this, Fade.DISPOSE);
    }// GEN-LAST:event_btbCancelarActionPerformed

    public static void eliminar(String nombre) {
        Runtime cmd = Runtime.getRuntime();
        Collection<CitasDTO> coll = Facade.ConsultarCitas(nombre);
        try {
            for (CitasDTO dto : coll) {
                if (!os.equals("Linux")) {
                    String comando;
                    String comando1 = "cmd.exe /C " + "schtasks /delete "
                            + "/TN " + dto.getNombre() + "_recordatorio_actual /F";
                    if (dto.getAvisos() == 2) {
                        comando = "cmd.exe /C " + "schtasks /delete "
                                + "/TN " + dto.getNombre() + "_recordatotio_previo /F";
                        cmd.exec(comando);
                    }
                    cmd.exec(comando1);
                }

                Facade.EliminarCitas(listCitas.getValueAt(listCitas.getSelectedRow(), 1).toString());
            }
        } catch (IOException ex) {

        }
    }

    public static void eliminar() {

    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        if (listCitas.getSelectedRow() < 0) {
            new sistema.alertas.Error(this, true, "\n DEBE SELECIONAR UNA CITA").setVisible(true);
        } else {
            eliminar(listCitas.getValueAt(listCitas.getSelectedRow(), 1).toString());
            llenarListaCitas();
            new Hecho(this, true).setVisible(true);
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_btnEliminarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // conectar();
        }
    }// GEN-LAST:event_btnEliminarKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        if (listCitas.getSelectedRow() < 0) {
            new sistema.alertas.Error(this, true, "\n DEBE SELECIONAR UNA CITA").setVisible(true);
        } else {
            NuevaCita obj = new NuevaCita(this, true);
            obj.etiquetaNuevaCita.setText("Editar Cita");
            Collection<CitasDTO> coll = Facade
                    .ConsultarCitas(listCitas.getValueAt(listCitas.getSelectedRow(), 1).toString());
            for (CitasDTO dto : coll) {
                obj.entrada.setText(dto.getNombre());
                obj.entradaFecha.setText(dto.getFecha());
                new EscucharBotones.focus().subir(obj.etiquetaFecha,
                        obj.entradaFecha, 0, 0, 153);
            }
            obj.setVisible(true);
            llenarListaCitas();

        }
    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_btnEditarKeyPressed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnEditarKeyPressed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            MisCitas dialog = new MisCitas(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JLabel etiquetaConexionServidor;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTable listCitas;
    // End of variables declaration//GEN-END:variables
}
