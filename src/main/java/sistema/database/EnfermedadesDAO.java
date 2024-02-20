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
public class EnfermedadesDAO {

    public void insertarEnfermedades(String param1, String param2) {
        String sql = "INSERT INTO Enfermedades (Nombre,Tipo,"
                + "HombresMenoresDe25Años,MujeresMenoresDe25Años,"
                + "Hombres25a44Años,Mujeres25a44Años,Hombres45a59Años,"
                + "Mujeres45a59Años,Hombres60a64Años,Mujeres60a64Años,"
                + "Hombres65AñosYMas,Mujeres65AñosYMas,"
                + "TotalHombres,TotalMujeres,TotalGeneral) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, param2);
            pstmt.setString(2, param1);
            pstmt.setInt(3, 0);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.setInt(6, 0);
            pstmt.setInt(7, 0);
            pstmt.setInt(8, 0);
            pstmt.setInt(9, 0);
            pstmt.setInt(10, 0);
            pstmt.setInt(11, 0);
            pstmt.setInt(12, 0);
            pstmt.setInt(13, 0);
            pstmt.setInt(14, 0);
            pstmt.setInt(15, 0);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertarEnfermedades( EnfermedadesDTO enfermedad) {
        String sql = "INSERT INTO Enfermedades(Nombre, Tipo,"
                + "HombresMenoresDe25Años,MujeresMenoresDe25Años,"
                + "Hombres25a44Años,Mujeres25a44Años,Hombres45a59Años,"
                + "Mujeres45a59Años,Hombres60a64Años,Mujeres60a64Años,"
                + "Hombres65AñosYMas,Mujeres65AñosYMas,"
                + "TotalHombres,TotalMujeres,TotalGeneral) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, enfermedad.getNombre());
            pstmt.setString(2, enfermedad.getTipo());
            pstmt.setInt(3, Integer.parseInt(enfermedad.getHombresMenoresDe25Años()));
            pstmt.setInt(4, Integer.parseInt(enfermedad.getMujeresMenoresDe25Años()));
            pstmt.setInt(5, Integer.parseInt(enfermedad.getHombres25a44Años()));
            pstmt.setInt(6, Integer.parseInt(enfermedad.getMujeres25a44Años()));
            pstmt.setInt(7, Integer.parseInt(enfermedad.getHombres45a59Años()));
            pstmt.setInt(8, Integer.parseInt(enfermedad.getMujeres45a59Años()));
            pstmt.setInt(9, Integer.parseInt(enfermedad.getHombres60a64Años()));
            pstmt.setInt(10, Integer.parseInt(enfermedad.getMujeres60a64Años()));
            pstmt.setInt(11,Integer.parseInt(enfermedad.getHombres65AñosYMas()));
            pstmt.setInt(12,Integer.parseInt(enfermedad.getMujeres65AñosYMas()));
            pstmt.setInt(13,Integer.parseInt(enfermedad.getTotalHombres()));
            pstmt.setInt(14,Integer.parseInt(enfermedad.getTotalMujeres()));
            pstmt.setInt(15,Integer.parseInt(enfermedad.getTotalGeneral()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<EnfermedadesDTO> consultarEnfermedad(String table) {
        ArrayList<EnfermedadesDTO> datos = null;
        String sql = "SELECT *"
                + " FROM " + table;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            EnfermedadesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new EnfermedadesDTO();
                result.setID(Integer.toString(rs.getInt("ID")));
                result.setNombre(rs.getString("Nombre"));
                result.setTipo(rs.getString("Tipo"));
                result.setHombresMenoresDe25Años(Integer.toString(rs.getInt("HombresMenoresDe25Años")));
                result.setMujeresMenoresDe25Años(Integer.toString(rs.getInt("MujeresMenoresDe25Años")));
                result.setHombres25a44Años(Integer.toString(rs.getInt("Hombres25a44Años")));
                result.setMujeres25a44Años(Integer.toString(rs.getInt("Mujeres25a44Años")));
                result.setHombres45a59Años(Integer.toString(rs.getInt("Hombres45a59Años")));
                result.setMujeres45a59Años(Integer.toString(rs.getInt("Mujeres45a59Años")));
                result.setHombres60a64Años(Integer.toString(rs.getInt("Hombres60a64Años")));
                result.setMujeres60a64Años(Integer.toString(rs.getInt("Mujeres60a64Años")));
                result.setHombres65AñosYMas(Integer.toString(rs.getInt("Hombres65AñosYMas")));
                result.setMujeres65AñosYMas(Integer.toString(rs.getInt("Mujeres65AñosYMas")));
                result.setTotalHombres(Integer.toString(rs.getInt("TotalHombres")));
                result.setTotalMujeres(Integer.toString(rs.getInt("TotalMujeres")));
                result.setTotalGeneral(Integer.toString(rs.getInt("TotalGeneral")));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<EnfermedadesDTO> consultarEnfermedadesPorLetra(String table, String letra) {
        ArrayList<EnfermedadesDTO> datos = null;
        String sql = "SELECT *"
                + " FROM " + table + " where Nombre like " + letra;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            EnfermedadesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new EnfermedadesDTO();
                result.setID(Integer.toString(rs.getInt("ID")));
                result.setNombre(rs.getString("Nombre"));
                result.setTipo(rs.getString("Tipo"));
                result.setHombresMenoresDe25Años(Integer.toString(rs.getInt("HombresMenoresDe25Años")));
                result.setMujeresMenoresDe25Años(Integer.toString(rs.getInt("MujeresMenoresDe25Años")));
                result.setHombres25a44Años(Integer.toString(rs.getInt("Hombres25a44Años")));
                result.setMujeres25a44Años(Integer.toString(rs.getInt("Mujeres25a44Años")));
                result.setHombres45a59Años(Integer.toString(rs.getInt("Hombres45a59Años")));
                result.setMujeres45a59Años(Integer.toString(rs.getInt("Mujeres45a59Años")));
                result.setHombres60a64Años(Integer.toString(rs.getInt("Hombres60a64Años")));
                result.setMujeres60a64Años(Integer.toString(rs.getInt("Mujeres60a64Años")));
                result.setHombres65AñosYMas(Integer.toString(rs.getInt("Hombres65AñosYMas")));
                result.setMujeres65AñosYMas(Integer.toString(rs.getInt("Mujeres65AñosYMas")));
                result.setTotalHombres(Integer.toString(rs.getInt("TotalHombres")));
                result.setTotalMujeres(Integer.toString(rs.getInt("TotalMujeres")));
                result.setTotalGeneral(Integer.toString(rs.getInt("TotalGeneral")));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    public ArrayList<EnfermedadesDTO> consultarPorEnfermedad(String table, String condicion) {
        ArrayList<EnfermedadesDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM " + table + " where Nombre=" + condicion;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            EnfermedadesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new EnfermedadesDTO();
                result.setID(Integer.toString(rs.getInt("ID")));
                result.setNombre(rs.getString("Nombre"));
                result.setTipo(rs.getString("Tipo"));
                result.setHombresMenoresDe25Años(Integer.toString(rs.getInt("HombresMenoresDe25Años")));
                result.setMujeresMenoresDe25Años(Integer.toString(rs.getInt("MujeresMenoresDe25Años")));
                result.setHombres25a44Años(Integer.toString(rs.getInt("Hombres25a44Años")));
                result.setMujeres25a44Años(Integer.toString(rs.getInt("Mujeres25a44Años")));
                result.setHombres45a59Años(Integer.toString(rs.getInt("Hombres45a59Años")));
                result.setMujeres45a59Años(Integer.toString(rs.getInt("Mujeres45a59Años")));
                result.setHombres60a64Años(Integer.toString(rs.getInt("Hombres60a64Años")));
                result.setMujeres60a64Años(Integer.toString(rs.getInt("Mujeres60a64Años")));
                result.setHombres65AñosYMas(Integer.toString(rs.getInt("Hombres65AñosYMas")));
                result.setMujeres65AñosYMas(Integer.toString(rs.getInt("Mujeres65AñosYMas")));
                result.setTotalHombres(Integer.toString(rs.getInt("TotalHombres")));
                result.setTotalMujeres(Integer.toString(rs.getInt("TotalMujeres")));
                result.setTotalGeneral(Integer.toString(rs.getInt("TotalGeneral")));
                result.setTotalFilasAfectadas(x);
                datos.add(result);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
     public void ActualizarEnfermedad(String nuevaEnfermedad,String enfermedad) {
         String sql = "UPDATE Enfermedades SET  Nombre=?"
                    + "WHERE Nombre=?";
            try {
                Connection Conexion = BaseDeDatos.getConexion();
                PreparedStatement pstmt = Conexion.prepareStatement(sql);
                pstmt.setString(1, nuevaEnfermedad);
                pstmt.setString(2,enfermedad.toUpperCase());
                pstmt.executeUpdate();                 
            } catch (NumberFormatException | SQLException e) {
                System.out.println(e.getMessage());
            }
    }
    public void ActualizarEnfermedades(String nombre,EnfermedadesDTO enferm) {
        String sql = "UPDATE Enfermedades SET  Nombre=?, Tipo=?,"
                + "HombresMenoresDe25Años=?,MujeresMenoresDe25Años=?,"
                + "Hombres25a44Años=?,Mujeres25a44Años=?,Hombres45a59Años=?,"
                + "Mujeres45a59Años=?,Hombres60a64Años=?,Mujeres60a64Años=?,"
                + "Hombres65AñosYMas=?,Mujeres65AñosYMas=?,"
                + "TotalHombres=?,TotalMujeres=?,TotalGeneral=?"
                + "WHERE Nombre=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            
            pstmt.setString(1, enferm.getNombre());
            pstmt.setString(2, enferm.getTipo());
            pstmt.setString(3, enferm.getHombresMenoresDe25Años());
            pstmt.setString(4, enferm.getMujeresMenoresDe25Años());
            pstmt.setString(5, enferm.getHombres25a44Años());
            pstmt.setString(6, enferm.getMujeres25a44Años());
            pstmt.setString(7, enferm.getHombres45a59Años());
            pstmt.setString(8, enferm.getMujeres45a59Años());
            pstmt.setString(9, enferm.getHombres60a64Años());
            pstmt.setString(10, enferm.getMujeres60a64Años());
            pstmt.setString(11, enferm.getHombres65AñosYMas());
            pstmt.setString(12, enferm.getMujeres65AñosYMas());
            pstmt.setString(13, enferm.getTotalHombres());
            pstmt.setString(14, enferm.getTotalMujeres());
            pstmt.setString(15, enferm.getTotalGeneral());
            pstmt.setString(16, nombre);
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void ActualizarEnfermedades(EnfermedadesDTO enferm) {
        String sql = "UPDATE Enfermedades SET "
                + "HombresMenoresDe25Años=?,MujeresMenoresDe25Años=?,"
                + "Hombres25a44Años=?,Mujeres25a44Años=?,Hombres45a59Años=?,"
                + "Mujeres45a59Años=?,Hombres60a64Años=?,Mujeres60a64Años=?,"
                + "Hombres65AñosYMas=?,Mujeres65AñosYMas=?,"
                + "TotalHombres=?,TotalMujeres=?,TotalGeneral=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            
            pstmt.setString(1, enferm.getHombresMenoresDe25Años());
            pstmt.setString(2, enferm.getMujeresMenoresDe25Años());
            pstmt.setString(3, enferm.getHombres25a44Años());
            pstmt.setString(4, enferm.getMujeres25a44Años());
            pstmt.setString(5, enferm.getHombres45a59Años());
            pstmt.setString(6, enferm.getMujeres45a59Años());
            pstmt.setString(7, enferm.getHombres60a64Años());
            pstmt.setString(8, enferm.getMujeres60a64Años());
            pstmt.setString(9, enferm.getHombres65AñosYMas());
            pstmt.setString(10, enferm.getMujeres65AñosYMas());
            pstmt.setString(11, enferm.getTotalHombres());
            pstmt.setString(12, enferm.getTotalMujeres());
            pstmt.setString(13, enferm.getTotalGeneral());
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public void eliminarEnfermedad(String nombre) {
          String sql = "DELETE FROM Enfermedades"
                    + " WHERE Nombre=?";
            try {
                Connection Conexion = BaseDeDatos.getConexion();
                PreparedStatement pstmt = Conexion.prepareStatement(sql);
                pstmt.setString(1, nombre);
                pstmt.executeUpdate(); 
            } catch (NumberFormatException | SQLException e) {
                System.out.println(e.getMessage());
            }
    }
}
