/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.database;

/**
 *
 * @author Luis mora
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {

    public static Connection conexion = null;

    static String sql;
    static String sql1;
    static String sql2;
    static String sql3;
    static String sql4;
    static String sql5;
    static String sql6;
    static String sql7;
    static String sql8;
    static String sql9;
    static String sql10;
    static String sql11;
    static String sql12;
    static String sql13;
    static String sql14;
    static String sql15;
    static String sql16;
    static String sql17;
    static String sql18;
    static String sql19;

    public static Connection getConexion() {
        try {
            if (conexion == null) {

                // con esto determinamos cuando finalize el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                Properties p = new Properties();
                p.load(new FileReader("medical-system/src/main/resources/conexion.properties"));
                String driver = p.getProperty("driver");
                String url = p.getProperty("url");
                String usr = p.getProperty("usr");
                String pwd = p.getProperty("pwd");
                //String urlDB = "jdbc:sqlite:bdMedica.db";
                //String urlDB = "jdbc:postgresql://localhost:5432/prueba";
                //JOptionPane.showMessageDialog(null, url);

                Class.forName(driver);
                conexion = DriverManager.getConnection(url, usr, pwd);
                System.out.println("Conexion Exitosa");
            }
            return conexion;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }

    public static Connection getConexion(String driver, String url, String usr, String pwd) {
        try {
            if (conexion == null) {
                Class.forName(driver);
                conexion = DriverManager.getConnection(url, usr, pwd);
                System.out.println("Conexion Exitosa");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error al crear la conexion");
        }
        return conexion;
    }

    static class MiShDwnHook extends Thread {

        // justo antes de finalizar el programa la JVM invocara
        // a este metodo donde podemos cerrar la conexion
        @Override
        public void run() {
            try {
                //Connection conexion = BaseDeDatos.getConexion();
                conexion.close();
                System.out.println("conexion cerrada");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void crearTablas() {
        sql = "CREATE TABLE IF NOT EXISTS Usuarios (\n"
                + "	ID Integer PRIMARY KEY NOT NULL,\n"
                + "	Nombre TEXT NOT NULL,\n"
                + "	Apellido TEXT NOT NULL,\n"
                + "	Cedula INTEGER NOT NULL,\n"
                + "	Email TEXT NOT NULL,\n"
                + "	Password TEXT NOT NULL,\n"
                + "	TipoCuenta TEXT NOT NULL"
                + ");";

        sql1 = "CREATE TABLE IF NOT EXISTS ActividadesMedicas(\n"
                + "	ID Integer PRIMARY KEY NOT NULL,\n"
                + "	Actividad text NOT NULL,\n"
                + "	Semana1  Integer NOT NULL,\n"
                + "	Semana2  INTEGER NOT NULL,\n"
                + "	Semana3  INTEGER NOT NULL,\n"
                + "	Semana4  INTEGER NOT NULL,\n"
                + "     Total INTEGER NOT NULL,\n"
                + "	Tipo  text NOT NULL, \n"
                + "     Porcentaje text NOT NULL"
                + ");";

        sql2 = "CREATE VIEW IF NOT EXISTS ConcultaCurativa AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Consulta Curativa Activos\' or tipo=\'Consulta Curativa Especial Activos\'"
                + " or tipo=\'Consulta Curativa Ministerio\' or tipo=\'Consulta Curativa Especial Ministerio\'"
                + " or tipo=\'Consulta Curativa Especial\' or tipo=\'Resultado de Evaluacion\'";

        sql3 = "CREATE VIEW IF NOT EXISTS ConcultaPreventiva AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Consulta Preventiva\'or tipo=\'Consulta Preventiva Especial\'";

        sql4 = "CREATE VIEW IF NOT EXISTS RepososEstudiosReferencias AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Reposos\' or tipo=\'Estudios\'or tipo=\'Estudios Especiales\'"
                + " or tipo=\'Referencias\'";
        sql5 = "CREATE VIEW IF NOT EXISTS PromocionDeLaSaludYOtras AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Actividades de Promocion de la salud\' or tipo=\'Actividades Ocupacionales\'";

        sql6 = "CREATE VIEW IF NOT EXISTS PsicologiaPsicoterapia AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Psicologia\'";

        sql7 = "CREATE VIEW IF NOT EXISTS Enfermeria AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Enfermeria\'";

        sql8 = "CREATE VIEW IF NOT EXISTS Fisioterapia AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Fisioterapia\'";

        sql9 = "CREATE VIEW IF NOT EXISTS Odontologia AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Odontologia Activos\' or tipo=\'Odontologia Ministerio\'";

        sql10 = "CREATE VIEW IF NOT EXISTS NutricionYDietetica AS \n"
                + "SELECT *\n"
                + "FROM ActividadesMedicas\n"
                + "where tipo= \'Nutricion\'";

        sql11 = "CREATE TABLE IF NOT EXISTS Enfermedades(\n"
                + "	ID Integer PRIMARY KEY NOT NULL,\n"
                + "	Nombre text NOT NULL,\n"
                + "     Tipo text NOT NULL,\n"
                + "	HombresMenoresDe25Años  Integer NOT NULL,\n"
                + "	MujeresMenoresDe25Años  Integer NOT NULL,\n"
                + "	Hombres25a44Años  INTEGER NOT NULL,\n"
                + "	Mujeres25a44Años  INTEGER NOT NULL,\n"
                + "	Hombres45a59Años  INTEGER NOT NULL,\n"
                + "	Mujeres45a59Años  INTEGER NOT NULL,\n"
                + "	Hombres60a64Años  INTEGER NOT NULL,\n"
                + "	Mujeres60a64Años  INTEGER NOT NULL,\n"
                + "	Hombres65AñosYMas  INTEGER NOT NULL,\n"
                + "	Mujeres65AñosYMas  INTEGER NOT NULL,\n"
                + "     TotalHombres INTEGER NOT NULL,\n"
                + "     TotalMujeres INTEGER NOT NULL,\n"
                + "	TotalGeneral  text NOT NULL"
                + ");";

        sql12 = "CREATE VIEW IF NOT EXISTS EnfermedadesInfecciosasYParasitarias AS \n"
                + "SELECT *\n"
                + "FROM Enfermedades\n"
                + "where tipo= \'EnfermedadesInfecciosasYParasitarias\'";

        sql13 = "CREATE VIEW IF NOT EXISTS Neoplasias AS \n"
                + "SELECT *\n"
                + "FROM Enfermedades\n"
                + "where tipo= \'Neoplasias\'";

        sql14 = "CREATE TABLE IF NOT EXISTS Pacientes (\n"
                + "	ID_Paciente Integer PRIMARY KEY NOT NULL,\n"
                + "	Nombre TEXT NOT NULL,\n"
                + "	Apellido TEXT NOT NULL,\n"
                + "	Cedula Integer NOT NULL,\n"
                + "	FechaDeNacimiento TEXT NOT NULL,\n"
                + "	Edad integer  NOT NULL,\n"
                + "	Genero TEXT NOT NULL,\n"
                + "	Tipo TEXT NOT NULL,\n"
                + "	TipoDeSangre TEXT NOT NULL,\n" 
                + "	Peso INTEGER NOT NULL,\n"
                + "	EstadoCivil TEXT NOT NULL"
                + ");";
        sql15 = "CREATE TABLE IF NOT EXISTS DatosmedicosPaciente(\n"
                + "	ID Integer PRIMARY KEY NOT NULL,\n"
                + "	Nombre TEXT NOT NULL,\n"
                + "	Tipo TEXT NOT NULL,\n"
                + "     ID_Paciente Integer NOT NULL,\n"
                + "     foreign key(ID_Paciente) references Pacientes(ID_Paciente)on update cascade on delete cascade"
                + ");";
        
        sql16 = "CREATE TABLE IF NOT EXISTS FamiliaresPaciente (\n"
                + "	ID Integer PRIMARY KEY NOT NULL,\n"
                + "	Nombre TEXT NOT NULL,\n"
                + "	Apellido TEXT NOT NULL,\n"
                + "	Cedula Integer NOT NULL,\n"
                + "	FechaDeNacimiento TEXT NOT NULL,\n"
                + "	Edad Integer NOT NULL,\n"
                + "	Genero TEXT NOT NULL,\n"
                + "	Parentesco TEXT NOT NULL,\n"
                + "     ID_Paciente Integer NOT NULL,\n"
                + "     foreign key(ID_Paciente) references Pacientes(ID_Paciente)on update cascade on delete cascade"
                + ");";
        sql17 = "PRAGMA foreign_keys = ON;";
        
        sql18= "CREATE TABLE IF NOT EXISTS Citas (\n"
                + "     ID INTEGER PRIMARY KEY NOT NULL,\n"
                + "     Nombre TEXT NOT NULL\n,"
                + "     Fecha TEXT NOT NULL,\n"
                + "     Avisos Integer NOT NULL"
                + ");";
        sql19= "CREATE TABLE IF NOT EXISTS  Historial (\n"
                + "     ID INTEGER PRIMARY KEY NOT NULL,\n"
                + "     TipoConsulta TEXT NOT NULL\n,"
                + "     MotivoConsulta TEXT NOT NULL\n,"
                + "     Diagnostico TEXT NOT NULL\n,"
                + "     Accion TEXT NOT NULL\n,"
                + "     Resultado TEXT NOT NULL\n,"
                + "     Hora TEXT NOT NULL\n,"
                + "     Fecha TEXT NOT NULL,\n"
                + "     ID_Paciente Integer NOT NULL,\n"
                + "     foreign key(ID_Paciente) references Pacientes(ID_Paciente)on update cascade on delete cascade"
                + ");";
        sql1 = tratarSQL(sql1);
        sql2 = tratarSQL(sql2);
        sql3 = tratarSQL(sql3);
        sql4 = tratarSQL(sql4);
        sql5 = tratarSQL(sql5);
        sql6 = tratarSQL(sql6);
        sql7 = tratarSQL(sql7);
        sql8 = tratarSQL(sql8);
        sql9 = tratarSQL(sql9);
        sql10 = tratarSQL(sql10);
        sql11 = tratarSQL(sql11);
        sql12 = tratarSQL(sql12);
        sql13 = tratarSQL(sql13);
        sql14 = tratarSQL(sql14);
        sql15 = tratarSQL(sql15);
        sql16 = tratarSQL(sql16);
        sql18 = tratarSQL(sql18);
        sql19 = tratarSQL(sql19);

        try {
            Connection conn = BaseDeDatos.getConexion();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
            stmt.execute(sql5);
            stmt.execute(sql6);
            stmt.execute(sql7);
            stmt.execute(sql8);
            stmt.execute(sql9);
            stmt.execute(sql10);
            stmt.execute(sql11);
            stmt.execute(sql12);
            stmt.execute(sql13);
            stmt.execute(sql14);
            stmt.execute(sql15);
            stmt.execute(sql16);
            stmt.execute(sql18);
            stmt.execute(sql19);
            Properties p = new Properties();
            p.load(new FileReader("medical-system/src/main/resources/config.properties"));
            if (p.getProperty("sqlite-jdbc-3.27.2.1.jar").equals("true")) {
                stmt.execute(sql17);
            }
            System.out.println("las tablas fueron creadas");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String tratarSQL(String sql) {
        Properties p = new Properties();
        try {
            p.load(new FileReader("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\sistema medico\\src\\config.properties"));
            if (p.getProperty("postgresql-9.4.1209.jar").equals("true")) {
                if (sql.contains("VIEW")) {
                    sql = sql.replace("IF NOT EXISTS", "");
                    sql = sql.replace("CREATE", "CREATE OR REPLACE");
                }

                if (sql.contains("PRIMARY KEY")) {
                    sql = sql.replace("Integer", "serial");
                }
            }
        } catch (IOException ex) {

        }
        return sql;
    }

    public static void eliminarTablas() {
        Properties p = new Properties();
        try {
            p.load(new FileReader("/home/luis/mvn/demo/src/main/resources/config.properties"));
            String borrar = "DROP TABLE IF EXISTS Pacientes";
            String borrar1 = "DROP TABLE IF EXISTS ActividadesMedicas";
            String borrar2 = "DROP TABLE IF EXISTS Enfermedades";
            String borrar3 = "DROP TABLE IF EXISTS FamiliaresPaciente";
            String borrar4 = "DROP TABLE IF EXISTS Citas";
            String borrar5 = "DROP TABLE IF EXISTS Historial";
            if (p.getProperty("postgresql-9.4.1209.jar").equals("true")) {
                borrar = borrar.concat(" cascade");
                borrar1 = borrar1.concat(" cascade");
                borrar2= borrar2.concat(" cascade");
                borrar3= borrar3.concat(" cascade");
                borrar4= borrar4.concat(" cascade");
                borrar5= borrar5.concat(" cascade");
            }
            System.out.println("paseeee" + borrar3);
            Connection conn = BaseDeDatos.getConexion();
            Statement stmt = conn.createStatement();
            stmt.execute(borrar);
            stmt.execute(borrar1);
            stmt.execute(borrar2);
            stmt.execute(borrar3);
            stmt.execute(borrar4);
            stmt.execute(borrar5);
        } catch (SQLException ex)  {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
