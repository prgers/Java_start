public class Dog extends Animal implements Runnable{
    @Override
    public void run() {
        Runnable.super.run();
        System.out.println("Dog - run()");
    }
}
