/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import sistema.medico.principal;

/**
 *
 * @author Administrador
 */
public class Instancia {

    private static HashMap<String, Object> instancias = new HashMap<>();

    public static Object getInstancia(String objName) {

        try {
            // verifico si existe un objeto relacionado a objName
            // en la hashMap
            Object obj = instancias.get(objName);
            // si no existe entonces lo instancio y lo agrego
            if (obj == null) {
                String sClassname = "sistema." + objName;
                obj = Class.forName(sClassname).getDeclaredConstructor().newInstance();
                // agrego el objeto a la hashMap
                instancias.put(objName, obj);
            }
            System.out.println(obj);
            return obj;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static Object getInstancia(String objName, String otro) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        try {
            // verifico si existe un objeto relacionado a objName
            // en la hashMap
            Object obj = instancias.get(objName);
            // si no existe entonces lo instancio y lo agrego
            if (obj == null) {
                Class<?> clazzNested = Class.forName("sistema.medico.principal$KeyUniversal");
                principal objtest = (principal) Instancia.getInstancia("medico.principal");
                Constructor<?> constructor = clazzNested.getDeclaredConstructor(new Class[]{principal.class});
                obj = constructor.newInstance(new Object[]{objtest});
                // agrego el objeto a la hashMap
                instancias.put(objName, obj);
            }
            System.out.println(obj);
            return obj;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
