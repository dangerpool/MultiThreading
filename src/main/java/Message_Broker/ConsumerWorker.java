package Message_Broker;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;

@AllArgsConstructor
public class ConsumerWorker implements Runnable{
    private final Queue<CalculationMessage> messageQueue;
    private final IConsumer consumer;
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            final CalculationMessage msg;
            System.out.println(Thread.currentThread().getName() + " entering Synchronised block ");
            synchronized (messageQueue) {
                while (messageQueue.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " going in wait state ");
                    messageQueue.wait();
                    System.out.println(Thread.currentThread().getName() + " coming out of wait state ");
                }
                msg = messageQueue.poll();// Another possibility is that suppose that there is only one message to consume both thread reach on this line.
                //then in that case one thread can process the message and second thread will get exception. which is wrong. So polling should be synchronised.

                // consumer.consume(msg); // if we consume here then all the threads are waiting till one thread consume the message. but that is wrong. If consumers are free they can consume message in parallel.
                // that's the reason we are just making sure that each thread gets a unique message to consume but consumption will happen in parallel.

            }
            // The reason synchronised block starts from 30 and end on 35 because we want each consumer to take on single message
            // but consumption of message should be in parallel. that's the reason consume is happening outside of synchronized block to make parallel consumption.
            consumer.consume(msg);
        }
    }
}
