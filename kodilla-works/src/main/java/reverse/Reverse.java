package reverse;

import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) {

        System.out.println(reverseInt( 17868));
        System.out.println(reverseNumber(17868));
    }

    public static int reverseInt(int number) {

        ArrayList<Integer> array = new ArrayList<>();
        do {
            array.add(number % 10);
            number /= 10;
        }while (number > 0);

        int newNumber = 0;
        for(int i = 0; i < array.size(); i++) {
            newNumber += array.get(i) * Math.pow(10, array.size() - i -1);
        }



        return newNumber;
    }


    //lub inne rozwiazanie
    public static int reverseNumber(int number){
        int reverse = 0;
        while(number != 0){
            reverse = (reverse*10)+(number%10);
            number = number/10;
        }
        return reverse;
    }

}


