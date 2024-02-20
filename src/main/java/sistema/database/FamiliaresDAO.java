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
public class FamiliaresDAO {
    
    public void AñadirFamiliar(ArrayList<FamiliaresDTO> Familiares) {
        String sql = "INSERT INTO FamiliaresPaciente (Nombre,Apellido,Cedula,"
                + "FechaDeNacimiento,Edad,Parentesco,Genero,ID_Paciente) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            for (FamiliaresDTO dto : Familiares) {
                pstmt.setString(1, dto.getNombre());
                pstmt.setString(2, dto.getApellido());
                pstmt.setInt(3, dto.getCedula());
                pstmt.setString(4, dto.getFechaDeNacimiento());
                pstmt.setInt(5, dto.getEdad());
                pstmt.setString(6, dto.getParentesco());
                pstmt.setString(7,dto.getGenero() );
                pstmt.setInt(8, dto.getID_Paciente());
                pstmt.executeUpdate();
           }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void AñadirFamiliar(FamiliaresDTO Familiar) {
        String sql = "INSERT INTO FamiliaresPaciente (Nombre,Apellido,Cedula,"
                + "FechaDeNacimiento,Edad,Parentesco,Genero,ID_Paciente) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
                pstmt.setString(1, Familiar.getNombre());
                pstmt.setString(2, Familiar.getApellido());
                pstmt.setInt(3, Familiar.getCedula());
                pstmt.setString(4, Familiar.getFechaDeNacimiento());
                pstmt.setInt(5, Familiar.getEdad());
                pstmt.setString(6, Familiar.getParentesco());
                pstmt.setString(7,Familiar.getGenero() );
                pstmt.setInt(8, Familiar.getID_Paciente());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<FamiliaresDTO> consultarFamiliares() {
        ArrayList<FamiliaresDTO> datos = null;
        String sql = "SELECT *"
                + " FROM FamiliaresPaciente";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            FamiliaresDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new FamiliaresDTO();
                result.setID(rs.getInt("ID"));
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                result.setEdad(rs.getInt("Edad"));
                result.setGenero(rs.getString("Genero"));
                result.setParentesco(rs.getString("Parentesco"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<FamiliaresDTO> consultarFamiliaresEspecificos(String condicion,int valor) {
        ArrayList<FamiliaresDTO> datos = null;
        int x=0;
        String sql = "SELECT *"
                + " FROM FamiliaresPaciente where "+condicion+"="+valor;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            FamiliaresDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new FamiliaresDTO();
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                result.setEdad(rs.getInt("Edad"));
                result.setGenero(rs.getString("Genero"));
                result.setParentesco(rs.getString("Parentesco"));
                result.setFilasAfectadas(x);
                datos.add(result);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

   
    public void ActualizarFamiliares(String condicion , int valor,FamiliaresDTO nuevosDatos) {
        String sql = "UPDATE FamiliaresPaciente SET Nombre=?,Apellido=?,Cedula=?,"
                + "FechaDeNacimiento=?,Edad=?,Parentesco=?,Genero=?"
                + "WHERE "+condicion+"="+ valor;
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);  
            pstmt.setString(1, nuevosDatos.getNombre());
            pstmt.setString(2, nuevosDatos.getApellido());
            pstmt.setInt(3, nuevosDatos.getCedula());
            pstmt.setString(4, nuevosDatos.getFechaDeNacimiento());
            pstmt.setInt(5, nuevosDatos.getEdad());
            pstmt.setString(6, nuevosDatos.getParentesco());
            pstmt.setString(7, nuevosDatos.getGenero());
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void EliminarFamiliares(String condicion , int valor) {
        String sql = "DELETE FROM FamiliaresPaciente"
                + " WHERE "+condicion+"=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setInt(1, valor);
            pstmt.executeUpdate();
            System.out.println("borrree");
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
