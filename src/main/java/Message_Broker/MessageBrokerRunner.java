package Message_Broker;

import SQS.AdditionConsumer;
import SQS.CalculationMessage;
import SQS.SubtractionConsumer;
import lombok.SneakyThrows;

import java.util.List;

public class MessageBrokerRunner {
    @SneakyThrows
    public static void run(){
        final MessageBroker mb = new MessageBroker();
        mb.register("add",List.of(new AdditionConsumer()));
        mb.register("minus",List.of(new SubtractionConsumer(),new SubtractionConsumer()));

        mb.publish(new CalculationMessage(1,2));
        mb.publish(new CalculationMessage(2,3));
        mb.publish(new CalculationMessage(5,6));
        mb.publish(new CalculationMessage(7,8));
        mb.publish(new CalculationMessage(10,10));

        Thread.sleep(5000);
        mb.register("add",List.of(new AdditionConsumer()));
    }
}
