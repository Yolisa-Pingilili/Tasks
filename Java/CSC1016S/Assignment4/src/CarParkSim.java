import java.util.Scanner;
/**
 * Write a description of class CarParkSimSolution here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarParkSim {
    
    private CarParkSim() {}

    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        final Clock clock = new Clock(new Time("00:00:00"));
        final Register register = new Register();
        Currency rand = new Currency("R", "ZAR", 100);
        TariffTable tariffTable = new TariffTable(10);
        //populate the TariffTable object
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.MINUTE,0), new Duration(TimeUnit.MINUTE,30)), new Money("R10.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.MINUTE,30), new Duration(TimeUnit.HOUR,1)), new Money("R15.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,1), new Duration(TimeUnit.HOUR,3)), new Money("R20.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,3), new Duration(TimeUnit.HOUR,4)), new Money("R30.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,4), new Duration(TimeUnit.HOUR,5)), new Money("R40.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,5), new Duration(TimeUnit.HOUR,6)), new Money("R50.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,6), new Duration(TimeUnit.HOUR,8)), new Money("R60.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,8), new Duration(TimeUnit.HOUR,10)), new Money("R70.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,10), new Duration(TimeUnit.HOUR,12)), new Money("R90.00", rand));
        tariffTable.addTariff(new TimePeriod(new Duration(TimeUnit.HOUR,12), new Duration(TimeUnit.DAY,1)), new Money("R100.00", rand));


        System.out.println("Car Park Simulator");
        System.out.printf("The current time is %s.\n", clock.examine());
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                clock.advance(new Duration("minute", keyboard.nextInt()));  
                System.out.printf("The current time is %s.\n", clock.examine());
            }
            else if (input.equals("arrive")) {
                final Ticket ticket = new Ticket(clock.examine(), UIDGenerator.makeUID());
                register.add(ticket);
                System.out.printf("Ticket issued: %s.\n", ticket);
            }
            else if(input.equals("tariffs")){
                System.out.println(tariffTable);
            }
            else if (input.equals("depart")) {
                final String ID = keyboard.next();
                if (!register.contains(ID)) {
                    System.out.println("Invalid ticket ID.");
                }
                else {
                    final Ticket ticket = register.retrieve(ID);
                    System.out.printf("Ticket details: %s.\n", ticket);
                    System.out.printf("Current time: %s.\n", clock.examine());
                    final Duration durationOfStay = ticket.age(clock.examine());
                    Duration.format(durationOfStay, TimeUnit.MINUTE);
                    System.out.printf("Duration of stay: %s.\n", Duration.format(durationOfStay, "hour", "minute"));
                    System.out.printf("Cost of stay : %s.\n", tariffTable.getTariff(ticket.age(clock.examine())));
                }
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: tariffs, advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }
}
