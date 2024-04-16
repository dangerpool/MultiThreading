package BoundedBlockingQueue;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@AllArgsConstructor
public class BoundedBLockQueue {

    int size;
    List<Integer> queue;

    @SneakyThrows
    public void enqueue(Integer value){
        System.out.println("eq thread invoked for " + value);
        synchronized (queue){
            while(queue.size() >= size){
                System.out.println("eq thread for " + value + " Is WAITING ");
                queue.wait();
                System.out.println("eq thread for " + value + " Coming out of wait ");
            }
            queue.add(value);
            queue.notifyAll();
            System.out.println("eq thread for " + value + "Completed it's task");
        }
    }
    @SneakyThrows
    public Integer dequeue(){
        synchronized (queue){
            System.out.println("dq thread invoked");
            while(queue.size() == 0){
                System.out.println("dq thread is Waiting");
                queue.wait();
                System.out.println("dq thread is Awake");
            }

            Integer dequeueValue = queue.remove(0);
            System.out.println("dq thread is DQing " + dequeueValue);
            queue.notifyAll();
            System.out.println("dq thread" + "Completed it's task");
            return dequeueValue;
        }
    }

}
