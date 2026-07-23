
import java.util.ArrayList;
import java.util.Scanner;

/*1. To-Do List Manager (Very similar to your current project)

Features: Add task, view all tasks, mark as completed, delete task, search by ID or name.
New concepts: Add a boolean isCompleted field, maybe sort tasks.
Why it's great: Almost identical structure to your student system — perfect reinforcement. */

public class To_Do_List{

   static  ArrayList<task_maker> tasksz = new ArrayList<>();
static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){

            System.out.println("Choose \n1.Add Task \n2. View All Task \n3. Mark As Completed \n4. Delete Task \n5. Exit");
            int options = scanner.nextInt();

            switch(options){
                case 1 -> AddTask();
                case 2 -> ViewTask();
                case 3 -> task_delete();
                case 4-> MarkCompleted();
                case 5-> {System.exit(0); System.out.print("Goodbye");}
                default -> {System.out.println("Please Try Again"); System.out.print("Invalid Option.");}
                
            }
        }
        
    }

    static void AddTask(){
        System.out.print("Enter Task: ");
        scanner.nextLine();
        String task = scanner.nextLine().trim();

        if(task.isEmpty()){
            System.out.println("Task cannot be empty.");
            return;
        }



        System.out.print("Enter ID:");
        int taskID = scanner.nextInt();


        tasksz.add(new task_maker(task, taskID)); 

        System.out.print("Task Made!!");



        

    }

    static  void ViewTask(){

        if(tasksz.isEmpty()){
            System.out.println("No students whatsoever.");
        }


        System.out.println("\n---------Your task.------------");
        for (task_maker taskMake: tasksz){
            System.out.print(taskMake);
        }


    }


    static  void task_delete(){

        System.out.print("Enter task ID:");
        int delete = scanner.nextInt();


        for(task_maker taskss: tasksz){

            if(taskss.getID() == delete){
                tasksz.remove(taskss);
                System.out.println("Task Removed");
                return; // used to escape the loop i think cuz without this it create an error smhw
            }





            
        }

        System.out.println("No such task.");
    }

    static  void MarkCompleted(){
        ViewTask();
        System.out.println("Enter Task ID to mark as completed");
        int id = scanner.nextInt();
        scanner.nextLine();

        for(task_maker tazkza: tasksz){
            if(tazkza.getID()== id){
                tazkza.setCompleted(true);
                System.out.println("Task" + tazkza.getTask()+ "marked as completed");
                return;//Immediately exits the method (because of return)

            }
            System.out.println("No task found with that ID");
        }
    }
        
        
}

