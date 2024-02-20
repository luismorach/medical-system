/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import Animacion.Fade;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Collection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import sistema.util.Instancia;
import sistema.alertas.Error;
import sistema.alertas.Hecho;
import sistema.database.ActividadesMedicasDAO;
import sistema.database.ActividadesMedicasDTO;
import sistema.util.CustomUI;

/**
 *
 * @author Administrador
 */
public class Añadir extends javax.swing.JDialog {
public static boolean continuar = false;
    /**
     * Creates new form Añadir
     *
     * * @param parent
     * @param parent
     * @param modal
     * @throws java.lang.InterruptedException
     */
    ActividadesMedicasDAO acceso = (ActividadesMedicasDAO) Instancia.getInstancia("database.ActividadesMedicasDAO");
    JDialog dialogo;
    String tipo;
    int x, y;

    public Añadir(JFrame parent, boolean modal, String tipo, String text) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        list.setVisible(false);
        etiqueta.setVisible(false);
        this.setLocationRelativeTo(parent);
        setOpacity(0f);
        dialogo = this;
        this.tipo = tipo;
        etiquetaAñadir.setText(tipo);
        etiquetaNombre.setText(text);
        continuar=false;
        Fade.JDialogFadeIn(0f, 1f, 0.2f, 50, this);
    }
     public Añadir(JDialog parent, boolean modal, String tipo, String text) {
        super(parent, modal);
        
        setUndecorated(true);
        initComponents();
        list.setVisible(false);
        etiqueta.setVisible(false);
        this.setLocationRelativeTo(parent);
        setOpacity(0f);
        dialogo = this;
        this.tipo = tipo;
        etiquetaAñadir.setText(tipo);
        etiquetaNombre.setText(text);
        continuar=false;
        Fade.JDialogFadeIn(0f, 1f, 0.2f, 50, this);
    }

    void añadirActividadPreventiva() {
        
        if (tipo.equals("Consulta Curativa")) {
            if (!entrada.getText().toUpperCase().contains("ACTIVOS")
                    && !entrada.getText().toUpperCase().contains("JUBILADOS")
                    && !entrada.getText().toUpperCase().contains("MINISTERIO DE ENERGIA ELECTRICA")) {
                if (((principal) Instancia.getInstancia("medico.test")).listPacientes.getItemAt(((principal) Instancia.getInstancia("medico.test")).listPacientes.getSelectedIndex()).getTipo().equals("MINISTERIO DE ENERGIA ELECTRICA")) {
                    entrada.setText("MINISTERIO DE ENERGIA ELECTRICA: "+entrada.getText().toUpperCase());
                } else if (((principal) Instancia.getInstancia("medico.test")).listPacientes.getItemAt(((principal) Instancia.getInstancia("medico.test")).listPacientes.getSelectedIndex()).getTipo().equals("ACTIVO")) {
                    entrada.setText("ACTIVOS: "+entrada.getText().toUpperCase());
                }else {
                    entrada.setText("JUBILADOS: "+entrada.getText().toUpperCase());
                }
            }
            if (((principal) Instancia.getInstancia("medico.test")).listPacientes.getItemAt(((principal) Instancia.getInstancia("medico.test")).listPacientes.getSelectedIndex()).getTipo().equals("MINISTERIO DE ENERGIA ELECTRICA")) {
                    tipo += " Ministerio";
                } else {
                    tipo += " Activos";
                }

        }
        if (tipo.equals("Actividad de Enfermeria")) {
            tipo = tipo.replace("Actividad de ", "");
        }
        acceso.insertarActividad(entrada.getText().toUpperCase(), tipo);
    }

    class Acciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (entrada.getText().equals("")) {
                new Error(dialogo, true, "\n EL NOMBRE NO PUEDE ESTAR VACIO").setVisible(true);
            } else {
                if (tipo.contains("Añadir")) {
                    tipo = tipo.replace("Añadir ", "");
                }
                if (tipo.equals("Enfermedades")) {
                    if (list.isVisible() && list.getSelectedIndex() < 1) {
                        new Error(dialogo, true, "\n DEBE SELECCIONAR EL TIPO DE ENFERMEDAD").setVisible(true);
                    } else {

                    }
                } else {
                    int result = 0;
                    Collection<ActividadesMedicasDTO> collConsultasMedicas = null;
                    if (tipo.equals("Consulta Preventiva")) {
                        collConsultasMedicas = Facade.consultarConsultaPreventivaEspecifica(entrada.getText().toUpperCase(), "Consulta Preventiva");
                    } else if (tipo.equals("Consulta Curativa")) {
                        collConsultasMedicas = Facade.consultarConsultaCurativaEspecifica(entrada.getText().toUpperCase(), "Consulta Curativa Activos");
                    } else if (tipo.equals("Estudios")) {
                        collConsultasMedicas = Facade.consultarRepososEstudiosReferenciasEspecificos(entrada.getText().toUpperCase(), "Estudios");
                    } else if (tipo.equals("Actividad de Enfermeria")) {
                        collConsultasMedicas = Facade.consultarEnfermeriaEspecifica(entrada.getText().toUpperCase(), "Enfermeria");
                    } else if (tipo.equals("Resultado de Evaluacion")) {
                        collConsultasMedicas = Facade.consultarConsultaCurativaEspecifica(entrada.getText().toUpperCase(), "Resultado de Evaluacion");
                    } else if (tipo.equals("Referencias")) {
                        collConsultasMedicas = Facade.consultarRepososEstudiosReferenciasEspecificos(entrada.getText().toUpperCase() , "Referencias");
                    }

                    for (ActividadesMedicasDTO dto : collConsultasMedicas) {
                        result = dto.getTotalfilasAfectadas();
                    }
                    if (result == 0) {
                        añadirActividadPreventiva();
                        continuar=true;
                        new Hecho(dialogo, true).setVisible(true);
                        dialogo.dispose();
                    } else {
                        new Error(dialogo, true, "YA EXISTE UNA " + tipo.toUpperCase() + " CON ESE NOMBRE").setVisible(true);
                    }
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("static-access")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiquetaNombre = new javax.swing.JLabel();
        entrada = new javax.swing.JTextField();
        btbCancelar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        etiquetaAñadir = new javax.swing.JLabel();
        list = new javax.swing.JComboBox<>();
        etiqueta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        etiquetaNombre.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        etiquetaNombre.setText("Nombre de la enfermedad");
        jPanel1.add(etiquetaNombre);
        etiquetaNombre.setBounds(40, 124, 450, 20);

        entrada.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        entrada.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        entrada.addFocusListener(new EscucharBotones().focus(etiquetaNombre,0,0,153));
        entrada.addActionListener(new Acciones());
        entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaActionPerformed(evt);
            }
        });
        jPanel1.add(entrada);
        entrada.setBounds(40, 130, 450, 24);

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
        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new Acciones());
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAñadir);
        btnAñadir.setBounds(40, 200, 160, 29);

        etiquetaAñadir.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        etiquetaAñadir.setForeground(new java.awt.Color(0, 0, 102));
        etiquetaAñadir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAñadir.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }
        });
        etiquetaAñadir.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent evt) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x - x, point.y - y);
            }
        });
        etiquetaAñadir.setText("Añadir Enfermedad");
        etiquetaAñadir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(etiquetaAñadir);
        etiquetaAñadir.setBounds(0, -1, 540, 50);

        list.setBackground(new java.awt.Color(0, 0, 0));
        list.setEditable(true);
        list.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setUI(CustomUI.createUI(rootPane));
        list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE EL TIPO DE ENFERMEDAD", "ENFERMEDADES INFECCIOSAS Y PARASITARIAS", "NEOPLASIAS" }));
        list.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listItemStateChanged(evt);
            }
        });
        jPanel1.add(list);
        list.setBounds(280, 130, 220, 25);

        etiqueta.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta.setForeground(new java.awt.Color(153, 153, 153));
        etiqueta.setText("etiuqeta");
        jPanel1.add(etiqueta);
        etiqueta.setBounds(280, 100, 240, 13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbCancelarActionPerformed
        // this.dispose();
        Fade.JDialogFadeOut(1f, 0f, 0.2f, 50, this, Fade.DISPOSE);
    }//GEN-LAST:event_btbCancelarActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaActionPerformed

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged
        //if(etiquetaAñadir.getText())
    }//GEN-LAST:event_listItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbCancelar;
    public javax.swing.JButton btnAñadir;
    public javax.swing.JTextField entrada;
    public javax.swing.JLabel etiqueta;
    private javax.swing.JLabel etiquetaAñadir;
    public javax.swing.JLabel etiquetaNombre;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox<String> list;
    // End of variables declaration//GEN-END:variables
}
