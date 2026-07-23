package Todolist;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class TodoApp {

    private  final  Scanner scanner = new Scanner(System.in);
    private  final  List<Task> task = new ArrayList<>();


    public static void main(String[] Danzkie) {
        new TodoApp().run();




    }

     private void run(){


        System.out.println("=== To-D0-List=== ");

        while (true) { 
            Options();

            try {  int  index =readint();

                switch( index){
                    case 1-> AddTask();
                    case 2-> ViewList();
                    case 3-> markTask();
                    case 4-> deleteTask();
                    case 5-> editTask();
                    case 6-> FilterByPriority()  ;
                    case 7-> sortDUeDate() ;
                    case 8-> Save();
                    case 9-> Load(); //case 10 Delete file
                    case 10-> DeleteFile() ;
                    case 11-> {System.out.println("Exit"); return;}


                    default -> {System.out.println("Invalid Choice");}
                } 
            }

            


            catch ( InputMismatchException e){
                System.out.println( "Please enter a number");
                scanner.nextLine();
            } 
              

            catch( IOException e ){
                System.out.println( "File error:" + e.getMessage());

            }

            catch (TasknotFoundException e){
                System.out.println(e.getMessage());

            }

             


            }

            


           
            

            
        }

        // DRY- HELPER METHODS


    

private  int readint(){
        int userInt  = scanner.nextInt();
        scanner.nextLine();
        return userInt;
        



    }
private String   promptNonEmpty(String prompt ){
    while (true) {      
        
        System.out.print( prompt);
  String value =  scanner.nextLine().trim();
  if (!value.isEmpty())return value;
    System.out.println("Input cannot be empty!");

}

}



private int getValidIndex( String index) throws TasknotFoundException{

System.out.println(index);
    int userIndex = readint();

    if ( userIndex < 0 || userIndex >= task.size()  ){
        throw  new TasknotFoundException(userIndex);

    }

    return userIndex;



}



    private  void Options(){
    System.out.println("""
                
                1. Add Task       6. Filter by Priority
                2. View List      7. Sort by Due Date
                3. Mark Done      8. Save
                4. Delete         9. Load
                5. Edit Task      10. Delete File
                11. Exit
                """);
        System.out.print("Choice: ");    }




private  void AddTask(){

    String description = promptNonEmpty("Enter Task: ");

    String  dueDate = Duedate();

    Priority priority = promptPriority() ;


    task.add(new Task( dueDate,description,priority ));
    System.out.println("Task Added!");
    

    







}

private  void ViewList(){

    if( task.isEmpty()){ System.out.println(" List is empty.");  return;}

    System.out.print("Your List: ");

    for(int i=0; i < task.size(); i++ ){
        System.out.println(i + ": "+ task.get(i)  );

    }



}



    private  String  Duedate()  throws  DateTimeParseException {

        LocalDate today = LocalDate.now();
        
        while (true) { 
                System.out.println("Date Format( YYYY-MM-DD) ");
                String userDate = promptNonEmpty("Enter due date: ");


                if(userDate.matches("\\d{4}-\\d{2}-\\d{2}")  ){


                    LocalDate parsedDate = LocalDate.parse(userDate);

                    if( !parsedDate.isBefore(today) ){
                        return  userDate;


                    }

                    else{
                        System.out.println("Date cannot be before: " + today);

                    }

    }
                else{
                    throw new DateTimeParseException("Cannot parse. Please try again ", userDate, 0) ; // So certain throwables need arguments. 
                }
            
                


            
        }
}
// When returning something the method must also possess the same data type as the value that is returned.
 private  Priority promptPriority(){

        while (true) { 
            
            System.out.print("Priority (LOW / MEDIUM / HIGH): ");

            Priority p = Priority.fromString(scanner.nextLine().trim() ); //optional. T'would still be okay to use a variable instead.
            if( p != null  ){ return p; }
            
            System.out.println("Invalid Input");

            
        }



    }


private  void deleteTask() throws  TasknotFoundException {

    if(task.isEmpty()){System.out.print("No Task");return; } 
    ViewList();
        
    int toDelete = getValidIndex("Enter index to remove: ");
    String removed = task.get(toDelete).getDescription();


    System.out.println("Deleted" + removed );
    task.remove(toDelete); 

}


private  void markTask() throws TasknotFoundException {

    if(task.isEmpty()){System.out.println("No Task");return;}


    ViewList();
    int userMark = getValidIndex("Enter index");
    task.get(userMark).setMarked(true);
    System.out.printf("Index: %d successfully marked!", userMark);}
    


private  void editTask() throws  TasknotFoundException {

    if(task.isEmpty()){System.out.println("There is no task to edit."); return;}
    ViewList();

    int taskEdit = getValidIndex("Enter index: ");

    Task t =  task.get(taskEdit);

    System.out.println("Edit 1: Description 2: Due Date 3. Priority");
    System.out.print("Choice: ");  
    int choice = readint();
    switch(choice){
        case 1-> t.setDescription(promptNonEmpty("Enter new task: ") ); 
        case 2-> t.setDueDate(Duedate());
        case 3-> t.setPriority(promptPriority() );
        default-> {System.out.println("Invalid Choice");return ;} // Again the enhanced switch is unable to take more than one statement.


    }
    // Cool discovery was that you can't actually  put/resolve setter values/methods into variables. 
    // But for getters you can String shuwa = task.get(0).getTask() yeah.
    
    System.out.println("Task Successfully Edited!");


    

    









}








private  void sortDUeDate(){

    if(task.isEmpty()){
        System.out.println("Task is empty"); return;  }
        


        task.sort(Comparator.comparing(Task::getDueDate));
        // fahhh need AI to explain the code above
        // like React this sorts the received argument/instance method
        // it would be optional to  add another method like ".reversed() or .thenComparing(Task::getTask) if dueDates are same"


        System.out.print("Sorted by Due Date: ");
        

            ViewList();


    

}





private  void FilterByPriority(){

    Priority filter = promptPriority();

    List<Task> filtered = task.stream().filter(t-> t.getPriority() == filter ).collect(Collectors.toList());

    if(filtered.isEmpty()){System.out.println("Priority is empty. \nNo "+  filter + " priority." ); return; }

    filtered.forEach(System.out::println); // alternative x-> System.out.println(x)
    // this is actually just lambda or smth like dat
}

private  void Save() throws  IOException {

    

        String fileInput = promptNonEmpty("Enter file name: ");

    try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileInput ))){
        for(Task t: task){
            bw.write(t.getDescription() + "," + // there's a fucking reason why this has no spacing after the comma lol
             t.getDueDate() + "," +
              t.getPriority() + "," +
               t.isMarked());
            bw.newLine();
        }



    }

    System.out.println("File name: " + fileInput);
    








}


