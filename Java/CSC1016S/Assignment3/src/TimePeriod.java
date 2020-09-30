/**
 * A TimePeriod is a Duration range. It has an inclusive lower bound, l, and an exclusive upper bound, u.
 * A Duration, d, falls within the range if l<=d<u.
 *
 * @author : Yolisa Pingilili
 */

public class TimePeriod {

    private final Duration lowerBound;
    private final Duration upperBound;


    public TimePeriod(Duration lowerBound, Duration upperBound){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Duration lowerBound(){
        return this.lowerBound;
    }

    public Duration upperBound(){
        return this.upperBound;
    }

    /**
     * Determine whether the given duration falls within this time period i.e. whether
     *  lowerBound()≤duration<upperBound().
     */
    public boolean includes(Duration duration){
        return lowerBound().compareTo(duration) <= 0
                && duration.compareTo(upperBound()) < 0;
    }

    /**
     * Determine whether this time period precedes the other time period i.e. whether
     * this.upperBound()≤other.lowerBound().
     */
    public boolean precedes(TimePeriod other){
        return upperBound().compareTo(other.lowerBound()) <= 0;
    }

    /**
     *  Determine whether this time period is adjacent to the other time period i.e. whether
     *  this.upperBound() is equal to other.lowerBound(), or this.lowerBound() is equal to other.upperBound()
     */
    public boolean adjacent(TimePeriod other){
        return upperBound().compareTo(other.lowerBound()) == 0
                || lowerBound().compareTo(other.upperBound()) == 0;
    }

    public String toString(){
        return "[" + Duration.format(lowerBound(), TimeUnit.MINUTE)
                + " .. " + Duration.format(upperBound(), TimeUnit.MINUTE) + "]";
    }

}
