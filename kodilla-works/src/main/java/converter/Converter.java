package converter;

import java.util.ArrayList;
import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {

        int binaryNumber;
        int resultNumber = 0;

        System.out.print("Podaj liczbe binarna: ");
        Scanner scanner = new Scanner(System.in);
        binaryNumber = scanner.nextInt();

        ArrayList<Integer> array = new ArrayList<>();
        do {
            array.add(binaryNumber % 10);
            binaryNumber /= 10;
        }while (binaryNumber > 0);

        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) == 1) {
                resultNumber += Math.pow(2,i);
            }
        }

        System.out.println(resultNumber);
    }
}


