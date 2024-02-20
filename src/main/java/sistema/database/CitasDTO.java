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
public class CitasDTO implements Serializable{

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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    private int ID;
    private String Nombre;
    private String fecha;
    private int FilasAfectadas;
    private int Avisos;

    /**
     * @return the Avisos
     */
    public int getAvisos() {
        return Avisos;
    }

    /**
     * @param Avisos the Avisos to set
     */
    public void setAvisos(int Avisos) {
        this.Avisos = Avisos;
    }
}
