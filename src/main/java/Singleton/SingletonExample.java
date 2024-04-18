package Singleton;

public class SingletonExample {
    private static volatile SingletonExample singletonExampleInstance;

    private SingletonExample(){

    }

    public static SingletonExample getInstance(){
        if(singletonExampleInstance == null){
            synchronized (SingletonExample.class){
                if(singletonExampleInstance == null){
                    singletonExampleInstance = new SingletonExample();
                }
            }
        }
        return singletonExampleInstance;
    }
}
