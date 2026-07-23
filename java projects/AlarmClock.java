
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock  implements  Runnable{

    private final LocalTime alarmTime;
    private  final  String filepath;
    private final Scanner scanner;

    

     AlarmClock(LocalTime alarmTime, String filepath,Scanner scanner) {
        this.alarmTime = alarmTime;   //axel assign the alarm time to the argument  we receive .
        this.filepath =  filepath;
        this.scanner = scanner;

    }

    

    @Override
    public void run(){
        

        //stpb yeah no this is prettty self-exaplantory. if the given alarm time has not happened yet sleep or be inactivc until it does.
        //axel let the thread sleep for a second
        // instead of having or creating an object you can shorten it to this
        //LocalTime.now().isBefore(alarmTime)

        while( LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);

                // int hours = LocalTime.now().getHour();
                // int minutes = LocalTime.now().getMinute();
                // int seconds =  LocalTime.now().getSecond();

                //Alternatively, it can be dne like this to make a shroer code. yeah i prefer this

                LocalTime now = LocalTime.now();
                

                //remember  \r makes it so that it would not repeatedly make lines and store everything in a single line


                System.out.printf("\r%02d:%02d:%02d",now.getHour(),now.getMinute(),now.getSecond()); //this updates every second/depends on the input for the thread actaully


            } catch (InterruptedException e) { System.out.println("Thread was interrupted"); }
        }
        System.out.println("\nAlarm Noises*");
        play(filepath);
        
    }
    private  void play( String filepath){
        File audioFile = new File(filepath);

        try(AudioInputStream audiostreram = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();

            clip.open(audiostreram);
            clip.start();

            System.out.println("Press *ENTER* to stop");
            scanner.nextLine();// yeah no any input given here or something like dat will most likely stop the program maybe
            clip.stop(); //music will keep playing unless we hit enter
            scanner.close();
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio file format is unsupported");


        }
        catch(LineUnavailableException e ){
            System.out.println("Audio is unavialable");
        
        }
        catch(IOException e){
            System.out.println("Error Audio Reading");
        }
    }
    
}


//beru LocalTime is a data type so yeah. u get the idea yk
 