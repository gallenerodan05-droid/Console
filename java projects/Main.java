import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


 public  class Main {

    public static void main(String[] DanG) {
      Scanner scanner = new Scanner(System.in);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      LocalTime alarmTime= null ;
      String filepath = "flip.wav";



      System.out.print("Enter alarm time(HH:MM:SS)");



     
while (alarmTime == null) { 
      try  { String user_input = scanner.nextLine();
       alarmTime = LocalTime.parse(user_input,formatter);
       
       System.out.println("Alarm set for:" + alarmTime );

          
      } catch (DateTimeException e) {
        System.out.println("You have entered an invalid time statement.");
      }
      
        

       
    }
      AlarmClock alarmClock = new AlarmClock(alarmTime,filepath,scanner);
      Thread thread  = new Thread(alarmClock);

      thread.start(); //beru to actually star a thread you just need to call the start method lol
                        // axel the moment this is called the run method runs pretty self-explantory ykyky

    
}
      

    

   
}


//