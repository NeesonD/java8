package com.neeson.Thread.course4;

import com.neeson.domain.Board;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by daile on 2017/8/31.
 */
public class CellularAutomata {

    private final Board mainBoard;

    private final CyclicBarrier barrier;

    private final Worker[] workers;

    public CellularAutomata(Board board){
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
        });
        this.workers = new Worker[count];


    }

    private class Worker implements Runnable{

        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()){
                for (int x=0;x<board.getMaxX();x++){
                    for (int y = 0;y<board.getMaxY();y++){
                        //board.setNewValue(x,y,computerValue(x,y));
                        try {
                            barrier.await();
                        }catch (InterruptedException ex){
                            return;
                        }catch (BrokenBarrierException ex){
                            return;
                        }
                    }
                }
            }
        }

        private void computerValue(int x, int y) {
        }
    }

    public void start(){
        for (int i = 0;i<workers.length;i++){
            new Thread(workers[i]).start();
            mainBoard.waitForConvergence();
        }
    }

}
