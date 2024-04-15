package Odd_Even;

public class EvenOddRunner {

    public static void run(){
        TypeOfPrinter typeOfPrinter = new TypeOfPrinter(100,"odd");
        new Thread(new EvenPrinter(typeOfPrinter)).start();
        new Thread(new OddPrinter(typeOfPrinter)).start();
    }
}
