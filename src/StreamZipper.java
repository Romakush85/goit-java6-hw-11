import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamZipper {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        // create lists for reusing streams without Supplier
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        long firstLength = firstList.stream().count();
        long secondLength = secondList.stream().count();
        if(firstLength == 0 || secondLength == 0) throw new IllegalArgumentException("At least on of streams is empty");
        long minLength = firstLength <= secondLength ? firstLength : secondLength;
        return Stream.concat(firstList.stream(), secondList.stream()).limit(minLength * 2).parallel(); // use parralel() to get unordered stream
    }
}
