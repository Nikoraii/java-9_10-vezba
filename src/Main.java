import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Integer> lista = new ArrayList<>();
        fibonacciSequence(lista, 1);
        printList(lista, 2);
        lista = new ArrayList<>();
        fibonacciSequence(lista, 15);
        printList(lista, 3);
        inputOddNumbers(lista);
        printList(lista, 7);
//
        System.out.println("Poslednji neparan broj je: " + lastOdd(lista));
        System.out.println("Najveci broj deljiv sa 5 je: " + maxMod5(lista));
        System.out.println("Suma parnih brojeva iznosi: " + sumEven(lista));
        ArrayList<Integer> listaParnih = listModN(lista, 2);
        printList(listaParnih, 2);
    }

    public static void inputOddNumbers(ArrayList<Integer> nums) {
        Scanner scan = new Scanner(System.in);
        String num;

        System.out.println("Unesite neparne brojeve: ");
        num = scan.nextLine();
        num = num.toLowerCase(Locale.ROOT);
        while(!num.equals("stop") && !num.equals("prekid")) {
            if (Integer.parseInt(num) % 2 == 0) {
                System.out.println("Paran broj nece biti dodat u listu");
            } else {
                nums.add(Integer.parseInt(num));
            }
            num = scan.nextLine();
            num = num.toLowerCase(Locale.ROOT);
        }
    }

    public static void fibonacciSequence(ArrayList<Integer> nums, int n) {
        if (n >= 1)
            nums.add(0);
        if (n > 1)
            nums.add(1);
        for (int i = 2; i < n; i++) {
            int next = nums.get(i - 1) + nums.get(i - 2);
            nums.add(next);
        }
    }

    public static int lastOdd(ArrayList<Integer> nums) {
        int lastOdd = -1;
        for (int num: nums) {
            if (num % 2 != 0) {
                lastOdd = num;
            }
        }
        return lastOdd;
    }

    public static int maxMod5(ArrayList<Integer> nums) {
        int max5 = -1;
        for (int num: nums) {
            if (num > max5 && num % 5 == 0)
                max5 = num;
        }
        return max5;
    }

    public static int sumEven(ArrayList<Integer> nums) {
        int sum = 0;
        for (int num: nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static ArrayList<Integer> listModN(ArrayList<Integer> nums, int n) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int num: nums) {
            if (num % n == 0) {
                newList.add(num);
            }
        }
        Collections.sort(newList);
        Collections.reverse(newList);
        return newList;
    }

    public static void printList(ArrayList<Integer> nums, int n) {
        int i;
        int brojac = n;
        for (i = 0; i < nums.size() - 1; i++) {
            if (i == brojac) {
                System.out.println();
                System.out.print(nums.get(i) + ", ");
                brojac += n;
            } else {
                System.out.print(nums.get(i) + ", ");
            }
        }
        if (i == brojac)
            System.out.println();
        System.out.println(nums.get(i));
    }
}