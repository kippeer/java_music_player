package org.example.mus;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filePath = "audio.wav";
        File file = new File(filePath); // Adicionando o ponto e vírgula

        if (file.exists()) {
            System.out.println("O arquivo existe: " + file.getAbsolutePath());
        } else {
            System.out.println("O arquivo não foi encontrado.");
        }
    }
}
