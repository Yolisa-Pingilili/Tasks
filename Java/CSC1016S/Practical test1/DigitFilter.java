/**
 * A DigitFilter obect is used to extract, one-by-one, the numbers embedded in a string
 * e.g. given "6432dhe236s7s", the digits 6, 4, 3, 2, 2, 3, 6 and 7 may be extracted.
 * 
 * @author: Yolisa Pingilili
 */

public class DigitFilter{

    private String string;
    private int current;

    DigitFilter(String s){
        this.string = s.replaceAll("[^0-9]", "");
        this.current = 0;
    }

    public boolean hasNext(){
        boolean flag = false;
        if(current<this.string.length()){
            flag = true;
        }
        return flag;
    }

    public int nextDigit(){
        char digit = ' ';
        if(this.hasNext()){
            digit = string.charAt(current);
            current++;
        }

        return Integer.parseInt(Character.toString(digit));
    }
}
