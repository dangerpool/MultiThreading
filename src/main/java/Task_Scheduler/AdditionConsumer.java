package Task_Scheduler;
import lombok.SneakyThrows;

public class AdditionConsumer implements IConsumer {

    private boolean isFree = true;

    @SneakyThrows
    @Override
    public void consume(CalculationMessage calculationMessage) {
        isFree = false;
        //adding sleep to mimic time taken to consume message
        System.out.println(Thread.currentThread().getName() + " Addition started  " + calculationMessage.toString());
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " addition completed " + calculationMessage.a + " + " + calculationMessage.b + " = " + (calculationMessage.a + calculationMessage.b));
        isFree = true;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }
}
