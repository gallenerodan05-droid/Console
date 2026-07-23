public class Java_Method_Overloading {
    //int x = 5; class variable

    public static void main(String[] args) {
        
    myMethod(4);

    }

    static int myMethod(int x){
        return x +5;

    }
}

/*With method overloading, multiple methods can have
 the same name with different parameters: */
//axel Example
 /*int myMethod(int x)
float myMethod(float x)
double myMethod(double x, double y) */

/*Loop Scope

Variables declared inside a for loop only exist inside the loop:
Example

public class Main {
  public static void main(String[] args) {

    for (int i = 0; i < 5; i++) {
      System.out.println(i); // i is accessible here
    }

    // i is NOT accessible here
  }
}
  

    The for loop has its own block ({ ... }).
    The variable i declared in the loop header (int i = 0) is only accessible inside that loop block.
    Once the loop ends, i is destroyed, so you can't use it outside.

*/