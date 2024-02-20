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
public class DatosMedicosPacienteDTO implements Serializable {

    /**
     * @return the FilasAfectadas
     */
    public int getFilasAfectadas() {
        return FilasAfectadas;
    }

    /**
     * @param FilasAfectadas the FilasAfectadas to set
     */
    public void setFilasAfectadas(int FilasAfectadas) {
        this.FilasAfectadas = FilasAfectadas;
    }

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
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
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
    private int ID;
    private String Nombre;
    private String Tipo;
    private int ID_Paciente;
    private int FilasAfectadas;
}
