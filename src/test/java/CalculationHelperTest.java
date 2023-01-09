import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculationHelperTest {


@Test
void calcTest(){
    Assertions.assertEquals("7", CalculationHelper.parseAndCalc("2+5"));
    Assertions.assertEquals("C", CalculationHelper.parseAndCalc("X*X"));
    Assertions.assertEquals("-3", CalculationHelper.parseAndCalc("2-5"));
    Assertions.assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-5"));
    Assertions.assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-V"));
    Assertions.assertThrows(RuntimeException.class, () -> CalculationHelper.parseAndCalc("V-VIII"));
}


}
