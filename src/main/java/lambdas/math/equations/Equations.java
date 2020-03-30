package lambdas.math.equations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Equations {
    public static void main(String[] args) {
        class Root {
            double a;
            double b;
            double c;
            double x1;
            double x2;
            boolean isComplex = false;

            public Root() {
            }

            public Root(double a, double b, double c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

            @Override
            public String toString() {
                if (isComplex) {
                    return "Equation :" +
                            a + "X^2 + " +
                            b + "X + " +
                            +c + "\n roots: X1 = " + x1 + " " + (x2 >= 0 ? "+ " + x2 : x2) + "i" + "\t X2 = " + x1 + " " + (x2 >= 0 ? "- " + x2 : "+ " + Math.abs(x2)) + "i \n";
                }
                if (x1 == x2) {
                    return "Equation :" +
                            a + "X^2 + " +
                            b + "X + " +
                            +c + "\n roots: X1 = X2 = " + x2 + "\n";
                }
                return "Equation :" +
                        a + "X^2 + " +
                        b + "X + " +
                        +c + "\n roots: X1 = " + x1 + "\t X2 = " + x2 + "\n";
            }
        }
        List<Root> roots = Stream.of(new Root(1, 4, 3), new Root(3, 6, 3), new Root(4, 5, 6)).collect(Collectors.toList());
        roots.stream().peek(root -> {
            double tempOperand = root.b * root.b - 4 * root.a * root.c;
            if (tempOperand > 0) {
                root.x1 = (-root.b + Math.sqrt(tempOperand)) / 2.0 / root.a;
                root.x2 = (-root.b - Math.sqrt(tempOperand)) / 2.0 / root.a;
            } else {
                if (tempOperand == 0) {
                    root.x1 = (-root.b) / 2d / root.a;
                    root.x2 = root.x1;
                } else {
                    root.isComplex = true;
                    root.x1 = (-root.b) / 2d / root.a;
                    root.x2 = Math.sqrt(Math.abs(tempOperand)) / 2.0 / root.a;
                }
            }
        }).forEach(System.out::println);
    }
}
