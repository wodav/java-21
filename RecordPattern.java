public class RecordPattern {

    record User(String firstName, String lastName){}

    public static void main(String[] args) { 

        String object = "Hello Record Pattern";
    
        if (object instanceof String text) {
            System.out.println(text);
        }

        Object user = new User("firstName","lastName");

        if(user instanceof User u){
            System.out.println(u.firstName + " " + u.lastName);
        }

        if(user instanceof User(String firstName, String lastName)){
            System.out.println(firstName + " " + lastName);
        }
    }

}


