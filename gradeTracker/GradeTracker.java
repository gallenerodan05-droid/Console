package gradeTracker;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import  java.util.Set;


public class GradeTracker {

    private final Map<String,List<Integer>> gradeList = new HashMap<>();
    private final Set<String>  uniqueSubjects  = new HashSet<>();//done??
    private final   Queue<String> reviewed = new LinkedList<>();
    private final  Deque<String> lastGraded = new ArrayDeque<>();
    private final  List<Student> studentList = new ArrayList<>();

// public void addGradeToStudent(String name, int grade) {
//     List<Integer> grades =  gradeList.get(name); i needa better understand this part
//     if(grades == null) {
//         System.out.println("Student not found.");
//         return;
//     }
//     grades.add(grade);
// } 



    public void addStudent(String student, String subjects){

      Student studentz = new Student(student, subjects);
      studentList.add(studentz);


      uniqueSubjects.add(subjects); //this is aight LMAOOO


 
      reviewed.add(student);

        lastGraded.push(student);




        gradeList.put(student,studentz.gradez );


        







    
    }
   

     

      
//     public void addGrade(int grade, String student){

//       gradeList.get(student).add(grade);  // Just because it is in an array does not necessarily mean
// that I'd have to insert an array too LOL. but I can replace the entire array using the put method so there's that. 

// }
    public void showSubjects(){

              System.out.println("Students subjects are" + uniqueSubjects);

    }
    public void gradedRecently(){
                System.out.println("Recently graded student: " + lastGraded.peek());

        
    }
    public void waitingStudents(){
                System.out.println("Students waiting for a graded review " + reviewed.peek());

        
    }

   



  public void processQueu(){
      String student = reviewed.poll();
   
      if(reviewed.isEmpty()) // The object before the '.' must exist.
// reviewed.isEmpty() ✅    
// student.isEmpty() ❌ if poll() returned null.
        {
   
        System.out.println("No students are waiting for a review.");
   
        return;
   
      }
      

      System.out.println("Now reviewing: " + student);

  }

    public  void viewStudents(){
                System.out.println("Welcome students " + studentList); //optional to for loop but meh}
}
  public void addGrade(String namez, int gradez) {
  
      

    for(Student student:studentList ){
      if(student.name.equals(namez) ){
        // gradeList.get(namez).add(grade); this was lowk a good attempt

        student.AddGrade(gradez);
        
        
        return;
      }



      
      
        
      }

      System.out.println("Student not found.");

  }







}



    

    

   /* —  List<Student> =  ordered list of all students
Map<String, List<Integer>> — student name → list of their grades // how tf do I do this part? do I repeatedly ask the user??
Set<String> — unique subjects being tracked
Queue<String> — students waiting for grade review
Deque<String> — recently graded students (last graded, first to get feedback)*/

/* 
The CLI lets you:

Add a student // this is the easy part idk how to the List<Students> part as well as the Map the set is pretty easy 
Add a grade for a subject // I think this has its own method?
View a student's average // how is this done??
Queue a student for grade review // I think we just use peek here tbh
Process the review queue */   //tf??
    


// Note to self: Create a fucking method first before creating variables that are not gonna be class variables. LMAO