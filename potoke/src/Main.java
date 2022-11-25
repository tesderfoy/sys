public class Main {
    public static void main(String[] args) {

        Account account = new Account();
        User user = new User(account);
        Bank bank = new Bank(account);
        new  Thread(user).start();
        new  Thread(bank).start();
    }
}

class Account{
    int balance;
    synchronized void balanceTake(){
        while (balance <= 350){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        balance = balance - 300;
        System.out.println("Вы сняли 300 рублей");
        System.out.println("Ваш баланс " + balance);
    }
    synchronized void balancePlus(){
        while (balance > 350) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        balance += 100;
        System.out.println("Вы пополнили баланс на 100 рублей ");
        notify();
        System.out.println("Ваш баланс " + balance);
    }

}
class Bank implements Runnable{

    Account account;
    Bank(Account account){
        this.account = account;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            account.balancePlus();
        }
    }
}
class User implements Runnable{
    Account account;
    User(Account account){
        this.account=account;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            account.balanceTake();
        }
    }
}