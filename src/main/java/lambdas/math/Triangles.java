package lambdas.math;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Triangles {
    public static void main(String[] args) {

        List<List<Double>> inputData = asList(asList(2d, 3d, 4d), asList(3d, 4d, 5d));
        Stream<Double> stream = inputData.stream().map(triangle -> {
            double halfPerimeter = triangle.stream().reduce(0d, Double::sum) / 2;
            double operand = triangle.stream().mapToDouble(переменная -> halfPerimeter - переменная).reduce(halfPerimeter, (a, b) -> a * b);
            return Math.sqrt(operand);
        });
        System.out.println("For triangles with side lengths of:");
        System.out.println(inputData);
        System.out.println("Triangle squares are:");
        stream.forEach(System.out::println);
        System.out.println();
    }
}
