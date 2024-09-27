package com.project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class PR114linies {

    // quantitat de números que apareixeran a l'arxiu
    private static final int QUANT_NUM = 10;

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        // creació d'un objecte Random
        Random random = new Random();

        int numToAdd;
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(camiFitxer))){
            // llistar a l'arxiu els números aleatoris que creem amb el mètode nextInt de l'objecte creat
            for(int i = 0; i < QUANT_NUM; i++){
                numToAdd = random.nextInt(99);
                writer.write(String.valueOf(numToAdd)+"\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
