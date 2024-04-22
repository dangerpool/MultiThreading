package Task_Scheduler;

import lombok.SneakyThrows;

public class MyTaskSchedulerRunner {
    @SneakyThrows
    public static void run(){
        MyTaskScheduler myTaskScheduler = new MyTaskScheduler();
        myTaskScheduler.registerConsumer(new AdditionConsumer());
        myTaskScheduler.registerConsumer(new AdditionConsumer());
        CalculationMessage msg1 = new CalculationMessage(1,2);
        CalculationMessage msg2 = new CalculationMessage(2,3);
        Thread.sleep(2000);
        myTaskScheduler.scheduleTaskAfter(msg1,1 * 1000); // 1 min = 1 * 60(sec) * 1000(millis)
        myTaskScheduler.scheduleTaskAfter(msg2,2 * 1000);
    }
}
