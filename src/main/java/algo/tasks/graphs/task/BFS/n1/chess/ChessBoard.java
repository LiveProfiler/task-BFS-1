package algo.tasks.graphs.task.BFS.n1.chess;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.awt.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ChessBoard {
    private final Pattern pattern = Pattern.compile("^[a-h]\\d$");
    private final int size = 8;
    private Figure[][] field;

    public ChessBoard(){
        field = new Figure[size][size];
        for (int i = 0; i < size; i++){
            Arrays.fill(field[i], Figure.EMPTY);
        }

    }

    public int getSize(){
        return size;
    }

    public Figure getFigure(Point point){
        return field[point.y][point.x];
    }

    public void addFigure(Point position, Figure figure){
        field[position.y][position.x] = figure;
    }

    public Point parsePosition(String position) throws ParsePositionException {
        if (position.length() != 2 || !pattern.matcher(position).matches()){
            throw new ParsePositionException();
        }
        int column = position.charAt(0) - 'a';
        int row = Integer.parseInt(position.substring(1, 2)) - 1;
        return new Point(column, row);
    }

    /**
     * position -> chess board notation
     * @param position
     */
    public String representPosition(Point position){
        return (char)(position.x + 'a') + String.valueOf(position.y + 1);
    }
}
