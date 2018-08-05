package com.neeson.thread.course8.puzzle;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by daile on 2017/9/8.
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {

    private final AtomicInteger taskCount = new AtomicInteger(0);


    public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
        super(puzzle, exec, seen);
    }

    protected Runnable newTask(P p, M m, SequentialPuzzleSolver.Node<P, M> n) {
        return (Runnable) new CountingSovlerTask(p, m, n);
    }

    class CountingSovlerTask extends SolverTask {

        public CountingSovlerTask(P pos, M move, SequentialPuzzleSolver.Node<P, M> prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }

        public void run() {
            try {
                super.run();
            } finally {
                if (taskCount.decrementAndGet() == 0) {
                    solution.setValue(null);
                }
            }
        }
    }
}
