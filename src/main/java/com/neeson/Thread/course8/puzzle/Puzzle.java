package com.neeson.Thread.course8.puzzle;

import java.util.Set;

/**
 * Created by daile on 2017/9/8.
 */
public interface Puzzle<P,M> {

    P initialPosition();
    boolean isGoal(P position);
    Set<M> legalMoves(P position);
    P move(P position,M move);

}
