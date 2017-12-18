package task9_2_3_4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String [] args) {
        int size = 10;
        int from = 12;
        int to = 150;
        Integer[] array = new Integer[size];
        System.out.print("\nBefore sort: ");
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt((to - from) + from);
            System.out.print(array[i] + " ");
        }
        //Arrays.sort(array, Comparator.comparingInt(Integer::));
        Arrays.sort(array, (a, b) -> b - a);
        System.out.print("\nAfter sort: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        List<String> strings = new ArrayList<>();
        String[] stringsArray = {"abc", "yzs", "obpe",
                "ngldg", "pial", "rfgs", "eojg", "ngjwf"};

        System.out.print("\nBefore sort: ");
        for (String s : stringsArray) {
            strings.add(s);
            System.out.print(s + " ");
        }
        // Collections.sort(strings, (a, b) -> b.compareToIgnoreCase(a));
        Collections.sort(strings, ((Comparator<String>) String::compareToIgnoreCase).reversed());

        System.out.print("\nAfter sort: ");

        for (String s : strings) {
            System.out.print(s + " ");
        }

        System.out.print("\nAfter change: " + changeArray(array, a -> a % 3 == 0));

        System.out.print("\nAfter list change: ");
        for (String s : changeList(strings, s -> s.startsWith("e"))) {
            System.out.print(s + " ");
        }

        System.out.print("\nConverted to uppercase: ");
        StringConversion<String, String> convertToUppercase = String::toUpperCase;
        for (String string : strings) {
            System.out.print(convertToUppercase.convertString(string) + " ");
        }
    }

    public static long changeArray(Integer [] array, Predicate<Integer> matchPredicate){
        return Arrays.stream(array).filter(matchPredicate).count();
    }

    public static List<String> changeList(List<String> list, Predicate<String> matchPredicate){
        return list.stream().filter(matchPredicate).collect(Collectors.toList());
    }

    @FunctionalInterface
    public interface StringConversion<T, R> {

        R convertString(T t);

        static boolean exists(String s){
            return !s.equals(null);
        }
    }
}


