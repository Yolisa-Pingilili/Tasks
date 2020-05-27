// program to output the multipication table between 2 integers
import java.util.Scanner;

public class multiplicationTable{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the base value:");
        int base = input.nextInt();
        
        System.out.println("Enter the end value:");
        int end = input.nextInt();

        multiply(base, end);

    }

    public static void multiply(int startValue, int endValue){
        System.out.print("       n");//seven spaces.
        for(int i=startValue; i<=endValue; i++){
            System.out.print(String.format("%8d", i));
        }
        System.out.println();
        System.out.println();
        
        for(int i=1; i<=15; i++){
            System.out.print(String.format("%8d", i));
            for(int j=startValue; j<= endValue; j++){
                System.out.print(String.format("%8d", i*j));
            }
            System.out.println();
        }
    }
}
