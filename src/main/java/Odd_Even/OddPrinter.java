package Odd_Even;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class OddPrinter implements Runnable{
    private final TypeOfPrinter typeOfPrinter;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (typeOfPrinter){
            System.out.println("Odd Thread Starting");
            int currOddNum = 1;

            while(currOddNum <= typeOfPrinter.printTill -1){
                while(!typeOfPrinter.printType.equals("odd")){
                    System.out.println("Odd Thread Going for wait");
                    typeOfPrinter.wait();
                    System.out.println("Odd Thread Coming out of wait");
                }
                System.out.println("The Number is " + currOddNum);
                currOddNum+=2;
                typeOfPrinter.printType = "even";
                typeOfPrinter.notifyAll();
            }
        }

    }
}
