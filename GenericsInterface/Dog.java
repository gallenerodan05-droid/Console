public class Dog  extends     Pet{

    private  final  String sound;

    


    public Dog( String name,String sound){
      
      super(name,"Pet");
      
      this.sound = sound; 


    }

   
    
  
  
    @Override
      public  String Speak(){return name + " says: " + sound ;
        }   
}
