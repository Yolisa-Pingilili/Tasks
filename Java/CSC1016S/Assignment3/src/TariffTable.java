import java.lang.IllegalArgumentException;


/**
 * A TariffTable records parking tariffs for a pay-to-stay car park.
 *
 * @author : Yolisa Pingilili
*/

public class TariffTable{
    private ParkingTariff[] table;
    private int numTariff;

    public TariffTable(int maxSize){
        table = new ParkingTariff[maxSize];
        numTariff = 0;
    }

    /**
     *  Add the tariff for the given period to the table. The period must directly follow, and be
     *  adjacent to, that for the previous tariff entered.
     *   If the period does not follow or is not adjacent then an IllegalArgumentException is thrown.
     */
    public void addTariff(TimePeriod period, Money tariff){
        if(table[this.numTariff] == null){
            table[numTariff] = new ParkingTariff(period, tariff);
            numTariff++;
        }                                                                           
        else if(table[numTariff-1].getTimePeriod().precedes(period) && table[numTariff-1].getTimePeriod().adjacent(period)){
            table[numTariff] = new ParkingTariff(period, tariff);
            numTariff++;
        }
        else{
            throw new IllegalArgumentException("Tariff periods must be adjacent.");
        }
    }

    // Obtain the tariff for the given length of stay.
    public Money getTariff(Duration lengthOfStay){
        Money money = null;
        for(int i=0; i<numTariff; i++){
            if(table[i].getTimePeriod().includes(lengthOfStay)){
                money = table[i].getMoney();
            }
        }
        return money;
    }

    /**
     * Obtain a String representation of this TariffTable in the form:
     *  <period 0> : <tariff 0>
     *  ...
     *  <period n> : <tariff n>
     */
    public String toString(){
        String str = "";
        for (int i = 0; i<numTariff; i++) {
            if(i<numTariff-1) {
                str += table[i].toString()+"\n";
            }
            else {
                str += table[i].toString();
            }
        }
        return str;
    }
}
