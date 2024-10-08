package com.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        if(new File(rutaArxiu).isDirectory()){
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArxiu), StandardCharsets.UTF_8))) {
            String linia;
            // mentres la línia no es nul·la, la imprimeix
            while ((linia = br.readLine()) != null) {
                System.out.println(linia);
            }
        } catch (IOException e) {
            System.out.println("El fitxer no existeix o no és accessible.");
        }

    }
}
