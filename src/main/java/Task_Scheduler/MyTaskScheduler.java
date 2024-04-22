package Task_Scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MyTaskScheduler {

    private final PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparing(Task::getSchedulingTime));
    private final List<IConsumer> consumers = new ArrayList<>();

    public void scheduleTaskAfter(CalculationMessage msg,int millisAfter){
        scheduleAtTime(msg,System.currentTimeMillis() + millisAfter);
    }

    public void scheduleAtTime(CalculationMessage msg,long millisSinceEpoch){
        synchronized (pq){
            pq.offer(new Task(msg,millisSinceEpoch));
            pq.notifyAll();
        }
    }
    public void registerConsumer(IConsumer consumer){
        consumers.add(consumer);
        new Thread(new ConsumerWorker(pq,consumer)).start();
    }
}
