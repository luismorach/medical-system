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
public class HistorialDAO {
    public void insertarHistorial(HistorialDTO historial) {
        String sql = "INSERT INTO Historial (TipoConsulta,MotivoConsulta,Diagnostico,"
                + "Accion,Resultado,Fecha,Hora,ID_Paciente) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, historial.getTipoConsulta());
            pstmt.setString(2, historial.getMotivoConsulta());
            pstmt.setString(3, historial.getDiagnostico());
            pstmt.setString(4, historial.getAccion());
            pstmt.setString(5, historial.getResultado());
            pstmt.setString(6, historial.getFecha());
            pstmt.setString(7, historial.getHora());
            pstmt.setInt(8, historial.getID_Paciente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<HistorialDTO> consultarHistorial(int id) {
        ArrayList<HistorialDTO> datos = null;
        String sql = "SELECT *"
                + " FROM Historial WHERE ID_Paciente=? ORDER BY ID desc";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            HistorialDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new HistorialDTO();
                result.setID(rs.getInt("ID"));
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setTipoConsulta(rs.getString("TipoConsulta"));
                result.setMotivoConsulta(rs.getString("MotivoConsulta"));
                result.setDiagnostico(rs.getString("Diagnostico"));
                result.setAccion(rs.getString("Accion"));
                result.setResultado(rs.getString("Resultado"));
                result.setFecha(rs.getString("Fecha"));
                result.setHora(rs.getString("Hora"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public ArrayList<HistorialDTO> consultarHistorial() {
        ArrayList<HistorialDTO> datos = null;
        String sql = "SELECT *"
                + " FROM Historial";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            HistorialDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new HistorialDTO();
                result.setID(rs.getInt("ID"));
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setTipoConsulta(rs.getString("TipoConsulta"));
                result.setMotivoConsulta(rs.getString("MotivoConsulta"));
                result.setDiagnostico(rs.getString("Diagnostico"));
                result.setAccion(rs.getString("Accion"));
                result.setResultado(rs.getString("Resultado"));
                result.setFecha(rs.getString("Fecha"));
                result.setHora(rs.getString("Hora"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

}
