

public class Fish extends    Pet  {

    


    public Fish(String name,String type) {
        super(name,type);


    }   

    @Override
    public String Speak(){

        return   name + " say: ... " ;
    }
    








}
//Cannot refer to an instance field name while explicitly invoking a constructor
//reference to name may only appear after an explicit constructor invocation