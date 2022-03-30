package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultTest {

    @Test
    public void the37CorrespondsTo00() {
        Result res = new Result(37);

        assertEquals(res.number,"00");

    }

    @Test()
    public void theResultIsAlwaysBetween00and36() throws Exception {

        assertNumberResult(0, "0");
        assertNumberResult(3, "3");
        assertNumberResult(37, "37");
        assertNumberResult(35, "35");

    }

    @Test
    public void theColorOf0and00IsGreen() throws Exception {
        assertColorResult(0, Result.Color.GREEN);
        assertColorResult(00, Result.Color.GREEN);


    }

    @Test
    public void theColorOfEvenNumbersIsBlack() throws Exception {
        assertColorResult(2, Result.Color.BLACK);
        assertColorResult(8, Result.Color.BLACK);

    }

    @Test
    public void theColorOfOddNumbersIsRed() throws Exception {
        assertColorResult(3, Result.Color.RED);
        assertColorResult(11, Result.Color.RED);


    }

    @Test
    public void itThrowsExceptionWhenTheRandomizerIsGreaterThan37() throws Exception {
        RouletteException error = assertThrows(RouletteException.class,   () -> new Result(40) );
        assertEquals("Result can't be 40", error.getMessage());

    }

    @Test
    public void itThrowsExceptionWhenTheRandomizerIsLesserThan0() throws Exception {

        RouletteException exception = assertThrows(RouletteException.class,  () -> new Result(-5));
        assertEquals("Result can't be -5", exception.getMessage());

    }

    private void assertColorResult(int randomizerValue, Result.Color expectedColor) {

        Result.Color c = new Result(randomizerValue).color;
        assertThat(c).isEqualTo(expectedColor);


    }

    private void assertNumberResult(int randomizerValue, String expectedNumber) {

        assertThat(new Result(randomizerValue).number).isEqualTo(expectedNumber);
    }
}