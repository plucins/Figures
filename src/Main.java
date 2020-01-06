import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        for (String arg : args) {
            try {
                Integer.parseInt(arg);
            } catch (NumberFormatException ex) {
                System.out.println("Błędne dane wejściowe");
            }
        }
        if (args.length == 3 || args.length == 4) {
            if (args.length == 3) {
                if (isPossibleToBuildTriangle(args)) {
                    System.out.println("Można zbudować trójkąt");
                } else {
                    System.out.println("nierozpoznano");
                }
            }
            if (args.length == 4) {
                if (!isPossibleToBuildRectangle(args) || !isPossibleToBuildSquare(args)) {
                    System.out.println("nierozpoznano");
                }
            }
        } else {
            System.out.println("Błędna ilość parametrów");
        }

    }

    private static boolean isPossibleToBuildTriangle(String[] args) {
        List<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());

        int longest = integers.stream().max(Comparator.naturalOrder()).get();
        int restSum = integers.stream().mapToInt(Integer::intValue).sum() - longest;

        return longest < restSum;
    }

    private static boolean isPossibleToBuildRectangle(String[] args) {
        List<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());

        boolean firstSame = integers.get(0).equals(integers.get(1)) ||
                integers.get(0).equals(integers.get(2)) ||
                integers.get(0).equals(integers.get(3));

        boolean secondSame = integers.get(1).equals(integers.get(2)) ||
                integers.get(1).equals(integers.get(3));

        if (firstSame && secondSame) {
            System.out.println("Można zbudować prostokąt");
        }
        return firstSame && secondSame;
    }

    private static boolean isPossibleToBuildSquare(String[] args) {

        for (String arg : args) {
            for (String s : args) {
                if (!arg.equals(s)) {
                    return false;
                }
            }
        }
        System.out.println("Można zbudować kwadrat");
        return true;
    }


}
