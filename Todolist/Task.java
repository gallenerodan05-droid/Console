package Todolist;

public class Task {
    private String description;
    private String dueDate;
    private Priority priority;  
    private boolean marked;

    public Task(String description, String dueDate, Priority priority) {
        this.description = description;
        this.dueDate     = dueDate;
        this.priority    = priority;
        this.marked      = false;
    }

    public String   getDescription() { return description; }
    public String   getDueDate()     { return dueDate; }
    public Priority getPriority()    { return priority; }
    public boolean  isMarked()       { return marked; }

    
  public void setDescription(String description) { 
        this.description = description != null ? description : this.description;  
        // if input is not empty/null  replace the old value
    }
    
    public void setDueDate(String dueDate) { 
        this.dueDate = dueDate != null ? dueDate : this.dueDate; 
    }
    
    public void setPriority(Priority priority) { 
        this.priority = priority != null ? priority : this.priority; 
    }
    
    public void setMarked(boolean marked) { 
        this.marked = marked; 
    }

    public void markAsDone() { 
        this.marked = true; 
    }
    
    public void markAsUndone() { 
        this.marked = false; 
    }
    @Override
    public String toString() {
        String status = marked ? "[DONE]" : "[    ]";
        return status + " " + description + " | " + dueDate + " | " + priority;
    }
}