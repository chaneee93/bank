public class Account {
    private static long lastNumber = 1000;
    private static int totalAccounts = 0;

    private final long number;
    private final String owner;
    private int balance;

    public Account(String owner, int balance) {
        this.number = ++lastNumber;
        this.owner = owner;
        this.balance = balance;
        totalAccounts++;
    }

    public Account(String owner) {
        this(owner, 0);
    }

    public long getNumber()  { return number; }
    public String getOwner() { return owner; }
    public int getBalance()  { return balance; }

    public static int getTotalAccounts() { return totalAccounts; }

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
