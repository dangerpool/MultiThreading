package Message_Broker;


public interface IConsumer {

    public void consume(CalculationMessage calculationMessage);
    public boolean isFree();

}
