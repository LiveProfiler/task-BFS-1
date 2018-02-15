package algo.tasks.graphs.task.BFS.n1.search;

import algo.tasks.graphs.task.BFS.n1.chess.ChessBoard;
import algo.tasks.graphs.task.BFS.n1.search.Digraph;
import algo.tasks.graphs.task.BFS.n1.chess.Figure;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BFSForHorseFigure {
    private final ChessBoard board;

    public BFSForHorseFigure(ChessBoard board){
        this.board = board;
    }

    public Digraph run(Point start) {
        Point end = null;
        Digraph digraph = new Digraph();
        digraph.addEdge(start, null);
        HashSet<Point> visited = new HashSet<>();
        visited.add(start);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            Point position = queue.poll();
            if (board.getFigure(position) == Figure.PAWN){
                end = position;
                break;
            }
            for (Point incident: getFilteredHorseSteps(position)){
                if (!visited.contains(incident)){
                    queue.add(incident);
                    visited.add(incident);
                    digraph.addEdge(incident, position);
                }
            }
        }
        return digraph;
    }

    private List<Point> getHorseSteps(Point position){
        return Arrays.asList(
                new Point(position.x - 1, position.y - 2),
                new Point(position.x + 1, position.y - 2),
                new Point(position.x - 1, position.y + 2),
                new Point(position.x + 1, position.y + 2),
                new Point(position.x - 2, position.y - 1),
                new Point(position.x - 2, position.y + 1),
                new Point(position.x + 2, position.y - 1),
                new Point(position.x + 2, position.y + 1)
        );
    }

    private List<Point> getFilteredHorseSteps(Point point){
        return getHorseSteps(point)
                .stream()
                .filter(x -> stepInBoardRange(x) && !stepInDangerByPawn(x))
                .collect(Collectors.toList());
    }

    private boolean stepInBoardRange(Point position){
        return 0 <= position.x && position.x < board.getSize() &&
                0 <= position.y && position.y < board.getSize();
    }

    private boolean stepInDangerByPawn(Point position){
        return Stream.of(
                new Point(position.x + 1, position.y + 1),
                new Point(position.x + 1, position.y - 1),
                new Point(position.x - 1, position.y + 1),
                new Point(position.x - 1, position.y - 1)
        )
                .filter(this::stepInBoardRange)
                .anyMatch(point -> board.getFigure(point) == Figure.PAWN);
    }
}
