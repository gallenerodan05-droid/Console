public class task_maker {
    

    private final   String task;
    private  final int ID;
    private boolean  completed;

    public task_maker( String task,int ID) { // it isnt actually necessary for your fields to have matching parameters as your instance variables
        this.completed = false;

        this.task  = task;
        this.ID = ID;
        
    }


  
   public String getTask(){
        return  task;


    }

    public int getID(){
        return  ID;
    }

    //modify

   public  boolean  isCompleted(){
    return  completed;
    
   }

   //modify
   public void setCompleted(boolean completed){
    this.completed = completed;
   }



    @Override
    public String toString(){
        
        String status = completed ? "[✅]":"[⁉️]";
        return  String.format("ID: %d %s %s",ID,status,task);
        // return "Task: " + task + "." + "\nID: " + ID;

    }





}


/*1. To-Do List Manager (Very similar to your current project)

Features: Add task, view all tasks, mark as completed, delete task, search by ID or name.
New concepts: Add a boolean isCompleted field, maybe sort tasks.
Why it's great: Almost identical structure to your student system — perfect reinforcement. */



