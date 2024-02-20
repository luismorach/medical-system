/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.database;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class FamiliaresDTO implements Serializable {

    /**
     * @param ID
     * @param nombre
     * @param apellido
     * @param cedula
     * @param FechaDeNacimiento
     * @param edad
     * @param genero
     * @param parentesco
     * @param ID_Paciente
     */
    public FamiliaresDTO(int ID, String nombre, String apellido,
            int cedula, String FechaDeNacimiento, int edad, String genero, String parentesco,
            int ID_Paciente) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaDeNacimiento = FechaDeNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.parentesco = parentesco;
        this.ID_Paciente = ID_Paciente;
    }
    public FamiliaresDTO(){
    }

    public int getFilasAfectadas() {
        return FilasAfectadas;
    }

    /**
     * @param FilasAfectadas the FilasAfectadas to set
     */
    public void setFilasAfectadas(int FilasAfectadas) {
        this.FilasAfectadas = FilasAfectadas;
    }
    
    public void setID(int id) {
        this.ID = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setID_Paciente(int id_paciente) {
        this.ID_Paciente = id_paciente;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public static void AñadirFamiliares(FamiliaresDTO familiar) {
        listFamiliares.add(familiar);
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public int getID_Paciente() {
        return ID_Paciente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public static ArrayList<FamiliaresDTO> getListFamiliares() {
        return listFamiliares;
    }

    public static void removerListFamiliares() {
        listFamiliares.removeAll(listFamiliares);
    }
    private int ID = 0;
    private String nombre;
    private String apellido;
    private int cedula;
    private String fechaDeNacimiento;
    private int edad;
    private String genero;
    private String parentesco;
    private int ID_Paciente;
    private int FilasAfectadas;
    private static ArrayList<FamiliaresDTO> listFamiliares = new ArrayList<>();
}
