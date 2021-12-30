import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        integers.add(24);
        integers.add(11);
        integers.add(8);
        integers.add(19);

        strings.add("Senior");
        strings.add("Remi");
        strings.add("Future");
        strings.add("Programmer");

        //Первое задание.
        System.out.println(search(integers, list -> list.indexOf(5)));
        //Второе задание.
        System.out.println((stringReverse(s -> new StringBuilder(s).reverse().toString(), "Everythng in your hands!")));
        //Третье задание.
        System.out.println(maxNumber(integers, list -> Collections.max(integers)));
        //Четвертое задание
        System.out.println(averageOfNumber(integers, list -> list.stream().mapToInt(number -> number).average().getAsDouble()));
        //Пятое задание.
        System.out.println("Amount of the same word - " + searchWord(strings, list -> String.valueOf(strings.stream().filter(x -> x.length() == 3).count())));

        System.out.println(searchWord(strings, list -> {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i).length() == 3) && (list.get(i).charAt(0) == 'a')) {
                }
            }
            return String.valueOf(result);
        }));
    }
    //Метод первого заданиу.
    public static Integer search(List<Integer> number, Function<List<Integer>, Integer> function) {
        return function.apply(number);
    }

    //Ветод второго заданиу.
    public static String stringReverse(UnaryOperator<String> unaryOperator, String s) {
        return unaryOperator.apply(s);
    }

    //Метод третьего задание.
    public static Integer maxNumber(List<Integer> maxNumber, Function<List<Integer>, Integer> function) {
        return function.apply(maxNumber);

    }

    //Метод четвертого задание.
    public static Double averageOfNumber(List<Integer> avarageOfNumber, Function<List<Integer>, Double> function) {
        return function.apply(avarageOfNumber);
    }

    //Метод пятого задание.
    public static String searchWord(List<String> list, Function<List<String>, String> function) {
        return function.apply(list);
    }

}
