package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenFigureImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure figure = new BishopBlack(Cell.A1);
        logic.add(figure);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> logic.move(Cell.A1, Cell.A4));
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from A1 to A4");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure figure1 = new BishopBlack(Cell.C1);
        Figure figure2 = new BishopBlack(Cell.D2);
        logic.add(figure1);
        logic.add(figure2);
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> logic.move(Cell.C1, Cell.D2));
        assertThat(exception.getClass()).isEqualTo(OccupiedCellException.class);
    }
}