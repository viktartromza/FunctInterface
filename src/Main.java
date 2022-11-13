import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.function.*;


public class Main {
    public static void main(String[] args) {
        //Создать интерфейс IShape  с методом getSquare(int x, int y). (Функциональный интерфейс)
        //Используя лямбда-выражения, реализовать его для квадрата(a*b) и треугольника(0.5a*h)
        IShape tetragon = (int a, int b) -> a * b;
        IShape triangle = (int a, int h) -> (int) ((0.5) * a * h);
        System.out.println(tetragon.getSquare(5, 6));
        System.out.println(triangle.getSquare(5, 6));


        //Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается “A”.
        Predicate<String> check = s -> ((s.charAt(0) == 'J' || s.charAt(0) == 'N') && s.charAt(s.length() - 1) == 'A');
        String string = "NANNA";
        System.out.println(check.test(string));


        //Написать лямбда выражение, которое принимает на вход объект типа Box и выводит на консоль сообщение “Отгрузили ящик с весом n” где n – поле в классе которое содержит вес ящика.
        Consumer<Box> weightAd = b -> System.out.println("Отгрузили ящик с весом " + b.getWeight());
        Box box = new Box(5);
        weightAd.accept(box);


        //Написать лямбда выражение, которое принимает на вход число и возвращает значение “Положительное число”, “Отрицательное число” или  “Ноль”.
        Function<Integer, String> ifPositive = x -> {
            String result;
            if (x > 0) {
                result = "Положительное число";
            } else if (x == 0) {
                result = "Ноль";
            } else {
                result = "Отрицательное число";
            }
            return result;
        };
        System.out.println(ifPositive.apply(5));


        //Написать лямбда выражение, которое возвращает случайное число от 0 до 10.
        Supplier<Integer> randomNumber = () -> {
            Random random = new Random();
            int r = random.nextInt(10);
            return r;
        };
        System.out.println(randomNumber.get());


        // Используя Predicate среди массива чисел вывести только те, которые являются положительными.
        Predicate<Integer> isPositive = s -> s > 0;
        int[] numbers = {5, -5, 0, 6};
        for (int n : numbers) {
            if (isPositive.test(n))
                System.out.println(n);
        }

        //Используя Binary/Unary возвеcти в квадрат массив чисел
        UnaryOperator<Integer> square = x -> x * x;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = square.apply(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers));

        //Используя Function реализовать лямбду, которая будет принимать в себя строку в формате “сумма”(через пробел), а возвращать сумму переведенную сразу в доллары.
        double dollarRate = 2.45;
        Function<String, Double> sumDollars = s -> Double.parseDouble(s.replaceAll(" BYN", "")) / dollarRate;
        String sum = "100 BYN";
        System.out.println(sumDollars.apply(sum));
    }
}
