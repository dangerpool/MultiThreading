package SQS;

public interface IConsumer {

    public void consume(CalculationMessage calculationMessage);
    public boolean isFree();

}
