public class RecordPattern {

    record User(String firstName, String lastName){}
    record ExtendedUser(String firstName, String lastName, Address address, Job job){}
    record Address(String city, String street, int streetNumber){}
    record Job(String jobTitle, String companyName){}

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

        Address address = new Address("city", "street", 1);
        Job job = new Job("developer", "Software Company");
        Object extendedUser = new ExtendedUser("firstName", "lastName", address, job);

        if (extendedUser instanceof ExtendedUser(String firstName, String lastName, Address(String city, String street, int streetNumber), Job(String jobTitle, String companyName))) {
            System.out.println("jobTitle: " + jobTitle);
        }

        if (extendedUser instanceof ExtendedUser u) {
            System.out.println("jobTitle: " + u.job.jobTitle);
        }

        printUserWithPatternMatchingSwitch(user);
        printUserWithPatternMatchingSwitch(extendedUser);

        printUserWithPatternMatchingSwitchLogic(user);
        printUserWithPatternMatchingSwitchLogic(extendedUser);

    }

    public static void printUserWithPatternMatchingSwitch(Object user) {
        switch (user) {
            case null -> throw new RuntimeException("No user");
            case User u -> System.out.println(u.firstName + " " + u.lastName);
            case ExtendedUser eu -> System.out.println("jobTitle: " + eu.job.jobTitle);
            default -> System.out.println("Default message");
        };
    }

    public static void printUserWithPatternMatchingSwitchLogic(Object user){
        switch (user) {
            case null -> throw new RuntimeException("No user");
            case User u when "firstName".equalsIgnoreCase(u.firstName) -> System.out.println("It's firstName");
            case User u when "anotherFirstName".equalsIgnoreCase(u.firstName) -> System.out.println("It's anotherFirstName");
            case ExtendedUser eu when "developer".equalsIgnoreCase(eu.job.jobTitle) -> System.out.println("It's a developer.");
            case ExtendedUser eu when "designer".equalsIgnoreCase(eu.job.jobTitle) -> System.out.println("It's a designer.");
            default -> System.out.println("Default message");
        };
    }

}


