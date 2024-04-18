package Message_Broker;

import SQS.CalculationMessage;
import SQS.IConsumer;
import SQS.SQSQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageBroker {
    private final Map<String,SQSQueue> queues = new HashMap<>();

    public void register(String subscriptionName,List<IConsumer> consumers){

        queues.putIfAbsent(subscriptionName,new SQSQueue());
        SQSQueue sqsQueue = queues.get(subscriptionName);
        for(IConsumer consumer:consumers){
            sqsQueue.subscribe(consumer);
        }
    }
    public void publish(CalculationMessage calculationMessage){
        for(SQSQueue sqsQueue:queues.values()){
            sqsQueue.publish(calculationMessage);
        }
    }
}
