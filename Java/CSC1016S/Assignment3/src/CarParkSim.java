import java.util.Scanner;
/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and Yolisa Pingilili
 * @version 14/7/2019
 */
public class CarParkSim {
        
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        // YOUR CODE HERE.
        // Declare variables to store a Clock and a Register object, create the relevant objects and assign them.
        Clock clock = new Clock(new Time("00:00:00"));
        Register register = new Register();
        
        System.out.println("Car Park Simulator");
        // YOUR CODE HERE.
        // Print current time.
        System.out.println("The current time is "+clock.examine()+".");
        System.out.println("Commands: advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                // YOUR CODE HERE.
                // Advance the clock, print the current time.
                clock.advance(new Duration("minute", keyboard.nextInt()));
                System.out.println("The current time is "+clock.examine()+".");
            }
            else if (input.equals("arrive")) {
                // YOUR CODE HERE.
                // Create a new ticket, add it to the register, print details of ticket issued.
                Ticket ticket = new Ticket(clock.examine(), UIDGenerator.makeUID());
                register.add(ticket);
                System.out.println("Ticket issued: "+ticket+".");
            }
            else if (input.equals("depart")) {
                // YOUR CODE HERE.
                // Determine if ticket is valid, i.e. in the register.
                // If not, print error message.
                // If yes, retrieve it, calculate duration of stay and print it.
                String temp = keyboard.next().strip();
                if(register.contains(temp)){
                    Ticket retrieved = register.retrieve(temp);
                    System.out.printf("Ticket details: %s.\n", retrieved.toString());
                    System.out.printf("Current time: %s.\n", clock.examine());
                    System.out.printf("Duration of stay: %s.\n", Duration.format(retrieved.age(clock.examine()), TimeUnit.HOUR, TimeUnit.MINUTE));
                }else{ System.out.println("Invalid ticket ID."); }
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
