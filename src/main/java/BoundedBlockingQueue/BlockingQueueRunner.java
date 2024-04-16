package BoundedBlockingQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class BlockingQueueRunner {

    public static void run(){
        BoundedBLockQueue bbq = new BoundedBLockQueue(2,new ArrayList<>());

        while(true){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            final String[] splits = input.split(" ");
            final String operations = splits[0];

            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(operations.equals("eq")){
                        final Integer val = Integer.parseInt(splits[1]);
                        bbq.enqueue(val);
                    }
                    else if(operations.equals("dq")){
                        Integer dqVal = bbq.dequeue();
                        System.out.println(" Dequeued value " + dqVal);
                    }
                }
            });
            th.start();
        }

    }

}
