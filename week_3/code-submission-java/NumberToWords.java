import java.util.Scanner;
public class NumberToWords {

    private static final String[] single = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] doubles = {"","ten","twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] ten_power = {"hundred","thousand"};



    private static final int[] a = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] r = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public static String intToWords(int num) {
		//Write your code here
        if (num == 0) {
            return "zero";
        }

        StringBuilder wordsResult = new StringBuilder();

        if (num >= 1000) {
            wordsResult.append(single[num / 1000]).append(" ").append(ten_power[1]).append(" ");
            num %= 1000;
        }

        if (num >= 100) {
            wordsResult.append(single[num / 100]).append(" ").append(ten_power[0]).append(" ");
            num %= 100;

            if (num != 0) {
              wordsResult.append("and ");
            }
        }

        if (num >= 20) {
            wordsResult.append(doubles[num / 10]).append(" ");
            num %= 10;
        }

        if (num > 0) {
            wordsResult.append(single[num]);
        }

        return wordsResult.toString().trim();
    }

    public static String intToRoman(int num) {
       //Write your code here 
       StringBuilder result = new StringBuilder();
       
       while (num > 0) {
        int count = -1;
        for (int i = 0; i < a.length; i++) {
          if (num >= a[i]) {
            count = i;
          }
        }
        int x = num/a[count];

        for (int j=0; j<x; j++) {
          result.append(r[count]);
          num -= a[count];
        }
       }
       return result.toString();
    }

    public static void main(String[] args) {
		//Write your code here 
    Scanner scanner = new Scanner (System.in);
    boolean run = true;
    while (run == true) {
      System.out.print("Number: ");
      int num = scanner.nextInt();
      if (num == -1) {
        run = false;
        }
      
      else {
        String roman_numeral = intToRoman(num);
        String written_num = intToWords(num);
        System.out.println("In Words: " + written_num);
        System.out.println("In Roman: " + roman_numeral);
      }
    }
    System.out.println("Done");
	}
}
