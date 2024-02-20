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
public class ActividadesMedicasDAO {

    public void insertarActividad(String param2, String param3) {
        String sql = "INSERT INTO ActividadesMedicas (Actividad,Semana1,Semana2,"
                + "Semana3,Semana4,Total,Tipo,Porcentaje) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, param2);
            pstmt.setInt(2, 0);
            pstmt.setInt(3, 0);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.setInt(6, 0);
            pstmt.setString(7, param3);
            pstmt.setString(8, "0%");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarActividad(ActividadesMedicasDTO actividad) {
        String sql = "INSERT INTO ActividadesMedicas (Actividad,Semana1,Semana2,"
                + "Semana3,Semana4,Total,Tipo,Porcentaje) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, actividad.getActividad());
            pstmt.setInt(2, Integer.parseInt(actividad.getSemana1()));
            pstmt.setInt(3, Integer.parseInt(actividad.getSemana2()));
            pstmt.setInt(4, Integer.parseInt(actividad.getSemana3()));
            pstmt.setInt(5, Integer.parseInt(actividad.getSemana4()));
            pstmt.setInt(6, Integer.parseInt(actividad.getTotal()));
            pstmt.setString(7, actividad.getTipo());
            pstmt.setString(8, actividad.getPorcentaje());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ActividadesMedicasDTO> consultarActividadMedica(String table) {
        ArrayList<ActividadesMedicasDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM " + table;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ActividadesMedicasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new ActividadesMedicasDTO();
                result.setID(rs.getInt("ID"));
                result.setActividad(rs.getString("Actividad"));
                result.setSemana1(Integer.toString(rs.getInt("Semana1")));
                result.setSemana2(Integer.toString(rs.getInt("Semana2")));
                result.setSemana3(Integer.toString(rs.getInt("Semana3")));
                result.setSemana4(Integer.toString(rs.getInt("Semana4")));
                result.setTotal(Integer.toString(rs.getInt("Total")));
                result.setTipo(rs.getString("Tipo"));
                result.setPorcentaje(rs.getString("Porcentaje"));
                result.setFilasAfectadas(x);
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<ActividadesMedicasDTO> consultarSoloActividadMedica(String table, String condicion) {
        ArrayList<ActividadesMedicasDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM "+ table+" where Tipo= ?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,condicion );
            ResultSet rs = pstmt.executeQuery();
            ActividadesMedicasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new ActividadesMedicasDTO();
                result.setID(rs.getInt("ID"));
                result.setActividad(rs.getString("Actividad"));
                result.setSemana1(Integer.toString(rs.getInt("Semana1")));
                result.setSemana2(Integer.toString(rs.getInt("Semana2")));
                result.setSemana3(Integer.toString(rs.getInt("Semana3")));
                result.setSemana4(Integer.toString(rs.getInt("Semana4")));
                result.setTotal(Integer.toString(rs.getInt("Total")));
                result.setTipo(rs.getString("Tipo"));
                result.setPorcentaje(rs.getString("Porcentaje"));
                result.setFilasAfectadas(x);
                datos.add(result);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<ActividadesMedicasDTO> consultarPorActividadMedica(String table, String condicion, String tipo) {
        ArrayList<ActividadesMedicasDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM " + table + " where Actividad= ? and Tipo= ?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, condicion);
            pstmt.setString(2, tipo);
            ResultSet rs = pstmt.executeQuery();
            ActividadesMedicasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new ActividadesMedicasDTO();
                x++;
                result.setID(rs.getInt("ID"));
                result.setActividad(rs.getString("Actividad"));
                result.setSemana1(Integer.toString(rs.getInt("Semana1")));
                result.setSemana2(Integer.toString(rs.getInt("Semana2")));
                result.setSemana3(Integer.toString(rs.getInt("Semana3")));
                result.setSemana4(Integer.toString(rs.getInt("Semana4")));
                result.setTotal(Integer.toString(rs.getInt("Total")));
                result.setTipo(rs.getString("Tipo"));
                result.setPorcentaje(rs.getString("Porcentaje"));
                result.setFilasAfectadas(x);
                datos.add(result);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<ActividadesMedicasDTO> consultarPorActividadMedica(String table, String condicion) {
        ArrayList<ActividadesMedicasDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM " + table + " where Actividad= ?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, condicion);
            ResultSet rs = pstmt.executeQuery();
            ActividadesMedicasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new ActividadesMedicasDTO();
                x++;
                result.setID(rs.getInt("ID"));
                result.setActividad(rs.getString("Actividad"));
                result.setSemana1(Integer.toString(rs.getInt("Semana1")));
                result.setSemana2(Integer.toString(rs.getInt("Semana2")));
                result.setSemana3(Integer.toString(rs.getInt("Semana3")));
                result.setSemana4(Integer.toString(rs.getInt("Semana4")));
                result.setTotal(Integer.toString(rs.getInt("Total")));
                result.setTipo(rs.getString("Tipo"));
                result.setPorcentaje(rs.getString("Porcentaje"));
                result.setFilasAfectadas(x);
                datos.add(result);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<ActividadesMedicasDTO> consultarActividadMedicaPorLetra(String table, String letra, String tipo) {
        ArrayList<ActividadesMedicasDTO> datos = null;
        String sql = "SELECT *"
                + " FROM " + table + " where Actividad like " + letra + " and Tipo= ?";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();
            ActividadesMedicasDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new ActividadesMedicasDTO();
                result.setID(rs.getInt("ID"));
                result.setActividad(rs.getString("Actividad"));
                result.setSemana1(Integer.toString(rs.getInt("Semana1")));
                result.setSemana2(Integer.toString(rs.getInt("Semana2")));
                result.setSemana3(Integer.toString(rs.getInt("Semana3")));
                result.setSemana4(Integer.toString(rs.getInt("Semana4")));
                result.setTotal(Integer.toString(rs.getInt("Total")));
                result.setTipo(rs.getString("Tipo"));
                result.setPorcentaje(rs.getString("Porcentaje"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public void ActualizarActividadMedica(String nuevaActividad, String Actividad) {
        String sql = "UPDATE ActividadesMedicas SET  Actividad=?"
                + "WHERE Actividad=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, nuevaActividad);
            pstmt.setString(2, Actividad.toUpperCase());
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ActualizarActividadMedica(String Actividad,String tipo,ActividadesMedicasDTO actv) {
        String sql = "UPDATE ActividadesMedicas SET  Actividad=?," 
                + "Semana1=?, Semana2=?, Semana3=?,Semana4=?,Total=?, Tipo=?,Porcentaje=?"
                + "WHERE Actividad=? AND Tipo=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            
            pstmt.setString(1, actv.getActividad());
            pstmt.setInt(2, Integer.parseInt(actv.getSemana1()));
            pstmt.setInt(3, Integer.parseInt(actv.getSemana2()));
            pstmt.setInt(4, Integer.parseInt(actv.getSemana3()));
            pstmt.setInt(5, Integer.parseInt(actv.getSemana4()));
            pstmt.setInt(6, Integer.parseInt(actv.getTotal()));
            pstmt.setString(7, actv.getTipo());
            pstmt.setString(8, actv.getPorcentaje());
            pstmt.setString(9, Actividad);
            pstmt.setString(10, tipo);
            System.out.println("Actuaice");
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ActualizarActividadMedica(ActividadesMedicasDTO actv) {
        String sql = "UPDATE ActividadesMedicas SET " 
                + "Semana1=?, Semana2=?, Semana3=?,Semana4=?,Total=?,Porcentaje=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            
            pstmt.setInt(1, Integer.parseInt(actv.getSemana1()));
            pstmt.setInt(2, Integer.parseInt(actv.getSemana2()));
            pstmt.setInt(3, Integer.parseInt(actv.getSemana3()));
            pstmt.setInt(4, Integer.parseInt(actv.getSemana4()));
            pstmt.setInt(5, Integer.parseInt(actv.getTotal()));
            pstmt.setString(6, actv.getPorcentaje());
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void EliminarActividadMedica(String Actividad) {
        String sql = "DELETE FROM ActividadesMedicas"
                + " WHERE Actividad=?";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setString(1, Actividad);
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
