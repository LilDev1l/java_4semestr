package task2.tender;
import task2.ask.Ask;
import java.util.Random;

public class TenderRunner {
    public static void main(String[] args) throws InterruptedException {
        Tender tender = new Tender();

        for (int i = 0; i < tender.NUMBER_ASK; i++) {
            Ask thread = new Ask(i, tender.getBarrier());
            tender.addAsk(thread);
            thread.start();

            Thread.sleep(new Random().nextInt(1000) + 2000);
        }
    }
}
