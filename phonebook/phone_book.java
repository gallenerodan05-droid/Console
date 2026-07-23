package phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class phone_book {

    static  ArrayList<back_end> lists = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {


            System.out.println("1. Add Contact: ");
            System.out.println("2. View Contacts");
            System.out.println("3. Search by Name or Phone");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Existing Contact");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> AddContact();
                case 2 -> ViewContacts();
                case 3 -> Search();
                case 4 -> DeleteContact();
                case 5-> Update(); 
                case 6->{System.out.print("Goodbye"); System.exit(0);}
                default-> System.out.println("Invalid Choice. \nPLease Try Again");
            }
            
        }


        
        
    }
    
    static void AddContact(){
        System.out.print("Welcome!!");
        
        String name;        

        while(true){
            scanner.nextLine();
            name = scanner.nextLine().trim();
            System.out.print("\nEnter Name: ");

        if(name.isEmpty() || name.matches(".*\\d+.*")){
        System.out.println("Must not contain digits and must not be empty!");

        }
       else{
     break;   }

        
        
 

        }


        String phone;
        while(true){

        System.out.print("Enter Phone NUmber: ");
        phone = scanner.nextLine().trim();

            if (phone.isEmpty() || !phone.matches("\\d+")){
            System.out.println("You did not enter anything");
        }
        else if (phone.length() != 11){
            System.out.println("Must be only 11 digits!");
        }


        else{
            break;
        }

        }

        String email;

        while (true) { 
        System.out.print("Enter email: ");
        email = scanner.nextLine().trim();

        if(email.isEmpty() || email.matches("\\d+")){


            System.out.print("\nMust not be all number and must not be empty");
        }
        else if(!email.contains("@")  || !email.contains(".")){
            System.out.println("Must contain  @ and . " );
        }

        else{
            break;
        }
            
        }

        lists.add(new back_end(name, phone, email));
        System.out.println("Succesfully Added!");

   
    /*Why not String name = scanner.nextLine() on the same line as
             the declaration? Because the loop needs to be able to re-ask and
              re-assign name on each failed attempt. If you read the input at
               declaration time (before the loop), you'd only get one chance to
                read it, and you'd have to restructure the whole logic.Just so it could be reused. */

   
    }

static  void ViewContacts(){

    if( lists.isEmpty()){

        System.out.println("You have no contacts!");
        return;
    }

     System.out.println("\n--------Contacts-----------");
    for(back_end contactsz : lists ){
        
        System.out.println(contactsz);}}

        
        


static  void Search(){

    System.out.print("Search contact: ");
    String contact = scanner.nextLine().trim();

    boolean found =  false;

    for(back_end contactsz : lists ){
        if (contactsz.getName().toLowerCase().contains(contact) || contactsz.getPhone().equals(contact)){
            System.out.println(contactsz);
            found = true;

        }
 }
 
 if(!found){
        System.out.println("There is nothing here.");
        System.out.println("No contacts.");}
        
        }



static  void DeleteContact(){


    System.out.print("Enter Contact to delete: ");
    scanner.nextLine();
    String delete = scanner.nextLine();

    for(back_end to_delete: lists){
        if(to_delete.getName().equals(delete)){
            lists.remove(to_delete);
            System.out.println("Contact Removed.");
            return;
            //return =  Exits the method immediately after deletion to prevent a ConcurrentModificationException crash and skip the "not found" message.

        }
    }
}


static  void Update(){

    ViewContacts();
    System.out.print("Enter contact to update: ");
    scanner.nextLine();
    String contacy = scanner.nextLine();

    for(back_end contact :lists ){

        if(contact.getName().equals(contacy)  ){
            System.out.println(contact);

            System.out.print("Enter new name: ");
            String new_name = scanner.nextLine().trim();

            System.out.print("Enter new Phone: ");
            String new_phone = scanner.nextLine();


            System.out.print("Enter new email: ");
            scanner.nextLine();
            String new_email = scanner.nextLine();

            contact.setName(new_name);
            contact.setEmail(new_email);
            contact.setPhone(new_phone);
            System.out.println("Successfully added new contact.");
            System.out.println(contact);
      }
    }



}




 





}








/*Features: Add contact (name, phone, email), view all, search by name or phone, delete, update existing contact.
New concepts: Searching by string (use .contains() or .equalsIgnoreCase()), editing an existing object in the ArrayList.
Bonus: Add validation (e.g., phone must be numbers only). */









    




