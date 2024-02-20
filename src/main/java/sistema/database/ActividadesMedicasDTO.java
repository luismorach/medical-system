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
public class ActividadesMedicasDTO implements Serializable {

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
    private int ID;
    private int totalFilasAfectadas;
    private String Actividad;
    private String Semana1;
    private String Semana2;
    private String Semana3;
    private String Semana4;
    private String Total;
    private String Porcentaje;
    private String Tipo;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFilasAfectadas(int filasAfectadas) {
        this.totalFilasAfectadas = filasAfectadas;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public void setSemana1(String Semana1) {
        this.Semana1 = Semana1;
    }

    public void setSemana2(String Semana2) {
        this.Semana2 = Semana2;
    }

    public void setSemana3(String Semana3) {
        this.Semana3 = Semana3;
    }

    public void setSemana4(String Semana4) {
        this.Semana4 = Semana4;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public void setPorcentaje(String Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public int getID() {
        return ID;
    }

    public String getActividad() {
        return Actividad;
    }

    public String getSemana1() {
        return Semana1;
    }

    public String getSemana2() {
        return Semana2;
    }

    public String getSemana3() {
        return Semana3;
    }

    public String getSemana4() {
        return Semana4;
    }

    public String getTotal() {
        return Total;
    }

    public int getTotalfilasAfectadas() {
        return totalFilasAfectadas;
    }

    public String getPorcentaje() {
        return Porcentaje;
    }
}
