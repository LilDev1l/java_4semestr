package task2.tender;

import task2.ask.Ask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Tender {
    private ArrayList<Ask> asks;
    private CyclicBarrier barrier;
    public final int NUMBER_ASK = 3;

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public Tender() {
        asks = new ArrayList<>();
        barrier = new CyclicBarrier(NUMBER_ASK, new Runnable() {
            @Override
            public void run() {
                Ask winner = defineWinner();
                System.out.println("ПРИНЯТО предложение #" + winner.getIdAsk() + ", цена: " + winner.getPrice());
            }
        });
    }
    public Ask defineWinner() {
        return Collections.min(asks, new Comparator<Ask>() {

            @Override
            public int compare(Ask o1, Ask o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
    public void addAsk(Ask ask) {
        asks.add(ask);
    }
}
