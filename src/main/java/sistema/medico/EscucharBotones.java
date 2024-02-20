/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import Animacion.Animacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import sistema.alertas.*;
import sistema.database.ActividadesMedicasDTO;
import sistema.database.EnfermedadesDTO;
import sistema.database.PacientesDTO;

import static sistema.medico.principal.menuOpciones;
import sistema.util.Instancia;
import sistema.util.ModeloTabla;

/**
 *
 * @author Administrador
 */
public class EscucharBotones {

    static class Tiempo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Date sistemaHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            principal.etiquetaHora.setText(String.format(formato.format(sistemaHora), now));
        }
    }

    static class focus implements FocusListener {

        JLabel etiqueta;
        int r, g, b;

        focus(JLabel etiqueta, int r, int g, int b) {
            this.etiqueta = etiqueta;
            this.r = r;
            this.g = g;
            this.b = b;
        }

        focus() {
        }

        public void subir(JLabel etiqueta, JTextField entrada, int r, int g, int b) {
            int pos = etiqueta.getY();
            if ((pos + 6) == entrada.getY()) {
                Animacion.subir(etiqueta.getY(), etiqueta.getY() - 20, 5, 5, etiqueta);
                etiqueta.setFont(new Font(etiqueta.getFont().getName(), etiqueta.getFont().getStyle(),
                        etiqueta.getFont().getSize() - ((etiqueta.getFont().getSize() / 8) * 2)));
                entrada.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(r, g, b)));
            }
        }

        public void bajar(JLabel etiqueta, JTextField entrada) {
            if ("".equals(entrada.getText()) && (entrada.getY() - 6) > etiqueta.getY()) {
                Animacion.bajar(etiqueta.getY(), etiqueta.getY() + 20, 5, 5, etiqueta);
                etiqueta.setFont(new Font(etiqueta.getFont().getName(), etiqueta.getFont().getStyle(),
                        etiqueta.getFont().getSize() + ((etiqueta.getFont().getSize() / 8) * 2)));
                entrada.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(180, 180, 180)));
            }
        }

        @Override
        public void focusGained(FocusEvent e) {
            JTextField aux = (JTextField) e.getComponent();
            subir(etiqueta, aux, r, g, b);
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField aux = (JTextField) e.getComponent();
            bajar(etiqueta, aux);
        }
    }

    public static FocusListener focus(JLabel etiqueta, int r, int g, int b) {
        return new focus(etiqueta, r, g, b);
    }

    static class mouse implements MouseListener {

        JFrame parent;
        int column;
        String msj;
        int indexConsult;

        public mouse(JFrame parent, int column, String msj, int indexConsult) {
            this.parent = parent;
            this.column = column;
            this.msj = msj;
            this.indexConsult = indexConsult;
        }

        public mouse() {

        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getComponent() instanceof JTable) {
                JTable table = (JTable) me.getComponent();
                int row = table.rowAtPoint(me.getPoint());
                if (me.isMetaDown()) {
                    table.setRowSelectionInterval(row, row);
                    principal.menuOpciones.removeAll();
                    if (msj.equals("")) {
                        principal.menuOpciones.add(principal.pnlVerPacientes);
                    } else {
                        principal.menuOpciones.add(principal.pnlOpciones);
                    }
                    principal.menuOpciones.show(me.getComponent(), me.getX(), me.getY());
                    Acciones.setValores(table, parent, column, msj, indexConsult);

                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            me.getComponent().setBackground(new Color(220, 220, 220));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            me.getComponent().setBackground(new Color(255, 255, 255));
        }

    }

    static class Acciones implements ActionListener {

        static JTable tabla;
        static JFrame parent;
        static int column;
        static String msj;
        static int indexConsult;

        public Acciones(JTable tabla, JFrame parent, int column, String msj, int indexConsult) {
            Acciones.tabla = tabla;
            Acciones.parent = parent;
            Acciones.column = column;
            Acciones.msj = msj;
            Acciones.indexConsult = indexConsult;
        }

        public static void setValores(JTable tabla, JFrame parent, int column, String msj, int indexConsult) {
            Acciones.tabla = tabla;
            Acciones.parent = parent;
            Acciones.column = column;
            Acciones.msj = msj;
            Acciones.indexConsult = indexConsult;
        }

        public Acciones() {

        }

        private void actualizarTotales() {
            ArrayList<ActividadesMedicasDTO> coll;
            ArrayList<ActividadesMedicasDTO> especial;

            switch (indexConsult) {
                case 0:
                    especial = Facade.consultarConsultaPreventiva("\'Consulta Preventiva Especial\'");
                    coll = Facade.consultarConsultaPreventiva("\'Consulta Preventiva\'");
                    Facade.ActualizarActividadMedica("TOTAL CONSULTAS PREVENTIVAS(CORPOELEC)", "Consulta Preventiva Especial", ((principal) Instancia.getInstancia("medico.principal")).estadisticas(coll, especial));
                    ((principal) Instancia.getInstancia("medico.principal")).porcentaje(coll, especial, "Consulta Preventiva");
                    break;
                case 1:
                    coll = Facade.consultarConsultaCurativa("\'Consulta Curativa Activos\'");
                    especial = Facade.consultarConsultaCurativa("\'Consulta Curativa Especial Activos\'");
                    Facade.ActualizarActividadMedica("TOTAL CONSULTAS A CORPOELEC", "Consulta Curativa Especial Activos", ((principal) Instancia.getInstancia("medico.principal")).estadisticas(coll, especial));
                    break;
                case 2:
                    coll = Facade.consultarConsultaCurativa("\'Consulta Curativa Ministerio\'");
                    especial = Facade.consultarConsultaCurativaEspecifica("\'TOTAL CONSULTAS A MINISTERIO DE ENERGIA ELECTRICA\'", "\'Consulta Curativa Especial Ministerio\'");
                    Facade.ActualizarActividadMedica("TOTAL CONSULTAS A MINISTERIO DE ENERGIA ELECTRICA", "Consulta Curativa Especial Ministerio", ((principal) Instancia.getInstancia("medico.principal")).estadisticas(coll, especial));
                    break;
                case 5:
                    coll = Facade.consultarRepososEstudiosReferencias("\'Estudios\'");
                    especial = Facade.consultarRepososEstudiosReferencias("\'Estudios Especiales\'");
                    Facade.ActualizarActividadMedica("TOTAL ESTUDIOS SOLICITADOS", "Estudios Especiales", ((principal) Instancia.getInstancia("medico.principal")).estadisticas(coll, especial));
                    break;

                default:

                    break;
            }
            ArrayList<ActividadesMedicasDTO> aux;
            coll = Facade.consultarConsultaCurativaEspecifica("\'TOTAL CONSULTAS A MINISTERIO DE ENERGIA ELECTRICA\'", "\'Consulta Curativa Especial Ministerio\'");
            aux = Facade.consultarConsultaCurativaEspecifica("\'TOTAL CONSULTAS A CORPOELEC\'", "\'Consulta Curativa Especial Activos\'");
            especial = Facade.consultarConsultaCurativaEspecifica("\'TOTAL CONSULTAS CURATIVAS (CORPOELEC, COMUNIDAD Y OTROS)\'", "\'Consulta Curativa Especial Ministerio\'");
            Facade.ActualizarActividadMedica("TOTAL CONSULTAS CURATIVAS (CORPOELEC, COMUNIDAD Y OTROS)", "Consulta Curativa Especial Ministerio", ((principal) Instancia.getInstancia("medico.principal")).estadisticas(((principal) Instancia.getInstancia("medico.principal")).totalesGenerales(coll, aux), especial));
            coll = Facade.consultarConsultaCurativaEspecifica("\'TOTAL CONSULTAS CURATIVAS (CORPOELEC, COMUNIDAD Y OTROS)\'", "\'Consulta Curativa Especial Ministerio\'");
            aux = Facade.consultarConsultaPreventiva("\'Consulta Preventiva Especial\'");
            especial = Facade.consultarConsultaCurativaEspecifica("\'TOTAL DE CONSULTAS EN GENERAL (CONSULTAS CURATIVAS + CONSULTAS PREVENTIVAS CORPOELEC)\'", "\'Consulta Curativa Especial\'");
            Facade.ActualizarActividadMedica("TOTAL DE CONSULTAS EN GENERAL (CONSULTAS CURATIVAS + CONSULTAS PREVENTIVAS CORPOELEC)", "Consulta Curativa Especial", ((principal) Instancia.getInstancia("medico.principal")).estadisticas(((principal) Instancia.getInstancia("medico.principal")).totalesGenerales(coll, aux), especial));

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (principal.btnEliminar == e.getSource()) {
                principal.menuOpciones.setVisible(false);
                String selected = tabla.getValueAt(tabla.getSelectedRow(), column).toString();
                Advertencia a = new Advertencia(parent, true, "\n ESTA SEGURO QUE DESEA ELIMINAR " + msj);
                a.setVisible(true);
                if (Advertencia.continuar) {
                    if (!msj.equals("ESTA ENFERMEDAD")) {
                        Facade.EliminarActividadMedica(selected);
                        actualizarTotales();
                    } else {
                        Facade.eliminarEnfermedades(selected);
                    }
                    ((principal) Instancia.getInstancia("medico.principal")).mostrarTablas();
                    new Hecho(parent, true).setVisible(true);
                }
                principal.btnEliminar.setBackground(new Color(255, 255, 255));

            } else if (principal.btnEditar == e.getSource()) {
                menuOpciones.setVisible(false);
                int row = tabla.getSelectedRow();
                ModeloTabla modelo = (ModeloTabla) tabla.getModel();
                modelo.setEditable(row, column);
                tabla.editCellAt(row, column);
                String valor = tabla.getValueAt(row, column).toString();
                modelo.addTableModelListener(new EscuchaDeTablas(tabla, parent, msj, valor, 2, indexConsult));
                tabla.getCellEditor().getTableCellEditorComponent(tabla, valor, true, row, column).requestFocus();
                modelo.setEditable(-1, -1);
                principal.btnEditar.setBackground(new Color(255, 255, 255));

            } else if (principal.btnVer == e.getSource()) {
                int valor = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
                VerDatosPaciente paciente = new VerDatosPaciente(null, true);
                VerDatosPaciente.llenarTablaPacientes("Cedula", valor);
                paciente.setVisible(true);
            }
        }
    }

    static class AccionesTxt implements KeyListener {

        String tipo;
        int tamaño;
        static int cant = 0;

        public AccionesTxt(String tipo) {
            this.tipo = tipo;
            this.tamaño = 10;
        }

        public AccionesTxt(String tipo, int tamaño) {
            this.tipo = tipo;
            this.tamaño = tamaño;
        }

        public static void setCant(int cant) {
            AccionesTxt.cant = cant;
        }

        public static int getCant() {
            return cant;
        }

        @Override
        public void keyTyped(KeyEvent ke) {
            char caracter = ke.getKeyChar();
            JTextField aux = (JTextField) ke.getComponent();
            if (ke.getComponent() instanceof JTextField) {
                if (tipo.equals("numerico")) {
                    if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')
                            || aux.getText().length() == tamaño) {
                        ke.consume();  // ignorar el evento de teclado
                    }
                }
                if (tipo.equals("texto")) {
                    if ((caracter < 'a' || caracter > 'z') && caracter != 'ñ' && caracter != ' '
                            && (caracter < 'A' || caracter > 'Z') && caracter != 'Ñ') {
                        ke.consume();  // ignorar el evento de teclado
                    }
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {

            JTextField aux = (JTextField) ke.getComponent();
            if (tipo.equals("especial")) {
                //JOptionPane.showMessageDialog(null, "pase");

                if (ke.getComponent() instanceof JTextField) {
                    if (ke.getKeyCode() == KeyEvent.VK_F4) {
                        if (PacientesDTO.getAlergias().size() - (cant + 1) >= 0) {
                            cant++;
                            aux.setText(PacientesDTO.getAlergias().get(PacientesDTO.getAlergias().size() - cant));
                        }

                    }
                    if (ke.getKeyCode() == KeyEvent.VK_F6) {
                        if (PacientesDTO.getAlergias().size() - (cant - 1) < PacientesDTO.getAlergias().size()) {
                            cant--;
                            aux.setText(PacientesDTO.getAlergias().get(PacientesDTO.getAlergias().size() - cant));
                        }
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                        ((principal) Instancia.getInstancia("medico.principal")).validarAlergias();
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }

    }

}

class EscuchaDeTablas implements TableModelListener {

    JTable tabla;
    JFrame parent;
    String msj;
    String valor;
    int aux;
    int indexConsult;
    TableModel modelo;
    int fila;
    int columna;

    public EscuchaDeTablas(JTable tabla, JFrame parent, String msj, String valor, int aux, int indexConsult) {
        this.parent = parent;
        this.msj = msj;
        this.valor = valor;
        this.aux = aux;
        this.tabla = tabla;
        this.indexConsult = indexConsult;
    }

    private ArrayList<EnfermedadesDTO> enfermedades() {
        ArrayList<EnfermedadesDTO> coll = null;
        switch (indexConsult) {
            case 14:
                coll = Facade.consultarEnfermedadesInfecciosasYParasitariasEspecificas("\'" + modelo.getValueAt(fila, columna).toString().toUpperCase() + "\'");
                break;
            case 15:
                coll = Facade.consultarNeoplasiasEspecificas("\'" + modelo.getValueAt(fila, columna).toString().toUpperCase() + "\'");
                break;
        }
        return coll;
    }

    public ArrayList<ActividadesMedicasDTO> ActividadesMedicas() {
        ArrayList<ActividadesMedicasDTO> coll = null;
        switch (indexConsult) {
            case 0:
                coll = Facade.consultarConsultaPreventivaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase() );
                break;
            case 1:
                coll = Facade.consultarConsultaCurativaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase(), "Consulta Curativa Activos");
                break;
            case 2:
                coll = Facade.consultarConsultaCurativaEspecifica( modelo.getValueAt(fila, columna).toString().toUpperCase(), "Consulta Curativa Ministerio");
                break;
            case 3:
                coll = Facade.consultarConsultaCurativaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase() , "Resultado de Evaluacion");
                break;
            case 4:
                coll = Facade.consultarRepososEstudiosReferenciasEspecificos(modelo.getValueAt(fila, columna).toString().toUpperCase() , "Reposos");
                break;
            case 5:
                coll = Facade.consultarRepososEstudiosReferenciasEspecificos(modelo.getValueAt(fila, columna).toString().toUpperCase() , "Estudios");
                break;
            case 6:
                coll = Facade.consultarRepososEstudiosReferenciasEspecificos(modelo.getValueAt(fila, columna).toString().toUpperCase(), "Referencias");
                break;
            case 7:
                coll = Facade.consultarPromocionDeLaSaludEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase());
                break;
            case 8:
                coll = Facade.consultarPsicologiaPsicoterapiaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase());
                break;
            case 9:
                coll = Facade.consultarEnfermeriaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase());
                break;
            case 10:
                coll = Facade.consultarFisioterapiaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase());
                break;
            case 11:
                coll = Facade.consultarOdontologiaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase(), "Odontologia Activos");
                break;
            case 12:
                coll = Facade.consultarOdontologiaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase() , "Odontologia Ministerio");
                break;
            case 13:
                coll = Facade.consultarNutricionYDieteticaEspecifica(modelo.getValueAt(fila, columna).toString().toUpperCase());
                break;
            default:

                break;
        }
        return coll;
    }

    @Override
    public void tableChanged(TableModelEvent tme) {

        if (TableModelEvent.UPDATE == tme.getType() && aux == 2) {
            aux++;
            modelo = ((TableModel) (tme.getSource()));
            fila = tme.getFirstRow();
            columna = tme.getColumn();

            if (modelo.getValueAt(fila, columna).equals("")) {
                new sistema.alertas.Error(parent, true, "\n EL NOMBRE NO PUEDE ESTAR VACIO").setVisible(true);
                modelo.setValueAt(valor, fila, columna);
            } else if (modelo.getValueAt(fila, columna).equals(valor)) {
                new Informacion(parent, true, "\n NO HA MODIFICADO EL NOMBRE DE " + msj).setVisible(true);
            } else {
                int result = 0;
                if (!msj.equals("ESTA ENFERMEDAD")) {
                    Collection<ActividadesMedicasDTO> collConsultasMedicas = ActividadesMedicas();
                    for (ActividadesMedicasDTO dto : collConsultasMedicas) {
                        result = dto.getTotalfilasAfectadas();
                    }
                } else {
                    Collection<EnfermedadesDTO> collenfermedades = enfermedades();
                    for (EnfermedadesDTO dto : collenfermedades) {
                        result = dto.getTotalFilasAfectadas();
                    }
                }
                if (result == 0) {
                    if (!msj.equals("ESTA ENFERMEDAD")) {
                        Facade.ActualizarActividadMedica(modelo.getValueAt(fila, columna).toString().toUpperCase(), valor);
                    } else {
                        Facade.ActualizarEnfermedades(modelo.getValueAt(fila, columna).toString().toUpperCase(), valor);
                    }
                    modelo.setValueAt(modelo.getValueAt(fila, columna).toString().toUpperCase(), fila, columna);
                    new Hecho(parent, true).setVisible(true);
                } else {
                    if (msj.contains("ESTA")) {
                        msj = msj.replace("ESTA", "UNA");
                    } else {
                        msj = msj.replace("ESTE", "UN");
                    }
                    new sistema.alertas.Error(parent, true, "\n YA EXISTE " + msj + " CON ESE NOMBRE").setVisible(true);
                    modelo.setValueAt(valor, fila, columna);
                }
            }
        }
    }

}
