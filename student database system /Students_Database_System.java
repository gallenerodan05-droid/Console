
import java.util.ArrayList;
import java.util.Scanner;


// Add student
// View all students
// Search student by ID
// Delete Student
/*
class Student
private variables 
getters & setters
ArrayList<Student> 
constructor
well also  use scanners,switch, while loops, enhanced for loops

*/
//static is a field somehow
public  class Students_Database_System{
     static Scanner scanner = new Scanner(System.in);
   static ArrayList<student> studentsz = new ArrayList<>();

    public static void main(String[] args) {

        

        while (true) { 
            System.out.println("Choose an option \n1.Add Student \n2.View All Students \n3.Search Student By ID \n4.Delete Student");

        int  options = scanner.nextInt();
         
            switch (options) {
                case 1 -> AddStudents();
                case 2 -> Show_Students();
                case 3 -> Search_Students();
                case 4 -> Delete_Student();
                case 5 -> {System.out.println("Goodbye"); System.exit(0);}
                default-> System.out.println("Invalid Input");
                //For the exit case, since it has two statements, we wrap them in {} after the arrow.
                    
            }}




    }

    static  void AddStudents(){
        System.out.print("Add Name: ");
        scanner.nextLine(); // we use this to prevent newLine buffers or something like that 
        String name = scanner.nextLine().trim();

        System.out.print("Add Grade: ");
        int ID = scanner.nextInt();

        System.out.print("Add GPA: ");
        double GPA = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Add Course: ");
        String Course = scanner.nextLine().trim().toUpperCase();

        studentsz.add(new student(name, ID, GPA, Course));
        System.out.println("Student Added!");
    
    
    }
    static  void Show_Students(){

        if(studentsz.isEmpty()){
            System.out.println("There are no students");

            return;      
            // atay dri diay dpit ang return putik bikogs pikas
                    // this is somewhat unnecessary?? or can be removed smthn like that
                    //Guard clause (7/1/26)
                    // exit early if certain conditions are met XDXD
}

        for(student studenz: studentsz){
            System.out.println(studenz);
        }


    }

    static void Search_Students(){
        System.out.print("Search for a student using ID: ");
        int student_ID = scanner.nextInt();

        // basically one has to loop throught it first
        for (student studentzzz: studentsz){
            if (studentzzz.getID() == student_ID) {
                System.out.println(studentzzz);
                return;

                
            }
        }

        System.out.println("Student was not found");




    }

    static  void Delete_Student(){
        System.out.println("Enter ID of student you wish to remove/delete: ");
        int delete = scanner.nextInt();


        for(student delete_Student : studentsz){
            if( delete_Student.getID() == delete){

                studentsz.remove(delete_Student); // dumbass we actually have to personally remove it from the container 
                System.out.println("Student Removed");
                return;

            }
        }

        System.out.println("No such student");
    }





/* String name = scanner.nextLine().trim().replaceAll("\\s+", " ");
removes whitespaces if this was on python it would just only .trim() lol*/
    




























}





