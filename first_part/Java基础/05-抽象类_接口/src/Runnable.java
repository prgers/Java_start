public interface Runnable {
    default void run() {
        System.out.println("Runnable - run()");
    }
}
