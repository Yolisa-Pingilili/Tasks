/**
 * A ParkingTariff object will be a composed of a TimePeriod object and its suitable Money object.
 * This solution of creating a ParkingTariff object is implemented because it is a better solution
 * than just having 2 arrays in the TariffTable class, one for TimePeriod objects and another for Money objects,
 * where the TimePeriod at array index i in the first array will correspond with the Money object at index i in the second array.
 *
 * @author : Yolisa Pingilili
 */

public class ParkingTariff {

    private Money money;
    private TimePeriod timePeriod;

    public ParkingTariff(TimePeriod timePeriod, Money money){
        this.money = money;
        this.timePeriod = timePeriod;

    }

    public void setMoney(Money money){
        this.money = money;
    }
    public Money getMoney(){
        return this.money;
    }

    public void setTimePeriod(TimePeriod timePeriod){
        this.timePeriod = timePeriod;
    }

    public Duration getLowerBound(){
        return this.timePeriod.lowerBound();
    }
    public Duration getUpperBound(){
        return this.timePeriod.upperBound();
    }
    public TimePeriod getTimePeriod(){
        return new TimePeriod(getLowerBound(), getUpperBound());
    }

    /**
     * Obtain a String representation of this ParkingTariff in the form:
     * "TimePeriod : Money"
     */
    public String toString(){
        return getTimePeriod().toString()+ " : " + getMoney().toString();
    }

}
