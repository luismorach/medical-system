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
public class UsuariosDTO implements Serializable {

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
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the TipoCuenta
     */
    public String getTipoCuenta() {
        return TipoCuenta;
    }

    /**
     * @param TipoCuenta the TipoCuenta to set
     */
    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    private int ID;
    private String Nombre;
    private String Apellido;
    private int Cedula;
    private String Email;
    private String Password;
    private String TipoCuenta;
    private int totalFilasAfectadas;

    /**
     * @return the totalFilasAfectadas
     */
    public int getTotalFilasAfectadas() {
        return totalFilasAfectadas;
    }

    /**
     * @param totalFilasAfectadas the totalFilasAfectadas to set
     */
    public void setTotalFilasAfectadas(int totalFilasAfectadas) {
        this.totalFilasAfectadas = totalFilasAfectadas;
    }

}
