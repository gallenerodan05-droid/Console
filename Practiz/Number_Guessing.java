import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
//Chatgpt rated this 7/10 
/*Category	Score
Logic	9/10
Understanding of concepts	8/10
Code structure	6/10
Efficiency	5/10
Error handling	8/10

Final score:

⭐ 7.8 / 10 howa */
// This does not have Code Reusability, cuz yeah repeatdely used exactly the same code with just minor changes!! umay.
// I did not implement Abstracction(showing only necessary components and hiding implementation details).
//  case 1 -> playRound(10,10) i could have done this/ sum all the 3 methods into one. But my dumbass just had to make all three of them.
// I must follow the coding principles!! D.R.Y = do not repeat yourself.

public class  Number_Guessing{
     static   Random random =  new Random();
       static Scanner scanner = new Scanner(System.in);
   final   static   int number =  random.nextInt(10)+ 1 ;
       final static int number2 =  random.nextInt(50)+ 1 ;
     final static    int number3 =  random.nextInt(100)+ 1 ;

    static    int attempts = 5;
     static    int score = 0;
     static   int rounds = 1;


    public static void main(String[] args) {
    




        while(true){
           
                
                
              try{  switch(rounds){
                    case 1-> Round1();
                    case 2-> Round2();
                    case 3-> Round3();
                    case 4-> System.exit(0);

                    default -> {System.out.println("Invalid");}


            }
            }

  catch( InputMismatchException e){
    System.out.println("Invalid Input! Please enter a number." );// Users shoult not see raw exception messages LOL
    scanner.nextLine();


}
        catch(Exception e){
    System.out.println(e);
}



            
     
}


        








        
    }
    static void Round1(){

        System.out.println("Enter number from 1-10!");
        System.out.println("Current Score: " + score);
        System.out.println("Attempts: " + attempts);


        int user_input = scanner.nextInt();
        scanner.nextLine();

        if(attempts ==0){
            System.out.println("You ran out of attempts!");
            System.exit(0);
          
        }



        if( user_input == number ){
            score++;
            System.out.printf("Well Done! \nThe random number was: %d", number);
            System.out.println("\nYour attempts: " + attempts);
            System.out.println("Your score: " + score);
            rounds++;
            attempts+=10;         
         
        }




        else if( user_input > number){
            attempts--;
            System.out.println("Your attempts: " + attempts);
            System.out.println("Too High");


        }


        else{
            attempts--;
            System.out.println("Too Low");
        }
}


 static void Round2(){

        System.out.println("Enter number from 1-50!");
        System.out.println("Current Score: " + score);
        System.out.println("Attempts: " + attempts);


        int user_input = scanner.nextInt();
        scanner.nextLine();

        if(attempts ==0){
            System.out.println("You ran out of attempts!");
          
        }



        if( user_input == number2 ){
            score++;
            System.out.printf("Well Donescore! \nThe random number was: %d", number2);
            System.out.println("\nYour attempts: " + attempts);
            System.out.println("\nYour score: " + score);
            rounds++;
            attempts+=20;
         
         
        }




        else if( user_input > number2){
            attempts--;
            System.out.println("Your attempts: " + attempts);
            System.out.println("Too High");


        }


        else{
            attempts--;
            System.out.println("Too Low");
        }
}
 static void Round3(){

        System.out.println("Enter number from 1-100!");
        System.out.println("Current Score: " + score);
        System.out.println("Attempts: " + attempts);


        int user_input = scanner.nextInt();
        scanner.nextLine();

        if(attempts ==0){
            System.out.println("You ran out of attempts!");
            System.exit(0); //LMAO forgot this part 
          
        }



        if( user_input == number3 ){
            score++;
            System.out.printf("Well Done! \nThe random number was: %d", number3);
            System.out.println("\nYour attempts: " + attempts);
            System.out.println("Your score: " + score);
            rounds++;
         
         
        }




        else if( user_input > number3){
            attempts--;
            System.out.println("Your attempts: " + attempts);
            System.out.println("Too High");


        }


        else{
            attempts--;
            System.out.println("Too Low");
        }
}


}

/*Number Guessing Game
Computer picks random number 1-100. You guess, it says "too high/low". Track attempts & score.
Skills: Random class, while loops, conditionals.
Extend it: Multiple rounds, difficulty levels. */


/*static void playRound(int maxNumber, int rewardAttempts){

    int number = random.nextInt(maxNumber) + 1;

    System.out.println("Enter number from 1-" + maxNumber);

    int userInput = scanner.nextInt();
    scanner.nextLine();

    
}
    


Turns out, I must practice Code Reusability!


switch(rounds){
    case 1 -> playRound(10,10);
    case 2 -> playRound(50,20);
    case 3 -> playRound(100,0);
}






*/

/*static void playRound(int maxNumber, int rewardAttempts){

    int number = random.nextInt(maxNumber) + 1;

    while(attempts > 0){

        System.out.println("\nEnter number from 1-" + maxNumber);
        System.out.println("Attempts: " + attempts);
        System.out.println("Score: " + score);

        int userInput = scanner.nextInt();
        scanner.nextLine();

        if(userInput == number){

            score++;
            attempts += rewardAttempts;
            rounds++;

            System.out.println("Correct!");
            System.out.println("The number was: " + number);

            return;   // exits the method and goes back to main
        }

        else if(userInput > number){
            attempts--;
            System.out.println("Too high!");
        }

        else{
            attempts--;
            System.out.println("Too low!");
        }

    }

    // If loop ends → attempts reached 0
    System.out.println("You ran out of attempts!");
    System.exit(0);

} */