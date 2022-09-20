class HelloRunable extends Thread {
    @Override
    public void run() {
            System.out.println(getName());
    }

}

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i<=9; i++){
            HelloRunable thread = new HelloRunable();
            thread.start();
        }
        System.out.println("Главный поток");
    }
}