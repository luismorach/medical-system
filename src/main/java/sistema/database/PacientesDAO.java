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
public class PacientesDAO {

    public void AñadirPaciente(PacientesDTO dto) {
        String sql = "INSERT INTO Pacientes (ID_Paciente,Nombre,Apellido,Cedula,"
                + "FechaDeNacimiento,Edad,Genero,Tipo,Peso,TipoDeSangre,"
                + "EstadoCivil) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setInt(1, dto.getID_Paciente());
            pstmt.setString(2, dto.getNombre());
            pstmt.setString(3, dto.getApellido());
            pstmt.setInt(4, dto.getCedula());
            pstmt.setString(5, dto.getFechaDeNacimiento());
            pstmt.setInt(6, dto.getEdad());
            pstmt.setString(7, dto.getGenero());
            pstmt.setString(8, dto.getTipo());
            pstmt.setInt(9, dto.getPeso());
            pstmt.setString(10, dto.getTipoDeSangre());
            pstmt.setString(11, dto.getEstadoCivil());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<PacientesDTO> consultarPacientes() {
        ArrayList<PacientesDTO> datos = null;
        String sql = "SELECT *"
                + " FROM Pacientes";
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            PacientesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new PacientesDTO();
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                result.setEdad(rs.getInt("Edad"));
                result.setGenero(rs.getString("Genero"));
                result.setTipo(rs.getString("Tipo"));
                result.setPeso(rs.getInt("Peso"));
                result.setTipoDeSangre(rs.getString("TipoDeSangre"));
                result.setEstadoCivil(rs.getString("EstadoCivil"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public ArrayList<PacientesDTO> consultarPacientesEspecificos(String condicion, int valor) {
        ArrayList<PacientesDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM Pacientes where " + condicion + "=" + valor;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            PacientesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new PacientesDTO();
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                result.setEdad(rs.getInt("Edad"));
                result.setGenero(rs.getString("Genero"));
                result.setTipo(rs.getString("Tipo"));
                result.setPeso(rs.getInt("Peso"));
                result.setTipoDeSangre(rs.getString("TipoDeSangre"));
                result.setEstadoCivil(rs.getString("EstadoCivil"));
                result.setFilasAfectadas(x);
                datos.add(result);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    

    public ArrayList<PacientesDTO> consultarPacientesEspecificos(String condicion, String valor) {
        ArrayList<PacientesDTO> datos = null;
        int x = 0;
        String sql = "SELECT *"
                + " FROM Pacientes where " + condicion + "= ?" ;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, valor);
            ResultSet rs = pstmt.executeQuery();
            PacientesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                x++;
                result = new PacientesDTO();
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                result.setEdad(rs.getInt("Edad"));
                result.setGenero(rs.getString("Genero"));
                result.setTipo(rs.getString("Tipo"));
                result.setPeso(rs.getInt("Peso"));
                result.setTipoDeSangre(rs.getString("TipoDeSangre"));
                result.setEstadoCivil(rs.getString("EstadoCivil"));
                result.setFilasAfectadas(x);
                datos.add(result);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    public ArrayList<PacientesDTO> consultarPacientePorLetra(String letra) {
        ArrayList<PacientesDTO> datos = null;
        String sql = "SELECT *"
                + " FROM Pacientes where Nombre like " + letra;
        try {
            Connection conn = BaseDeDatos.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            PacientesDTO result;
            datos = new ArrayList<>();
            while (rs.next()) {
                result = new PacientesDTO();
                result.setID_Paciente(rs.getInt("ID_Paciente"));
                result.setNombre(rs.getString("Nombre"));
                result.setApellido(rs.getString("Apellido"));
                result.setCedula(rs.getInt("Cedula"));
                result.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                result.setEdad(rs.getInt("Edad"));
                result.setGenero(rs.getString("Genero"));
                result.setTipo(rs.getString("Tipo"));
                result.setPeso(rs.getInt("Peso"));
                result.setTipoDeSangre(rs.getString("TipoDeSangre"));
                result.setEstadoCivil(rs.getString("EstadoCivil"));
                datos.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    public void ActualizarPacientes(String condicion, int valor,PacientesDTO paciente) {
        String sql = "UPDATE Pacientes SET ID_Paciente=?,Nombre=?, Apellido=?,Cedula=?,"
                + "FechaDeNacimiento=?,Edad=?,Genero=?,Tipo=?,Peso=?,TipoDeSangre=?,EstadoCivil=?"
                + " WHERE " + condicion + "=" + valor;
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.setInt(1, paciente.getID_Paciente());
            pstmt.setString(2, paciente.getNombre());
            pstmt.setString(3, paciente.getApellido());
            pstmt.setInt(4, paciente.getCedula());
            pstmt.setString(5, paciente.getFechaDeNacimiento());
            pstmt.setInt(6, paciente.getEdad());
            pstmt.setString(7, paciente.getGenero());
            pstmt.setString(8, paciente.getTipo());
             pstmt.setInt(9, paciente.getPeso());
            pstmt.setString(10, paciente.getTipoDeSangre());
            pstmt.setString(11, paciente.getEstadoCivil());
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ActualizarPacientesPorCondicion(String condicion, int valor, int nuevo) {
        String sql = "UPDATE Pacientes SET ID_Paciente=?"
                + " WHERE " + condicion + "=" + valor;
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            System.out.println(sql);
            pstmt.setInt(1, nuevo);
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void EliminarPacientes(String condicion, int valor) {
        String sql = "DELETE FROM Pacientes"
                + " WHERE " + condicion + "=" + valor;
        try {
            Connection Conexion = BaseDeDatos.getConexion();
            PreparedStatement pstmt = Conexion.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
