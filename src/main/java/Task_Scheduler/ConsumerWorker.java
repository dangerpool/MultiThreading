package Task_Scheduler;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.PriorityQueue;

@AllArgsConstructor
public class ConsumerWorker implements Runnable{

    private final PriorityQueue<Task> pq;
    private final IConsumer consumer;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        while (true) {
            Task tempTask;
            synchronized (pq) {
                while (true) {
                    while (pq.isEmpty()){
                        System.out.println(" Pq is empty. No Task to process . Thread going to wait " + Thread.currentThread().getName());
                        pq.wait();
                        System.out.println(" Pq is empty. No Task to process . Thread coming out of wait " + Thread.currentThread().getName());
                    }
                    tempTask = pq.peek();
                    long millisToWait = tempTask.schedulingTime - System.currentTimeMillis();
                    if (millisToWait > 0){
                        System.out.println(Thread.currentThread().getName() + " going to wait as time is remaining to process the message " + millisToWait);
                        pq.wait(millisToWait);
                        System.out.println(Thread.currentThread().getName() + " coming out of wait " + millisToWait);
                    }
                    else{
                        break;
                    }
                }
                tempTask = pq.poll();
            }
            consumer.consume(tempTask.msg);
        }
    }
}
