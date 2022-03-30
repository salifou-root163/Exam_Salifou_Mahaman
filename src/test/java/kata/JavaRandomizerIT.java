package kata;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaRandomizerIT {

    private JavaRandomizer java_random = new JavaRandomizer();

    private IntStream generate_res() {
        return IntStream.range(0, 20000).map(i -> java_random.getRouletteResult());
    }

    @Test
    public void numbersAreNeverOutsideBoundsOf0And37() throws Exception {
        assertThat(generate_res().min().getAsInt()).isEqualTo(0);
        assertThat(generate_res().max().getAsInt()).isEqualTo(37);
    }

    @Test
    public void allNumbersOccur() throws Exception {
        IntStream singleton = generate_res().distinct();
        //assertThat(singleton).size().isEqualTo(37);
        assertThat(singleton).size().isEqualTo(38);
    }




}
