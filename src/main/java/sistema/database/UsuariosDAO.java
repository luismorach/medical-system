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
public class UsuariosDAO {
    
    public void insertarUsuarios(UsuariosDTO Usuario) {
        String sql = "INSERT INTO Usuarios (ID,Nombre,Apellido,Cedula,Email,Password,TipoCuenta) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setInt(1, Usuario.getID());
            pstmt.setString(2, Usuario.getNombre());
            pstmt.setString(3, Usuario.getApellido());
            pstmt.setInt(4, Usuario.getCedula());
            pstmt.setString(5, Usuario.getEmail());
            pstmt.setString(6, Usuario.getPassword());
            pstmt.setString(7, "admin"/*Usuario.getTipoCuenta()*/);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<UsuariosDTO> consultarUsuarios(String condicion,int valor) {
        ArrayList<UsuariosDTO> datos = null;
        int x=0;
        String sql = "SELECT *"
                + " FROM Usuarios WHERE "+condicion+"=?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, valor);
            ResultSet rs = pstmt.executeQuery();
            UsuariosDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new UsuariosDTO();
                result.setID(rs.getInt("ID"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setEmail(rs.getString("Email"));
                result.setPassword(rs.getString("Password"));
                result.setTipoCuenta(rs.getString("TipoCuenta"));
                result.setTotalFilasAfectadas(x);
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public ArrayList<UsuariosDTO> consultarUsuarios() {
        ArrayList<UsuariosDTO> datos = null;
        int x=0;
        String sql = "SELECT *"
                + " FROM Usuarios ";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            UsuariosDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new UsuariosDTO();
                result.setID(rs.getInt("ID"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setEmail(rs.getString("Email"));
                result.setPassword(rs.getString("Password"));
                result.setTipoCuenta(rs.getString("TipoCuenta"));
                result.setTotalFilasAfectadas(x);
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public void ActualizarUsuarios(int valor,UsuariosDTO user) {
        String sql = "UPDATE Usuarios SET Nombre=?,Apellido=?,Cedula=?,"
                + "ID=?,Email=?,Password=?"
                + "WHERE ID= ?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);  
            pstmt.setString(1, user.getNombre());
            pstmt.setString(2, user.getApellido());
            pstmt.setInt(3, user.getCedula());
            pstmt.setInt(4, user.getID());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getPassword());
            pstmt.setInt(7, valor);
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
