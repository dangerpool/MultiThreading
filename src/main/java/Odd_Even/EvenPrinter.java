package Odd_Even;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class EvenPrinter implements Runnable{
    private final TypeOfPrinter typeOfPrinter;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (typeOfPrinter){
            System.out.println("Even Thread Starting");
            int currEvenNum = 2;

            while(currEvenNum <= typeOfPrinter.printTill){
                while(!typeOfPrinter.printType.equals("even")){
                    System.out.println("Even Thread Going for wait");
                    typeOfPrinter.wait();
                    System.out.println("Even Thread Coming out of wait");
                }
                System.out.println("The Number is " + currEvenNum);
                currEvenNum+=2;
                typeOfPrinter.printType = "odd";
                typeOfPrinter.notifyAll();
            }
        }
    }
}
