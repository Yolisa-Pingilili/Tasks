/**
 * A Register stores a collection of Tickets
 * A Ticket may be retrieved given its ID
 * 
 * @author : Yolisa Pingilili
 */

public class Register{
   private Ticket[] tickets;
   private int numTickets;
   
   //create a new Register object
   public Register(){
      tickets = new Ticket[100];
      numTickets = 0;
   }
   
   /**
    * store the given ticket in the register
    * append to the end of the register
    */
   public void add(Ticket ticket){
      tickets[numTickets] = ticket;
      numTickets++;
   }
   
   /**
    * determine whether or not a ticket with the given id
    * exists in the collection
    * because this is a partially filled array, use numTickets(contains highest index)
    * instead of tickets.length
    */
   public boolean contains(String ticketID){
      for(int i = 0; i<numTickets; i++){
         if(tickets[i].ID().equals(ticketID))
            return true;
      }
      return false;
   }

   /**
    * retrieve the ticket with the given ticketID
    * because this is a partially filled array, use numTickets(contains highest index)
    * instead of tickets.length
    */
   public Ticket retrieve(String ticketID){
      Ticket rTicket=null;
      for(int i = 0; i<numTickets; i++){
         if(tickets[i].ID().equals(ticketID)){
            rTicket = tickets[i];
            // return rTicket;
         }
      }
      return rTicket;
   }
}
