/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class CitasDAO {
     public void insertarCitas(CitasDTO cita) {
        String sql = "INSERT INTO Citas (Nombre, Fecha, Avisos) VALUES(?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, cita.getNombre());
            pstmt.setString(2, cita.getFecha());
            pstmt.setInt(3, cita.getAvisos());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<CitasDTO> consultarCitas() {
        ArrayList<CitasDTO> datos = null;
        String sql = "SELECT *"
                + " FROM Citas";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            CitasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new CitasDTO();
                result.setID(rs.getInt("ID"));
                result.setNombre(rs.getString("Nombre"));
                result.setFecha(rs.getString("Fecha"));
                result.setAvisos(rs.getInt("Avisos"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public ArrayList<CitasDTO> consultarCitas(String nombre) {
        ArrayList<CitasDTO> datos = null;
        String sql = "SELECT *"
                + " FROM Citas WHERE Nombre = ?";
        int x=0;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            CitasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new CitasDTO();
                result.setID(rs.getInt("ID"));
                result.setNombre(rs.getString("Nombre"));
                result.setFecha(rs.getString("Fecha"));
                result.setFilasAfectadas(x);
                result.setAvisos(rs.getInt("Avisos"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public void ActualizarCitas(String nuevaCita,String cita) {
         String sql = "UPDATE Citas SET Nombre=?"
                    + "WHERE Nombre=?";
            try {
                Connection Conexion = BaseDeDatos.getConexion();
                PreparedStatement pstmt = Conexion.prepareStatement(sql);
                pstmt.setString(1, nuevaCita);
                pstmt.setString(2,cita.toUpperCase());
                pstmt.executeUpdate();                 
            } catch (NumberFormatException | SQLException e) {
                System.out.println(e.getMessage());
            }
    }
    
    public void EliminarCitas(String Nombre) {
          String sql = "DELETE FROM Citas"
                    + " WHERE Nombre=?";
            try {
                Connection Conexion = BaseDeDatos.getConexion();
                PreparedStatement pstmt = Conexion.prepareStatement(sql);
                pstmt.setString(1, Nombre);
                pstmt.executeUpdate(); 
            } catch (NumberFormatException | SQLException e) {
                System.out.println(e.getMessage());
            }
    }
}
