package SQS;

public class SQSRunner {
    public static void run(){
        SQSQueue sqsQueue = new SQSQueue();
        IConsumer consumer1 = new AdditionConsumer();
        IConsumer consumer2 = new AdditionConsumer();

        sqsQueue.subscribe(consumer1);
        sqsQueue.subscribe(consumer2);

        sqsQueue.publish(new CalculationMessage(1,2));
        sqsQueue.publish(new CalculationMessage(2,3));
        sqsQueue.publish(new CalculationMessage(5,6));
        sqsQueue.publish(new CalculationMessage(7,8));
        sqsQueue.publish(new CalculationMessage(10,10));
    }
}
