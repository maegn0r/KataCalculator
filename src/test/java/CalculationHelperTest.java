import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculationHelperTest {


    @Test
    void calcTest() {
        Assertions.assertEquals("7", CalculationHelper.parseAndCalc("2+5"));
        Assertions.assertEquals("C", CalculationHelper.parseAndCalc("X*X"));
        Assertions.assertEquals("-3", CalculationHelper.parseAndCalc("2-5"));
        Assertions.assertEquals("1", CalculationHelper.parseAndCalc("10/9"));
        Assertions.assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-5"));
        Assertions.assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-V"));
        Assertions.assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-VIII"));
    }

    @Test
    void testExpectedExceptionWhenThereIsNoMathSign() {
        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("XX"));

        Assertions.assertEquals("Неверный формат ввода данных, добавьте тип математической операции (+-*/)", thrown.getMessage());
    }

    @Test
    void testExpectedExceptionWhenWeCalculatedZeroInRomanNumeral() {
        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-V"));

        Assertions.assertEquals(0 + " не входит в диапазон вычисляемых значений для римских цифр", thrown.getMessage());
    }

    @Test
    void testExpectedExceptionWhenMoreThenTwoArguments() {
        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("5+5+5"));

        Assertions.assertEquals("Неверный формат данных. Введите два арабских или римских числа от 1 до 10, разделенные одним из знаков: +, -, *, /", thrown.getMessage());
    }
}

