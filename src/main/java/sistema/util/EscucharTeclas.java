/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import sistema.database.ActividadesMedicasDTO;
import sistema.database.EnfermedadesDTO;
import sistema.database.PacientesDTO;
import sistema.medico.Facade;
import sistema.medico.principal;

/**
 *
 * @author Administrador
 */
public class EscucharTeclas implements KeyListener {

    JComboBox<?> combo;
    static int cant = 0;
    static int posEnfermedad = 0;
    static int posCirugia = 0;
    String msj = "";
    static String tipo = "";
    static String resource;

    public EscucharTeclas(JComboBox <?> combo) {
        this.combo = combo;
    }

    public EscucharTeclas(JComboBox<?>  combo, String msj) {
        this.combo = combo;
        this.msj = msj;
    }

    public static void setcant(int cant) {
        EscucharTeclas.cant = cant;
    }
    public static int getcant() {
        return cant;
    }

    public static void setTipo(String tipo) {
        EscucharTeclas.tipo = tipo;
    }

    public static String getTipo() {
        return tipo;
    }

    public ArrayList<ActividadesMedicasDTO> lista(String letra) {
        ArrayList<ActividadesMedicasDTO> list = new ArrayList<>();
        Collection<ActividadesMedicasDTO> aux;
        String tipoPaciente = ((principal) Instancia.getInstancia("medico.principal")).listPacientes.getItemAt(((principal) Instancia.getInstancia("medico.principal")).listPacientes.getSelectedIndex()).getTipo();
        if (letra.contains("\"")) {
            letra = letra.replace("\"", "");
        }
        if (letra.contains("%")) {
            letra = letra.replace("%", "");
        }
        if (tipoPaciente.equals("ACTIVO")
                || tipoPaciente.equals("JUBILADO")) {
            aux = Facade.consultarConsultaCurativa("Consulta Curativa Activos");
        } else {
            aux = Facade.consultarConsultaCurativa("Consulta Curativa Ministerio");
        }
        for (ActividadesMedicasDTO dto : aux) {
            if (dto.getActividad().contains("ACTIVOS:")) {
                dto.setActividad(dto.getActividad().replace("ACTIVOS: ", ""));
            }
            if (dto.getActividad().contains("MINISTERIO DE ENERGIA ELECTRICA:")) {
                dto.setActividad(dto.getActividad().replace("MINISTERIO DE ENERGIA ELECTRICA: ", ""));
            }
            if (dto.getActividad().contains("JUBILADOS")) {
                continue;
            }
            if (!dto.getActividad().startsWith(letra)) {
                continue;
            }
            list.add(dto);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private void llenarList(Collection<ActividadesMedicasDTO> collConsultasMedicas) {
        DefaultComboBoxModel <String> modelo;
        modelo = (DefaultComboBoxModel<String> ) combo.getModel();
        collConsultasMedicas.forEach((dto) -> {
            modelo.addElement(dto.getActividad());
        });
    }

    @SuppressWarnings("unchecked")
    private void llenarListPacientes(Collection<PacientesDTO> paciente) {
        DefaultComboBoxModel <PacientesDTO> modelo;
        modelo = (DefaultComboBoxModel <PacientesDTO>) combo.getModel();
        paciente.forEach((dto) -> {
            modelo.addElement(dto);
        });
    }

    @SuppressWarnings("unchecked")
    private void llenarListEnfermedades(Collection<EnfermedadesDTO> collConsultasMedicas) {
        DefaultComboBoxModel<String> modelo;
        modelo = (DefaultComboBoxModel <String>) combo.getModel();
        collConsultasMedicas.forEach((dto) -> {
            modelo.addElement(dto.getNombre());
        });
    }

    @SuppressWarnings("unchecked")
    private void llenarList(String msj, String rango) {
        //JOptionPane.showMessageDialog(null,tipo);
        DefaultComboBoxModel<String> modelo;
        modelo = (DefaultComboBoxModel<String>) combo.getModel();
        if (!((principal) Instancia.getInstancia("medico.principal")).listTipoConsulta.getSelectedItem().equals("SELECCIONE EL TIPO DE CONSULTA")
                ||((principal) Instancia.getInstancia("medico.principal")).listPacientes1.getSelectedIndex()>=0) {
            if (msj.equals("SELECCIONE LA ACCION A TOMAR EN LA CONSULTA")
                    && ((principal) Instancia.getInstancia("medico.principal")).listTipoConsulta.getSelectedItem().equals("CONSULTA CURATIVA")
                    && !((principal) Instancia.getInstancia("medico.principal")).listMotivoConsulta.getSelectedItem().equals("SELECCIONE EL MOTIVO DE LA CONSULTA")) {
                msj = "SELECCIONE LA CAUSA DE LA CONSULTA";
            }
            if (msj.equals("SELECCIONE LA ACCION A TOMAR EN LA CONSULTA1")) {
                msj = "SELECCIONE LA ACCION A TOMAR EN LA CONSULTA";
            }
            if (msj.equals("SELECCIONE LA ACCION A TOMAR EN LA CONSULTA")
                    && ((principal) Instancia.getInstancia("medico.principal")).listMotivoConsulta.getSelectedItem().equals("SELECCIONE EL MOTIVO DE LA CONSULTA")) {

            } else if (msj.equals("SELECCIONE LA ACCION A TOMAR EN LA CONSULTA")
                    && ((principal) Instancia.getInstancia("medico.principal")).listEnfermedades.getSelectedItem().equals("SELECCIONE LA CAUSA DE LA CONSULTA")) {

            } else if (msj.equals("SELECCIONE EL RESULTADO DE LA CONSULTA")
                    && ((principal) Instancia.getInstancia("medico.principal")).listEnfermedades.getSelectedItem().equals("SELECCIONE LA CAUSA DE LA CONSULTA")) {

            } else {
                modelo.removeAllElements();
                modelo.addElement(msj);
            }
        }
        Collection<ActividadesMedicasDTO> collConsultasMedicas = null;
        if (tipo.equals("ENFERMEDADES")) {
            //JOptionPane.showMessageDialog(null,tipo);
            ArrayList<EnfermedadesDTO> aux = new ArrayList<>();
            ArrayList<EnfermedadesDTO> coll = new ArrayList<>();
            if (rango.equals("TODO")) {
                coll = Facade.consultarEnfermedadesInfecciosasYParasitarias();
                for (int i = 0; i < 2; i++) {
                    for (EnfermedadesDTO dto : coll) {
                        aux.add(dto);
                    }
                    coll = Facade.consultarNeoplasias();
                }
                llenarListEnfermedades(aux);
            } else {
                coll = Facade.consultarEnfermedadesInfecciosasYParasitariasPorLetra(rango);
                for (int i = 0; i < 2; i++) {
                    for (EnfermedadesDTO dto : coll) {
                        aux.add(dto);
                    }
                    coll = Facade.consultarNeoplasiasPorLetra(rango);
                }
                llenarListEnfermedades(aux);
            }
        } else {
            if (tipo.equals("CONSULTA PREVENTIVA")) {
                if (rango.equals("TODO")) {
                    collConsultasMedicas = Facade.consultarConsultaPreventiva("Consulta Preventiva");
                } else {
                    collConsultasMedicas = Facade.consultarconsultaPreventivaPorLetra(rango, "Consulta Preventiva");
                }
                llenarList(collConsultasMedicas);
            } else if (tipo.equals("CONSULTA CURATIVA")) {
                if (rango.equals("TODO")) {
                    modelo.addElement("ACTIVIDADES DE ENFERMERIA");
                    llenarList(((principal)Instancia.getInstancia("medico.principal")).lista());
                } else {
                    if(rango.contains("A")){
                        modelo.addElement("ACTIVIDADES DE ENFERMERIA");
                    }
                    llenarList(lista(rango));
                }
            } else if (tipo.equals("ESTUDIOS")) {
                if (rango.equals("TODO")) {
                    collConsultasMedicas = Facade.consultarRepososEstudiosReferencias("Estudios");
                } else {
                    collConsultasMedicas = Facade.consultarRepososEstudiosReferenciasPorLetra(rango, "Estudios");
                }
                llenarList(collConsultasMedicas);
            } else if (tipo.equals("ENFERMERIA")) {
                if (rango.equals("TODO")) {
                    collConsultasMedicas = Facade.consultarEnfermeria();
                } else {
                    collConsultasMedicas = Facade.consultarEnfermeriaPorLetra(rango, "Enfermeria");
                }
                llenarList(collConsultasMedicas);
            } else if (tipo.equals("REFERENCIAS")) {
                if (rango.equals("TODO")) {
                    ((principal) Instancia.getInstancia("medico.principal")).llenarReposo();
                    collConsultasMedicas = Facade.consultarRepososEstudiosReferencias("Referencias");
                } else {
                    if (rango.contains("R")) {
                        ((principal) Instancia.getInstancia("medico.principal")).llenarReposo();
                    }
                    collConsultasMedicas = Facade.consultarRepososEstudiosReferenciasPorLetra(rango, "Referencias");
                }
                llenarList(collConsultasMedicas);
            } else if (tipo.equals("RESULTADOS")) {
                if (rango.equals("TODO")) {
                    collConsultasMedicas = Facade.consultarConsultaCurativa("Resultado de Evaluacion");
                } else {
                    collConsultasMedicas = Facade.consultarconsultaCurativaPorLetra(rango, "Resultado de Evaluacion");
                }
                llenarList(collConsultasMedicas);
            } else if (tipo.equals("PACIENTES")) {
                Collection<PacientesDTO> pac;
                if (rango.equals("TODO")) {
                    pac = Facade.ConsultarPacientes();
                } else {
                    pac = Facade.ConsultarPacientesPorLetra(rango);
                }
                llenarListPacientes(pac);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void keyPressed(KeyEvent e) {
        DefaultComboBoxModel<String> modelo;
        ArrayList<String> list;
        if (msj.equals("ENFERMEDAD")) {
            list = PacientesDTO.getEnfermedadesCronicas();
        } else {
            list = PacientesDTO.getCirugias();
        }

        if ("JPanel".equals(e.getComponent().getClass().getSimpleName())) {
            modelo = (DefaultComboBoxModel<String>) combo.getModel();
            if (e.getKeyCode() == KeyEvent.VK_F5) {
                llenarList(msj, "TODO");
            } else if (((e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') || e.getKeyChar() == 'ñ')
                    || (e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z') || e.getKeyChar() == 'Ñ') {

                String letra = "\"" + Character.toString(e.getKeyChar()).toUpperCase() + "%\"";
                llenarList(msj, letra);
            }
            if (e.getKeyCode() == KeyEvent.VK_F6 && (msj.equals("ENFERMEDAD") || msj.equals("CIRUGIA"))) {
                if (list.size() - (cant + 1) >= 0) {
                    cant++;
                    modelo.setSelectedItem(list.get(list.size() - cant));
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_F7 && (msj.equals("ENFERMEDAD") || msj.equals("CIRUGIA"))) {
                if (list.size() - (cant - 1) < list.size()) {
                    cant--;
                    modelo.setSelectedItem(list.get(list.size() - cant));
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER && (msj.equals("ENFERMEDAD") || msj.equals("CIRUGIA"))) {
                ((principal) Instancia.getInstancia("medico.principal")).validarCombox(msj, combo);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
