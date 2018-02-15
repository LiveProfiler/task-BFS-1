package algo.tasks.graphs.task.BFS.n1;

import algo.tasks.graphs.commons.TaskSolver;
import algo.tasks.graphs.task.BFS.n1.chess.ChessBoard;
import algo.tasks.graphs.task.BFS.n1.chess.Figure;
import algo.tasks.graphs.task.BFS.n1.chess.ParsePositionException;
import algo.tasks.graphs.task.BFS.n1.search.BFSForHorseFigure;
import algo.tasks.graphs.task.BFS.n1.search.PathNotFoundException;

import java.awt.*;

public class Solver implements TaskSolver{
    @Override
    public String[] solve(String[] args) {
        ChessBoard board = new ChessBoard();
        try {
            Point horsePosition = board.parsePosition(args[0]);
            Point pawnPosition = board.parsePosition(args[1]);
            board.addFigure(horsePosition, Figure.HORSE);
            board.addFigure(pawnPosition, Figure.PAWN);
            return new BFSForHorseFigure(board)
                    .run(horsePosition)
                    .getPath(horsePosition, pawnPosition)
                    .stream()
                    .map(board::representPosition)
                    .toArray(String[]::new);

        } catch (ParsePositionException | PathNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
