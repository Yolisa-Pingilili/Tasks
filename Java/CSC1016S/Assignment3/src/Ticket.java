/**
 * A Ticket object represents a car park ticket. It has a unique ID and time of issue(24 hour clock)
 * 
 * @author : Yolisa Pingilili
 */

public class Ticket{
   private String id;
   private Time issueTime;

   //Create a new Ticket that has the given issue time and a unique ID.
   public Ticket(Time currentTime, String ID){
      this.id = ID;
      this.issueTime = currentTime;
   }
   
   //Obtain this Ticket's ID.
   public String ID(){
      return this.id;
   }
   
   //Obtain this Ticket's age
   //i.e issue time subtracted from the given(current) time.
   public Duration age(Time currentTime){
      return currentTime.subtract(issueTime);
   }
   
   //Obtain a string representation of this Ticket object in the form:
   //"Ticket[id="this tickets's unique ID", time="this ticket's time of issue(hh:mm:ss)"]"
   public String toString(){
      return "Ticket[id="+this.id+", time="+ this.issueTime.toString()+"]";
   }
}
