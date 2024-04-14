public class Main {

    public static void main(String[] args){

    TransitionState transitionState = new TransitionState("Hi");

    new Thread(new WordProcessor(transitionState,"Shukiboi","dude")).start();
    new Thread(new WordProcessor(transitionState,"i","am")).start();
    new Thread(new WordProcessor(transitionState,"Hi","i")).start();
    new Thread(new WordProcessor(transitionState,"am","Shukiboi")).start();
    new Thread(new WordProcessor(transitionState,"dude",null)).start();

    }
}
