package Task_Scheduler;

public interface IConsumer {

    public void consume(CalculationMessage calculationMessage);
    public boolean isFree();

}
