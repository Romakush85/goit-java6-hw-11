import java.util.stream.Stream;

public class LinearCongruentGenerator {

    public static Stream<Long> lounchGenerator(Long a, Long c, Long  m, Long  seed) {
        Stream<Long> result = Stream.iterate(seed, i -> (a * i + c) % m);
        return result;
    }

}
