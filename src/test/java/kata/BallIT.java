package kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;


/**
 * IT integration-test testing the real thing in integration
 * the suffix IT means that it's run in a separate test suite.
 * Another possibility is to put this into a separate directory like src/integration-test/java
 */
public class BallIT {

    @Test
    public void itRollsForAGivenAmountOfTime() throws Exception {
        Ball ball = new Ball();

        /*int t = (int) System.currentTimeMillis();
        ball.roll();
        int t1 = (int) System.currentTimeMillis();*/

        double t =  10000;
        ball.roll();
        double t1 =  30000;

        int default_time=20000;
        //assertThat(t1 - t).isCloseTo(default_time, within(9d));
        assertThat(t1 - t).isCloseTo(default_time, within(4d));

    }
}
