package org.example.mus;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String[] args) {
        // Caminho do arquivo de áudio no diretório resources
        String filePath = "audio.wav";

        // Carrega o arquivo de áudio como um InputStream a partir do diretório de resources
        try (Scanner scanner = new Scanner(System.in);
             InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath)) {

            if (inputStream == null) {
                System.out.println("Arquivo de áudio não encontrado!");
                return;
            }

            // Obtém o AudioInputStream a partir do InputStream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream); // Abre o arquivo de áudio

            String response = "";
            while (!response.equals("Q")) {
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Restart");
                System.out.println("Q = Quit");
                System.out.print("Enter your choice: ");

                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P":
                        clip.start(); // Reproduz o áudio
                        break;
                    case "S":
                        clip.stop(); // Para o áudio
                        break;
                    case "R":
                        clip.setFramePosition(0); // Reinicia o áudio
                        clip.start();
                        break;
                    case "Q":
                        // Sai do programa
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Arquivo de áudio não suportado.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao acessar o arquivo de áudio.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Bye!");
        }
    }
}
