package SQS;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SQSQueue {

    List<IConsumer> consumers = new ArrayList<>();
    public final Queue<CalculationMessage> messageQueue = new LinkedList<>();

    public void publish(CalculationMessage calculationMessage){
        synchronized (messageQueue) {
            messageQueue.offer(calculationMessage);
            messageQueue.notifyAll();
        }
    }

    public void subscribe(IConsumer consumer){
        System.out.println("Registering Consumer " + consumer);
        consumers.add(consumer);
        new Thread(new ConsumerWorker(messageQueue,consumer)).start();
    }


}
