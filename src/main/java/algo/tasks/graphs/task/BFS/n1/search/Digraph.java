package algo.tasks.graphs.task.BFS.n1.search;


import java.awt.*;
import java.util.*;
import java.util.List;

public class Digraph {
    private Map<Point, Point> path;

    public Digraph(){
        path = new HashMap<>();
    }

    /**
     * Add directed edge from start to end
     * @param start
     * @param end
     */
    public void addEdge(Point start, Point end){
        path.put(start, end);
    }

    public List<Point> getPath(Point start, Point end) throws PathNotFoundException {
        List<Point> result = new ArrayList<>();
        Point current = end;
        while (current != null){
            result.add(current);
            current = path.getOrDefault(current, null);
        }
        if (result.size() > 0 && result.get(result.size() - 1).equals(start)){
            Collections.reverse(result);
            return result;
        }
        throw new PathNotFoundException();
    }

}
