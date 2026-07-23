package gradeTracker;


import java.util.ArrayList;
import  java.util.List;
public class Student {
    public  final  String  name;
    public  final List<Integer> gradez;
    public  final  String subject;




    public Student(String name,String subject){
        this.subject = subject;
        this.name = name;
        this.gradez = new ArrayList<>();

    }
    
    public void AddGrade(int grade){
        gradez.add(grade);

    }

    public double  getAverage(){
        double sum = 0;

        
        if(gradez.isEmpty()){
            return 0 ;
        }
        for(double grade: gradez ){


            sum+=grade;

        }

          double average = sum/ gradez.size();
        return  average;




    }



    
    
}
