/**
 * implements the logic for a cows and bulls guessing game
 *
 * @author : Yolisa Pingilili
 */

public class CowsAndBulls {

    public final static int NUM_DIGITS = 4;
    public final static int MAX_VALUE = 9876;
    public final static int MIN_VALUE = 1234;
    public final static int MAX_GUESSES = 10;

    private int bulls;
    private final int mysteryNumber;
    private int guessesRemaining;

    /**
     * create a CowsAndBulls object that has a mystery number that is NUM_DIGITS long
     * and give the user MAX_GUESSES
     * @param seed used for randomisation
     */
    public CowsAndBulls(int seed){
        bulls = 0;
        NumberPicker numberPicker = new NumberPicker(seed, 1, 9);
        StringBuilder track = new StringBuilder();
        for(int i =0; i<NUM_DIGITS; i++){
            track.append(numberPicker.nextInt());
        }
        guessesRemaining = CowsAndBulls.MAX_GUESSES;
        mysteryNumber = Integer.parseInt(track.toString());
    }

    public int guessesRemaining(){
        return guessesRemaining;
    }

    /**
     * evaluate a users guess, comparing it to the mystery number
     * @param guessNumber - user guess
     * @return the result of the comparison in the form of a result object
     *
     * countMatches and countIntersect do pretty much the same thing, this is because there s no logic
     * in place to prevent countIntersect from counting every number that matches (doing this causes problems)
     * so the solution is: since we know the number of cows and the supposed number of bulls
     * the difference between these two numbers should be the actual number of cows
     */
    public Result guess(int guessNumber){
        this.guessesRemaining--;
        this.bulls = NumberUtils.countMatches(guessNumber, this.mysteryNumber);
        return new Result(NumberUtils.countIntersect(guessNumber, this.mysteryNumber)-this.bulls, this.bulls);
    }

    // end the game, returning the mystery number
    public int giveUp(){
        this.bulls = 4;
        return mysteryNumber;
    }

    // is the game over?
    public boolean gameOver(){
        return this.bulls == 4 || guessesRemaining == 0;
    }

}
