
//Java Method Parameters
//Parameters act as variables inside the method.
class method_parameters {
    static void myMethod(String fname,int basta) {

    System.out.println(fname + " Refsnes" + "I am also "+ basta + " years old");
  }

  public static void main(String[] args) {
    myMethod("Liam ",19);
    myMethod("Jenny ",23);
    myMethod("Anja ",29);
  }

}
//Multiple Parameters yeah you already know this
/*public class Main {

  // Create a checkAge() method with an integer variable called age
  static void checkAge(int age) {

    // If age is less than 18, print "access denied"
    if (age < 18) {
      System.out.println("Access denied - You are not old enough!");

    // If age is greater than, or equal to, 18, print "access granted"
    } else {
      System.out.println("Access granted - You are old enough!");
    }

  }

  public static void main(String[] args) {
    checkAge(20); // Call the checkAge method and pass along an age of 20
  }
} */ // theres also this