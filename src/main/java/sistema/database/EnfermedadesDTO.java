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
public class EnfermedadesDTO implements Serializable {

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
    
    public void setID(String ID){
        this.ID=ID;
    }    
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public void setHombresMenoresDe25Años(String HombresMenoresDe25Años){
        this.HombresMenoresDe25Años=HombresMenoresDe25Años;
    }
    public void setMujeresMenoresDe25Años(String MujeresMenoresDe25Años){
        this.MujeresMenoresDe25Años=MujeresMenoresDe25Años;
    }
    public void setHombres25a44Años(String Hombres25a44Años){
        this.Hombres25a44Años=Hombres25a44Años;
    }
    public void setMujeres25a44Años(String Mujeres25a44Años){
        this.Mujeres25a44Años=Mujeres25a44Años;
    }
    public void setHombres45a59Años(String Hombres45a59Años){
        this.Hombres45a59Años=Hombres45a59Años;
    }
    public void setMujeres45a59Años(String Mujeres45a59Años){
        this.Mujeres45a59Años=Mujeres45a59Años;
    }
    public void setHombres60a64Años(String Hombres60a64Años){
        this.Hombres60a64Años=Hombres60a64Años;
    }
    public void setMujeres60a64Años(String Mujeres60a64Años){
        this.Mujeres60a64Años=Mujeres60a64Años;
    }
    public void setTotalHombres(String TotalHombres){
        this.TotalHombres=TotalHombres;
    }
    public void setTotalMujeres(String TotalMujeres){
        this.TotalMujeres=TotalMujeres;
    }
    public void setTotalGeneral(String TotalGeneral){
        this.TotalGeneral=TotalGeneral;
    }    
     public void setHombres65AñosYMas(String Hombres65AñosYMas){
        this.Hombres65AñosYMas=Hombres65AñosYMas;
    }
    public void setMujeres65AñosYMas(String Mujeres65AñosYMas){
        this.Mujeres65AñosYMas=Mujeres65AñosYMas;
    }
    public String getID(){
        return ID;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getHombresMenoresDe25Años(){
        return HombresMenoresDe25Años;
    }
    public String getMujeresMenoresDe25Años(){
        return  MujeresMenoresDe25Años;
    }
    public String getHombres25a44Años(){
        return  Hombres25a44Años;
    }
    public String getMujeres25a44Años(){
        return  Mujeres25a44Años;
    }
    public String getHombres45a59Años(){
        return  Hombres45a59Años;
    }
    public String getMujeres45a59Años(){
        return  Mujeres45a59Años;
    }
    public String getHombres60a64Años(){
        return  Hombres60a64Años;
    }
    public String getMujeres60a64Años(){
        return  Mujeres60a64Años;
    }
    public String getHombres65AñosYMas(){
        return  Hombres65AñosYMas;
    }
    public String getMujeres65AñosYMas(){
        return  Mujeres65AñosYMas;
    }
    public String getTotalHombres(){
        return  TotalHombres;
    }
    public String getTotalMujeres(){
        return  TotalMujeres;
    }
    public String getTotalGeneral(){
        return  TotalGeneral;
    }
    private String ID;
    private String Nombre;
    private String Tipo;
    private String HombresMenoresDe25Años; 
    private String MujeresMenoresDe25Años; 
    private String Hombres25a44Años;
    private String Mujeres25a44Años;  
    private String Hombres45a59Años;  
    private String Mujeres45a59Años;  
    private String Hombres60a64Años;  
    private String Mujeres60a64Años;
    private String Hombres65AñosYMas;  
    private String Mujeres65AñosYMas;
    private String TotalHombres; 
    private String TotalMujeres; 
    private String TotalGeneral; 
    private int totalFilasAfectadas;
}
