package PrintingWords;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class WordProcessor implements Runnable{

    public TransitionState state;
    public String word;
    public String nextWord;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (state){
            System.out.println("Starting "+word + " thread.");
            while (!state.nextWord.equals(word)){
                System.out.println("Going on wait "+word);
                state.wait();
                System.out.println("Coming out of wait "+word);
            }
            System.out.println(word);
            state.nextWord = nextWord;
            state.notifyAll();
            System.out.println("Finishing "+word + " thread.");
        }
    }
}
