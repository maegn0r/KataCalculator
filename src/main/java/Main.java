import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            System.out.println("******* Начало работы программы Калькулятор *******\nВведите число от 1 до 10 (арабскими или римскими цифрами) \nразделенные одним из знаков: +, -, *, / \nили exit для завершения работы калькулятора");
            while (!(line = reader.readLine()).equals("exit")) {
                System.out.println(calc(line));
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("******* До новых встреч! *******");
        }
    }

    public static String calc(String input) {
        return CalculationHelper.checkMathOperationSign(input);
    }
}
