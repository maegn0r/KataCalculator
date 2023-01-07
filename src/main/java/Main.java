import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while(!(line = reader.readLine()).equals("exit")){
                System.out.println(calc(line));
            }
        } catch (IOException | RuntimeException e) {
           e.printStackTrace();
        }
    }
    public static String calc(String input){
        if (!CalculationHelper.validate(input)){
            throw new RuntimeException("Не прошло валидацию");
        } else {
            return CalculationHelper.parseAndCalc(input);
        }
    }
}
