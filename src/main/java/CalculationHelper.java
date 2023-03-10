import java.util.Arrays;
import java.util.List;

class CalculationHelper {

    public static String checkMathOperationSign(String line) {
        String result;
        if (line.contains("+")) {
            result = parseAndCalc("\\+", line);
        } else if (line.contains("-")) {
            result = parseAndCalc("\\-", line);
        } else if (line.contains("*")) {
            result = parseAndCalc("\\*", line);
        } else if (line.contains("/")) {
            result = parseAndCalc("\\/", line);
        } else {
            throw new RuntimeException("Неверный формат ввода данных, добавьте тип математической операции (+-*/)");
        }

        return result;
    }

    public static String parseAndCalc(String mathOperationType, String line) {
        boolean isRoman = false;
        int result = 0;
        String[] whatToCalc = line.split(mathOperationType);
        if (whatToCalc.length != 2) {
            throw new RuntimeException("Неверный формат данных. Введите два арабских или римских числа от 1 до 10, разделенные одним из знаков: +, -, *, /");
        }
        List<DigitsToCalc> enumList = Arrays.stream(DigitsToCalc.values()).toList();
        DigitsToCalc firstDigit = enumList.stream().filter(i -> i.getLabel().equals(whatToCalc[0].trim())).findFirst().orElseThrow(() -> new RuntimeException("Ошибка в первом введенном числе"));
        DigitsToCalc secondDigit = enumList.stream().filter(i -> i.getLabel().equals(whatToCalc[1].trim())).findFirst().orElseThrow(() -> new RuntimeException("Ошибка во втором введенном числе"));
        if (!(firstDigit.isArabic() == secondDigit.isArabic())) {
            throw new RuntimeException("Неверный формат ввода данных: требуется ввести два арабских или два римских числа");
        }
        if (!firstDigit.isArabic()) {
            isRoman = true;
        }
        switch (mathOperationType) {
            case "\\+" -> result = firstDigit.getValue() + secondDigit.getValue();
            case "\\-" -> result = firstDigit.getValue() - secondDigit.getValue();
            case "\\*" -> result = firstDigit.getValue() * secondDigit.getValue();
            case "\\/" -> result = firstDigit.getValue() / secondDigit.getValue();
        }
        if (!isRoman) {
            return Integer.toString(result);
        } else return arabicToRoman(result);
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            throw new RuntimeException(number + " не входит в диапазон вычисляемых значений для римских цифр");
        }

        List<RomanDigits> romanDigits = RomanDigits.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanDigits.size())) {
            RomanDigits currentSymbol = romanDigits.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
