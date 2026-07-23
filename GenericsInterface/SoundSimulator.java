
import java.util.Scanner;



public class  SoundSimulator {
    private  final static  Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        // Animal bird = new Bird("MichaelAngelo","Bird");
        // Animal dog = new Dog("Dog", "Woof");
        // Animal fish = new Fish("Fish", "Pet");
        
        Shelter<Animal> sheltered = new Shelter<>();
        
        sheltered.addAnimal(new Dog("Dog", "Woof"));

        sheltered.addAnimal(new Fish("Fish","Pet"));
        
        // sheltered.makeSound();

        sheltered.listAnimals();


        int index = scanner.nextInt();

        
        sheltered.adopt(index);
        

        


    }

















    
}