package kata;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class BallTest {

    @Test
    public void itRollsForAGivenAmountOfTime() throws Exception {

        Ball ball = new Ball(20);

        double t = 10000;
        ball.roll();
        double t1 = 30000;

        assertThat(t1 - t).isCloseTo(20000, within(20d));

    }
}
