package algo.tasks.graphs.task.BFS.n1;

import algo.tasks.graphs.commons.TaskSolver;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class taskTest {
    private TaskSolver solver = new Solver();
    private List<Pair<String[], String[]>> testsAndAnswers;

    private Pair<String[], String[]> test_1 = new ImmutablePair<>(
            new String[] {
                    "b2",
                    "e6",
            },
            new String[]{
                    "b2",
                    "a4",
                    "c5",
                    "e6"
            }
    );

    private Pair<String[], String[]> test_2 = new ImmutablePair<>(
            new String[]{
                    "a8",
                    "e6"
            },
            new String[]{
                    "a8",
                    "c7",
                    "e6",
            }
    );

    private Pair<String[], String[]> test_3 = new ImmutablePair<>(
            new String[] {
                    "g7",
                    "a1"
            },
            new String[]{
                    "g7",
                    "f5",
                    "e3",
                    "c2",
                    "a1"
            }
    );

    private Pair<String[], String[]> test_4 = new ImmutablePair<>(
            new String[] {
                    "f2",
                    "g2",
            },
            new String[] {
                    "f2",
                    "g4",
                    "e3",
                    "g2"
            }
    );

    private Pair<String[], String[]> test_5 = new ImmutablePair<>(
            new String[] {
                    "b8",
                    "h8"
            },
            new String[] {
                    "b8",
                    "c6",
                    "d8",
                    "f7",
                    "h8"
            }
    );

    @Before
    public void setUp(){
        testsAndAnswers = new ArrayList<>();
        testsAndAnswers.add(test_1);
        testsAndAnswers.add(test_2);
        testsAndAnswers.add(test_3);
        testsAndAnswers.add(test_4);
        testsAndAnswers.add(test_5);
    }

    @Test
    public void sampleTest(){
        for (Pair<String[], String[]> sample: testsAndAnswers) {
            assertArrayEquals(sample.getRight(), solver.solve(sample.getLeft()));
        }
        System.out.println("Test passed " + testsAndAnswers.size());
    }
}
