class returnzz{

    static int checkAge(int age){
        return  5+ age;
       
    
        
    }
    
    










    public static void main(String[] args) {
        System.out.println("Hello! Ahh so you're already that old"+checkAge(12));
        
        
    }
    
}

/*Using format specifiers INSIDE a function (normal)
static void greet(String name, int age) {
    System.out.printf("Hello %s, you are %d years old%n", name, age);
}
greet("Axel", 19);

If by chance you wanna use format specifiers ykykyk

Also if you have a value to return you dont need to use void anymore,
or even public cuz just the main needs to be in public.
btw you need to declare the data type of your method
cuz yeah dk why u just have to
You can also store the result in a variable (recommended, as it is easier to read and maintain):
int z = myMEthod(5,4)
System.out.println(z)

Using a for loop yeah self-explanatory
public class Main {
  // Method that doubles the number
  static int doubleGame(int x) {
    return x * 2;
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 5; i++) {
      System.out.println("Double of " + i + " is " + doubleGame(i));
    }
  }
}
*/