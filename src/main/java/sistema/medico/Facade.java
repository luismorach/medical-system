/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.medico;

import java.util.ArrayList;

import sistema.database.ActividadesMedicasDAO;
import sistema.database.ActividadesMedicasDTO;
import sistema.database.BaseDeDatos;
import sistema.database.CitasDAO;
import sistema.database.CitasDTO;
import sistema.database.DatosMedicosPacienteDAO;
import sistema.database.DatosMedicosPacienteDTO;
import sistema.database.EnfermedadesDAO;
import sistema.database.EnfermedadesDTO;
import sistema.database.FamiliaresDAO;
import sistema.database.FamiliaresDTO;
import sistema.database.HistorialDAO;
import sistema.database.HistorialDTO;
import sistema.database.PacientesDAO;
import sistema.database.PacientesDTO;
import sistema.database.UsuariosDAO;
import sistema.database.UsuariosDTO;
import sistema.util.Instancia;

/**
 *
 * @author Administrador
 */
public class Facade {

    Facade() {
        BaseDeDatos.crearTablas();
    }
    public static int c;
    static ActividadesMedicasDAO acceso = (ActividadesMedicasDAO) Instancia.getInstancia("database.ActividadesMedicasDAO");
    static EnfermedadesDAO acceso1 = (EnfermedadesDAO) Instancia.getInstancia("database.EnfermedadesDAO");
    static PacientesDAO acceso2 = (PacientesDAO) Instancia.getInstancia("database.PacientesDAO");
    static FamiliaresDAO acceso3 = (FamiliaresDAO) Instancia.getInstancia("database.FamiliaresDAO");
    static DatosMedicosPacienteDAO acceso6 = (DatosMedicosPacienteDAO) Instancia.getInstancia("database.DatosMedicosPacienteDAO");
    static CitasDAO acceso4 = (CitasDAO) Instancia.getInstancia("database.CitasDAO");
    static HistorialDAO acceso5 = (HistorialDAO) Instancia.getInstancia("database.HistorialDAO");
    static UsuariosDAO acceso7 = (UsuariosDAO) Instancia.getInstancia("database.UsuariosDAO");

