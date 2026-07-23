
import java.util.ArrayList;

public class Shelter< T extends  Animal>  {


    private  final  ArrayList<T > animals = new ArrayList<>();

    


    public void  addAnimal(T animal){

            animals.add(animal);
            
    }


    public T getAnimal(int index){

            
           return animals.get(index);

        
    }
   

    public void makeSound(){
        
    // System.out.println(animal.Speak());

    if(animals.isEmpty() ){
        System.out.println("There are no animals.");
        return;
    }
    for(T animal: animals ){
        System.out.println(animal.Speak());

    }
}


public void listAnimals( ){
    if(animals.isEmpty() ){
        System.out.println("There are no animals.");
        return;
    }
    for(int i= 0;i< animals.size(); i++){
        System.out.println( i +" "+animals.get(i).getName() );
    }
}

public void adopt(int index ){


   T shuwa =  animals.remove(index);
   
    System.out.println("You have removed " + shuwa.getName());

}
    
    





    

    
}


/* That last part is the key — T extends Animal means "blank until filled, but it must be an Animal." Bounded generics. It ties everything together because without interfaces and abstract classes, the generic bound has nothing to point at.
The CLI would let you:

Add animals to the shelter
List all animals and hear them speak
Adopt (pop) one out */