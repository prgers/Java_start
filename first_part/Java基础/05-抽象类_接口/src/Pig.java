public interface Pig extends Sleepable, Eatable {
    static void eat(String name) {
        System.out.println("Pig - " + name);
    }
}
