package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class BishopBlackTest {

    @Test
    public void whenStartPositionCreatedCorrectly() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        Cell bbCell = bb.position();
        assertThat(bbCell).isEqualTo(Cell.F8);
    }

    @Test
    public void whenCopyPositionCreatedCorrectly() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        Figure copyBb = bb.copy(Cell.A3);
        assertThat(copyBb.position()).isEqualTo(Cell.A3);
    }

    @Test
    public void whenWayOpen() {
    BishopBlack bb = new BishopBlack(Cell.C1);
    Cell[] way = bb.way(Cell.G5);
    Cell[] steps = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
    assertThat(way).isEqualTo(steps);
    }

    @Test
    public void whenDiagonalFalse() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bb.way(Cell.G6));
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G6");
    }
}