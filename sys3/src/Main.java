class ree {
    public static void main(String[] args)
            throws InterruptedException {
        EgAndChick eg = new EgAndChick("Яйцо");
        EgAndChick chiks = new EgAndChick("Курица");
        eg.start();
        chiks.start();
        eg.join();
        if(chiks.isAlive()){
            System.out.println("Победила курица");
        }
        else {
            System.out.println("Победило яйцо");
        }
    }
}
class  EgAndChick extends Thread {
    String name;
    public EgAndChick(String name) {
        this.name = name;
    }
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(name);
        }
    }
}