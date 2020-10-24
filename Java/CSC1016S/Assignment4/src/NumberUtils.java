/**
 * contains a collection of methods for working with integers
 *
 * @author : Yolisa Pingilili
 */

public class NumberUtils {

    private NumberUtils(){}

    /**
     * given an integer that is n digits in length, maps the integers into an array
     * @param number number to be mapped
     * @return an array of digits mapped from number
     */
    public static int[] toArray(int number){
        int[] array = new int[Integer.toString(number).length()];
        String[] temp = Integer.toString(number).split("");
        for(int i =0; i<array.length; i++){
            array[i] = Integer.parseInt(temp[i]);
        }
        return array;
    }

    /**
     * given 2 numbers, count the number of matching digits - those with the same value and index
     * example: given 39628 & 79324, the matching digits are x9xx2x.
     * It is assumed that the numbers are the same length and have no repeating digits
     * @return how many matching integers there are
     */
    public static int countMatches(int numberA, int numberB){
        int[] firstSet = toArray(numberA);
        int[] secondSet = toArray(numberB);
        int temp = 0;
        for(int i = 0; i<firstSet.length; i++){
           if(firstSet[i] == secondSet[i]){
               temp++;
           }
        }
        return temp;
    }

    /**
     * count the number of digits that 2 numbers have in common, regardless of position
     * @return how many matching integers there are
     */
    public static int countIntersect(int numberA, int numberB){
        int[] firstSet = toArray(numberA);
        int[] secondSet = toArray(numberB);
        int temp = 0;
        for (int item : firstSet) {
            for (int value : secondSet) {
                if (item == value) {
                    temp++;
                }
            }
        }
        return temp;
    }

}
