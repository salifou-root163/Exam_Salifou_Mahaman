package kata;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;

public class RouletteAT {

     private Between0And37Randomizer rand1 = mock(Between0And37Randomizer.class);
     private Ball bal = mock(Ball.class);

    @Test
    public void itWaitsForTheBallToStop() {

        Roulette rlt = new Roulette(bal, rand1);

        rlt.playGame();

        verify(bal).roll();
    }

    @Test()
    public void itProvidesAResultWithColor() throws Exception {

        Between0And37Randomizer rand2 = mock(Between0And37Randomizer.class);

        when(rand2.getRouletteResult()).thenReturn(7);

        Roulette roulette = new Roulette(bal, rand2);

        Result actual = roulette.playGame();

        assertEquals("7", actual.number);

        assertEquals(Color.red, actual.color);
    }

}
