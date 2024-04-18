package SQS;

import lombok.SneakyThrows;

public class SubtractionConsumer implements IConsumer{

    private boolean isFree = true;

    @SneakyThrows
    @Override
    public void consume(CalculationMessage calculationMessage) {
        isFree = false;
        //adding sleep to mimic time taken to consume message
        System.out.println(Thread.currentThread().getName() + " Subtraction started  " + calculationMessage.toString());
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " Subtraction completed " + calculationMessage.a + " - " + calculationMessage.b + " = " + (calculationMessage.a - calculationMessage.b));
        isFree = true;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }
}

