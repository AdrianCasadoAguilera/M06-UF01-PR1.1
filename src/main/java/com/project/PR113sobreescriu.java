package com.project;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {
        // obrim el writer amb la ruta passada com a argument
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(camiFitxer), StandardCharsets.UTF_8)) {
            writer.write("I can only show you the door");
            writer.newLine();
            writer.write("You're the one that has to walk through it");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
