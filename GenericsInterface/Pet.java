public   abstract  class  Pet implements  Animal{


    protected  String name;
    protected  String type;

    public Pet(String name,String type ) {
        this.name = name;
        this.type = type;
    } 

    @Override
     public  String  getName(){
        return  name;
     }

    @Override
     public String getType(){
        return  type;
     }

    
     

     

    


    

}