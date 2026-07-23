package Todolist;
public  class  TasknotFoundException extends  Exception{

    public TasknotFoundException(int index) {

        super("No index found at" + index );

    }

    

}