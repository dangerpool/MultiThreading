import BoundedBlockingQueue.BlockingQueueRunner;
import Message_Broker.MessageBrokerRunner;
import Odd_Even.EvenOddRunner;
import Odd_Even.EvenPrinter;
import Odd_Even.OddPrinter;
import Odd_Even.TypeOfPrinter;
import PrintingWords.TransitionState;
import PrintingWords.WordPrinterRunner;
import PrintingWords.WordProcessor;
import SQS.SQSRunner;
import Task_Scheduler.MyTaskSchedulerRunner;

public class Main {

    public static void main(String[] args){
        MessageBrokerRunner.run();
    }
}
