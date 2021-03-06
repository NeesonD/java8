package com.neeson.thread.course8.puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by daile on 2017/9/8.
 */
public class SequentialPuzzleSolver<P, M> {

    private final Puzzle<P, M> puzzle;
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> sovle() {
        P pow = puzzle.initialPosition();
        return search(new Node<>(pow,null,null));
    }

    private List<M> search(Node<P, M> node) {
        if (!seen.contains(node.pos)) {
            seen.add(node.pos);
            if (puzzle.isGoal(node.pos))
                return node.asMoveList();
            for (M move : puzzle.legalMoves(node.pos)) {
                P pos = puzzle.move(node.pos, move);
                Node<P, M> child = new Node<>(pos, move, node);
                List<M> result = search(child);
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    static class Node<P, M> {

        final P pos;
        final M move;
        final Node<P, M> prev;

        public Node(P pos, M move, Node<P, M> prev) {
            this.pos = pos;
            this.move = move;
            this.prev = prev;
        }

        List<M> asMoveList() {
            List<M> solution = new LinkedList<>();
            for (Node<P, M> n = this; n.move != null; n = n.prev)
                solution.add(0, n.move);
            return solution;
        }
    }
}
