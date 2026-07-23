public class student {

    private final  String name;
    private  final int ID;
    private final  double  GPA;
    private final  String Course;
// we can essentially turn fields into final if they have no setter methods/ things like this "this.name  = name"
// yeah let this sink

    public static int count = 0;

     student( String name, int ID, double  GPA, String Course) {

        this.name = name;
        this.ID  = ID;
        this.GPA = GPA;
        this.Course = Course;
        count++;



    }
    public int getCount(){
        return count;
    }

    public String getName(){
        return  name;
    }

    public int getID(){
        return  ID;
    }

    public double  getGPA(){
        return GPA;
    }

    public String getCourse(){
        return  Course;
    }


// to make a statement is to use the return keyword.... let that sink in
    @Override
    public String toString(){
      return "Name: " + name + " ID: " + ID + "GPA: " + GPA + " Course: " + Course;
    }


    
    
}
