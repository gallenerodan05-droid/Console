import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import  java.util.InputMismatchException;
import java.util.Scanner; 
/*Console To-Do List
Add task, view list, mark done, delete, save/load from .txt file.
Skills: OOP (Task class), ArrayList, File 
I/O.
Extend it: Due dates, priority.

LOL I was rated 7.5/10. LMAOOO That's the highest I've received so far!!
The only problem was that I did'nt know how to connect 
 */
//Yes, all of tihs is AI improved! 
 public class Console {

    //variables should be lowercase
    static  ArrayList<Task> taskz = new ArrayList<>();  
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    

        while(true){

            try{ 
            System.out.println("Enter a choice: ");
            System.out.println("1. Add Task \n2. View List \n3. Mark Done \n4. Delete \n5. Save \n6. Load \n7. File Deletion \n8. File Read \n9. Exit");

            int User_Input  = scanner.nextInt();
            scanner.nextLine();



            switch(User_Input){
                case 1-> Add_Task();
                case 2-> ViewList();
                case 3 -> Marked();
                case 4 ->Delete();
                case 5-> Save();
                case 6-> Load();
                case 7 -> deleteFIle();
                case 8-> readFile();

                case 9 -> { System.out.println("Goodbye."); System.exit(0); }
                default-> System.out.println("INVALID INPUT"); 

            }
        
        
        
        
        }








        catch( InputMismatchException e){
                System.out.println("Incorrect Input");
                scanner.nextLine();

        }
        catch(IOException  e) {
            System.out.println(e+ " occured!");
        }
        catch(Exception e){
            System.out.println("An error occured!");
        }



        }

        

    }



static void Add_Task() {

    
    String task;
    while (true) { 
        System.out.print("Enter Task: ");
     task = scanner.nextLine().trim();

     //Putting this regex here is bad becasue if the user tries to do a task like "Buy 3 apples"... yeah it would not allow it.  || task.matches(".*\\d.*") too bad tbh. This is lowkey good regex
     if(task.isEmpty()){
        System.out.println("Input must not be empty!");
        
     }
// yeah this must be removed lol pretty stupid tbh.
     else if(task.length()  <= 7){
        System.out.println("What task needs just 7 letters??  You a dumbass?");

     }
        
     else{
        break;
     }


        
    }
    


    String dueDate;

    while (true) { 


        System.out.print("Enter Due Date (e.g. 2026-04-01): ");
        System.out.println("Me no like you ⁉️");

        dueDate = scanner.nextLine().trim();

        if(dueDate.matches("\\d{4}-\\d{2}-\\d{2}") ){
            try {
                LocalDate.parse(dueDate);
                break;
                
            } 
            catch (DateTimeParseException e) {
                System.out.println("Invalid Date!  Use YYYY-MM-DD.");
            }


        }


        else{
            System.out.println("Invalid Format!! Use YYYY-MM-DD.");
        }}

    

    String priority;
    while (true) {
        System.out.print("Priority (LOW / MEDIUM / HIGH): ");
        priority = scanner.nextLine().toUpperCase();

        if (priority.equals("LOW") || priority.equals("MEDIUM") || priority.equals("HIGH")) {
            break;
        } else {
            System.out.println("Invalid priority!");
        }
    }

    taskz.add(new Task(task, dueDate, priority));
    System.out.println("Task Added!");

}

   


static void ViewList() {

    if (taskz.isEmpty()) {
        System.out.println("No tasks!");
        return;
    }

    for (int i = 0; i < taskz.size(); i++) {
        System.out.println(i + ": " + taskz.get(i));
    }
}
        
static void Marked() {

    ViewList();

    if( taskz.size() <=0){
        System.out.println("You have no task to mark!");
        return;
    }

    System.out.print("Enter index to mark: ");
    int index = scanner.nextInt();
    scanner.nextLine();

    if (index >= 0 && index < taskz.size()) {
        taskz.get(index).setMarked(true);
        System.out.println("Task marked!");
    } else {
        System.out.println("Invalid index!");
    }
}

//try-w-resources

static void Save() throws  IOException {

    System.out.print("Enter file name: ");
    String file_name = scanner.nextLine();


    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_name))) {

        for (Task t : taskz) {
            writer.write( 
                t.getTask() + "," +
                t.getDueDate() + "," +
               t.getPriority()+ "," +
                t.isMarked()
       
            );
            writer.newLine();
        }

        System.out.println("Saved!");}

    
}


static void Load() throws  IOException {

    System.out.print("Enter file name: ");
    String file = scanner.nextLine();

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

        taskz.clear();

        String line;

        while ((line = reader.readLine()) != null) { //Deepseek suggested to correct this part becaus it was prone/susceptible errors, Because what if the user types: Buy eggs,bread,. Yeah It would unnecessarily separate these lines. 

            String[] parts = line.split(",");

            String task =  parts[0];
            String dueDate = parts[1];
            String priority =  parts[2];
            boolean marked = Boolean.parseBoolean(parts[3]);

            Task t = new Task(task, dueDate, priority);
            t.setMarked(marked);

            taskz.add(t);
        }

        System.out.println("Loaded!");

    }
}


static void deleteFIle(){

    String file_delete;


    while (true) { 

            System.out.println("Enter file to delete: ");
            System.out.print("Press Q to exit");

            file_delete = scanner.nextLine().trim();

         if (file_delete.isEmpty() ){
                System.out.println("File must not be empty ");
            }

            else if(file_delete.equalsIgnoreCase("q") ){
                System.out.println("Goodbye");

                break;
            }
            





            else{

            File file = new File(file_delete);
            


             if( !file.exists() ){
            System.out.println("Does not exist!");
            

           }




               else{ file.delete();
               System.out.println("You deleted "+ file_delete+ "!");
               
                break;}
                

                
            }
            


        
    }


}


static void readFile() throws  IOException {



  System.out.println("Welcome!");

    while (true) {
        System.out.print("Please enter the name of your file: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {  // read once, store in variable
                    System.out.println(line);
                }
            }

         

            

            break;
        } else {
            System.out.println("File not found. Try again.");
        }
    }



}


static void Delete() {

    
    ViewList();

    System.out.print("Enter index to delete: ");
    int index = scanner.nextInt();
    scanner.nextLine();

    if (index >= 0 && index < taskz.size()) {
        taskz.remove(index);


        System.out.println("Task removed!");
    } else {
        System.out.println("Invalid index!");
    }
}





        
    
    




    //Currently no way to modify a task's description, date, or priority without deleting and re-adding.



}








