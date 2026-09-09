public class Account {
    private final String owner;
    private int balance;

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public Account(String owner) {
        this(owner, 0);
    }

    public String getOwner() { return owner; }
    public int getBalance()  { return balance; }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("입금액은 0원보다 커야 합니다.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("출금액은 0원보다 커야 합니다.");
            return false;
        }
        if (amount > balance) {
            System.out.println("잔액이 부족합니다. 현재 " + balance + "원");
            return false;
        }
        balance -= amount;
        return true;
    }
}
