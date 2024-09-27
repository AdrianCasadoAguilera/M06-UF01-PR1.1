package com.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        try(
            InputStreamReader inp = new InputStreamReader(new FileInputStream(rutaOrigen));)
        {
            new File(rutaDesti).createNewFile();
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(rutaDesti));

            int c;
            // while reading, print on the output file
            while((c = inp.read())!=-1){
                out.write(c);
            }

            inp.close();
            out.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("ERROR. El fitxer d'origen no existeix o no és un arxiu de text.");
        }catch(IOException e2){
            e2.printStackTrace();
        } 
    }
}
