public class Bird implements  Animal{
String name;
String type;


public Bird(String name, String type ){
    this.name = name;
    this.type = type;
    
}


@Override
public String Speak(){

    return  name+ ": " + "Kaka";
}

@Override
public String getType(){

    return    type  ;
}

@Override
public String getName(){

    return  name;

}



}