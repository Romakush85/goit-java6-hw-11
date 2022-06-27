import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Andriy", "Ivan", "Pavlo", "Bohdan", "Iryna", "Maryna", "Tetyana", "Oksana");

//        TASK_1
        String names = namesList
                .stream()
                .map(s -> namesList.indexOf(s)%2 == 1 ? namesList.indexOf(s) + ". " + s : null)
                .filter(i -> i != null)
                .collect(Collectors.joining(", "));
        System.out.println(names);

//        TASK_2
        List<String> upperList = namesList
                .stream()
                .map(s -> s.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(upperList.toString());

//      TASK_3
        String[] testArr = {"1, 2, 0", "4, 5"};
        String numbers =
                Arrays.stream(testArr)
                .map(s -> s.split(", "))
                .flatMap(Arrays::stream)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(numbers);

//      TASK_4

        LinearCongruentGenerator.lounchGenerator(25214903L, 11L, 2^48L, 2L).limit(20).forEach(System.out::println);

//      TASK_5
        Stream<String> stream1 = Stream.of("Stay", "curious", "2", "4");
        Stream<String> stream2 = Stream.of("1", "Keep", "Pushing", "Or", "Die", "Trying");

        StreamZipper.zip(stream1,stream2).forEach(System.out::println);
    }




}