    public static void actividadesPorDefecto() {
        acceso.insertarActividad("ACTIVOS: ENFERMEDADES COMUNES", "Consulta Curativa Activos");
        acceso.insertarActividad("ACTIVOS: ACCIDENTES COMUNES", "Consulta Curativa Activos");
        acceso.insertarActividad("ACTIVOS: ACCIDENTES LABORALES", "Consulta Curativa Activos");
        acceso.insertarActividad("ACTIVOS: ENFERMEDADES DE PROBABLE ORIGEN OCUPACIONAL", "Consulta Curativa Activos");
        acceso.insertarActividad("JUBILADOS CORPOELEC", "Consulta Curativa Activos");
        acceso.insertarActividad("TOTAL CONSULTAS A CORPOELEC", "Consulta Curativa Especial Activos");
        acceso.insertarActividad("MINISTERIO DE ENERGIA ELECTRICA: ENFERMEDADES COMUNES", "Consulta Curativa Ministerio");
        acceso.insertarActividad("MINISTERIO DE ENERGIA ELECTRICA: ACCIDENTES COMUNES", "Consulta Curativa Ministerio");
        acceso.insertarActividad("MINISTERIO DE ENERGIA ELECTRICA: ACCIDENTES LABORALES", "Consulta Curativa Ministerio");
        acceso.insertarActividad("MINISTERIO DE ENERGIA ELECTRICA: ENFERMEDADES OCUPACIONALES", "Consulta Curativa Ministerio");
        acceso.insertarActividad("TOTAL CONSULTAS A MINISTERIO DE ENERGIA ELECTRICA", "Consulta Curativa Especial Ministerio");
        acceso.insertarActividad("TOTAL CONSULTAS CORTESIAS", "Consulta Curativa Especial Ministerio");
        acceso.insertarActividad("TOTAL CONSULTAS CURATIVAS (CORPOELEC, COMUNIDAD Y OTROS)", "Consulta Curativa Especial Ministerio");
        acceso.insertarActividad("INDICACION DE CAMBIO DE PUESTO DE TRABAJO", "Resultado de Evaluacion");
        acceso.insertarActividad("INDICACION DE LIMITACION DE TAREAS", "Resultado de Evaluacion");
        acceso.insertarActividad("TOTAL DE CONSULTAS EN GENERAL (CONSULTAS CURATIVAS + CONSULTAS PREVENTIVAS CORPOELEC)", "Consulta Curativa Especial");

        acceso.insertarActividad("EXAMEN PRE-EMPLEO (INGRESOS)", "Consulta Preventiva");
        acceso.insertarActividad("EXAMEN PRE-VACACIONAL", "Consulta Preventiva");
        acceso.insertarActividad("EXAMEN POST-VACACIONAL", "Consulta Preventiva");
        acceso.insertarActividad("REINTEGRO LABORAL POR ENFERMEDAD COMUN", "Consulta Preventiva");
        acceso.insertarActividad("REINTEGRO LABORAL POR ACCIDENTE COMUN", "Consulta Preventiva");
        acceso.insertarActividad("REINTEGRO LABORAL POR ACCIDENTE DE TRABAJO", "Consulta Preventiva");
        acceso.insertarActividad("REINTEGRO LABORAL POR ENFERMEDAD DE PROBABLE ORIGEN OCUPACIONAL", "Consulta Preventiva");
        acceso.insertarActividad("REINTEGRO LABORAL POR POSTNATAL O PERMISOS PROLONGADOS", "Consulta Preventiva");
        acceso.insertarActividad("EGRESOS", "Consulta Preventiva");
        acceso.insertarActividad("EVALUACION ESPECIAL ANUAL", "Consulta Preventiva");
        acceso.insertarActividad("EV. ESPECIAL POR ASCENSO O CAMBIO DE PUESTO DE TRABAJO", "Consulta Preventiva");
        acceso.insertarActividad("EV. ESPECIALES CONTROL Y SEGUIMIENTO POR ENFERMEDAD COMUN", "Consulta Preventiva");
        acceso.insertarActividad("EV. ESPECIALES CONTROL Y SEGUIMIENTO POR ACCIDENTES COMUNES", "Consulta Preventiva");
        acceso.insertarActividad("EV. ESPECIALES CONTROL Y SEGUIMIENTO POR ACCIDENTE LABORAL", "Consulta Preventiva");
        acceso.insertarActividad("EV. ESPECIALES CONTROL Y SEGUIMIENTO POR ENFERMEDAD DE PROBABLE ORIGEN OCUPACIONAL", "Consulta Preventiva");
        acceso.insertarActividad("TOTAL CONSULTAS PREVENTIVAS(CORPOELEC)", "Consulta Preventiva Especial");

        acceso.insertarActividad("Nº REPOSOS", "Reposos");
        acceso.insertarActividad("DIAS DE REPOSO", "Reposos");
        acceso.insertarActividad("REINTEGROS DE REPOSO", "Reposos");
        acceso.insertarActividad("AUDIOMETRIAS", "Estudios");
        acceso.insertarActividad("ESPIROMETRIAS", "Estudios");
        acceso.insertarActividad("RX LUMBOSACRAS", "Estudios");
        acceso.insertarActividad("RX TORAX", "Estudios");
        acceso.insertarActividad("MEDIDAS  ANTROPOMÉTRICAS", "Estudios");
        acceso.insertarActividad("RESONANCIA MAGNETICA", "Estudios");
        acceso.insertarActividad("TAC", "Estudios");
        acceso.insertarActividad("ECOSONOGRAMA", "Estudios");
        acceso.insertarActividad("LABORATORIOS", "Estudios");
        acceso.insertarActividad("OTROS ESTUDIOS", "Estudios");
        acceso.insertarActividad("TOTAL ESTUDIOS SOLICITADOS", "Estudios Especiales");
        acceso.insertarActividad("REFERENCIA A EMERGENCIA", "Referencias");
        acceso.insertarActividad("REFERENCIA A ESPECIALIDADES", "Referencias");

        acceso.insertarActividad("CHARLAS EDUCATIVAS", "Actividades de Promocion de la salud");
        acceso.insertarActividad("CHARLAS CORTAS A TRABAJADORES EN LAS CONSULTAS / PTO DE TRABAJO", "Actividades de Promocion de la salud");
        acceso.insertarActividad("ELABORACIÓN DE MATERIAL IMPRESO , VOLANTES, TRÍPTICOS, CARTELERAS, OTROS", "Actividades de Promocion de la salud");
        acceso.insertarActividad("JORNADAS DE SALUD", "Actividades de Promocion de la salud");
        acceso.insertarActividad("PERMISOS POR CUIDADOS MATERNOS Y FAMILIARES (CLÁUSULA 75)", "Actividades de Promocion de la salud");
        acceso.insertarActividad("OTRAS ACTIVIDADES (ELABORACION DE INFORMES MEDICOS)", "Actividades de Promocion de la salud");
        acceso.insertarActividad("OTRAS ACTIVIDADES (VISITA INTRAHOSPITALARIA / INTRADOMICILIARIA A TRABAJADOR )", "Actividades de Promocion de la salud");
        acceso.insertarActividad("REUNION CON EL COMITE DE SALUD Y SEGURIDAD", "Actividades Ocupacionales");
        acceso.insertarActividad("REUNION CON INPSASEL Y/O EXTERNOS", "Actividades Ocupacionales");
        acceso.insertarActividad("INSPECCIONES DE CAMPO (AMBULANCIA DE CORPOELEC)", "Actividades Ocupacionales");
        acceso.insertarActividad("ASESORIAS", "Actividades Ocupacionales");
        acceso.insertarActividad("ELABORACIÓN DE INFORME MEDICO OCUPACIONAL", "Actividades Ocupacionales");
        acceso.insertarActividad("OTRAS ACTIVIDADES ", "Actividades Ocupacionales");

        acceso.insertarActividad("Nº DE CONSULTAS PROGRAMADAS", "Psicologia");
        acceso.insertarActividad("Nº DE CONSULTAS POR PRIMERA VEZ", "Psicologia");
        acceso.insertarActividad("OTRAS ACTIVIDADES (TALLER MOTIVACIONAL, TALLLER ARMONIA LABORAL,DINAMICAS GRUPALES,CARTELERA)", "Psicologia");

        acceso.insertarActividad("TTO. IM", "Enfermeria");
        acceso.insertarActividad("TTO. IV", "Enfermeria");
        acceso.insertarActividad("TTO. SUBL.", "Enfermeria");
        acceso.insertarActividad("TTO. VO", "Enfermeria");
        acceso.insertarActividad("NEBULIZACIONES", "Enfermeria");
        acceso.insertarActividad("CURAS", "Enfermeria");
        acceso.insertarActividad("LAVADO OCULAR", "Enfermeria");
        acceso.insertarActividad("GLICEMIA CAPILAR", "Enfermeria");
        acceso.insertarActividad("RETIRO DE SUTURAS", "Enfermeria");
        acceso.insertarActividad("DRENAJES", "Enfermeria");
        acceso.insertarActividad("PESO", "Enfermeria");
        acceso.insertarActividad("T.A.", "Enfermeria");
        acceso.insertarActividad("TEMPERATURA", "Enfermeria");
        acceso.insertarActividad("EKG", "Enfermeria");

        acceso.insertarActividad("Nº DE CONSULTAS PROGRAMADAS", "Fisioterapia");
        acceso.insertarActividad("Nº DE CONSULTAS POR PRIMERA VEZ", "Fisioterapia");
        acceso.insertarActividad("OTRAS ACTIVIDADES (DESCRIBA)", "Fisioterapia");

        acceso.insertarActividad("Nº DE CONSULTAS PROGRAMADAS", "Odontologia Activos");
        acceso.insertarActividad("Nº DE CONSULTAS POR PRIMERA VEZ", "Odontologia Activos");
        acceso.insertarActividad("PREVENTIVAS", "Odontologia Activos");
        acceso.insertarActividad("CURATIVAS", "Odontologia Activos");
        acceso.insertarActividad("EMERGENCIAS", "Odontologia Activos");
        acceso.insertarActividad("PACIENTES DADOS DE ALTA", "Odontologia Activos");
        acceso.insertarActividad("ACTIVIDAD EDUCATIVA EN SALUD ORAL", "Odontologia Activos");
        acceso.insertarActividad("N° DE CONSULTAS POR PRIMERA VEZ", "Odontologia Ministerio");
        acceso.insertarActividad("PREVENTIVAS", "Odontologia Ministerio");
        acceso.insertarActividad("CURATIVAS", "Odontologia Ministerio");
        acceso.insertarActividad("EMERGENCIAS", "Odontologia Ministerio");
        acceso.insertarActividad("PACIENTES DADOS DE ALTA", "Odontologia Ministerio");
        acceso.insertarActividad("ACTIVIDAD EDUCATIVA EN SALUD ORAL", "Odontologia Ministerio");

        acceso.insertarActividad("Nº DE CONSULTAS PROGRAMADAS", "Nutricion");
        acceso.insertarActividad("Nº DE CONSULTAS POR PRIMERA VEZ", "Nutricion");
        acceso.insertarActividad("OTRAS ACTIVIDADES (DESCRIBA)", "Nutricion");

        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "AMIBIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "ASCARIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "BLASTOCITOS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "CANDIDIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "CISTICERCOSIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "CITOMEGALOVIRUS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "CONJUNTIVITIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "DENGUE CLÁSICO");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "DENGE HEMORRÁGICO");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "DIARREA Y GASTROENTERITIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "ENFERMEDADES DE TRANSMISION SEXUAL");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "ESCABIOSIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "HEPATITIS A");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "HEPATITIS B");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "HERPES LABIAL");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "HERPES ZOSTER");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "LEISHMANIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "MIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "MICOSIS SUPERFICIAL");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "MONONUCLEOSIS INFECCIOSA");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "OTRA PARASITOSIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "OTRAS ENFERMEDADES INFECCIOSAS Y PARASITARIAS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "OtRAS HEPATITIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "OXIURIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "PAROTIDITIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "PEDIUCLOSIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "POLIPARASITOSIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "RUBEOLA");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "SARAMPIÓN");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "SINDROME VIRAL");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "TRICURIASIS");
        acceso1.insertarEnfermedades("EnfermedadesInfecciosasYParasitarias", "VARICELA");

        acceso1.insertarEnfermedades("Neoplasias", "OTROS TUMORES BENIGNOS");
        acceso1.insertarEnfermedades("Neoplasias", "OTROS TUMORES MALIGNOS");
        acceso1.insertarEnfermedades("Neoplasias", "OTROS TUMORES MALIGNOS DEL SISTEMA GENITOURITARIO");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DE LA MAMA");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DE LA PIEL");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DE LA PROSTATA");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DE LA SANGRE Y ÓRGANO HEMATOPEYICO");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DE UTERO");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DEL SISTEMA DIGESTIVO");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DEL SISTEMA NERVIOSO");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DEL SISTEMA OCULAR");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DEL SISTEMA OTORRINOLARINGÓLOGO");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DEL SISTEMA OSTEOMUSCULAR");
        acceso1.insertarEnfermedades("Neoplasias", "TUMOR MALIGNO DEL SISTEMA RESPIRATORIO");

        
    }

    public static void insertarActividadesMedicas(ActividadesMedicasDTO actividad) {
        acceso.insertarActividad(actividad);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarActividadesMedicas() {
        return acceso.consultarActividadMedica("ActividadesMedicas");
    }

    public static ArrayList<ActividadesMedicasDTO> consultarConsultaCurativa() {
        return acceso.consultarActividadMedica("ConcultaCurativa");
    }
    public static ArrayList<ActividadesMedicasDTO> consultarConsultaCurativa(String condicion) {
        return acceso.consultarSoloActividadMedica("ConcultaCurativa",condicion);
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarconsultaCurativaPorLetra(String letra,String tipo) {
        return acceso.consultarActividadMedicaPorLetra("ConcultaCurativa", letra,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarConsultaCurativaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("ConcultaCurativa", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarConsultaCurativaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("ConcultaCurativa", condicion);
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarConsultaPreventiva() {
        return acceso.consultarActividadMedica("ConcultaPreventiva");
    }

    public static ArrayList<ActividadesMedicasDTO> consultarConsultaPreventiva(String condicion) {
        return acceso.consultarSoloActividadMedica("ConcultaPreventiva", condicion);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarConsultaPreventivaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("ConcultaPreventiva", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarConsultaPreventivaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("ConcultaPreventiva", condicion);
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarconsultaPreventivaPorLetra(String letra,String tipo) {
        return acceso.consultarActividadMedicaPorLetra("ConcultaPreventiva", letra ,tipo);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarRepososEstuidosReferencias() {
        return acceso.consultarActividadMedica("RepososEstudiosReferencias");
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarRepososEstudiosReferencias(String condicion) {
        return acceso.consultarSoloActividadMedica("RepososEstudiosReferencias",condicion);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarRepososEstudiosReferenciasEspecificos(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("RepososEstudiosReferencias", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarRepososEstudiosReferenciasEspecificos(String condicion) {
        return acceso.consultarPorActividadMedica("RepososEstudiosReferencias", condicion);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarRepososEstudiosReferenciasPorLetra(String letra,String tipo) {
        return acceso.consultarActividadMedicaPorLetra("RepososEstudiosReferencias", letra ,tipo);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarPromocionDeLaSalud() {
        return acceso.consultarActividadMedica("PromocionDeLaSaludYOtras");
    }
    public static ArrayList<ActividadesMedicasDTO> consultarPromocionDeLaSalud(String condicion) {
       return acceso.consultarSoloActividadMedica("PromocionDeLaSaludYOtras", condicion);
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarPromocionDeLaSaludEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("PromocionDeLaSaludYOtras", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarPromocionDeLaSaludEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("PromocionDeLaSaludYOtras", condicion);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarPsicologiaPsicoterapiaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("PsicologiaPsicoterapia", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarPsicologiaPsicoterapiaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("PsicologiaPsicoterapia", condicion);
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarEnfermeria() {
        return acceso.consultarActividadMedica("Enfermeria");
    }
    public static ArrayList<ActividadesMedicasDTO> consultarEnfermeriaPorLetra(String letra,String tipo) {
        return acceso.consultarActividadMedicaPorLetra("Enfermeria", letra ,tipo);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarEnfermeriaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("Enfermeria", condicion,tipo);
    }
     public static ArrayList<ActividadesMedicasDTO> consultarEnfermeriaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("Enfermeria", condicion);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarFisioterapiaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("Fisioterapia", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarFisioterapiaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("Fisioterapia", condicion);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarOdontologia() {
        return acceso.consultarActividadMedica("Odontologia");
    }
    
    public static ArrayList<ActividadesMedicasDTO> consultarOdontologia(String condicion) {
        return acceso.consultarSoloActividadMedica("Odontologia",condicion);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarOdontologiaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("Odontologia", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarOdontologiaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("Odontologia", condicion);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarNutricionYDieteticaEspecifica(String condicion,String tipo) {
        return acceso.consultarPorActividadMedica("NutricionYDietetica", condicion,tipo);
    }
    public static ArrayList<ActividadesMedicasDTO> consultarNutricionYDieteticaEspecifica(String condicion) {
        return acceso.consultarPorActividadMedica("NutricionYDietetica", condicion);
    }

    public static void ActualizarActividadMedica(String nuevaActividad, String Actividad) {
        acceso.ActualizarActividadMedica(nuevaActividad, Actividad);
    }
    public static void ActualizarActividadMedica(String Actividad,String tipo, ActividadesMedicasDTO actv) {
        acceso.ActualizarActividadMedica(Actividad,tipo,  actv);
    }
    public static void ActualizarActividadMedica(ActividadesMedicasDTO actv) {
        acceso.ActualizarActividadMedica(actv);
    }

    public static void EliminarActividadMedica(String Actividad) {
        acceso.EliminarActividadMedica(Actividad);
    }

    public static ArrayList<ActividadesMedicasDTO> consultarPsicologiaPsicoterapia() {
        return acceso.consultarActividadMedica("PsicologiaPsicoterapia");
    }

    public static ArrayList<ActividadesMedicasDTO> consultarFisioterapia() {
        return acceso.consultarActividadMedica("Fisioterapia");
    }

    

    public static ArrayList<ActividadesMedicasDTO> consultarNutricion() {
        return acceso.consultarActividadMedica("NutricionYDietetica");
    }

    public static void insertarEnferemdades(EnfermedadesDTO enfermedad) {
        acceso1.insertarEnfermedades(enfermedad);
    }

    public static ArrayList<EnfermedadesDTO> consultarEnfermedades() {
        return acceso1.consultarEnfermedad("Enfermedades");
    }

    public static ArrayList<EnfermedadesDTO> consultarEnfermedadesInfecciosasYParasitarias() {
        return acceso1.consultarEnfermedad("EnfermedadesInfecciosasYParasitarias");
    }
    public static ArrayList<EnfermedadesDTO> consultarEnfermedadesInfecciosasYParasitariasPorLetra(String letra) {
        return acceso1.consultarEnfermedadesPorLetra("EnfermedadesInfecciosasYParasitarias",letra);
    }
    
    public static ArrayList<EnfermedadesDTO> consultarEnfermedadesInfecciosasYParasitariasEspecificas(String Condicion) {
        return acceso1.consultarPorEnfermedad("EnfermedadesInfecciosasYParasitarias", Condicion);
    }
    public static ArrayList<EnfermedadesDTO> consultarNeoplasias() {
        return acceso1.consultarEnfermedad("Neoplasias");
    }
     public static ArrayList<EnfermedadesDTO> consultarNeoplasiasPorLetra(String letra) {
        return acceso1.consultarEnfermedadesPorLetra("Neoplasias",letra);
    }

    public static ArrayList<EnfermedadesDTO> consultarNeoplasiasEspecificas(String Condicion) {
        return acceso1.consultarPorEnfermedad("Neoplasias", Condicion);
    }

    public static void ActualizarEnfermedades(String nuevaEnfermedad, String enfermedad) {
        acceso1.ActualizarEnfermedad(nuevaEnfermedad, enfermedad);
    }
     public static void ActualizarEnfermedades(String Enfermedad,EnfermedadesDTO enferm) {
        acceso1.ActualizarEnfermedades(Enfermedad, enferm);
    }
    public static void ActualizarEnfermedades(EnfermedadesDTO enferm) {
        acceso1.ActualizarEnfermedades(enferm);
    }

    public static void eliminarEnfermedades(String nombre) {
        acceso1.eliminarEnfermedad(nombre);
    }

    public static void AñadirPacientes(PacientesDTO paciente) {
        acceso2.AñadirPaciente(paciente);
    }

    public static void EliminarPacientes(String condicion, int valor) {
        acceso2.EliminarPacientes(condicion, valor);
    }

    public static void ActualizarPacientesID(String condicion, int valor, int nuevo) {
        acceso2.ActualizarPacientesPorCondicion("ID_Paciente", valor, nuevo);
    }

    public static void ActualizarPacientes(String condicion, int valor, PacientesDTO paciente) {
        acceso2.ActualizarPacientes(condicion, valor, paciente);
    }

    public static ArrayList<PacientesDTO> ConsultarPacientes() {
        return acceso2.consultarPacientes();
    }

    public static ArrayList<PacientesDTO> ConsultarPacientesEspecificos(String condicion, int valor) {
        return acceso2.consultarPacientesEspecificos(condicion, valor);
    }
    public static ArrayList<PacientesDTO> ConsultarPacientesEspecificos(String condicion, String valor) {
        return acceso2.consultarPacientesEspecificos(condicion, valor);
    }
    public static ArrayList<PacientesDTO> ConsultarPacientesPorLetra(String letra) {
        return acceso2.consultarPacientePorLetra(letra);
    }

    public static void AñadirFamiliares(ArrayList<FamiliaresDTO> Familiar) {
        acceso3.AñadirFamiliar(Familiar);
    }

    public static void AñadirFamiliares(FamiliaresDTO Familiar) {
        acceso3.AñadirFamiliar(Familiar);
    }

    public static void EliminarFamiliares(String condicion, int valor) {
        acceso3.EliminarFamiliares(condicion, valor);
    }

    public static ArrayList<FamiliaresDTO> ConsultarFamiliares() {
        return acceso3.consultarFamiliares();
    }

    public static ArrayList<FamiliaresDTO> ConsultarFamiliaresEspecificos(String condicion, int valor) {
        return acceso3.consultarFamiliaresEspecificos(condicion, valor);
    }

    public static void ActualizarFamiliares(String condicion, int valor, FamiliaresDTO nuevosDatos) {
        acceso3.ActualizarFamiliares(condicion, valor, nuevosDatos);
    }

    public static void AñadirCitas(CitasDTO cita) {
        acceso4.insertarCitas(cita);
    }

    public static ArrayList<CitasDTO> ConsultarCitas() {
        return acceso4.consultarCitas();
    }

    public static ArrayList<CitasDTO> ConsultarCitas(String nombre) {
        return acceso4.consultarCitas(nombre);
    }

    public static void EliminarCitas(String nombre) {
        acceso4.EliminarCitas(nombre);
    }
    public static void AñadirHistorial(HistorialDTO historial) {
        acceso5.insertarHistorial(historial);
    }
    public static ArrayList<HistorialDTO> ConsultarHistorial(int id) {
        return acceso5.consultarHistorial(id);
    }
    public static ArrayList<HistorialDTO> ConsultarHistorial() {
        return acceso5.consultarHistorial();
    }
    public static void AñadirDatosMedicosPaciente(ArrayList<DatosMedicosPacienteDTO> datos) {
        acceso6.AñadirAfeccion(datos);
    }

    public static void AñadirDatosMedicosPaciente(DatosMedicosPacienteDTO datos) {
        acceso6.AñadirAfeccion(datos);
    }

    public static void EliminarAfeccion(int valor,String nombre,String tipo) {
        acceso6.EliminarAfeccion(valor,nombre,tipo);
    }

    public static ArrayList<DatosMedicosPacienteDTO> ConsultarDatosMedicos() {
        return acceso6.consultarDatosMedicos();
    }

    public static ArrayList<DatosMedicosPacienteDTO> ConsultarDatosMedicos(String condicion, int valor) {
        return acceso6.consultarDatosMedicos(condicion, valor);
    }
    public static ArrayList<DatosMedicosPacienteDTO> ConsultarDatosMedicos(String condicion, int valor,String nombre) {
        return acceso6.consultarDatosMedicos(condicion, valor,nombre);
    }

    public static void ActualizarAfeccion(String condicion, int valor, DatosMedicosPacienteDTO nuevosDatos) {
        acceso6.ActualizarAfeccion(condicion, valor, nuevosDatos);
    }
    public static void AñadirUsuarios(UsuariosDTO Usuario) {
        acceso7.insertarUsuarios(Usuario);
    }
    public static ArrayList<UsuariosDTO> ConsultarUsuario(String condicion,int valor) {
        return acceso7.consultarUsuarios(condicion,valor);
    }
    public static ArrayList<UsuariosDTO> ConsultarUsuario() {
        return acceso7.consultarUsuarios();
    }
    public static void ActualizarUsuarios(int valor, UsuariosDTO user) {
        acceso7.ActualizarUsuarios(valor, user);
    }
     
}
