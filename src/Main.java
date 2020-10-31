import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter strings");
        Scanner in = new Scanner(System.in);

        String string1 = in.nextLine();
        String string2 = in.nextLine();
        in.close();

        if(string1.length() == string2.length()){
            executeArraySolution(string1, string2);
            executeMapSolution(string1, string2);
        } else {
            System.out.println("Strings are not identical");
        }

    }

    private  static void executeArraySolution(String string1, String string2) {

        long timeStart = System.currentTimeMillis();

        char[] strToArray1 = string1.toCharArray();
        char[] strToArray2 = string2.toCharArray();

        Arrays.sort(strToArray1);
        Arrays.sort(strToArray2);

//          System.out.println(Arrays.equals(strToArray1, strToArray2) ? "Identical strings" : "Strings are not identical"); - есть такой способ вывода результата.

        if (Arrays.equals(strToArray1, strToArray2)) {
            System.out.println("Identical strings");
        } else {
            System.out.println("Strings are not identical");
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Time = " + (timeEnd - timeStart));

    }

    private static void executeMapSolution(String string1, String string2) {

        long timeStart = System.currentTimeMillis();

        Map<Character, Integer> map = new HashMap<>();

        int a = string1.length();


        for (int i = 0; i < a; i++) {
            map.merge(string1.charAt(i), 1, (x, y) -> x + y);
            map.merge(string2.charAt(i), -1, (x, y) -> x + y);
        }

        Set<Integer> set = new HashSet<>(map.values());
        long timeEnd = System.currentTimeMillis();
        System.out.println(set.size() == 1 && set.contains(0) ? "Identical" : "Not identical");
        System.out.println("Time = " + (timeEnd - timeStart));
    }
}
