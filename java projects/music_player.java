import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;
import  javax.sound.sampled.Clip;
public class music_player {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = new File("make you mine.wav");

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P = play");
                System.out.println("S = stop");
                System.out.println("R = reset");
                System.out.println("Q = quit");
                System.out.println("Enter choice");

                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    default -> System.out.println("Cute kayu ka alma moba???");
                }
            }

            clip.close();
            audioStream.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
