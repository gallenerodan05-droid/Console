package phonebook;
public class back_end {

    private   String name;
    private  String phone;
    private  String email;

    public back_end(String name,String phone, String email ) {
        this.name = name;
        this.phone = phone;
        this.email = email;

    }

    public String getName(){
        return name;
    }

        public String getEmail(){
            return  email;
        }

        public String getPhone(){
            return  phone;
        }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone( String phone){
        this.phone = phone;
    }


    @Override
    public String toString(){
        return String.format("Name: %s | Email: %s | Phone Number: %s ", name,email,phone); //Lowkey its better this way. String.format()
    }

    

    




    
}

/*Features: Add contact (name, phone, email), view all, search by name or phone, delete, update existing contact.
New concepts: Searching by string (use .contains() or .equalsIgnoreCase()), editing an existing object in the ArrayList.
Bonus: Add validation (e.g., phone must be numbers only). */