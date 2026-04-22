

/*Yes, you should make your model class like `User_History` **public** if it’s used by other classes.
In Java, each file can only have **one public class**, and the file name must match it.
So `User_History.java` → `public class User_History` is correct.
Use non-public (`class`) only if the class is used **inside one file only**.
👉 Simple rule: **If other classes need it → make it public.

👉 Class names = PascalCase

First letter uppercase
Every word uppercase
No underscores**

👉 Classes → PascalCase (UserHistory)
👉 Variables → camelCase (userHistory)

👉 Because your class represents a task, not "history"
 */
 public class Task {

   final  private String task;
    private boolean marked;
    final private String dueDate; // simple string for now
    final private String priority; // LOW, MEDIUM, HIGH

    public Task(String task, String dueDate, String priority) {
        this.task = task;
        this.dueDate = dueDate;
        this.priority = priority;
        this.marked = false;
    }

    public String getTask() {
        return task;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return (marked ? "[✔] " : "[ ] ") +
               task + " | Due: " + dueDate +
               " | Priority: " + priority;
    }
}