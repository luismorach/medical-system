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
public class DatosMedicosPacienteDAO {
        
    public void AñadirAfeccion(ArrayList<DatosMedicosPacienteDTO> dato) {
        String sql = "INSERT INTO DatosMedicosPaciente (Nombre,"
                + "Tipo,ID_Paciente) VALUES(?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            for (DatosMedicosPacienteDTO dto : dato) {
                pstmt.setString(1, dto.getNombre());
                pstmt.setString(2, dto.getTipo());
                pstmt.setInt(3, dto.getID_Paciente());
                pstmt.executeUpdate();
           }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void AñadirAfeccion(DatosMedicosPacienteDTO datos) {
        String sql = "INSERT INTO DatosMedicosPaciente (Nombre,"
                + "Tipo,ID_Paciente) VALUES(?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
                pstmt.setString(1, datos.getNombre());
                pstmt.setString(2, datos.getTipo());
                pstmt.setInt(3, datos.getID_Paciente());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<DatosMedicosPacienteDTO> consultarDatosMedicos() {
        ArrayList<DatosMedicosPacienteDTO> datos = null;
        String sql = "SELECT *"
                + " FROM DatosMedicosPaciente";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            DatosMedicosPacienteDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new DatosMedicosPacienteDTO(); 
                result.setID(rs.getInt("ID"));
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setTipo(rs.getString("Tipo"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<DatosMedicosPacienteDTO> consultarDatosMedicos(String condicion,int valor) {
        ArrayList<DatosMedicosPacienteDTO> datos = null;
        int x=0;
        String sql = "SELECT *"
                + " FROM DatosMedicosPaciente where Tipo=? And ID_Paciente=?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, condicion);
            pstmt.setInt(2, valor);
            ResultSet rs = pstmt.executeQuery();
            DatosMedicosPacienteDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new DatosMedicosPacienteDTO(); 
                result.setID(rs.getInt("ID"));
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setTipo(rs.getString("Tipo"));
                result.setFilasAfectadas(x);
                datos.add(result);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public ArrayList<DatosMedicosPacienteDTO> consultarDatosMedicos(String tipo,int ID_Paciente,String nombre) {
        ArrayList<DatosMedicosPacienteDTO> datos = null;
        int x=0;
        String sql = "SELECT *"
                + " FROM DatosMedicosPaciente where Tipo=? And ID_Paciente=? AND Nombre=?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tipo);
            pstmt.setInt(2, ID_Paciente);
            pstmt.setString(3, nombre);
            ResultSet rs = pstmt.executeQuery();
            DatosMedicosPacienteDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new DatosMedicosPacienteDTO(); 
                result.setID(rs.getInt("ID"));
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setTipo(rs.getString("Tipo"));
                result.setFilasAfectadas(x);
                datos.add(result);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

   
    public void ActualizarAfeccion(String condicion , int valor,DatosMedicosPacienteDTO nuevosDatos) {
        String sql = "UPDATE DatosMedicosPaciente SET Nombre=?,Tipo=?"
                + "WHERE "+condicion+"="+ valor;
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);  
            pstmt.setString(1, nuevosDatos.getNombre());
            pstmt.setString(2, nuevosDatos.getTipo());
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void EliminarAfeccion(int valor,String nombre,String tipo ) {
        String sql = "DELETE FROM DatosMedicosPaciente"
                + " WHERE ID_Paciente=? AND Nombre=? AND Tipo=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setInt(1, valor);
            pstmt.setString(2,nombre );
            pstmt.setString(3,tipo);
            pstmt.executeUpdate();
            System.out.println("borrree alergias");
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
