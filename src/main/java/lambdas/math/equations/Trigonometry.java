package lambdas.math.equations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.lang.Math.tan;

public class Trigonometry {
    public static void main(String[] args) {

        List<Double> list = Stream.of(PI, PI / 3d, PI / 4d, 0d)
                .peek(x -> {
                    System.out.println(">>>>>>>>>> ROOT IS : " + x / PI + "pi" + " <<<<<<<<<<");
                })
                .peek(x -> {
                    System.out.print("For equation : sin(3⋅x) = 4⋅sin(x) ⋅ sin(π/3 + x) ⋅ sin(π/3 - x)  and x = " + x + " equation result: ");
                    double result = 4d * sin(x) * sin(PI / 3d + x) * sin(PI / 3d - x) - sin(3d * x);
                    System.out.println(result < 1E-10 ? 0 : result);
                    System.out.println();
                })
                .peek(x -> {
                    System.out.print("For equation : tg(3⋅x) = tg(x) ⋅ tg(π/3 + x) ⋅ tg(π/3 - x)  and x = " + x + " equation result: ");
                    double result = tan(x) * tan(PI / 3d + x) * tan(PI / 3d - x) - tan(3d * x);
                    System.out.println(result < 1E-10 ? 0 : result);
                    System.out.println();
                })
                .peek(x -> {
                    System.out.print("For equation : sin(5⋅x) = 16⋅sin(x) ⋅ sin(π/5 + x) ⋅ sin(π/5 - x) ⋅ sin(2⋅π/5 + x) ⋅ sin(2⋅π/5 - x)  and x = " + x + " equation result: ");
                    double result = 16d * sin(x) * sin(PI / 5d + x) * sin(PI / 5d - x) * sin(PI / 5d * 2d + x) * sin(PI / 5d * 2d - x) - sin(5d * x);
                    System.out.println(result < 1E-10 ? 0 : result);
                    System.out.println();
                })
                .peek(x -> {
                    System.out.print("For equation : tg(5⋅x) = tg(x) ⋅ tg(π/5 + x) ⋅ tg(π/5 - x) ⋅ tg(2⋅π/5 + x) ⋅ tg(2⋅π/5 - x)  and x = " + x + " equation result: ");
                    double result = tan(x) * tan(PI / 5d + x) * tan(PI / 5d - x) * tan(PI / 5d * 2d + x) * tan(PI / 5d * 2d - x) - tan(5d * x);
                    System.out.println(result < 1E-10 ? 0 : result);
                    System.out.println();
                })
                .peek(x -> {
                    System.out.print("For equation : sin(7⋅x) = 64⋅sin(x) ⋅ sin(π/7 + x) ⋅ sin(π/7 - x) ⋅ sin(2⋅π/7 + x) ⋅ sin(2⋅π/7 - x) ⋅ sin(3⋅π/7 + x) ⋅ sin(3⋅π/7 - x)  and x = " + x + " equation result: ");
                    double result = 64d * sin(x) * sin(PI / 7d + x) * sin(PI / 7d - x) * sin(PI / 7d * 2d + x) * sin(PI / 7d * 2d - x) * sin(PI / 7d * 3d + x) * sin(PI / 7d * 3d - x) - sin(7d * x);
                    System.out.println(result < 1E-10 ? 0 : result);
                    System.out.println();
                })
                .peek(x -> {
                    System.out.print("For equation : tg(7⋅x) = tg(x) ⋅ tg(π/7 + x) ⋅ tg(π/7 - x) ⋅ tg(2⋅π/7 + x) ⋅ tg(2⋅π/7 - x) ⋅ tg(3⋅π/7 + x) ⋅ tg(3⋅π/7 - x)  and x = " + x + " equation result: ");
                    double result = tan(x) * tan(PI / 7d + x) * tan(PI / 7d - x) * tan(PI / 7d * 2d + x) * tan(PI / 7d * 2d - x) * tan(PI / 7d * 3d + x) * tan(PI / 7d * 3d - x) - tan(7d * x);
                    System.out.println(result < 1E-10 ? 0 : result);
                    System.out.println();
                })
                .collect(Collectors.toList());
    }
}
