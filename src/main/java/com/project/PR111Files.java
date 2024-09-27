package com.project;

import java.io.File;
import java.io.IOException;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/PR111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        try{
            crearCarpeta(camiFitxer+"/myFiles");

            String[] nomsFitxers = new String[]{"file1.txt","file2.txt"}; 
            crearArxius(new File(camiFitxer+"/myFiles"),nomsFitxers);

            renombrarArxiu(camiFitxer+"/myFiles","file2.txt","renamedFile.txt");

            llistarArxius(camiFitxer+"/myFiles");

            esborrarArxiu(camiFitxer+"/myFiles","file1.txt");

            llistarArxius(camiFitxer+"/myFiles");
        }catch(IOException err){
            System.out.println("ERROR: "+err.getMessage());
        }

    }

    // Crea carpeta PR111 a data
    private static void crearCarpeta(String camiCarpeta) throws IOException{
        File arxiu = new File(camiCarpeta);
        if(!arxiu.mkdirs()){
            throw new IOException("La carpeta ja existeix.");
        }
    }

    // Crea els arxiu indicats
    private static void crearArxius(File ruta,String[] fitxers) throws IOException{

        if(ruta.exists() && ruta.isDirectory()){
            // Per cada fitxer a l'array, creem el nou fitxer. 
            for(String fitxer : fitxers){
                File nouFitxer = new File(ruta+"/"+fitxer);
                if(!nouFitxer.createNewFile()){
                    throw new IOException("No s'ha pogut crear l'arxiu "+fitxer);
                }
            }
        }else{
            throw new IOException("El directori no existeix.");
        }
        
    }

    // renombre l'arxiu origen de la ruta a l'arxiu destí
    private static void renombrarArxiu(String ruta,String origin,String desti) throws IOException{
        File fileOrigin = new File(ruta+"/"+origin);
        File fileDesti = new File(ruta+"/"+desti);

        if(!fileOrigin.exists()){
            throw new IOException("L'arxiu original no existeix.");
        }else if(fileDesti.exists()){
            throw new IOException("Ja existeix un arxiu amb el nom "+desti+"en aquest directori.");
        }
        // Utilitzem el renameTo per canviar el nom d'un fitxer a un altre
        fileOrigin.renameTo(fileDesti);
    }

    // esborra l'arxiu indicat a la ruta indicada
    private static void esborrarArxiu(String ruta, String nomArxiu) throws IOException{
        File arxiuAEsborrar = new File(ruta+"/"+nomArxiu);
        if(!arxiuAEsborrar.exists()){
            throw new IOException("No s'ha trobat l'arxiu "+nomArxiu);
        }
        // esborrem l'arxiu a l'argument de l'If. Si falla, retorna false i llença l'excepció.
        if(!arxiuAEsborrar.delete()){
            throw new IOException("No s'ha pogut esborrar l'arxiu"+nomArxiu);
        }
    }

    // llista els arxius del directori indicat
    private static void llistarArxius(String ruta) throws IOException{
        File directori = new File(ruta);
        if(!directori.isDirectory()){
            throw new IOException("La ruta indicada no correspon a un directori.");
        }

        // fem un array amb els arxius del directori
        File[] filesList = directori.listFiles();

        System.out.println("Els arxius de la carpeta són: ");
        // per cada arxiu, imprimim el seu nom
        for(File file : filesList){
            System.out.println(file.getName());
        }
    }
}
