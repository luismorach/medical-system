/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.database;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class HistorialDTO implements Serializable {

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the TipoConsulta
     */
    public String getTipoConsulta() {
        return TipoConsulta;
    }

    /**
     * @param TipoConsulta the TipoConsulta to set
     */
    public void setTipoConsulta(String TipoConsulta) {
        this.TipoConsulta = TipoConsulta;
    }

    /**
     * @return the MotivoConsulta
     */
    public String getMotivoConsulta() {
        return MotivoConsulta;
    }

    /**
     * @param MotivoConsulta the MotivoConsulta to set
     */
    public void setMotivoConsulta(String MotivoConsulta) {
        this.MotivoConsulta = MotivoConsulta;
    }

    /**
     * @return the Diagnostico
     */
    public String getDiagnostico() {
        return Diagnostico;
    }

    /**
     * @param Diagnostico the Diagnostico to set
     */
    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    /**
     * @return the Accion
     */
    public String getAccion() {
        return Accion;
    }

    /**
     * @param Accion the Accion to set
     */
    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    /**
     * @return the Resultado
     */
    public String getResultado() {
        return Resultado;
    }

    /**
     * @param Resultado the Resultado to set
     */
    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    /**
     * @return the Hora
     */
    public String getHora() {
        return Hora;
    }

    /**
     * @param Hora the Hora to set
     */
    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the ID_Paciente
     */
    public int getID_Paciente() {
        return ID_Paciente;
    }

    /**
     * @param ID_Paciente the ID_Paciente to set
     */
    public void setID_Paciente(int ID_Paciente) {
        this.ID_Paciente = ID_Paciente;
    }
     private int ID ;
     private String TipoConsulta ;
     private String MotivoConsulta;
     private String Diagnostico;
     private String Accion;
     private String Resultado;
     private String Hora;
     private String Fecha;
     private int ID_Paciente;
     
}