private  void Load() throws  IOException{

    String fileLoad = promptNonEmpty("Enter file name to load: ");
    File file = new File(fileLoad);
    if(!file.exists()){
        System.out.println("File does not exist!");return;
    }

    try(BufferedReader br = new BufferedReader(new FileReader(file) ) ){
        task.clear();
        String line;
        while( (line = br.readLine()) != null){

        String[] parts = line.split(",",4);// skip malformed lines, don't crash 
        // shit like this split method must actually be EXACTLY THE SAME. fuck
        if (parts.length < 4){continue; }        

        String description = parts[0];
        String dueDate = parts[1];
        Priority prioritiez = Priority.fromString(parts[2]);
        boolean isMarked = Boolean.parseBoolean(parts[3]);

        if( prioritiez == null ){continue; } 

        Task t = new Task( dueDate, description,prioritiez);// this is needed for the sake of setters. A reference
        t.setMarked(isMarked);
        task.add(t);



        



        }

    }
            System.out.println("Loaded " + task.size() + " tasks." );

}

// fucking made this method w memory alone and no AIIII fuck yeah

private  void DeleteFile(){ 
    String delete = promptNonEmpty("Enter file to delete: ");







    File file = new File(delete);

    if(!file.exists() ){
        System.out.println("File does not exist."); 
    }

    else{


            String confirm = promptNonEmpty("Are you sure you want to delete this file? Y/N: ").toUpperCase() ;

            if(confirm.matches("Y") ){

                file.delete();
                System.out.println( delete  +" has been deleted");}

            else if(confirm.matches("N") )  {
                System.out.println( delete + "shall no longer be deleted.");
            }
            else{
                System.out.println("Please enter valid input.");
            }





        
    }



    


    

}




    }
