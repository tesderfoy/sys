public class Main {
    public static void main(String[] args) {
        AnimalThread tort = new AnimalThread("Черепаха Олег");
        tort.setPriority(10);
        AnimalThread rab = new AnimalThread("Кролик");
        rab.setPriority(1);
        tort.start();
        rab.start();
    }
}
class  AnimalThread extends Thread {
    String name;
    public AnimalThread(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println(name + " начал забег");
        for (int i = 100; i <= 1000; i+=100) {
            System.out.println(name + " пробежал "+ " метров: " + i);
        }
    }
}