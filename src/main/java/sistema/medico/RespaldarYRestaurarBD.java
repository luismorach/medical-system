/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import sistema.database.ActividadesMedicasDTO;
import sistema.database.BaseDeDatos;
import sistema.database.CitasDTO;
import sistema.database.DatosMedicosPacienteDTO;
import sistema.database.EnfermedadesDTO;
import sistema.database.FamiliaresDTO;
import sistema.database.HistorialDTO;
import sistema.database.PacientesDTO;
import sistema.database.UsuariosDTO;

/**
 *
 * @author Administrador
 */
public class RespaldarYRestaurarBD implements Runnable {

    static ArrayList<Object> data = new ArrayList<>();
    static int accion;
    static String ruta;
    static boolean wait;
    static ArrayList<Thread> hilos;

    public static boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                OutputStream out;
                try (InputStream in = new FileInputStream(origin)) {
                    out = new FileOutputStream(destination);
                    // We use a buffer for the copy (Usamos un buffer para la copia).
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                }
                out.close();
                return true;
            } catch (IOException ioe) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void setHilos(Thread hilo) {
        hilos = new ArrayList<>();

    }

    public static Thread crearRespaldo(String ruta, boolean wait) {
        if (!data.isEmpty()) {
            data.removeAll(data);
        }
        RespaldarYRestaurarBD.wait = wait;
        RespaldarYRestaurarBD obj = new RespaldarYRestaurarBD();
        accion = 0;
        RespaldarYRestaurarBD.ruta = ruta;
        Thread hilo = new Thread(obj);
        hilo.start();
        return hilo;
    }

    @Override
    public void run() {
        if (accion == 0) {
            int progres = 0;
            int total;
            BufferedOutputStream bos;
            ObjectOutputStream out;

            try {
                bos = new BufferedOutputStream(new FileOutputStream(ruta));
                out = new ObjectOutputStream(bos);
                BaseDeDatos.crearTablas();
                ArrayList<PacientesDTO> coll = Facade.ConsultarPacientes();
                ArrayList<FamiliaresDTO> coll1 = Facade.ConsultarFamiliares();
                ArrayList<ActividadesMedicasDTO> coll2 = Facade.consultarActividadesMedicas();
                ArrayList<EnfermedadesDTO> coll3 = Facade.consultarEnfermedades();
                ArrayList<UsuariosDTO> coll4 = Facade.ConsultarUsuario();
                ArrayList<HistorialDTO> coll5 = Facade.ConsultarHistorial();
                ArrayList<DatosMedicosPacienteDTO> coll6 = Facade.ConsultarDatosMedicos();
                ArrayList<CitasDTO> coll7 = Facade.ConsultarCitas();
                total = (coll.size() + coll1.size() + coll2.size() + coll3.size() + coll4.size()
                        + coll5.size() + coll6.size() + coll7.size()) - 1;
                if (wait) {
                    Thread.sleep(1000);
                }
                for (int i = 0; i < coll.size(); i++) {
                    PacientesDTO p = coll.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }
                for (int i = 0; i < coll1.size(); i++) {
                    FamiliaresDTO p = coll1.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }
                for (int i = 0; i < coll2.size(); i++) {
                    ActividadesMedicasDTO p = coll2.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }
                for (int i = 0; i < coll3.size(); i++) {
                    EnfermedadesDTO p = coll3.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }

                for (int i = 0; i < coll4.size(); i++) {
                    UsuariosDTO p = coll4.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }

                for (int i = 0; i < coll5.size(); i++) {
                    HistorialDTO p = coll5.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }
                for (int i = 0; i < coll6.size(); i++) {
                    DatosMedicosPacienteDTO p = coll6.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }

                for (int i = 0; i < coll7.size(); i++) {
                    CitasDTO p = coll7.get(i);
                    data.add(p);
                    progres = data.size() - 1;
                    if (wait) {
                        Respaldo.progreso.setValue((int) ((((float) progres) / (total)) * 100));
                    }
                }
               
                out.writeObject(data);
                out.close();
                bos.close();
            } catch (IOException ex) {
                //System.out.println("errororo" + ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(RespaldarYRestaurarBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (accion == 1) {
            PacientesDTO pc;
            FamiliaresDTO f;
            ActividadesMedicasDTO act;
            EnfermedadesDTO enf;
            UsuariosDTO user;
            HistorialDTO hist;
            DatosMedicosPacienteDTO dat;
            CitasDTO citas;
             
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i) instanceof PacientesDTO) {
                    pc = (PacientesDTO) data.get(i);
                    Facade.AñadirPacientes(pc);
                }
                if (data.get(i) instanceof FamiliaresDTO) {
                    f = (FamiliaresDTO) data.get(i);
                    Facade.AñadirFamiliares(f);
                }
                if (data.get(i) instanceof ActividadesMedicasDTO) {
                    act = (ActividadesMedicasDTO) data.get(i);
                    Facade.insertarActividadesMedicas(act);
                }
                if (data.get(i) instanceof EnfermedadesDTO) {
                    enf = (EnfermedadesDTO) data.get(i);
                    Facade.insertarEnferemdades(enf);
                }
                if (data.get(i) instanceof UsuariosDTO) {
                    user = (UsuariosDTO) data.get(i);
                    Facade.AñadirUsuarios(user);
                }
                if (data.get(i) instanceof HistorialDTO) {
                    hist = (HistorialDTO) data.get(i);
                    Facade.AñadirHistorial(hist);
                }
                if (data.get(i) instanceof DatosMedicosPacienteDTO) {
                    dat = (DatosMedicosPacienteDTO) data.get(i);
                    Facade.AñadirDatosMedicosPaciente(dat);
                }
                if (data.get(i) instanceof CitasDTO) {
                    citas = (CitasDTO) data.get(i);
                    Facade.AñadirCitas(citas);
                }
               
                Respaldo.progreso.setValue((int) ((((float) i) / (data.size() - 1)) * 100));
            }
        }

    }

    @SuppressWarnings("unchecked")
    public static Thread restaurar(String ruta) {
        Thread hilo;
        RespaldarYRestaurarBD obj = new RespaldarYRestaurarBD();
        hilo = new Thread(obj);
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ruta));
            ObjectInputStream in = new ObjectInputStream(bis);
            BaseDeDatos.eliminarTablas();
            BaseDeDatos.crearTablas();
            data = (ArrayList<Object>) in.readObject();
            accion = 1;
            hilo.setPriority(1);
            hilo.start();
            in.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {

        }
        return hilo;
    }
}
