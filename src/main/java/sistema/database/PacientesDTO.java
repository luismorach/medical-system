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
public class PacientesDTO implements Serializable{

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the tipoDeSangre
     */
    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    /**
     * @param tipoDeSangre the tipoDeSangre to set
     */
    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PacientesDTO(){
        
    }
    public PacientesDTO(int ID, String nombre, String apellido,
            int cedula, String FechaDeNacimiento, int edad, String genero, String EstadoCivil) {
        this.ID_Paciente = ID;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cedula = cedula;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Edad = edad;
        this.Genero = genero;
        this.EstadoCivil = EstadoCivil;
    }

    /**
     * @return the Alergias
     */
    public static ArrayList<String> getAlergias() {
        return Alergias;
    }

    /**
     * @param aAlergias the Alergias to set
     */
    public static void añadirAlergias(String aAlergias) {
        Alergias.add(aAlergias);
    }

    /**
     * @return the enfermedadesCronicas
     */
    public static ArrayList<String> getEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }

    /**
     * @param aEnfermedadesCronicas the enfermedadesCronicas to set
     */
    public static void setEnfermedadesCronicas(ArrayList<String> aEnfermedadesCronicas) {
        enfermedadesCronicas = aEnfermedadesCronicas;
    }

    /**
     * @return the Cirugias
     */
    public static ArrayList<String> getCirugias() {
        return Cirugias;
    }

    /**
     * @param aCirugias the Cirugias to set
     */
    public static void setCirugias(ArrayList<String> aCirugias) {
        Cirugias = aCirugias;
    }

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
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Cedula
     */
    public int getCedula() {
        return Cedula;
    }

    /**
     * @param Cedula the Cedula to set
     */
    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    /**
     * @return the FechaDeNacimiento
     */
    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    /**
     * @param FechaDeNacimiento the FechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(String FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    /**
     * @return the Edad
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * @param Edad the Edad to set
     */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    /**
     * @return the Genero
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero the Genero to set
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the EstadoCivil
     */
    public String getEstadoCivil() {
        return EstadoCivil;
    }

    /**
     * @param EstadoCivil the EstadoCivil to set
     */
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    @Override
    public String toString() {
        return Nombre + " " + Apellido;
    }

    /**
     * @return the TipoDeSangre
     *
     * /
     **
     * @param Alergias the Alergias to set
     */
    private int ID_Paciente;
    private String Nombre;
    private String Apellido;
    private int Cedula;
    private String FechaDeNacimiento;
    private int Edad;
    private int peso;
    private String tipoDeSangre;
    private String Genero;
    private String EstadoCivil;
    private int FilasAfectadas;
    private static ArrayList<String> Alergias = new ArrayList<>();
    private static ArrayList<String> enfermedadesCronicas = new ArrayList<>();
    private static ArrayList<String> Cirugias = new ArrayList<>();
    private String tipo;

}
